package com.istody.simulei.ui.viewmodel

import com.istody.simulei.data.*

class ListViewModel : BaseViewModel() {

//    private var folderList: List<String> = getExampleFolderList()
//    private var examList: List<Exam> = getExampleExamList(getFolderId())

    fun getFolderList(): List<String> {
        return getExampleFolderList()
    }

    fun getExamList(): List<Exam> {
        return getExampleExamList(getFolderId())
    }

}


