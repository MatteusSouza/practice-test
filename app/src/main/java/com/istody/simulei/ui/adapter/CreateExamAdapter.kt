package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.Question
import com.istody.simulei.databinding.ItemQuestionBinding

class CreateExamAdapter(
    private val data: List<Question>,
    private val itemClick: (itemID : Int) -> Unit
) : RecyclerView.Adapter<CreateExamAdapter.CreateExamViewHolder>() {

    inner class CreateExamViewHolder(val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateExamViewHolder {
        val binding = ItemQuestionBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CreateExamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreateExamViewHolder, position: Int) {
        with(holder){
            with(data[position]){
                val questionNumber = "Question ${position+1}"
                binding.questionNumber.text = questionNumber
                binding.question.text = this.question
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