package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.Folder
import com.istody.simulei.databinding.ItemFolderBinding

class FolderAdapter(
    private val data: List<String>,
    private val itemClick: (ItemID: Int) -> Unit
) : RecyclerView.Adapter<FolderAdapter.FolderViewHolder>() {

    inner class FolderViewHolder(val binding: ItemFolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val binding = ItemFolderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FolderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        with(holder){
            with(data[position]){
                binding.itemHeadline.text = this
                binding.root.setOnClickListener {
                    itemClick(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}