package com.example.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val database = intent.getParcelableExtra<Image>("databse")
        if (database != null) {
            val imageView: ImageView = findViewById(R.id._imageDesc)
            val textViewTitle : TextView = findViewById(R.id._Title)
            val tetViewDesc : TextView = findViewById(R.id._desc)

            imageView.setImageResource(database.imageSource)
            textViewTitle.text = database.imageTitle
            tetViewDesc.text = database.imageDesc

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}