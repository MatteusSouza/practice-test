package com.istody.simulei.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.istody.simulei.ui.ToolbarListener


open class BaseViewModel : ViewModel() {

    var toolbarSupport : ToolbarListener? = null //Refactor
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

    fun setFolderId(itemId: Int) {
        folderId = itemId
    }

    fun setExamId(itemId: Int) {
        examId = itemId
    }

    fun setQuestionId(itemId: Int) {
        questionId = itemId
    }

    fun getFolderId(): Int {
        return folderId!!
    }

    fun getExamId(): Int {
        return examId!!
    }

    fun getQuestionId(): Int {
        return questionId!!
    }

}