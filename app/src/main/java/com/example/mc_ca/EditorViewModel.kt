package com.example.mc_ca

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mc_ca.data.RatingEntity
import com.example.mc_ca.localDB.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditorViewModel (app: Application) : AndroidViewModel(app) {
    private val database = AppDatabase.getInstance(app)
    val currentRating = MutableLiveData<RatingEntity>()

    fun getRating(ratingId: String?) {
        Log.i(TAG2, "Id : " + ratingId)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val rating =
                    database?.ratingDao()?.getRatingById(ratingId)

                rating?.let {
                    currentRating.postValue(it)
                    Log.i(TAG2, "MYRATINGS Returned from DB" + it.myRatings)
                }
            }
        }
    }

    fun saveRating(ratingEntity: RatingEntity) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                database?.ratingDao()?.insertRating(ratingEntity)
            }
        }
    }
}