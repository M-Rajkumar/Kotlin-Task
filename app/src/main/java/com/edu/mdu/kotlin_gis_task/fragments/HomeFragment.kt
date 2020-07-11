package com.edu.mdu.kotlin_gis_task.fragments

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.edu.mdu.kotlin_gis_task.R
import com.edu.mdu.kotlin_gis_task.adapters.UsersRecyclerAdapter
import com.edu.mdu.kotlin_gis_task.model.User
import com.edu.mdu.kotlin_gis_task.sql.DatabaseHelper
import java.security.AccessController.getContext
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var textViewName: AppCompatTextView
    private lateinit var recyclerViewUsers: RecyclerView
    private lateinit var listUsers: MutableList<User>
    private lateinit var usersRecyclerAdapter: UsersRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      print("enttttttttt");
        textViewName = view.findViewById<View>(R.id.textViewName) as AppCompatTextView
        recyclerViewUsers = view.findViewById<View>(R.id.recyclerViewUsers) as RecyclerView
        initObjects()
    }


    /**
     * This method is to initialize objects to be used
     */
    private fun initObjects() {
        listUsers = ArrayList()
        usersRecyclerAdapter = UsersRecyclerAdapter(listUsers)

        val mLayoutManager = LinearLayoutManager(activity)
        recyclerViewUsers.layoutManager = mLayoutManager
        recyclerViewUsers.itemAnimator = DefaultItemAnimator()
        recyclerViewUsers.setHasFixedSize(true)
        recyclerViewUsers.adapter = usersRecyclerAdapter
        databaseHelper = DatabaseHelper(requireContext()
        )
//        val emailFromIntent = intent.getStringExtra("EMAIL")
//        textViewName.text = emailFromIntent

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()
    }

//    override fun onAttach(activity: Activity) {
//        super.onAttach(activity)
//        databaseHelper = DatabaseHelper(activity)
//    }

    /**
     * This class is to fetch all user records from SQLite
     */
    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<User>>() {

        override fun doInBackground(vararg p0: Void?): List<User> {
            return databaseHelper.getAllUser()
        }

        override fun onPostExecute(result: List<User>?) {
            super.onPostExecute(result)
            listUsers.clear()
            listUsers.addAll(result!!)
        }

    }
}
