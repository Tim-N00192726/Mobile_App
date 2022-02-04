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

//gets the ratings in Rating Entity. table name ratings is defined in RatingEntity
    @Query("SELECT * FROM ratings WHERE id = :id")
    // gets rating by id. ? is used because value may be null
    fun getRatingById(id: String?):RatingEntity?
}