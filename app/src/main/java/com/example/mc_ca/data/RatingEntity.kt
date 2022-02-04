package com.example.mc_ca.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

//stores data in the ratings table of the local database
@Entity (tableName = "ratings")

//data class
//primary constructor RatingsEntity with parameters id and myRatings
//creates the data that is stored in the database
data class RatingEntity(
    @PrimaryKey val id: String,
    var myRatings: String
)
