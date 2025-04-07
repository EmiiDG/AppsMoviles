package com.appsmoviles.tp1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val boton = findViewById<Button>(R.id.button2)

        boton.setOnClickListener{
            val nombre = findViewById<EditText>(R.id.editTextText2)
            val mail = findViewById<EditText>(R.id.editTextTextEmailAddress)
            val contraseña = findViewById<EditText>(R.id.editTextTextPassword)
            val confirmar = findViewById<EditText>(R.id.editTextTextPassword3)
            val texton = findViewById<TextView>(R.id.textView)
            val textom = findViewById<TextView>(R.id.textView3)
            val textoc = findViewById<TextView>(R.id.textView5)
            val textocc = findViewById<TextView>(R.id.textView4)

            if (nombre.text.toString().isEmpty()){
                texton.visibility = View.VISIBLE
            }else{
                texton.visibility = View.GONE
            }

            if (mail.text.toString().isEmpty()){
                textom.visibility = View.VISIBLE
            }else{
                textom.visibility = View.GONE
            }

            if (contraseña.text.toString().length < 6){
                textoc.visibility = View.VISIBLE
            }else{
                textoc.visibility = View.GONE
            }

            if (confirmar.text.toString() != contraseña.text.toString()){
                textocc.visibility = View.VISIBLE
            }else{
                textocc.visibility = View.GONE
            }

            if (nombre.text.toString().isNotEmpty() && mail.text.toString().isNotEmpty() && contraseña.text.toString().length >= 6 && contraseña.text.toString() == confirmar.text.toString()){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)}
        }
    }
}