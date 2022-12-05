package com.hfad.intentsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCreateUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCreateUser = findViewById(R.id.btnCreateUser)

        buttonCreateUser.setOnClickListener{
            val intentActivityCreateUser = Intent(this, CreateUser::class.java)

            startActivity(intentActivityCreateUser)

        }
    }

}


