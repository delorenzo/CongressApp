package com.jdelorenzo.congressapp.data.local

import com.jdelorenzo.congressapp.data.LegislatorDao
import com.jdelorenzo.congressapp.data.LegislatorDataSource
import com.jdelorenzo.congressapp.data.model.Legislator

import io.reactivex.Flowable

/**
 * Local data source for {@link Legislator} objects
 */
class LocalLegislatorDataSource(private val legislatorDao: LegislatorDao) : LegislatorDataSource {

    override fun getLegislator(): Flowable<Legislator>? {
        return null
    }
}
