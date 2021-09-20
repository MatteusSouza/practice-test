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

        val recyclerView = binding.recyclerViewFolder
        val adapter = FolderAdapter { itemID: Int ->
            itemClick(
                itemID
            )
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.folderList.observe(viewLifecycleOwner) { folders ->
            folders.let { adapter.setData(it) }
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
        val dialogBinding : DialogAddBinding = DialogAddBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(dialogBinding.root)

        dialogBinding.headline.text = resources.getString(R.string.new_folder)
        dialogBinding.subtitle.text = resources.getString(R.string.enter_the_folder_name)
        dialogBinding.editText.hint = resources.getString(R.string.name)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        dialog.setCancelable(false)

        dialogBinding.buttonCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.buttonSave.setOnClickListener {
            val text = dialogBinding.editText.text.toString()
            val response = viewModel.insertFolder(text)
            if (!response) {
                Toast.makeText(
                    activity,
                    "the folder field cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }else dialog.dismiss()
        }
    }

}