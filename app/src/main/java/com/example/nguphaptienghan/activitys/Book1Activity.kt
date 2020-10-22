package com.example.nguphaptienghan.activitys

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.adapters.VocabularyAdapter
import com.example.nguphaptienghan.database.DatabaseHandler

class Book1Activity : AppCompatActivity() {
    private var adapter:VocabularyAdapter ?= null
    private var layoutManager:RecyclerView.LayoutManager ?= null
    lateinit var db : DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book1)
        db = DatabaseHandler(this)
        setAdapter()
    }

    @SuppressLint("SetTextI18n")
    fun setAdapter(){
        val listVocabulary = db.viewVocabulary()
        layoutManager = LinearLayoutManager(this)
        adapter = VocabularyAdapter(listVocabulary, this)
        val mRecyclerView: RecyclerView = findViewById(R.id.rcWordBook1)
        val tvNumWord:TextView = findViewById(R.id.numWord)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = adapter
        tvNumWord.text = listVocabulary.size.toString() + " words"
    }
}