package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.recyclerViewExam.layoutManager = LinearLayoutManager(activity)
        binding.recyclerViewExam.adapter = ExamAdapter(viewModel.getExamList()
        ) { itemID: Int ->
            itemClick(itemID)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            val action = ListExamFragmentDirections.actionListExamFragmentToCreateExamFragment(true)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun itemClick(itemID : Int){

        viewModel.setExamId(itemID)

        val examId = viewModel.getExamId()
        val folderId = viewModel.getFolderId()


        val action = ListExamFragmentDirections
            .actionListExamFragmentToExamDetailFragment(
                examId = examId,
                folderId = folderId
            )
        findNavController().navigate(action)
    }

}