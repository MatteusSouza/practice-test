package com.istody.simulei.ui.viewmodel

import com.istody.simulei.data.*

class ExamViewModel : BaseViewModel() {

    private var questionList = mutableListOf<Question>()
//    private lateinit var emptyQuestion : Question

    var isNewExam : Boolean = false
    var isNewQuestion : Boolean = false


    fun addQuestion(question: Question){
        questionList.add(question)
    }

    fun updateQuestionList() {
        if(!isNewExam){
            questionList = getExampleQuestionList(
                folderId = getFolderId(),
                examId = getExamId()
            ).toMutableList()
        }
        else{
            questionList = mutableListOf<Question>()
        }
    }

//    fun updateQuestionDetail(): Question {
//        if (!isNewQuestion) {
//            return questionList[getQuestionId()]
//        }
//    }

    fun getQuestionList() : List<Question>{
        return questionList
    }

    fun getAnswerList(): List<Answer> {
        if(isNewQuestion) {
            return listOf<Answer>()
        }
        else{
            return getQuestionList()[getQuestionId()].answerList
        }
    }


}
