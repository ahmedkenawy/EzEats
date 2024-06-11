package com.ahmedkenawy.ezeats.ui.user_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmedkenawytask.R
import com.ahmedkenawytask.databinding.FragmentUserDetailsBinding
/**
 * UserDetailsFragment displays the details of a user.
 *
 * Properties:
 * - binding: FragmentUserDetailsBinding - Binds the fragment's layout UI components.
 * - viewModel: UserDetailsViewModel - Manages the user data, scoped to the Fragment's lifecycle.
 * - args: UserDetailsFragmentArgs - Retrieves the user passed as an argument to the fragment.
 *
 * Methods:
 * - onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
 *   - Inflates the layout using data binding.
 *
 * - onViewCreated(view: View, savedInstanceState: Bundle?)
 *   - Sets the user in the ViewModel and binds it to the UI.
 */
class UserDetailsFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailsBinding
    private val viewModel: UserDetailsViewModel by viewModels()
    val args: UserDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setUser(args.user)

        viewModel.getUser()?.let { user ->
            binding.user = user
        }
    }
}
