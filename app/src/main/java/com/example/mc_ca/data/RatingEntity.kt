package com.example.mc_ca.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "ratings")
data class RatingEntity(
    @PrimaryKey val id: String,
    var myRatings: String
)
