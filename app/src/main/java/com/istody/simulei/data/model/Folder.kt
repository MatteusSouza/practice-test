package com.istody.simulei.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folder_table")
data class Folder(
    @ColumnInfo(name = "folderName") var folderName: String,
    @PrimaryKey(autoGenerate = true) var folderId : Int? = null
    )
