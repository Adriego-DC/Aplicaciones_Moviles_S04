package com.example.quizziz
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var tvTitulo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Cargar el usuario actual
        val usuario = UserData.usuarioActual ?: PrefsHelper.obtenerUsuarioActual(this)
        UserData.usuarioActual = usuario

        // Inicializar el TextView del título
        tvTitulo = findViewById(R.id.tvTitulo)

        // Cargar el fragmento de menú por defecto
        cambiarFragment(MenuFragment(), "Menú")

        // Configurar la navegación inferior
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_nav -> {
                    cambiarFragment(MenuFragment(), "Menú")
                    true
                }
                R.id.quizz_nav -> {
                    cambiarFragment(QuizPinFragment(), "Quizzes") // Cambiado para usar PIN
                    true
                }
                R.id.perfil_nav -> {
                    cambiarFragment(PerfilFragment(), "Perfil")
                    true
                }
                else -> false
            }
        }
    }

    // Función para cambiar fragmento y actualizar título
    private fun cambiarFragment(fragment: Fragment, titulo: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
        tvTitulo.text = titulo
    }
}