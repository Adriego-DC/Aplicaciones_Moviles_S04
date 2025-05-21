package com.example.quizziz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        val usuario = UserData.usuarioActual
        if (usuario != null) {
            view.findViewById<TextView>(R.id.tvNombre).text = "Nombres: ${usuario.nombres}"
            view.findViewById<TextView>(R.id.tvApellidos).text = "Apellidos: ${usuario.apellidos}"
            view.findViewById<TextView>(R.id.tvCorreo).text = "Correo: ${usuario.correo}"
        } else {
            Toast.makeText(requireContext(), "No hay usuario cargado", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
