package com.example.switchstyles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

private const val LAST_RANDOM_VALUE="LAST_RANDOM_VALUE"
class CoffeeFragment : Fragment() {

    private lateinit var coffeeImageView : ImageView
    private lateinit var randomizeButton : Button
    private var randomValue: Int = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_coffee, container, false)

        coffeeImageView = view.findViewById(R.id.coffee_image_view)
        randomizeButton = view.findViewById(R.id.randomize_button)

        savedInstanceState?.let {
            randomValue = it.getInt(LAST_RANDOM_VALUE)
           rollDice(randomValue)
       }

        randomizeButton.setOnClickListener{
            randomValue=Random.nextInt(1,6)
            rollDice(randomValue)
        }
    return view
}

private fun rollDice(randomValue: Int){
    coffeeImageView.setImageResource(
        when (randomValue){
            1 -> R.drawable.ic_dvatone_free_breakfast_24
            2 -> R.drawable.ic_dvatone_free_breakfast_24
            3 -> R.drawable.ic_dvatone_free_breakfast_24
            4 -> R.drawable.ic_dvatone_free_breakfast_24
            5 -> R.drawable.ic_dvatone_free_breakfast_24
            6 -> R.drawable.ic_dvatone_free_breakfast_24
            else -> R.drawable.ic_baseline_games_24
        }
    )
}

 //   override fun onSaveInstanceState(outState: Bundle) {
 //       super.onSaveInstanceState(outState)
 //       outState.putInt(LAST_RANDOM_VALUE,randomValue)
  //      super.onSaveInstanceState(outState)
  //  }
}