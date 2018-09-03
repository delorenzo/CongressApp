package com.jdelorenzo.congressapp.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.jdelorenzo.congressapp.data.model.Legislator

import io.reactivex.Flowable

/**
 * Data access object for the legislator table
 */
@Dao
interface LegislatorDao {

    /**
     * Get the legislator from the table.
     * @return
     */
    @get:Query("SELECT * FROM Legislators")
    val legislator: Flowable<Legislator>

    /**
     * Insert a legislator into the database.
     *
     * @param Legislator the legislator to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertLegislator(legislator: Legislator)


}
