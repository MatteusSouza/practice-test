package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.istody.simulei.databinding.FragmentQuestionDetailBinding
import com.istody.simulei.ui.adapter.AnswerAdapter
import com.istody.simulei.ui.viewmodel.PracticeViewModel

class QuestionDetailFragment : Fragment() {

    private val viewModel: PracticeViewModel by activityViewModels()

    private var _binding: FragmentQuestionDetailBinding? = null
    private val binding get() = _binding!!

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentQuestionDetailBinding.inflate(inflater, container, false)
//
//        val questionId = viewModel.getQuestionId()
//        val questionNumber = "Question ${questionId.plus(1)}"
//        val questionStatement = viewModel.getQuestionList()[questionId].question
//
//        val answerList = viewModel.getQuestionList()[questionId].answerList
//
//        binding.questionNumber.text = questionNumber
//        binding.statementQuestion.text = ""
//        binding.source.text = ""
//        binding.question.text = questionStatement
//
//        binding.recyclerViewAnswer.layoutManager = LinearLayoutManager(activity)
//        binding.recyclerViewAnswer.adapter = AnswerAdapter(answerList){
//            itemID -> itemClick(itemID)
//        }
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun itemClick(itemID : Int){
        Toast.makeText(activity, "Not implemented", Toast.LENGTH_SHORT).show()
//        The choice of questions needs to be implemented
    }

}