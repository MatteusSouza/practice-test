package com.istody.simulei.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.istody.simulei.databinding.DialogNewFolderBinding
import com.istody.simulei.databinding.FragmentListFolderBinding
import com.istody.simulei.ui.adapter.FolderAdapter
import com.istody.simulei.ui.viewmodel.ListViewModel

class ListFolderFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()
    private var _binding: FragmentListFolderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListFolderBinding.inflate(inflater, container, false)

        binding.recyclerViewFolder.layoutManager = LinearLayoutManager(activity)
        binding.recyclerViewFolder.adapter = FolderAdapter(viewModel.getFolderList()) { itemID: Int ->
            itemClick(
                itemID
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.upButtonVisibility(false)

        binding.fab.setOnClickListener {
            dialogNewFolder()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.upButtonVisibility(true)
        _binding = null
    }

    private fun itemClick(itemID : Int){
        viewModel.setFolderId(itemID)
        val action =  ListFolderFragmentDirections.actionListFolderFragmentToListExamFragment()
        findNavController().navigate(action)
    }


    private fun dialogNewFolder(){
        val dialogBinding : DialogNewFolderBinding = DialogNewFolderBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(dialogBinding.root)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        dialog.setCancelable(false)

        dialogBinding.buttonCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.buttonSave.setOnClickListener {
            dialog.dismiss()
        }
    }

}