package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.istody.simulei.databinding.FragmentExamDetailBinding
import com.istody.simulei.ui.viewmodel.ExamViewModel

class ExamDetailFragment : Fragment() {

    private val viewModel: ExamViewModel by activityViewModels()
    private var _binding: FragmentExamDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: ExamDetailFragmentArgs by navArgs()
        viewModel.setFolderId(args.folderId)
        viewModel.setExamId(args.examId)

        viewModel.editButtonVisibility(true)

        viewModel.editButtonClick {
            val action = ExamDetailFragmentDirections
                .actionExamDetailFragmentToCreateExamFragment(
                    false,
                    examId = viewModel.getExamId(),
                    folderId = viewModel.getFolderId()
                )
            findNavController().navigate(action)
        }

        binding.buttonStart.setOnClickListener {
            val action = ExamDetailFragmentDirections
                .actionExamDetailFragmentToListQuestionFragment(
                    examId = viewModel.getExamId(),
                    folderId = viewModel.getFolderId()
                )
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.editButtonVisibility(false)
        _binding = null
    }

}