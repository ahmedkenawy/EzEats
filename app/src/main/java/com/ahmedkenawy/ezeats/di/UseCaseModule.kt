package com.ahmedkenawy.ezeats.di

import com.ahmedkenawy.ezeats.data.remote.ApiService
import com.ahmedkenawy.ezeats.data.repository.UserRepositoryImpl
import com.ahmedkenawy.ezeats.domain.repository.UserRepository
import com.ahmedkenawy.ezeats.domain.use_case.show_users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * UseCaseModule is a Dagger Hilt module responsible for providing dependencies related to use cases.
 *
 * This module:
 * - Defines a method to provide a UsersUseCase.
 *
 * Annotations:
 * - @InstallIn(SingletonComponent::class): Specifies that the bindings in this module are available for the lifetime of the application.
 *
 * Functions:
 * - provideUserUseCase(userRepository: UserRepository): Provides a singleton instance of UsersUseCase.
 *   - Returns an instance of UsersUseCase that depends on an instance of UserRepository.
 */

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUserUseCase(userRepository: UserRepository): UsersUseCase {
        return UsersUseCase(userRepository)
    }
}