package com.akmalinnuha.eventpractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triangleActivity: Button = findViewById(R.id.triangle)
        triangleActivity.setOnClickListener(this)

        val coneActivity: Button = findViewById(R.id.cone)
        coneActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.triangle -> {
                val moveIntent = Intent(this@MainActivity, Segitiga::class.java)
                startActivity(moveIntent)
            }
            R.id.cone -> {
                val moveIntent = Intent(this@MainActivity, Cone::class.java)
                startActivity(moveIntent)
            }
        }
    }
}