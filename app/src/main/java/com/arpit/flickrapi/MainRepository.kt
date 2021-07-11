package com.arpit.flickrapi

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.arpit.flickrapi.models.PhotoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val imageList = MutableLiveData<List<PhotoItem>>()


    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun loadImage() {
        showProgress.value = true
        // Networkcall

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()


        val service = retrofit.create(APIRequest::class.java)


        service.getImages().enqueue(object  : Callback<List<PhotoItem>> {
            override fun onFailure(call: Call<List<PhotoItem>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error wile accessing the API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<PhotoItem>>,
                response: Response<List<PhotoItem>>
            ) {
                imageList.value = response.body()
                showProgress.value = false
            }

        })
    }
}