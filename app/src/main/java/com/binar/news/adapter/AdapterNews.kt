package com.binar.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.news.R
import com.binar.news.model.GetAllNewsResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_news_adapter.view.*

class AdapterNews (private var onClick : (GetAllNewsResponse)->Unit) : RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private var dataNews : List<GetAllNewsResponse>? = null

    fun setDataNews(film : List<GetAllNewsResponse>){
        this.dataNews = film
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNews.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_news_adapter, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: AdapterNews.ViewHolder, position: Int) {
        holder.itemView.judulNews.text = dataNews!![position].title
        holder.itemView.tanggalNews.text = dataNews!![position].createdAt
        holder.itemView.penulisNews.text = dataNews!![position].author
        Glide.with(holder.itemView.context).load(dataNews!![position].image).apply(RequestOptions().override(120, 120)).into(holder.itemView.imageNews)



        holder.itemView.cardFilm.setOnClickListener{
            onClick(dataNews!![position])
        }

    }

    override fun getItemCount(): Int {
        if (dataNews == null){
            return 0
        }else{
            return dataNews!!.size

        }
    }
}