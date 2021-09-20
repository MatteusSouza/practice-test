package com.istody.simulei.data.dao

import androidx.room.*
import com.istody.simulei.data.model.Answer
import kotlinx.coroutines.flow.Flow

@Dao
interface AnswerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnswer(answer: Answer)

    @Query("SELECT * FROM answer_table ORDER BY answer")
    fun getAnswerList() : Flow<List<Answer>>

    @Query("SELECT * FROM answer_table WHERE answerId = :answerId")
    suspend fun getAnswer(answerId: Int) : Answer   //remove

    @Query("UPDATE answer_table SET answer = :answer, parentQuestionId = :parentQuestionId WHERE answerId = :answerId")
    suspend fun updateAnswer(parentQuestionId: Int, answerId: Int, answer: String)

    @Delete
    suspend fun deleteAnswer(answer: Answer)

}