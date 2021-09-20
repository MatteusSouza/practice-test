package com.istody.simulei.data.dao

import androidx.room.*
import com.istody.simulei.data.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestion(question: Question)

    @Query("SELECT * FROM question_table ORDER BY question ASC")
    fun getQuestionList() : Flow<List<Question>>

    @Query("SELECT * FROM question_table WHERE questionId = :questionId")
    fun getQuestion(questionId: Int) : Flow<Question>

    @Query("UPDATE question_table SET question = :question, statement_question = :statement, source = :source WHERE questionId = :questionId")
    suspend fun updateQuestion(questionId: Int, question: String, statement: String, source: String)

    suspend fun deleteQuestion(question: Question){
        deleteAllDependent(question)
    }

    @Query("SELECT questionId FROM question_table ORDER BY questionId DESC LIMIT 1")
    fun getLastQuestionId() :  Flow<Int>

    // **************************************************************
    // **************************************************************


    suspend fun deleteAllDependent(question: Question) {
        question.questionId?.let { deleteAnswers(it) }
        deleteSelected(question)
    }

    @Delete
    suspend fun deleteSelected(question: Question)

    @Query("DELETE FROM answer_table WHERE parentQuestionId = :parentQuestionId")
    suspend fun deleteAnswers(parentQuestionId: Int)

}