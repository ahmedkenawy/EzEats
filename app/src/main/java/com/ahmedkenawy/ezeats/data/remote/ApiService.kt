package com.ahmedkenawy.ezeats.data.remote

import com.ahmedkenawy.ezeats.domain.model.User
import com.ahmedkenawy.ezeats.util.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * ApiService is an interface defining the API endpoints and their corresponding network requests.
 *
 * This interface:
 * - Specifies the HTTP methods (e.g., GET) and endpoint paths.
 * - Defines suspend functions for making network requests asynchronously.
 *
 * Functions:
 * - getUsers(): Defines a suspend function to fetch a list of users from the API.
 *   - Returns a Response object containing a BaseResponse wrapped list of users.
 */

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<BaseResponse<List<User>>>
}