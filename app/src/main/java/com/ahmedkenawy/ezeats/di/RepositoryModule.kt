package com.ahmedkenawy.ezeats.di

import com.ahmedkenawy.ezeats.data.remote.ApiService
import com.ahmedkenawy.ezeats.data.repository.UserRepositoryImpl
import com.ahmedkenawy.ezeats.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RepositoryModule is a Dagger Hilt module responsible for providing dependencies related to repositories.
 *
 * This module:
 * - Defines a method to provide a UserRepository implementation.
 *
 * Annotations:
 * - @InstallIn(SingletonComponent::class): Specifies that the bindings in this module are available for the lifetime of the application.
 *
 * Functions:
 * - provideUserRepository(apiService: ApiService): Provides a singleton instance of UserRepositoryImpl, which is implemented by UserRepository interface.
 *   - Returns an instance of UserRepositoryImpl that depends on an instance of ApiService.
 */

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }
}