package com.istody.simulei.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.istody.simulei.R
import com.istody.simulei.ui.fragment.*
import com.istody.simulei.ui.viewmodel.ExamViewModel
import com.istody.simulei.ui.viewmodel.ListViewModel
import com.istody.simulei.ui.viewmodel.PracticeViewModel

class MainActivity : AppCompatActivity(), ToolbarListener {

//    private val baseViewModel: BaseViewModel by viewModels()
    private val listViewModel: ListViewModel by viewModels()
    private val examViewModel: ExamViewModel by viewModels()
    private val practiceViewModel: PracticeViewModel by viewModels()

    private var toolbarEditButton : MenuItem? = null
    private var editButtonClick: (() -> Unit)? = null

//    var navCount: Int = 0 //Navigate Counter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Refactor
        listViewModel.toolbarSupport = this
        examViewModel.toolbarSupport = this
        practiceViewModel.toolbarSupport = this

        setSupportActionBar(findViewById(R.id.toolbar))

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