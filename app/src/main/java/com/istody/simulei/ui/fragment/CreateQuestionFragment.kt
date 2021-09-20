package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.istody.simulei.R
import com.istody.simulei.databinding.DialogAddBinding
import com.istody.simulei.databinding.FragmentCreateQuestionBinding
import com.istody.simulei.ui.adapter.CreateAnswerAdapter
import com.istody.simulei.ui.viewmodel.ExamViewModel

class CreateQuestionFragment : Fragment() {

    private val viewModel: ExamViewModel by activityViewModels()
    private var _binding: FragmentCreateQuestionBinding? = null
    private val binding get() = _binding!!
    private val args: CreateQuestionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateQuestionBinding.inflate(inflater, container, false)

        viewModel.isNewQuestion = args.isNewQuestion

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerViewAnswer
        val adapter = CreateAnswerAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.getAllAnswerList().observe(viewLifecycleOwner) { answers ->
            answers.let {
                if (!viewModel.isNewQuestion) {
                    viewModel.checkAnswerUpdate(answers)
                }
        }

            val list = viewModel.getAnswerList()
            if (list != null) {
                adapter.setData(list)
            }
        }

        viewModel.getNewAnswerList().observe(viewLifecycleOwner) { answers ->
            answers.let { adapter.setData(it) }
        }

        if (viewModel.isNewQuestion) {

            viewModel.getLastQuestionId().observe(viewLifecycleOwner) { id ->
                viewModel.setQuestionId(id)

                if (viewModel.btSaveWasPressed){
                    viewModel.saveAnswers()
                    findNavController().popBackStack()
                }
            }

            binding.fabSave.setOnClickListener {
                val response = viewModel.saveQuestion(
                    binding.question.text.toString(),
                    binding.statementQuestion.text.toString(),
                    binding.source.text.toString()
                )
                if (response) {
                    //refactor to saveQuestion needs to return if insert request was ok
                }
                else Toast
                        .makeText(activity, "the question field cannot be empty ", Toast.LENGTH_SHORT)
                        .show()
            }
        }

        else{
            viewModel.getQuestion().observe(viewLifecycleOwner) { question ->
                binding.statementQuestion.setText(question.statementQuestion)
                binding.source.setText(question.source)
                binding.question.setText(question.question)

                if (viewModel.btSaveWasPressed){
                    viewModel.saveAnswers()
                    findNavController().popBackStack()
                }
            }


            binding.fabSave.text = resources.getString(R.string.update)
            binding.fabSave.setOnClickListener {
                val response = viewModel.updateQuestion(
                    binding.question.text.toString(),
                    binding.statementQuestion.text.toString(),
                    binding.source.text.toString()
                )
                if (response) {
//                    //refactor to saveQuestion needs to return if insert request was ok
                }
                else Toast
                    .makeText(activity, "the question field cannot be empty ", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.fab.setOnClickListener {
            dialogNewAnswer()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.resetAll()
        _binding = null
    }

    private fun dialogNewAnswer(){
        val dialogBinding : DialogAddBinding = DialogAddBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(dialogBinding.root)

        dialogBinding.headline.text = resources.getString(R.string.new_answer)
        dialogBinding.subtitle.text = resources.getString(R.string.enter_the_answer_option)
        dialogBinding.editText.hint = resources.getString(R.string.write_the_option)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialogBinding.buttonCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialogBinding.buttonSave.setOnClickListener {
            val text = dialogBinding.editText.text.toString()

            viewModel.insertAnswer(text)

            dialog.dismiss()
        }
    }

}
