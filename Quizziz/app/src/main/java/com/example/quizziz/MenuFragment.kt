package com.example.quizziz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MenuFragment : Fragment(R.layout.fragment_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener el usuario actual
        val usuario = UserData.usuarioActual ?: PrefsHelper.obtenerUsuarioActual(requireContext())
        val nombre = usuario?.nombres?.split(" ")?.firstOrNull() ?: "Usuario"

        // Actualizar el TextView con el nombre
        val tvBienvenida = view.findViewById<TextView>(R.id.tvBienvenida)
        tvBienvenida.text = "Bienvenido $nombre"
    }
}
