package com.ahmedkenawy.ezeats.ui.user_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ahmedkenawy.ezeats.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * UserDetailsViewModel handles the user data for UserDetailsFragment.
 *
 * Annotations:
 * @HiltViewModel - Enables Hilt dependency injection for the ViewModel.
 *
 * Properties:
 * - savedStateHandle: SavedStateHandle - Used to save and retrieve the user data across configuration changes.
 *
 * Methods:
 * - setUser(user: User?)
 *   - Saves the user data in the savedStateHandle.
 *
 * - getUser(): User?
 *   - Retrieves the user data from the savedStateHandle.
 */
@HiltViewModel
class UserDetailsViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    companion object {
        private const val USER = "user"
    }

    fun setUser(user: User?) {
        savedStateHandle[USER] = user
    }

    fun getUser(): User? {
        return savedStateHandle[USER]
    }
}
