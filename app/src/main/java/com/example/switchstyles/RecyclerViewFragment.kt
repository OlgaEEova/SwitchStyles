package com.example.switchstyles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFragment : Fragment() {
    val appsmainList: List<Appsmain> = listOf(
        Appsmain("Sberbank", "bankapp", "https://sberbank.ru"),
        Appsmain("Ubrir", "bankapp", "https://ubrr.ru"),
        Appsmain("Pochtabank", "bankapp", "https://pochtabank.ru"),
        Appsmain("Promsvjazbank", "bankapp", "https://psbank.ru"),
        Appsmain("Новости E1", "browser", "https://e1.ru"),
        Appsmain("Telegram", "messenger", ""),
        Appsmain("Viber", "messenger", ""),
        Appsmain("WhatsApp", "messenger", ""),
        Appsmain("Yandex", "browser", ""),
        Appsmain("Crome", "browser", ""),
        Appsmain("Microsoft Edge", "browser", ""),
        Appsmain("Opera", "browser", "")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

       val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)

         val usersRecyclerView: RecyclerView = view.findViewById(R.id.users_recycler_view)
        usersRecyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
         usersRecyclerView.addItemDecoration(
           DividerItemDecoration(
               view.context,
              DividerItemDecoration.VERTICAL))

         usersRecyclerView.adapter = AppsAdapter(appsmainList)
        return view
    }


}