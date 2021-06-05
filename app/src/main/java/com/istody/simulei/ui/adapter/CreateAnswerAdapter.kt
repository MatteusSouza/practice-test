package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.Answer
import com.istody.simulei.data.Exam
import com.istody.simulei.data.Question
import com.istody.simulei.databinding.ItemAnswerBinding

class CreateAnswerAdapter(val data: List<Answer>) : RecyclerView.Adapter<CreateAnswerAdapter.CreateAnswerViewHolder>() {

    inner class CreateAnswerViewHolder(
        val binding : ItemAnswerBinding
        ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateAnswerViewHolder {
        val binding = ItemAnswerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CreateAnswerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreateAnswerViewHolder, position: Int) {
        with(holder){
            with(data[position]){
                binding.answer.text = this.answer
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}