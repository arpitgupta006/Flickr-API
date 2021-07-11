package com.arpit.flickrapi.models

import com.google.gson.annotations.SerializedName

data class FlickrResponse(

	@field:SerializedName("stat")
	val stat: String? = null,

	@field:SerializedName("photos")
	val photos: Photos? = null
)


