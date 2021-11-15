package com.example.switchstyles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.material.switchmaterial.SwitchMaterial
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appsmainList:List<Appsmain> = listOf(
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



    }
}