package com.istody.simulei.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answer_table")
data class Answer(
    @ColumnInfo(name = "parentQuestionId") val parentQuestionId: Int,
    @ColumnInfo(name = "parentExamId") var parentExamId: Int,
    @ColumnInfo(name = "parentFolderId") var parentFolderId: Int,
    @ColumnInfo(name = "answer") val answer: String,
    @PrimaryKey(autoGenerate = true) val answerId: Int? = null
)
