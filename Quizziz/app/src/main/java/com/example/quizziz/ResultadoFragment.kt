package com.example.quizziz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.math.roundToInt
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ResultadoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_resultado, container, false)
        val tvResultado = view.findViewById<TextView>(R.id.tvResultado)

        val total = arguments?.getInt("TOTAL") ?: 1
        val correctas = arguments?.getInt("CORRECTAS") ?: 0

        val nota = (20.0 * correctas / total).roundToInt()
        tvResultado.text = "Tu nota es: $nota\nCorrectas: $correctas\nIncorrectas: ${total - correctas}"

        return view
    }
}
