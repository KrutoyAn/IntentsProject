package com.hfad.intentsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateUser : AppCompatActivity() {

    private lateinit var textName : EditText
    private lateinit var textAge : EditText
    private lateinit var textAdress: EditText
    private lateinit var textEmail: EditText
    private lateinit var buttonSaveUser : Button
    var isAllFieldsChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        buttonSaveUser = findViewById(R.id.save_user)
        textName = findViewById(R.id.editTextName)
        textAge = findViewById(R.id.editTextTextAge)
        textAdress = findViewById(R.id.editTextTextAdress)
        textEmail  = findViewById(R.id.editTextTextEmail)



        buttonSaveUser.setOnClickListener{
            isAllFieldsChecked = CheckAllFields()
            if (isAllFieldsChecked) {
                val intentActivitySendInfo = Intent(this, SendInfo::class.java)
                intentActivitySendInfo.putExtra("Name", textName.text.toString())
                intentActivitySendInfo.putExtra("Age", textAge.text.toString())
                intentActivitySendInfo.putExtra("Adress", textAge.text.toString())
                intentActivitySendInfo.putExtra("Email", textEmail.text.toString())

                startActivity(intentActivitySendInfo)

            }
        }
    }
    private fun CheckAllFields(): Boolean {
        if (textName!!.length() == 0) {
            textName!!.error = "This field is required"
            return false
        }
        if (textAge!!.length() == 0) {
            textAge!!.error = "This field is required"
            return false
        }
        if (textAdress!!.length() == 0) {
            textAdress!!.error = "Password is required"
            return false
        }
        if (textEmail!!.length() == 0) {
            textEmail!!.error = "Email is required"
            return false
        }
        return true
    }
}
