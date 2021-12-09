package com.example.mc_ca.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mc_ca.data.RatingEntity

@Dao
interface RatingDao {

    // this insert deals with creating by inserting and also updates by replacing them
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRating(rating: RatingEntity)

    // ratings is defined in RatingEntity as the table name
    @Query("SELECT * FROM ratings WHERE id = :id")
    // Use ? as the object may be null - i.e. now entry in the DB for that id.
    fun getRatingById(id: String?):RatingEntity?
}