package com.appsmoviles.tp1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.text.InputType
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.primerapagina)
        var contraseña = findViewById<EditText>(R.id.editTextTextPassword2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            val boton = findViewById<Button>(R.id.button)
            boton.setOnClickListener{
                val intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
        }

            val ingresar = findViewById<Button>(R.id.button3)
            ingresar.setOnClickListener{
                if(findViewById<EditText>(R.id.editTextText).text.toString() == "Juan Torres" && contraseña.text.toString() == "1234utn"){
                val intent2 = Intent(this, BienvenidaActivity::class.java)
                startActivity(intent2)}else{
                    findViewById<TextView>(R.id.textView2).visibility = View.VISIBLE
                }
            }
        val toggleBtn3 = findViewById<ImageButton>(R.id.btnTogglePassword3)
        var isVisible3 = false
        toggleBtn3.setOnClickListener {

            if (isVisible3) {
                contraseña.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                toggleBtn3.setImageResource(R.drawable.ic_eye_closed)
            } else {
                contraseña.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                toggleBtn3.setImageResource(R.drawable.ic_eye_open)
            }
            contraseña.setSelection(contraseña.text.length)
            isVisible3 = !isVisible3
        }
    }
}