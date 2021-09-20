package com.istody.simulei.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")
data class Question(
    @ColumnInfo(name = "parentExamId") var parentExamId: Int,
    @ColumnInfo(name = "parentFolderId") var parentFolderId: Int,
    @ColumnInfo(name = "question") var question: String,
    @ColumnInfo(name = "statement_question") var statementQuestion: String? = "",
    @ColumnInfo(name = "source") var source: String? = "",
    @PrimaryKey(autoGenerate = true) var questionId: Int? = null
)