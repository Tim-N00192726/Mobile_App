package com.example.mc_ca.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mc_ca.data.RatingEntity

// If you make changes to your Entity class and therefore need to make changes to your table easiest thing
// to do is change the version here and uncomment .fallbackToDestructiveMigration() below.
// This will scrap the whole database and start again.
@Database(entities = [RatingEntity::class], version = 2, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {

    // this will be instantiated and all the abstract methods in the DAO will be implemented
    abstract fun ratingDao(): RatingDao?

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "ratings.db"
                    )//.fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}