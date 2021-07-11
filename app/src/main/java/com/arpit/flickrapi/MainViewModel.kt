package com.arpit.flickrapi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arpit.flickrapi.models.PhotoItem
import com.arpit.flickrapi.models.Photos

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository  = MainRepository(application)
    val showProgress : LiveData<Boolean>
    val imageList : LiveData<List<PhotoItem>>

    init {
        this.showProgress = repository.showProgress
        this.imageList = repository.imageList
    }


    fun changeState(){
        repository.changeState()
    }

    fun loadImage(){
        repository.loadImage()
    }
}