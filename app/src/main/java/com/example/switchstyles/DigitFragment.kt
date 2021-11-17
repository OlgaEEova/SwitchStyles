package com.example.switchstyles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
//КОНстанта для ключа сохранения состояния
private const val LAST_RANDOMIZED_VALUE="LAST_RANDOMIZED_VALUE"

class DigitFragment : Fragment() {
private lateinit var resultTextView : TextView
private lateinit var randomizeButton : Button
private var randomValue: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_digit, container, false)

        resultTextView= view.findViewById(R.id.result_text_view)
        randomizeButton= view.findViewById(R.id.randomize_button)

//если состояние сохранено, то применить его к текстовому полю результата
        randomValue=savedInstanceState?.getInt(LAST_RANDOMIZED_VALUE) ?: 0
            resultTextView.text= randomValue.toString()

        // если нет, то зарандомить новое число else randomize()
            // событие онклик - генерируем рандом-число
        randomizeButton.setOnClickListener{randomize()}
        return view
    }
// сохранияем сотояние приложения
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_RANDOMIZED_VALUE, randomValue)
        super.onSaveInstanceState(outState)
    }

    private fun randomize(){
        randomValue = Random.nextInt(100)
        resultTextView.text= randomValue.toString()
    }
}