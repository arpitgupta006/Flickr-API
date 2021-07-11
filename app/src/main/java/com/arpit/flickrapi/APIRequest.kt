package com.arpit.flickrapi

import com.arpit.flickrapi.models.PhotoItem
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://api.flickr.com/services/rest/"
const val apikey = "6f102c62f41998d151e5a1b48713cf13"

interface APIRequest {


    @GET("?method=flickr.photos.getRecent&per_page=20&page=1&api_key={$apikey}&format=json&nojsoncallback=1&extras=url_s")
     fun getImages(): Call<List<PhotoItem>>

}