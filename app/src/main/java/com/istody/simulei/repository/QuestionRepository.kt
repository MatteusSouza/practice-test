package com.istody.simulei.repository

import androidx.annotation.WorkerThread
import com.istody.simulei.data.dao.QuestionDao
import com.istody.simulei.data.model.Question
import kotlinx.coroutines.flow.Flow

class QuestionRepository(private val questionDao: QuestionDao) {

    val questionList: Flow<List<Question>> = questionDao.getQuestionList()

    fun getQuestion(questionId: Int) : Flow<Question> {
        return questionDao.getQuestion(questionId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertQuestion(question: Question) {
        questionDao.insertQuestion(question)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateQuestion(questionId: Int, question: String, statement: String, source: String) {
        questionDao.updateQuestion(questionId, question, statement, source)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question)
    }

    fun getLastQuestionId() : Flow<Int> {
        return questionDao.getLastQuestionId()
    }

}