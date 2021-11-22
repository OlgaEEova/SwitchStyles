package com.example.switchstyles

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

private const val LAST_RANDOM_VALUE="LAST_RANDOM_VALUE"
lateinit var  mAnimationDrawable : AnimationDrawable
val animatorSetReshka = AnimatorSet()
val animatorSetOrel = AnimatorSet()

class CoffeeFragment : Fragment() {
    private lateinit var coffeeImageView : ImageView
    private lateinit var reversImageView : ImageView
    private lateinit var coffeeButton : Button
    private lateinit var textView: TextView
    private var randomValue: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_coffee, container, false)
//анимация градиента фона
        mAnimationDrawable = view.background as AnimationDrawable
        mAnimationDrawable.setEnterFadeDuration(2500)
        mAnimationDrawable.setExitFadeDuration(5000)
        mAnimationDrawable.start()

        coffeeImageView = view.findViewById(R.id.coffee_image_view)
        reversImageView = view.findViewById(R.id.revers_image_view)

        coffeeButton = view.findViewById(R.id.coffee_button)
        textView = view.findViewById(R.id.txt_example3)
        textView.text = ""
//общий набор анимаций
        val scaleXAnimatorAvers = ObjectAnimator.ofFloat(coffeeImageView,"scaleX",0F,1F,0F)
        scaleXAnimatorAvers.duration = 250
        val scaleXAnimatorRevers = ObjectAnimator.ofFloat(reversImageView,"scaleX",0F,1F,0F)
        scaleXAnimatorRevers.duration = 250
        val scaleXAnimatorAvers1 = ObjectAnimator.ofFloat(coffeeImageView,"scaleX",0F,1F,0F)
        scaleXAnimatorRevers.duration = 250
        val scaleXAnimatorRevers1 = ObjectAnimator.ofFloat(reversImageView,"scaleX",0F,1F,0F)
        scaleXAnimatorRevers.duration = 250

        //остаёмся в решке
        val scaleXAnimatorReshka = ObjectAnimator.ofFloat(coffeeImageView,"scaleX",0F,1F,1F)
        scaleXAnimatorReshka.duration = 250

        //остаёмся в Орле
        val scaleXAnimatorOrel = ObjectAnimator.ofFloat(reversImageView,"scaleX",0F,1F,1F)
        scaleXAnimatorOrel.duration = 250

        animatorSetReshka.playSequentially(scaleXAnimatorRevers,scaleXAnimatorAvers,
            scaleXAnimatorRevers1,scaleXAnimatorAvers1,scaleXAnimatorReshka)
        animatorSetReshka.duration = 600

        animatorSetOrel.playSequentially(scaleXAnimatorRevers,scaleXAnimatorAvers,
            scaleXAnimatorRevers1,scaleXAnimatorAvers1,scaleXAnimatorOrel)
        animatorSetOrel.duration = 600

      //  animatorSetReshka.start()

        savedInstanceState?.let {
            randomValue = it.getInt(LAST_RANDOM_VALUE)
           rollCent(randomValue)
       }

        coffeeButton.setOnClickListener{
           // animatorSet.start()
            textView.text = ""
                randomValue = Random.nextInt(1, 3)//ранг 1-2 не работает, всегда 1
                rollCent(randomValue)
        }
    return view
}
private fun rollCent(randomValue: Int){
    when (randomValue) {
        1 -> {

            animatorSetReshka.start() //Toast.makeText(view?.context, "выпал 1", Toast.LENGTH_LONG).show()//animatorSet.start()
            textView.text = "РЕШКА!"
        }

        2 -> {

            animatorSetOrel.start()
            textView.text = "ОРЁЛ!"
                // Toast.makeText(view?.context, "выпал 2", Toast.LENGTH_LONG).show()//animatorSet.start()
        }
        3 -> Toast.makeText(view?.context, "3", Toast.LENGTH_LONG).show()//animatorSet.start()
        else -> Toast.makeText(view?.context, "ELSE!!!", Toast.LENGTH_LONG).show()//animatorSet.start()
    }
}

private fun rollDice(randomValue: Int){
    coffeeImageView.setImageResource(
        when (randomValue){
            1 -> R.drawable.bitkoin_avers
            2 -> R.drawable.bitkoin_revers
            3 -> R.drawable.ic_dvatone_free_breakfast_24
            4 -> R.drawable.ic_dvatone_free_breakfast_24
            5 -> R.drawable.ic_dvatone_free_breakfast_24
            6 -> R.drawable.ic_dvatone_free_breakfast_24
            else -> R.drawable.ic_baseline_games_24
        }
    )
}

    override fun onSaveInstanceState(outState: Bundle) {
     //   super.onSaveInstanceState(outState)
       outState.putInt(LAST_RANDOM_VALUE,randomValue)
       super.onSaveInstanceState(outState)
    }
}