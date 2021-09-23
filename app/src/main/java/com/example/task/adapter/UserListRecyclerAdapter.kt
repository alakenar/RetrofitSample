package com.example.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.model.Users
import com.example.task.databinding.UsersItemBinding
import com.example.task.view.UsersFragmentDirections

class UserListRecyclerAdapter(var userList: List<Users>) :
    RecyclerView.Adapter<UserListRecyclerAdapter.UserViewHolder>() {


    class UserViewHolder(val view: UsersItemBinding) : RecyclerView.ViewHolder(view.root) {


        fun bind(item: Users) {
            view.userNameText.text = item.username
            view.nameText.text = item.name
            view.mailText.text = item.email

           /* itemView.setOnClickListener {
                val action = UsersFragmentDirections.actionUsersFragmentToPostFragment()
                Navigation.findNavController(it).navigate(action)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

      val binding = DataBindingUtil.inflate<UsersItemBinding>(LayoutInflater.from(parent.context), R.layout.users_item , parent, false)
      return UserViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

     val item = userList.get(position)
        holder.bind(item)

    }

    override fun getItemCount(): Int {

        return userList.size

    }

}