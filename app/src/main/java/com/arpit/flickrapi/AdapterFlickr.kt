package com.arpit.flickrapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arpit.flickrapi.models.PhotoItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class AdapterFlickr( private val context: Context) :
    RecyclerView.Adapter<AdapterFlickr.ViewHolder>() {
    private var list: List<PhotoItem> = ArrayList()

    fun setImageList(list: List<PhotoItem>){
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = list[position].title
        Glide.with(context).load(list[position].urlS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        )
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val image = v.ivImage!!
        val title = v.tvTitle!!
    }

}