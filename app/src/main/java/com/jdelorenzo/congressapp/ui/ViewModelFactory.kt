package com.jdelorenzo.congressapp.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.jdelorenzo.congressapp.data.LegislatorDataSource
import com.jdelorenzo.congressapp.ui.legislators.LegislatorViewModel

class ViewModelFactory(private val legislatorDataSource: LegislatorDataSource) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LegislatorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LegislatorViewModel(legislatorDataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
