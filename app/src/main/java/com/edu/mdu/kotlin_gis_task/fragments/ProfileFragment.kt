package com.edu.mdu.kotlin_gis_task.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.edu.mdu.kotlin_gis_task.R


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    private lateinit var showUserNameText: TextView
    private lateinit var showEmailText: TextView
    private lateinit var showPhoneText: TextView
    private lateinit var showDomainText: TextView
    private lateinit var submit: Button
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "PREFERENCE_NAME"
    var userNameStr: String =""
    var emailStr: String  = ""
    var phoneStr: String  = ""
    var passStr: String  = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print("enttttttttt");
        showUserNameText = view.findViewById<View>(R.id.showUserNameText) as TextView
        showEmailText = view.findViewById<View>(R.id.showEmailText) as TextView
        showPhoneText = view.findViewById<View>(R.id.showPhoneText) as TextView
        showDomainText = view.findViewById<View>(R.id.showDomainText) as TextView
        submit = view.findViewById<View>(R.id.submit) as Button

        val sharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        userNameStr = sharedPreferences.getString("regName","").toString();
        emailStr= sharedPreferences.getString("regEmail","").toString();
        phoneStr= sharedPreferences.getString("regPhone","").toString();
        passStr= sharedPreferences.getString("regPass","").toString();
        Log.d("fadfa", "value userNameStr: $userNameStr")
        showPhoneText.text =phoneStr
        showEmailText.text =emailStr
        showUserNameText.text =userNameStr
        showDomainText.text =passStr

        submit.setOnClickListener {
            Log.d("fadfa", "presseddd")
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
         userNameStr = sharedPreferences.getString("regName","").toString();
        emailStr= sharedPreferences.getString("regEmail","").toString();
        phoneStr= sharedPreferences.getString("regPhone","").toString();
        passStr= sharedPreferences.getString("regPass","").toString();

    }
}
