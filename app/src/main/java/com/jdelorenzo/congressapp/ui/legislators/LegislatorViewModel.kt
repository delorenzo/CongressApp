package com.jdelorenzo.congressapp.ui.legislators

import android.arch.lifecycle.ViewModel

import com.jdelorenzo.congressapp.data.LegislatorDataSource
import com.jdelorenzo.congressapp.data.model.Legislator

import io.reactivex.Flowable

class LegislatorViewModel(private val dataSource: LegislatorDataSource) : ViewModel() {

    private var legislator: Legislator? = null

    /**
     * Get the name of a legislator
     *
     * @return a [io.reactivex.Flowable] that will emit every time the legislator's name
     * is updated.
     */
    val legislatorName: Flowable<String>
        get() = dataSource.legislator
                .map { legislator ->
                    this.legislator = legislator
                    legislator.firstName
                }
}
