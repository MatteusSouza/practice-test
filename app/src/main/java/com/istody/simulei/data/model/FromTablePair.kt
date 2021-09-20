package com.istody.simulei.data.model

import java.io.Serializable

/**
    EXAMPLE

    fun getFromDatabase() : FromTablePair<List<String>, Int> {
        val list = listOf("word1", "word2", "word3")
        return FromTablePair(list, list.size)
    }

    fun execute() {
        val example = getFromDatabase()
        val a = example.lastId
        val b = example.list
    }

 **/
data class FromTablePair<out A, out B>(
    val list: A,
    val lastId: B
) : Serializable

