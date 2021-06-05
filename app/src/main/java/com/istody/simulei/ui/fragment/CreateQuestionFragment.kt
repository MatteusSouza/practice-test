package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.istody.simulei.data.Answer
import com.istody.simulei.databinding.FragmentCreateQuestionBinding
import com.istody.simulei.ui.adapter.CreateAnswerAdapter
import com.istody.simulei.ui.viewmodel.ExamViewModel

class CreateQuestionFragment : Fragment() {

    private val viewModel: ExamViewModel by activityViewModels()
    private var _binding: FragmentCreateQuestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val questionId = viewModel.getQuestionId()
        val questionNumber = "Question ${questionId+1}"
        binding.questionNumber.text = questionNumber

        if (viewModel.isNewQuestion) {
            binding.statementQuestion.setText("")
            binding.source.setText("")
            binding.question.setText("")
        }
        else{
//            binding.statementQuestion.setText("") // not implemented
//            binding.source.setText("") // not implemented
            binding.question.setText(viewModel.getQuestionList()[questionId].question)
        }

        binding.recyclerViewAnswer.layoutManager = LinearLayoutManager(activity)
        binding.recyclerViewAnswer.adapter = CreateAnswerAdapter(viewModel.getAnswerList())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}