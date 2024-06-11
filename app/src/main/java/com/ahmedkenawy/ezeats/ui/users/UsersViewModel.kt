package com.ahmedkenawy.ezeats.ui.users

import android.annotation.SuppressLint
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedkenawy.ezeats.domain.model.User
import com.ahmedkenawy.ezeats.domain.use_case.show_users.UsersUseCase
import com.ahmedkenawy.ezeats.util.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * UsersViewModel is a ViewModel that manages the data and state for the UsersFragment.
 *
 * This ViewModel:
 * - Retrieves a list of users from a use case.
 * - Manages UI visibility for an internet connection state.
 *
 * Properties:
 * - usersLiveData: LiveData that holds the list of users.
 * - isInternetConnectedLiveData: LiveData that holds the visibility state of the internet connection indicator.
 *
 * Functions:
 * - getUsers(): Fetches users and updates the LiveData. It handles the internet connection state by toggling visibility.
 */

@HiltViewModel
class UsersViewModel @Inject constructor(private val usersUseCase: UsersUseCase) : ViewModel() {

    private val usersMutableLiveData = SingleLiveData<List<User?>>()
    val usersLiveData: SingleLiveData<List<User?>> get() = usersMutableLiveData

    private val isInternetConnectedMutableLiveData = SingleLiveData<Int>()
    val isInternetConnectedLiveData: SingleLiveData<Int> get() = isInternetConnectedMutableLiveData

    @SuppressLint("CheckResult")
    fun getUsers() {
        viewModelScope.launch {
            try {
                isInternetConnectedMutableLiveData.value = GONE
                val response = usersUseCase.invoke()
                if (response.isSuccessful) {
                    usersMutableLiveData.value = response.body()!!.data!!
                }
            } catch (e: Exception) {
                isInternetConnectedMutableLiveData.value = VISIBLE
            }
        }


    }

}
