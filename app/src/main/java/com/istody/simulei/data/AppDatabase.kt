package com.istody.simulei.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.istody.simulei.data.dao.AnswerDao
import com.istody.simulei.data.dao.ExamDao
import com.istody.simulei.data.dao.FolderDao
import com.istody.simulei.data.dao.QuestionDao
import com.istody.simulei.data.model.Answer
import com.istody.simulei.data.model.Exam
import com.istody.simulei.data.model.Folder
import com.istody.simulei.data.model.Question
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Answer::class, Exam::class, Folder::class, Question::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun folderDao() : FolderDao
    abstract fun examDao() : ExamDao
    abstract fun questionDao() : QuestionDao
    abstract fun answerDao() : AnswerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val thisFolderDao = database.folderDao()
                    val thisExamDao = database.examDao()
                    val thisQuestionDao = database.questionDao()
                    val thisAnswerDao = database.answerDao()

                    //Folders
                    val folder = Folder("Folder Example")
                    thisFolderDao.insertFolder(folder)

                    //Exams
                    val exam = Exam("Exam Example",1)
                    thisExamDao.insertExam(exam)

                    //Questions
                    val question = Question(1, 1, "Question Example")
                    thisQuestionDao.insertQuestion(question)
                    //Answers
                    val answer = Answer(1, 1, 1, "Answer Example")
                    thisAnswerDao.insertAnswer(answer)
                }
            }
        }
    }

}