package com.ahmedkenawy.ezeats.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ahmedkenawytask.R
import com.ahmedkenawytask.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
/**
 * LoginFragment handles the login screen UI and logic.
 *
 * Annotations:
 * @AndroidEntryPoint - Enables Hilt dependency injection.
 *
 * Properties:
 * - binding: FragmentLoginBinding - Interacts with the layout UI components.
 * - viewModel: LoginViewModel - Manages the login logic, scoped to the Fragment's lifecycle.
 *
 * Methods:
 * - onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
 *   - Inflates the layout using data binding and sets up the views.
 *
 * - setUpViews()
 *   - Sets click listener on login button, validates inputs, and navigates to UsersFragment if valid.
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        binding.btnLogin.setOnClickListener {
            viewModel.isValidInputs(
                binding.tvEmail,
                binding.etEmail,
                binding.tvPassword,
                binding.etPassword
            ) {
                findNavController().navigate(R.id.action_loginFragment_to_usersFragment)
            }
        }
    }
}
