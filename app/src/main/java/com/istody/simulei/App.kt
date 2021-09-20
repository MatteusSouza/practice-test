package com.istody.simulei

import android.app.Application
import com.istody.simulei.data.AppDatabase
import com.istody.simulei.repository.AnswerRepository
import com.istody.simulei.repository.ExamRepository
import com.istody.simulei.repository.FolderRepository
import com.istody.simulei.repository.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val folderRepository by lazy { FolderRepository(database.folderDao()) }
    val examRepository by lazy { ExamRepository(database.examDao()) }
    val questionRepository by lazy { QuestionRepository(database.questionDao()) }
    val answerRepository by lazy { AnswerRepository(database.answerDao()) }
}