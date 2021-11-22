package com.example.switchstyles

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

//константа для ключа сохранения состояния
private const val LAST_SELECTED_ITEM="LAST_SELECTED_ITEM"
private val DIGIT_FRAGMENT = DigitFragment().javaClass.name
private val COFFEE_FRAGMENT = CoffeeFragment().javaClass.name
private val RECYCLER_VIEW_FRAGMENT= RecyclerViewFragment().javaClass.name
private val PROBA_FRAGMENT = ProbaFragment().javaClass.name

    // раняя инициализация нижней навигации
private lateinit var bottomNavigationMenu: BottomNavigationView
private var digitFragment = DigitFragment()
private var coffeeFragment = CoffeeFragment()
private var recyclerViewFragment = RecyclerViewFragment()
private var probaFragment = ProbaFragment()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // настройка кликов элекментов по навигации
        bottomNavigationMenu = findViewById(R.id.bottom_navigation)
        var fragment: Fragment? = null

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.digits -> {
                    fragment = savedInstanceState?.let {
                     supportFragmentManager.getFragment(it, DIGIT_FRAGMENT)
                    } ?: digitFragment
                }

                R.id.treepunkt ->{
                    fragment = savedInstanceState?.let {
                        supportFragmentManager.getFragment(it, RECYCLER_VIEW_FRAGMENT)
                    } ?: recyclerViewFragment
                }

                R.id.nexton -> {
                    fragment = savedInstanceState?.let {
                        supportFragmentManager.getFragment(it, COFFEE_FRAGMENT)
                    } ?: coffeeFragment
                }
            }
            replaceFragment(fragment!!)
            true
        }
        //сохрание состояния выбранного посл.элемента, если не выбрано, то R.id.digits
        bottomNavigationMenu.selectedItemId=
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.treepunkt
    }
//сохрание состояния последнего нажатого элемента в навигации
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM,bottomNavigationMenu.selectedItemId)
    val fragment = supportFragmentManager.fragments.last()
    supportFragmentManager.putFragment(outState, fragment.javaClass.name, fragment)
        super.onSaveInstanceState(outState)
    }
    //функция замены фрагментов через суппорфрагментманагер
        private fun replaceFragment(fragment: Fragment) {
                supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
               // .addToBackStack(null)
                .commit()

        }

}