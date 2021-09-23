package com.example.task.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.R
import com.example.task.adapter.UserListRecyclerAdapter
import com.example.task.databinding.FragmentsUsersBinding
import com.example.task.viewmodel.UserListViewModel

class UsersFragment : Fragment() {

    private lateinit var binding: FragmentsUsersBinding
    private val usersViewModel:  UserListViewModel by viewModels()

    private val recyclerUserAdapter = UserListRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragments_users, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        super.onViewCreated(view, savedInstanceState)


        usersViewModel.getUserData()

        binding.userListRecyclerView.layoutManager= LinearLayoutManager(context)
        binding.userListRecyclerView.adapter= recyclerUserAdapter
        observeLiveData()
    }

    fun observeLiveData(){

        usersViewModel.users.observe(viewLifecycleOwner, Observer{
            it?.let{
                recyclerUserAdapter.userList= it
                recyclerUserAdapter.notifyDataSetChanged()

            }

        })
    }

}