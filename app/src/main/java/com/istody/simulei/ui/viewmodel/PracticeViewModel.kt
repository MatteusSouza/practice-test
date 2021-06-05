package com.istody.simulei.ui.viewmodel

import com.istody.simulei.data.*

class PracticeViewModel : BaseViewModel() {

//    private var examList : List<Exam> = exam
//    private var questionList : List<Question> = question

//    private var questionList : List<Question> = getExampleQuestionList(
//        folderId = getFolderId(),
//        examId = getExamId()
//    )

    fun getQuestionList(): List<Question> {
        return getExampleQuestionList(
            folderId = getFolderId(),
            examId = getExamId()
        )
    }
}