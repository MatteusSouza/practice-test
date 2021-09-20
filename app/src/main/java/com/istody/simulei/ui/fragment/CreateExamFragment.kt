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
    private val args: CreateExamFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.setFolderId(args.folderId)
        viewModel.setExamId(args.examId)
        _binding = FragmentCreateExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerViewQuestion
        val adapter = CreateExamAdapter { itemID: Int -> itemClick(itemID) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.getQuestionList().observe(viewLifecycleOwner) { exams ->
            exams.let { adapter.setData(it) }
        }

        binding.fab.setOnClickListener {
            navigate(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun itemClick(itemID : Int){
        viewModel.setQuestionId(itemID)
        navigate(false)
    }

    private fun navigate(isNew: Boolean){
        val action = CreateExamFragmentDirections
            .actionCreateExamFragmentToCreateQuestionFragment(isNew)
        findNavController().navigate(action)
    }

}