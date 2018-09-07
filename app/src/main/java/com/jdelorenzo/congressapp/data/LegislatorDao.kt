package com.jdelorenzo.congressapp.data

import android.arch.lifecycle.LiveData
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
     * Get legislators from the table.
     * @return LiveData<List<Legislator>>
     */
    @get:Query("SELECT * FROM Legislators")
    val legislators: LiveData<List<Legislator>>

    /**
     * Get legislators matching a query parameter
     */
    @Query("SELECT * FROM legislators WHERE lastName = :lastName")
    fun legislatorsWithName(lastName: String): LiveData<List<Legislator>>

    /**
     * Insert a legislator into the database.
     *
     * @param Legislator the legislator to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertLegislator(legislator: Legislator)

}
