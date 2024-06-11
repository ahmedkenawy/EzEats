package com.ahmedkenawy.ezeats.domain.repository

import com.ahmedkenawy.ezeats.domain.model.User
import com.ahmedkenawy.ezeats.util.BaseResponse
import retrofit2.Response

/**
 * UserRepository is an interface that defines a method for fetching users from a data source.
 *
 * Functions:
 * - getUsers(): Suspends the coroutine and fetches a list of users wrapped in a Response object.
 */
interface UserRepository {
    suspend fun getUsers(): Response<BaseResponse<List<User>>>
}