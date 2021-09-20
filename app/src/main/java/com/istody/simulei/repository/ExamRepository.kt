package com.istody.simulei.repository

import androidx.annotation.WorkerThread
import com.istody.simulei.data.dao.ExamDao
import com.istody.simulei.data.model.Exam
import com.istody.simulei.data.model.FromTablePair
import kotlinx.coroutines.flow.Flow

class ExamRepository(private val examDao: ExamDao) {

    fun getExamPair(): Flow<FromTablePair<List<Exam>, Int>> = examDao.getExamPair()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertExam(exam: Exam) {
        return examDao.insertExam(exam)
    }

    fun getExam(examId: Int) : Flow<Exam> {
        return examDao.getExam(examId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateExam(examId: Int, examName: String) {
        examDao.updateExam(examId, examName)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteExam(exam: Exam) {
        examDao.deleteExam(exam)
    }


}