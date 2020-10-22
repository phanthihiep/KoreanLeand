package com.example.nguphaptienghan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.nguphaptienghan.activitys.Book1Activity
import com.example.nguphaptienghan.activitys.addVocabulary

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolBar: Toolbar = findViewById(R.id.toolbar)
        val tvBook1: TextView = findViewById(R.id.tvBook1)
        val tvBook2: TextView = findViewById(R.id.tvBook2)
        add(tvBook1)
        showBook1(tvBook2)
    }

    private fun add (tv:TextView) {
        tv.setOnClickListener {
            val intent = Intent(this, addVocabulary::class.java)
            startActivity(intent)
        }
    }

    private fun showBook1(tv:TextView) {
        tv.setOnClickListener {
            val intent = Intent(this, Book1Activity::class.java)
            startActivity(intent)
        }
    }
}
