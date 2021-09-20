package com.istody.simulei.data.dao

import androidx.room.*
import com.istody.simulei.data.model.Exam
import com.istody.simulei.data.model.Folder
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFolder(folder: Folder)

    @Query("SELECT * FROM folder_table ORDER BY folderName ASC")
    fun getFolderList() : Flow<List<Folder>>

    @Query("UPDATE folder_table SET folderName = :folderName WHERE folderId = :folderId")
    suspend fun updateFolder(folderId: Int, folderName: String)

    suspend fun deleteFolder(folder: Folder) {
        deleteAllDependent(folder)
    }

    // **************************************************************
    // **************************************************************


    suspend fun deleteAllDependent(folder: Folder) {
        folder.folderId?.let {
            deleteAnswers(it)
            deleteQuestions(it)
            deleteExams(it)
        }
        deleteSelected(folder)
    }

    @Delete
    suspend fun deleteSelected(folder: Folder)

    @Query("DELETE FROM answer_table WHERE parentQuestionId = :parentQuestionId")
    suspend fun deleteAnswers(parentQuestionId: Int)

    @Query("DELETE FROM question_table WHERE parentExamId = :parentExamId")
    suspend fun deleteQuestions(parentExamId: Int)

    @Query("DELETE FROM exam_table WHERE parentFolderId = :parentFolderId")
    suspend fun deleteExams(parentFolderId: Int)


}