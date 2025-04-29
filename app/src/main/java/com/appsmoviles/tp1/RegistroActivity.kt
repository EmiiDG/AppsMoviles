package com.appsmoviles.tp1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.InputType

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

        val contraseña = findViewById<EditText>(R.id.editTextTextPassword)
        val confirmar = findViewById<EditText>(R.id.editTextTextPassword3)
        boton.setOnClickListener{
            val nombre = findViewById<EditText>(R.id.editTextText2)
            val mail = findViewById<EditText>(R.id.editTextTextEmailAddress)
            val texton = findViewById<TextView>(R.id.textView)
            val textom = findViewById<TextView>(R.id.textView3)
            val textoc = findViewById<TextView>(R.id.textView5)
            val textocc = findViewById<TextView>(R.id.textView4)

            if (nombre.text.toString().isEmpty() || nombre.text.toString().length < 2 || !nombre.text.toString().matches(Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+\$"))) {
                texton.visibility = View.VISIBLE
                texton.text = "El nombre no es válido"
            } else {
                texton.visibility = View.GONE
            }


            if (mail.text.toString().isEmpty()){
                textom.visibility = View.VISIBLE
                textom.text="El campo email no puede estar vacío"
            }else if(!isValidEmail(mail.text.toString())){
                textom.visibility = View.VISIBLE
                textom.text = "El email no es válido"
            }else{
                textom.visibility = View.GONE
            }

            if (!isValidPassword(contraseña.text.toString())) {
                textoc.visibility = View.VISIBLE
                textoc.text = "La contraseña debe tener al menos 6 caracteres, una mayúscula, una minúscula, un número y un símbolo"
            } else {
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

        val toggleBtn = findViewById<ImageButton>(R.id.btnTogglePassword)
        var isVisible = false
        toggleBtn.setOnClickListener {

            if (isVisible) {
                contraseña.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                toggleBtn.setImageResource(R.drawable.ic_eye_closed)
            } else {
                contraseña.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                toggleBtn.setImageResource(R.drawable.ic_eye_open)
            }
            contraseña.setSelection(contraseña.text.length)
            isVisible = !isVisible
        }

        val toggleBtn2 = findViewById<ImageButton>(R.id.btnTogglePassword2)
        var isVisible2 = false
        toggleBtn2.setOnClickListener {

            if (isVisible2) {
                confirmar.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                toggleBtn2.setImageResource(R.drawable.ic_eye_closed)
            } else {
                confirmar.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                toggleBtn2.setImageResource(R.drawable.ic_eye_open)
            }
            confirmar.setSelection(contraseña.text.length)
            isVisible2 = !isVisible2
        }

        var backButton = findViewById<ImageButton>(R.id.btnBack)
        backButton.setOnClickListener{
            finish()
        }
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    return emailRegex.matches(email)
}

fun isValidPassword(password: String): Boolean {
    val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!.,]).{6,}\$")
    return passwordRegex.matches(password)
}