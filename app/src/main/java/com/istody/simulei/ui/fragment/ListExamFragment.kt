package com.istody.simulei.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.istody.simulei.R
import com.istody.simulei.databinding.DialogAddBinding
import com.istody.simulei.databinding.FragmentListExamBinding
import com.istody.simulei.ui.adapter.ExamAdapter
import com.istody.simulei.ui.viewmodel.ListViewModel

class ListExamFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    private var _binding: FragmentListExamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerViewExam
        val adapter = ExamAdapter { itemID: Int ->
            itemClick(itemID)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.exams.observe(viewLifecycleOwner) { exams ->
            exams.let {
                val list = viewModel.filter(it.list)
                adapter.setData(list)
                viewModel.setExamId(it.lastId)
            }

            if (viewModel.examSaved) {
                val action = ListExamFragmentDirections
                    .actionListExamFragmentToCreateExamFragment(
                        isNew = true,
                        examId = viewModel.getExamId(),
                        folderId = viewModel.getFolderId()
                    )
                findNavController().navigate(action)
                viewModel.examSaved = false
            }
        }

        binding.fab.setOnClickListener {
            dialogNewExam()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun itemClick(itemID : Int){

        viewModel.setExamId(itemID)

        val action = ListExamFragmentDirections
            .actionListExamFragmentToExamDetailFragment()
        findNavController().navigate(action)
    }

    private fun dialogNewExam(){
        val dialogBinding : DialogAddBinding = DialogAddBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(dialogBinding.root)


        dialogBinding.headline.text = resources.getString(R.string.new_exam)
        dialogBinding.subtitle.text = resources.getString(R.string.enter_the_exam_name)
        dialogBinding.editText.hint = resources.getString(R.string.name)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialogBinding.buttonCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.buttonSave.setOnClickListener {
            val text = dialogBinding.editText.text.toString()

            val response = viewModel.insertExam(text)
            if(!response){
                Toast.makeText(activity,
                    "the folder field cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }else dialog.dismiss()
        }
    }


}