package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.model.Folder
import com.istody.simulei.databinding.ItemFolderBinding

class FolderAdapter(
    private var data: List<Folder> = mutableListOf(),
    private val itemClick: (ItemID: Int) -> Unit
) : RecyclerView.Adapter<FolderAdapter.FolderViewHolder>() {

    fun setData(thisData: List<Folder>) {
        data = thisData
        this.notifyDataSetChanged()
    }

    inner class FolderViewHolder(val binding: ItemFolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val binding = ItemFolderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FolderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        with(holder){
            with(data[position]){
                binding.itemHeadline.text = this.folderName
                binding.root.setOnClickListener {
//                    itemClick(position)
                    itemClick(folderId!!)  // folderId!!.toInt()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}