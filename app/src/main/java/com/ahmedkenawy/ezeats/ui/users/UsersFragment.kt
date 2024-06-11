package com.ahmedkenawy.ezeats.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ahmedkenawy.ezeats.domain.model.User
import com.ahmedkenawytask.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * UsersFragment is a Fragment that displays a list of users using a RecyclerView.
 *
 * This fragment:
 * - Observes ViewModel data to update the UI.
 * - Handles user interactions, such as refreshing the list and clicking on items.
 *
 * Functions:
 * - onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
 *   - Inflates the fragment's layout.
 *
 * - onViewCreated(view: View, savedInstanceState: Bundle?)
 *   - Called after the fragment's view has been created. Sets up the views and observes data.
 *
 * - setUpViews()
 *   - Sets up click listeners for the views.
 *
 * - observeData()
 *   - Observes LiveData from the ViewModel to update the UI when data changes.
 *
 * - onItemClick(user: User)
 *   - Handles item click events, navigating to the UserDetailsFragment with the clicked user's details.
 */

@AndroidEntryPoint
class UsersFragment : Fragment(), UserAdapter.OnItemClickListener {
    private lateinit var binding: FragmentUsersBinding
    private val viewModel: UsersViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUsers()
        setUpViews()
        observeData()
    }

    private fun setUpViews() {
        binding.btnRefresh.setOnClickListener {
            viewModel.getUsers()
        }
    }

    private fun observeData() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) {
            userAdapter = UserAdapter(it, this)
            binding.rvUsers.adapter = userAdapter
        }
        viewModel.isInternetConnectedLiveData.observe(viewLifecycleOwner) { visibility ->
            binding.lottieAnimationView.visibility = visibility
            binding.btnRefresh.visibility = visibility
        }
    }

    override fun onItemClick(user: User) {
        val action = UsersFragmentDirections.actionUsersFragmentToUserDetailsFragment(user)
        findNavController().navigate(action)
    }
}