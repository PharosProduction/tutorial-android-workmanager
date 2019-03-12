package com.pharosproduction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        startWorkBt.setOnClickListener { model.startOneTimeWork() }
        //startWorkBt.setOnClickListener { model.startChainingWork() }
        //startWorkBt.setOnClickListener { model.startOneTimeWork() }


    }
}
