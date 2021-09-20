package com.istody.simulei.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exam_table")
data class Exam(
    @ColumnInfo(name = "examName") var examName : String,
    @ColumnInfo(name= "parentFolderId") var parentFolderId: Int,
    @PrimaryKey(autoGenerate = true) var examId: Int? = null
)
