package com.istody.simulei.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.istody.simulei.ui.ToolbarListener


open class BaseViewModel : ViewModel() {

    var toolbarSupport : ToolbarListener? = null //Refactor

//    private var idItemClicked : Int? = null
    private var folderId : Int? = null
    private var examId : Int? = null
    private var questionId : Int? = null


    fun toolbarVisibility(boolean: Boolean){
        toolbarSupport?.onToolbarVisibility(boolean)
    }

    fun upButtonVisibility(boolean: Boolean){
        toolbarSupport?.onUpButtonVisibility(boolean)
    }

    fun editButtonVisibility(boolean: Boolean){
        toolbarSupport?.onEditButtonVisibility(boolean)
    }

    fun editButtonClick(function: () -> Unit) {
            toolbarSupport?.onEditButtonClick {
                function()
        }
    }

//    fun getIdItemClicked(): Int {
//        return idItemClicked!!
//    }
//
//    fun setIdItemClicked(itemId: Int) {
//        idItemClicked = itemId
//    }
//
    //FolderID
    fun getFolderId(): Int {
        return folderId!!
    }

    fun setFolderId(itemId: Int) {
        folderId = itemId
    }

    //ExamId
    fun getExamId(): Int {
        return examId!!
    }

    fun setExamId(itemId: Int) {
        examId = itemId
    }

    //QuestionId
    fun getQuestionId(): Int {
        return questionId!!
    }

    fun setQuestionId(itemId: Int) {
        questionId = itemId
    }

}