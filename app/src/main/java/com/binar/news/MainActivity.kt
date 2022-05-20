package com.binar.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.news.adapter.AdapterNews
import com.binar.news.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var newsAdapter : AdapterNews
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsAdapter = AdapterNews { }
        initViewModel()
        rv_film.layoutManager = LinearLayoutManager(this)
        rv_film.adapter = newsAdapter



    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveDataNews2().observe(this) {
            if (it != null) {
                newsAdapter.setDataNews(it)
                newsAdapter.notifyDataSetChanged()
            }
        }
        viewModel.getDataNews()
    }
}