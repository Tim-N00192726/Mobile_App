package com.example.mc_ca

import android.util.Log
import androidx.lifecycle.*
import com.example.mc_ca.data.JokeEntity
import com.example.mc_ca.webaccess.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val _jokes: MutableLiveData<List<JokeEntity>> = MutableLiveData()

    // jokes is exposed to the UI - Fragment
    val jokes: LiveData<List<JokeEntity>>
        // get() This is a getter() function, which returns the list of jokes as LiveData
        get() = _jokes

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading



    init {
        //get jokes data to use in the UI
        getJokes()
    }

    private fun getJokes() {
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedJokes = RetrofitInstance.api.getJokes()
            Log.i(TAG, "List of Jokes : $fetchedJokes")
            _jokes.value = fetchedJokes
            _isLoading.value = false
        }
    }
}