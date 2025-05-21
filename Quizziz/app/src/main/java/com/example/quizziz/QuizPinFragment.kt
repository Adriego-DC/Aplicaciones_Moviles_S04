package com.example.quizziz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class QuizPinFragment : Fragment() {
    private lateinit var etPin: EditText
    private lateinit var btnIngresar: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_pin, container, false)
        etPin = view.findViewById(R.id.etPin)
        btnIngresar = view.findViewById(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val pin = etPin.text.toString()
            if (BaseDeDatosQuizzes.quizzes.containsKey(pin)) {
                val bundle = Bundle().apply {
                    putString("PIN", pin)
                    putInt("INDICE", 0)
                    putInt("CORRECTAS", 0)
                }
                val fragment = PreguntaFragment()
                fragment.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, fragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(requireContext(), "PIN inválido", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
