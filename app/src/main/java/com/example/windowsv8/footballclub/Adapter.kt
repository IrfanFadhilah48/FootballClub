package com.example.windowsv8.footballclub

import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.startActivity
import java.text.FieldPosition
import java.util.*


class Adapter(private val context: Context, private val items: List<Club>, private val listener : (
    Club) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        return ViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(ClubUI.nameId)
        val image = itemView.findViewById<ImageView>(ClubUI.imageId);

        fun bindItem (items: Club, listener: (Club) -> Unit) {
            name.text = items.nama
            Glide.with(itemView.context)
                .load(items.image)
                .into(image)
            itemView.setOnClickListener {
                listener(items)
//                itemView.context.startActivity<DetailActivity>("name" to items.nama, "image" to items.image, "info" to items.keterangan)
            }
        }
    }

}