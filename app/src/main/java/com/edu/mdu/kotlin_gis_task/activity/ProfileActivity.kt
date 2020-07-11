package com.edu.mdu.kotlin_gis_task.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import com.edu.mdu.kotlin_gis_task.R
import com.google.android.material.textfield.TextInputLayout

class ProfileActivity : AppCompatActivity() {

    private lateinit var submit: Button
    private lateinit var userNameTxt: TextView
    private lateinit var PhoneTxt: TextView
    private lateinit var DomainTxt: TextView
    private lateinit var EmailTxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {

        submit = findViewById<View>(R.id.submit) as Button
        userNameTxt = findViewById<View>(R.id.showUserNameText) as TextView
        PhoneTxt = findViewById<View>(R.id.showPhoneText) as TextView
        DomainTxt = findViewById<View>(R.id.showDomainText) as TextView
        EmailTxt = findViewById<View>(R.id.showEmailText) as TextView
    }

    }
