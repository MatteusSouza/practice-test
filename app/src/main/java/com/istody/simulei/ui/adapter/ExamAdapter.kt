package com.istody.simulei.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istody.simulei.data.Exam
import com.istody.simulei.databinding.ItemExamBinding

class ExamAdapter(
    private val data: List<Exam>,
    private val itemClick: (ItemID: Int) -> Unit
    ) : RecyclerView.Adapter<ExamAdapter.ExamViewHolder>() {

    inner class ExamViewHolder(val binding: ItemExamBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        val binding = ItemExamBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ExamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {

        with(holder) {
            with(data[position]){
                val subtitle = " ${position+1} Questions"
                binding.itemHeadline.text = this.exam
                binding.itemSubtitle.text = subtitle
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