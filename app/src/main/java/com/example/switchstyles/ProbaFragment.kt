package com.example.switchstyles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.switchstyles.R.drawable


class ProbaFragment : Fragment() {

    private lateinit var probaButton : Button
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_proba, container, false)
        probaButton= view.findViewById(R.id.randomize_button)
        imageView.setImageResource(drawable.ic_dvatone_free_breakfast_24)
        //addView(imageView)
        return view
    }



}