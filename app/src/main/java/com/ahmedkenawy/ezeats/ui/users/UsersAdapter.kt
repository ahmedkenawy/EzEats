package com.ahmedkenawy.ezeats.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmedkenawy.ezeats.domain.model.User
import com.ahmedkenawytask.databinding.ItemUserBinding
/**
 * UserAdapter is a RecyclerView adapter for displaying a list of users.
 *
 * Parameters:
 * - users: List<User?> - List of users to be displayed in the RecyclerView.
 * - listener: OnItemClickListener - Interface for handling click events on the user items.
 *
 * Methods:
 * - onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder
 *   - Inflates the layout for each user item and returns a UserViewHolder.
 *
 * - onBindViewHolder(holder: UserViewHolder, position: Int)
 *   - Binds the user data to the ViewHolder.
 *
 * - getItemCount(): Int
 *   - Returns the total number of items in the list.
 *
 * Inner Classes:
 * - UserViewHolder(binding: ItemUserBinding, listener: OnItemClickListener)
 *   - ViewHolder class for binding the user data to the view and handling click events.
 *
 * Interfaces:
 * - OnItemClickListener
 *   - Defines a method for handling item click events.
 */
class UserAdapter(
    private val users: List<User?>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemUserBinding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position]!!)
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder(
        private val binding: ItemUserBinding,
        private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                listener.onItemClick(user)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(user: User)
    }
}
