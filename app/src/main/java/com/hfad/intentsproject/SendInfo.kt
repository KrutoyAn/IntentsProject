package com.hfad.intentsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class SendInfo : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var textViewAge: TextView
    private lateinit var textViewAdress: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var btnSaveUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_info)

        textViewName = findViewById(R.id.SendTextName)
        textViewAge = findViewById(R.id.SendTextAge)
        textViewAdress = findViewById(R.id.SendTextAdress)
        textViewEmail = findViewById(R.id.SendTextEmail)
        btnSaveUser = findViewById(R.id.SaveUser)

        val getIntent : Intent = intent
        textViewName.text = getIntent.getStringExtra("Name")
        textViewAge.text = getIntent.getStringExtra("Age")
        textViewAdress.text = getIntent.getStringExtra("Adress")
        textViewEmail.text = getIntent.getStringExtra("Email")
        val textSend = textViewName.text.toString() + "\n" + textViewAge.text.toString() + "\n" +
                        textViewAdress.text.toString() + "\n" + textViewEmail.text

        btnSaveUser.setOnClickListener(){
            val text = "Info was sent"
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, textSend)
                type = "text/plain"
            }
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            startActivity(Intent.createChooser(sendIntent, null))


        }

    }
}