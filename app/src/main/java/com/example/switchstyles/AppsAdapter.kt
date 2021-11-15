package com.example.switchstyles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AppsAdapter(private val appsList: List<Appsmain>): RecyclerView.Adapter <AppsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        val appsListItemView=LayoutInflater.from(parent.context).inflate(R.layout.switch_list_item, parent,false)
        return AppsViewHolder(appsListItemView)
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        val apps=appsList[position]
        holder.bind(apps)

    }

    override fun getItemCount(): Int {
       return appsList.size
    }
}