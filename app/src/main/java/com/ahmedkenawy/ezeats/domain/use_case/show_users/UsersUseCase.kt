package com.ahmedkenawy.ezeats.domain.use_case.show_users

import com.ahmedkenawy.ezeats.domain.repository.UserRepository
import javax.inject.Inject

/**
 * UsersUseCase is a use case class responsible for fetching a list of users from the UserRepository.
 *
 * This class:
 * - Acts as an intermediary between the ViewModel and the repository layer.
 * - Simplifies the process of retrieving users by using the invoke operator function.
 *
 * Functions:
 * - invoke(): Fetches users from the UserRepository and returns the result.
 */

class UsersUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke() =
        repository.getUsers()
}