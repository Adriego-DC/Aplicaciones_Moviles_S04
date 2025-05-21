package com.example.quizziz

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etNombres = findViewById<EditText>(R.id.etNombres)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val etConfirmar = findViewById<EditText>(R.id.etConfirmar)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val nombres = etNombres.text.toString()
            val apellidos = etApellidos.text.toString()
            val correo = etCorreo.text.toString()
            val contrasena = etContrasena.text.toString()
            val confirmar = etConfirmar.text.toString()

            if (contrasena == confirmar) {
                val nuevoUsuario = User(nombres, apellidos, correo, contrasena)
                UserData.usuarios.add(nuevoUsuario)

                // ✅ Guardar usuarios en SharedPreferences
                PrefsHelper.guardarUsuarios(this, UserData.usuarios)

                startActivity(Intent(this, SuccessActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }
}