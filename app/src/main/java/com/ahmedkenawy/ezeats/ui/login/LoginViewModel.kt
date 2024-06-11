package com.ahmedkenawy.ezeats.ui.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
/**
 * LoginViewModel handles the validation logic for login inputs.
 *
 * Annotations:
 * @HiltViewModel - Enables Hilt dependency injection for the ViewModel.
 *
 * Methods:
 * - isAValidEmail(textInputEditText: TextInputEditText, textInputLayout: TextInputLayout): Boolean
 *   - Validates the email for non-empty and proper format, setting error messages accordingly.
 *
 * - isValidPassword(textInputEditText: TextInputEditText, textInputLayout: TextInputLayout): Boolean
 *   - Validates the password for non-empty, minimum length, and containing uppercase, lowercase, and digit characters, setting error messages accordingly.
 *
 * - isValidInputs(emailLayoutL: TextInputEditText, email: TextInputLayout, passwordLayout: TextInputEditText, password: TextInputLayout, onSuccess: () -> Unit)
 *   - Validates both email and password, and executes onSuccess callback if both are valid.
 */
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private fun isAValidEmail(
        textInputEditText: TextInputEditText,
        textInputLayout: TextInputLayout
    ): Boolean {
        val email = textInputEditText.text.toString()
        val isEmpty = email.isBlank()
        val isValidFormat = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        textInputLayout.error = when {
            isEmpty -> "This Field Is Required"
            !isValidFormat -> "Invalid Email Format"
            else -> ""
        }
        return !isEmpty && isValidFormat
    }

    private fun isValidPassword(
        textInputEditText: TextInputEditText,
        textInputLayout: TextInputLayout
    ): Boolean {
        val password = textInputEditText.text.toString()
        val isEmpty = password.isBlank()
        val isValidLength = password.length >= 8
        val hasUppercase = password.any { it.isUpperCase() }
        val hasLowercase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }

        textInputLayout.error = when {
            isEmpty -> "This Field Is Required"
            !isValidLength -> "Password must be at least 8 characters"
            !hasUppercase -> "Password must contain at least one uppercase letter"
            !hasLowercase -> "Password must contain at least one lowercase letter"
            !hasDigit -> "Password must contain at least one digit"
            else -> ""
        }
        return !isEmpty && isValidLength && hasUppercase && hasLowercase && hasDigit
    }

    fun isValidInputs(
        emailLayoutL: TextInputEditText,
        email: TextInputLayout,
        passwordLayout: TextInputEditText,
        password: TextInputLayout,
        onSuccess: () -> Unit
    ) {
        if (isAValidEmail(emailLayoutL, email) &&
            isValidPassword(passwordLayout, password)
        ) {
            onSuccess()
        }
    }
}
