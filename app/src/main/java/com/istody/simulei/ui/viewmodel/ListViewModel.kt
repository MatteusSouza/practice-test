package com.istody.simulei.ui.viewmodel

import androidx.lifecycle.*
import com.istody.simulei.data.model.Answer
import com.istody.simulei.data.model.Exam
import com.istody.simulei.data.model.Folder
import com.istody.simulei.data.model.Question
import com.istody.simulei.repository.ExamRepository
import com.istody.simulei.repository.FolderRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ListViewModel(
    private val folderRepository: FolderRepository,
    private val examRepository: ExamRepository
    ) : BaseViewModel() {

    val folderList: LiveData<List<Folder>> = folderRepository.folderList.asLiveData()
    val exams = examRepository.getExamPair().asLiveData()

    var examSaved: Boolean = false

    fun insertFolder(folderName: String) : Boolean {
        return if (folderName.isNotEmpty()) {
            insertFolderDb(folderName)
            true
        }else false
    }

    fun insertExam(examName: String) : Boolean {
        return if(examName.isNotEmpty()){
            examSaved = true
            insertExamDb(examName)
            true
        }else false
    }

    fun filter(list: List<Exam>): List<Exam> {
        /** examList Filtered By ParentFolderId **/
        return list.filter {
            it.parentFolderId == getFolderId()
        }
    }

    fun deleteFolder(folder: Folder) {
        deleteFolderDb(folder)
    }

    //--------------//--------------//--------------

    private fun insertFolderDb(folderName: String) = viewModelScope.launch {
        folderRepository.insertFolder(Folder(folderName))
    }

    private fun insertExamDb(examName: String) = viewModelScope.launch {
            examRepository.insertExam(
                Exam(examName,getFolderId()
                )
            )
    }

    private fun getExamDb(): LiveData<Exam> {
        return examRepository.getExam(getExamId()).asLiveData()
    }

    private fun updateFolderDb(folderName: String) = viewModelScope.launch {
        folderRepository.updateFolder(getFolderId(), folderName)
    }

    private fun updateExamDb(examName: String) = viewModelScope.launch {
        examRepository.updateExam(getExamId(), examName)
    }

    private fun deleteFolderDb(folder: Folder) = viewModelScope.launch {
        folderRepository.deleteFolder(folder)
    }

    private fun deleteExamDb(exam: Exam) = viewModelScope.launch {
        examRepository.deleteExam(exam)
    }

    //--------------//--------------//--------------

}

class ListViewModelFactory(
    private val folderRepository: FolderRepository,
    private val examRepository: ExamRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ListViewModel(folderRepository, examRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }