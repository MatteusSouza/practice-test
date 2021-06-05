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
import com.istody.simulei.databinding.FragmentListQuestionBinding
import com.istody.simulei.ui.adapter.QuestionAdapter
import com.istody.simulei.ui.viewmodel.PracticeViewModel

class ListQuestionFragment : Fragment() {

    private val viewModel: PracticeViewModel by activityViewModels()

    private var _binding: FragmentListQuestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: ListQuestionFragmentArgs by navArgs()

        viewModel.setFolderId(args.folderId)
        viewModel.setExamId(args.examId)

        val questionQuantity = " 0 / ${viewModel.getQuestionList().size} "
        binding.answeredQuestions.text = questionQuantity

        binding.recyclerViewQuestion.layoutManager = LinearLayoutManager(activity)
        binding.recyclerViewQuestion.adapter = QuestionAdapter(viewModel.getQuestionList()
        ) {
                itemID -> itemClick(itemID)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun itemClick(itemID : Int){
        val action = ListQuestionFragmentDirections.actionListQuestionFragmentToQuestionDetailFragment()
        findNavController().navigate(action)
        viewModel.setQuestionId(itemID)
    }

}