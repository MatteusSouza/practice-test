package com.istody.simulei.data.dao

import androidx.room.*
import com.istody.simulei.data.model.Exam
import com.istody.simulei.data.model.FromTablePair
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Dao
interface ExamDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExam(exam: Exam)

    @Query("SELECT * FROM exam_table ORDER BY examName ASC")
    suspend fun getExamList() : List<Exam>

    @Query("SELECT * FROM exam_table WHERE examId = :examId")
    fun getExam(examId: Int) : Flow<Exam>

    @Query("UPDATE exam_table SET examName = :examName WHERE examId = :examId")
    suspend fun updateExam(examId: Int, examName: String)

    suspend fun deleteExam(exam: Exam){
        deleteAllDependent(exam)
    }

    @Query("SELECT examId FROM exam_table ORDER BY examId DESC LIMIT 1")
    suspend fun getLastExamId() :  Int

    fun getExamPair() : Flow<FromTablePair<List<Exam>, Int>> {
        return examPair()
    }

    // **************************************************************
    // **************************************************************


    suspend fun deleteAllDependent(exam: Exam) {
        exam.examId?.let {
            deleteAnswers(it)
            deleteQuestions(it)
        }
        deleteSelected(exam)
    }

    @Delete
    suspend fun deleteSelected(Exam: Exam)

    @Query("DELETE FROM answer_table WHERE parentQuestionId = :parentQuestionId")
    suspend fun deleteAnswers(parentQuestionId: Int)

    @Query("DELETE FROM question_table WHERE parentExamId = :parentExamId")
    suspend fun deleteQuestions(parentExamId: Int)


    // **************************************************************
    // **************************************************************

    private fun examPair() : Flow<FromTablePair<List<Exam>, Int>> = flow {

        suspend fun fromTablePair() = FromTablePair(getExamList(), getLastExamId())

        var oldValue = fromTablePair()
        var live : FromTablePair<List<Exam>, Int>
        emit(oldValue)

        while (true){

            while (true) {
                live = fromTablePair()

                if (oldValue != live) {
                    oldValue = live
                    break
                }
                delay(1000)

            }
            emit(live)
        }
    }




}

