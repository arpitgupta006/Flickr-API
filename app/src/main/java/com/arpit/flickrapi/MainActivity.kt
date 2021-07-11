package com.arpit.flickrapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AdapterFlickr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.loadImage()



        viewModel.showProgress.observe(this, Observer {


            viewModel.imageList.observe(this, Observer {
                adapter.setImageList(it)
            })

            adapter = AdapterFlickr(this)
            rvRecycler.adapter = adapter
        }
        )
    }
}