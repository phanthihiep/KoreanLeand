package com.example.nguphaptienghan.activitys

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.adapters.VocabularyAdapter
import com.example.nguphaptienghan.database.DatabaseHandler

class Book1Activity : AppCompatActivity() {
    private var adapter:VocabularyAdapter ?= null
    private var layoutManager:RecyclerView.LayoutManager ?= null
    lateinit var db : DatabaseHandler
    private lateinit var toolbar: Toolbar
    lateinit var mRecyclerView: RecyclerView
    lateinit var tvNumWord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book1)

        initView()
        actionToolBar()
        db = DatabaseHandler(this)
        setAdapter()
    }

    @SuppressLint("SetTextI18n")
    fun setAdapter(){
        val listVocabulary = db.viewVocabulary()
        layoutManager = LinearLayoutManager(this)
        adapter = VocabularyAdapter(listVocabulary, this)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = adapter
        tvNumWord.text = listVocabulary.size.toString() + " words"
    }

    // init view
    private fun initView() {
        mRecyclerView = findViewById(R.id.rcWordBook1)
        tvNumWord = findViewById(R.id.numWord)
        toolbar = findViewById(R.id.toolbar_detail)
    }

    fun actionToolBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_left1)
        toolbar.setNavigationOnClickListener(View.OnClickListener {

        })

    }

}