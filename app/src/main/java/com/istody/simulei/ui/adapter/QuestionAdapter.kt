package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.Question
import com.istody.simulei.databinding.ItemQuestionBinding

class QuestionAdapter(
    private val data: List<Question>,
    private val itemClick: (ItemID: Int) -> Unit
    ) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = ItemQuestionBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {

        with(holder) {
            with(data[position]){
                binding.questionNumber.text = ("Question ${position+1}")
                binding.question.text  = this.question
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