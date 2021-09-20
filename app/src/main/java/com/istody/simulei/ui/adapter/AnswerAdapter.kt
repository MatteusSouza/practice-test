package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.model.Answer
import com.istody.simulei.databinding.ItemAnswerBinding

class AnswerAdapter(
    private val data: List<Answer>,
    private val itemClick: (ItemID: Int) -> Unit
    ) : RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    inner class AnswerViewHolder(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val binding = ItemAnswerBinding
            .inflate(LayoutInflater.from(parent.context), parent ,false)
        return AnswerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        with(holder){
            with(data[position]){
                binding.answer.text = this.answer
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