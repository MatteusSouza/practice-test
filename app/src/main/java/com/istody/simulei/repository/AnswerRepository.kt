package com.istody.simulei.repository

import androidx.annotation.WorkerThread
import com.istody.simulei.data.dao.AnswerDao
import com.istody.simulei.data.model.Answer
import kotlinx.coroutines.flow.Flow

class AnswerRepository(private val answerDao: AnswerDao) {

    val answerList: Flow<List<Answer>> = answerDao.getAnswerList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertAnswer(answer: Answer) {
        answerDao.insertAnswer(answer)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAnswer(answerId: Int) {
        answerDao.getAnswer(answerId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateAnswer(parentQuestionId: Int, answerId: Int, answer: String) {
        answerDao.updateAnswer(parentQuestionId, answerId, answer)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAnswer(answer: Answer) {
        answerDao.deleteAnswer(answer)
    }

}