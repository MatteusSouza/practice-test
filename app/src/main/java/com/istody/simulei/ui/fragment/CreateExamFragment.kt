package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.istody.simulei.databinding.FragmentCreateExamBinding
import com.istody.simulei.ui.adapter.CreateExamAdapter
import com.istody.simulei.ui.viewmodel.ExamViewModel

class CreateExamFragment : Fragment() {

    private val viewModel: ExamViewModel by activityViewModels()
    private var _binding: FragmentCreateExamBinding? = null
    private val binding get() = _binding!!
    val args: CreateExamFragmentArgs by navArgs()

    private val action = CreateExamFragmentDirections.actionCreateExamFragmentToCreateQuestionFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isNewExam = args.isNew
        viewModel.setExamId(args.examId)
        viewModel.setFolderId(args.folderId)
        viewModel.updateQuestionList()

        binding.recyclerViewQuestion.layoutManager = LinearLayoutManager(activity)
        binding.recyclerViewQuestion.adapter = CreateExamAdapter(viewModel.getQuestionList()) {
                itemId : Int -> itemClick(itemId)
        }

        binding.fab.setOnClickListener {

            viewModel.isNewQuestion = true

            if (viewModel.getQuestionList().isNotEmpty()){
                val questionId = viewModel.getQuestionList().size + 1
                viewModel.setQuestionId(questionId)
            }else{
                viewModel.setQuestionId(0)
            }
//            val questionId = viewModel.getQuestionList().size + 1
//            viewModel.setQuestionId(questionId)


            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.isNewExam = false
    }

    private fun itemClick(itemID : Int){
        viewModel.isNewQuestion = false
        findNavController().navigate(action)
        viewModel.setQuestionId(itemID)
    }

}