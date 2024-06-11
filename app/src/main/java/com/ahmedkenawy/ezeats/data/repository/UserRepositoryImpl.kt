package com.ahmedkenawy.ezeats.data.repository

import com.ahmedkenawy.ezeats.data.remote.ApiService
import com.ahmedkenawy.ezeats.domain.repository.UserRepository
import javax.inject.Inject

/**
 * UserRepositoryImpl is an implementation of the UserRepository interface.
 *
 * This class:
 * - Implements the getUsers() function to fetch users from the ApiService.
 *
 * Constructor:
 * - apiService: ApiService dependency used to make network requests.
 *
 * Functions:
 * - getUsers(): Calls the getUsers() function from the ApiService to fetch a list of users.
 *   - Returns the Response object containing the list of users wrapped in a BaseResponse.
 */

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {
    override suspend fun getUsers() = apiService.getUsers()
}