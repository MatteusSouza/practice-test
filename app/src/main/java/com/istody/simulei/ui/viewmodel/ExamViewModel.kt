package com.istody.simulei.ui.viewmodel

import androidx.lifecycle.*
import com.istody.simulei.data.model.Answer
import com.istody.simulei.data.model.Question
import com.istody.simulei.repository.AnswerRepository
import com.istody.simulei.repository.QuestionRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ExamViewModel(
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository
) : BaseViewModel() {

    private val questionListFromDb: LiveData<List<Question>> = questionRepository.questionList.asLiveData()
    private val answerListFromDb: LiveData<List<Answer>> = answerRepository.answerList.asLiveData()

    private var originalAnswerList: List<Answer> = mutableListOf()
    private var newAnswerList: MutableLiveData<MutableList<Answer>> = MutableLiveData<MutableList<Answer>>()

    var isNewQuestion = false
    var btSaveWasPressed = false

    fun insertAnswer(answer:  String, answerId: Int? = null) {
        newAnswerList.insertItem(Answer(getQuestionId(), getExamId(), getFolderId(), answer, answerId)
        )
    }

    fun getQuestion(): LiveData<Question> {
        return getQuestionDb()
    }

    fun saveQuestion(questionForm: String, statementQuestionForm: String, sourceForm: String)
    : Boolean {
        return if (questionForm != "" && newAnswerList.value != null){
            insertQuestionDb(questionForm, statementQuestionForm, sourceForm)
            btSaveWasPressed = true
            return true
        }else false
    }

    fun saveAnswers() {
        if (isNewQuestion) {
            val list = newAnswerList.value
            if ((list != null) && (list.size != 0) ) {
                for (item in list) {
                    insertAnswerDb(item.answer)
                }
            }
        }

        else {
            val newList = newAnswerList.value
            val oldList = originalAnswerList
            val idFromNewList = mutableListOf<Int>()

            if ((newList != null) && (newList.size != 0) ) {
                for (item in newList) {
                    if (item.answerId == null) {
                        insertAnswerDb(item.answer)
                    }
                    else{
                        updateAnswerDb(item.answerId, item.answer)
                    }
                    item.answerId?.let { answerId -> idFromNewList.add(answerId) }
                }
                for (item in oldList) {
                    if (!(idFromNewList.contains(item.answerId))) {
                        deleteAnswerDb(item)
                    }
                }
            }
        }
    }

    fun updateQuestion(questionForm: String, statementQuestionForm: String, sourceForm: String)
    : Boolean {
        return if (questionForm != "") {
            updateQuestionDb(questionForm, statementQuestionForm, sourceForm)
            btSaveWasPressed = true
            true
        }else false
    }

    fun getQuestionList() : LiveData<List<Question>> {
        return questionListFilteredByParentExamId(getExamId())
    }

    fun getAnswerList() : MutableList<Answer>? {
        return if (isNewQuestion) {
            mutableListOf()
        }
        else {
            newAnswerList.clearList()
            val list = originalAnswerList

            for (i in list) {
                insertAnswer(i.answer, i.answerId)
            }
            return newAnswerList.value
        }
    }

    fun getAllAnswerList(): LiveData<List<Answer>> {
        return answerListFromDb
    }

    fun getNewAnswerList(): MutableLiveData<MutableList<Answer>> {
        return newAnswerList
    }

    fun checkAnswerUpdate(data: List<Answer>) {
        val filter = data.filter {
            it.parentQuestionId == getQuestionId()
        }
        originalAnswerList = filter
    }

    fun resetAll() {
        btSaveWasPressed = false
        newAnswerList.clearList()
        originalAnswerList = mutableListOf()
    }

    private fun questionListFilteredByParentExamId(parentExamId: Int): LiveData<List<Question>> {
        return Transformations.map(questionListFromDb) { questions ->
            questions.filter {
                it.parentExamId == parentExamId
            }
        }
    }

    //------------//------------//------------//------------
    //------------//------------//------------//------------


    private fun getQuestionDb(): LiveData<Question> {
        return questionRepository.getQuestion(getQuestionId()).asLiveData()
    }

    private fun insertQuestionDb(question: String, statementQuestion: String, source: String
    ) = viewModelScope.launch {
        questionRepository.insertQuestion(
            Question(getExamId(), getFolderId(), question, statementQuestion, source)
        )
    }

    private fun insertAnswerDb(answer: String) = viewModelScope.launch {
        answerRepository.insertAnswer(
            Answer(getQuestionId(), getExamId(), getFolderId(), answer)
        )
    }

    private fun updateQuestionDb(question: String, statementQuestion: String, source: String
    ) = viewModelScope.launch {
        questionRepository.updateQuestion(getQuestionId(), question, statementQuestion, source)
    }

    private fun updateAnswerDb(answerId: Int, answer: String) = viewModelScope.launch {
        answerRepository.updateAnswer(getQuestionId(), answerId, answer)
    }

    private fun deleteQuestionDb(question: Question) = viewModelScope.launch {
        questionRepository.deleteQuestion(question)
    }


    private fun deleteAnswerDb(answer: Answer) = viewModelScope.launch {
        answerRepository.deleteAnswer(answer)
    }

    fun getLastQuestionId(): LiveData<Int> {
        return questionRepository.getLastQuestionId().asLiveData()
    }

    //------------//------------//------------//------------
    //------------//------------//------------//------------


    private fun <T> MutableLiveData<MutableList<T>>.insertItem(item: T) {
        val oldList = this.value?: mutableListOf()
        oldList.add(item)
        this.postValue(oldList)
    }

    private fun <T> MutableLiveData<MutableList<T>>.clearList() {
        val oldList = this.value?: mutableListOf()
        oldList.clear()
        this.postValue(oldList)
    }
}

class ExamViewModelFactory(
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExamViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExamViewModel(questionRepository, answerRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}