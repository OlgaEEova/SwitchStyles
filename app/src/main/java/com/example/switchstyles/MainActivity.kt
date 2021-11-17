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
private val TREE_FRAGMENT= ProbaFragment()
    // раняя инициализация нижней навигации
private lateinit var bottomNavigationMenu: BottomNavigationView
private var digitFragment = DigitFragment()
private var coffeeFragment = CoffeeFragment()
private var treeFragment = ProbaFragment()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appsmainList: List<Appsmain> = listOf(
            Appsmain("Sberbank", "bankapp", "https://sberbank.ru"),
            Appsmain("Ubrir", "bankapp", "https://ubrr.ru"),
            Appsmain("Pochtabank", "bankapp", "https://pochtabank.ru"),
            Appsmain("Promsvjazbank", "bankapp", "https://psbank.ru"),
            Appsmain("Facebook messenger", "messenger", ""),
            Appsmain("Telegram", "messenger", ""),
            Appsmain("Viber", "messenger", ""),
            Appsmain("WhatsApp", "messenger", ""),
            Appsmain("Yandex", "browser", ""),
            Appsmain("Crome", "browser", ""),
            Appsmain("Microsoft Edge", "browser", ""),
            Appsmain("Opera", "browser", "")
        )

        val usersRecyclerView: RecyclerView = findViewById(R.id.users_recycler_view)
        usersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        usersRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        usersRecyclerView.adapter = AppsAdapter(appsmainList)

        // настройка кликов элекментов по навигации
        bottomNavigationMenu = findViewById(R.id.bottom_navigation)
        var fragment: Fragment? = null

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.digits -> {
                    Toast.makeText(this, "1 пункт меню",
                        Toast.LENGTH_LONG).show()
                    fragment = savedInstanceState?.let {
                     supportFragmentManager.getFragment(it, DIGIT_FRAGMENT)
                    } ?: digitFragment
                }
R.id.treepunkt ->{
    supportFragmentManager
        .beginTransaction()
        .add(R.id.fragment_container, treeFragment)
        .commit()
    Toast.makeText(this, "3q пункт меню",
        Toast.LENGTH_LONG).show()
}

                R.id.nexton -> {
                    Toast.makeText(this, "Привет! Здесь пока ничего нет, но мы работаем над этим!",
                        Toast.LENGTH_LONG).show()
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
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.digits
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
                ?.beginTransaction()
                ?.replace(R.id.fragment_container,fragment)
                ?.addToBackStack(null)
                ?.commit()

        }

}