package com.istody.simulei.ui

interface ToolbarListener {
    fun onToolbarVisibility(boolean: Boolean)
    fun onUpButtonVisibility(boolean: Boolean)
    fun onEditButtonVisibility(boolean: Boolean)
    fun onEditButtonClick(function : () -> Unit)
}