package com.example.switchstyles

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.app.BundleCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import android.content.Context as AndroidContentContext

class AppsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bind(appsmain: Appsmain){
      val appswitch: SwitchMaterial=itemView.findViewById(R.id.main_switch)
      val appstext : TextView =itemView.findViewById(R.id.text_view)
        appswitch.text=appsmain.name
        appstext.text=appsmain.tip

//проверка работы кликлистенера   // val link = Uri.parse("https://odin.study")

        appswitch.setOnClickListener{
            val temp = appsmain.urllll
            if (temp.isNotEmpty()) {
                val link = Uri.parse(temp)
                val intent=Intent(Intent.ACTION_VIEW,link)
                itemView.context.startActivity(intent)
    }
            else {
                Toast.makeText(itemView.context, "Привет! Здесь пока ничего нет, но мы работаем над этим!",
                Toast.LENGTH_LONG).show()}

    }

}
}
