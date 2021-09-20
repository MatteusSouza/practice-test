package com.istody.simulei.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.istody.simulei.App
import com.istody.simulei.R
import com.istody.simulei.databinding.ActivityMainBinding
import com.istody.simulei.ui.fragment.*
import com.istody.simulei.ui.viewmodel.*

class MainActivity : AppCompatActivity(), ToolbarListener {

    private lateinit var binding: ActivityMainBinding

    private val listViewModel: ListViewModel by viewModels {
        ListViewModelFactory(
            (application as App).folderRepository,
            (application as App).examRepository
        )
}
    private val examViewModel: ExamViewModel by viewModels {
        ExamViewModelFactory(
            (application as App).questionRepository,
            (application as App).answerRepository
        )
    }
//    private val practiceViewModel: PracticeViewModel by viewModels()

    private var toolbarEditButton : MenuItem? = null
    private var editButtonClick: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Refactor
        listViewModel.toolbarSupport = this
        examViewModel.toolbarSupport = this
//        practiceViewModel.toolbarSupport = this

        setSupportActionBar(binding.toolbar)
        upHomeButton(true)
    }

    private fun upHomeButton(option: Boolean){
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(option)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        toolbarEditButton = menu?.findItem(R.id.edit_icon)
        toolbarEditButton?.isVisible = false

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.edit_icon -> {
            editButtonClick?.let { it() }
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onToolbarVisibility(boolean: Boolean) {
        supportActionBar?.hide()
    }

    override fun onUpButtonVisibility(boolean: Boolean) {
        upHomeButton(boolean)
    }

    override fun onEditButtonVisibility(boolean: Boolean) {
        toolbarEditButton?.isVisible = boolean
        if (!boolean) {
            editButtonClick = null
        }
    }

    override fun onEditButtonClick(function : () -> Unit) {
        editButtonClick = function
    }

}