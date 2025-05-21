package com.example.quizziz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PreguntaFragment : Fragment() {
    private lateinit var tvPregunta: TextView
    private lateinit var botones: List<Button>
    private var pin: String = ""
    private var indice: Int = 0
    private var correctas: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pregunta, container, false)
        tvPregunta = view.findViewById(R.id.tvPregunta)
        botones = listOf(
            view.findViewById(R.id.btnResp1),
            view.findViewById(R.id.btnResp2),
            view.findViewById(R.id.btnResp3),
            view.findViewById(R.id.btnResp4)
        )

        pin = arguments?.getString("PIN") ?: ""
        indice = arguments?.getInt("INDICE") ?: 0
        correctas = arguments?.getInt("CORRECTAS") ?: 0

        val preguntas = BaseDeDatosQuizzes.quizzes[pin] ?: return view
        val preguntaActual = preguntas[indice]

        tvPregunta.text = "Pregunta ${indice + 1}: ${preguntaActual.texto}"
        botones.forEachIndexed { i, btn ->
            btn.text = preguntaActual.respuestas[i]
            btn.setOnClickListener {
                val esCorrecto = i == preguntaActual.indiceCorrecto
                if (esCorrecto) correctas++
                Toast.makeText(requireContext(), if (esCorrecto) "Correcto" else "Incorrecto", Toast.LENGTH_SHORT).show()

                if (indice + 1 < preguntas.size) {
                    val bundle = Bundle().apply {
                        putString("PIN", pin)
                        putInt("INDICE", indice + 1)
                        putInt("CORRECTAS", correctas)
                    }
                    val nuevoFragment = PreguntaFragment()
                    nuevoFragment.arguments = bundle
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frameContainer, nuevoFragment)
                        .addToBackStack(null)
                        .commit()
                } else {
                    val bundle = Bundle().apply {
                        putInt("TOTAL", preguntas.size)
                        putInt("CORRECTAS", correctas)
                    }
                    val resultadoFragment = ResultadoFragment()
                    resultadoFragment.arguments = bundle
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frameContainer, resultadoFragment)
                        .commit()
                }
            }
        }

        return view
    }
}
