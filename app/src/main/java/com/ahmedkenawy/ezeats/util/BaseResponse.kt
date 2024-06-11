package com.ahmedkenawy.ezeats.util

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    var data: T? = null
)