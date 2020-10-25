package com.example.nguphaptienghan.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.MainActivity
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.adapters.VocabularyAdapter
import com.example.nguphaptienghan.database.DatabaseHandler
import com.example.nguphaptienghan.modle.Vocabulary

class BookActivity : AppCompatActivity() {
    private var adapter: VocabularyAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var db: DatabaseHandler
    private lateinit var toolbar: Toolbar
    lateinit var mRecyclerView: RecyclerView
    lateinit var tvNumWord: TextView
    lateinit var tvTitle: TextView
    private var listVocabulary: ArrayList<Vocabulary> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book1)

        val type = intent.getIntExtra("type", 0)
        initView()
        actionToolBar()
        db = DatabaseHandler(this)
        getData(type)
        setAdapter()
    }

    @SuppressLint("SetTextI18n")
    fun setAdapter() {

        layoutManager = LinearLayoutManager(this)
        adapter = VocabularyAdapter(listVocabulary, this)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = adapter
        tvNumWord.text = listVocabulary.size.toString() + " Words"
    }

    // init view
    private fun initView() {
        mRecyclerView = findViewById(R.id.rcWordBook1)
        tvNumWord = findViewById(R.id.numWord)
        tvTitle = findViewById(R.id.tvTitle)
        toolbar = findViewById(R.id.toolbar_detail)

    }

    // set action tool bar
    fun actionToolBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_left1)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    // get list vocabulary book and set title
    private fun getData(type: Int) {
        when (type) {
            1 -> {
                tvTitle.text = getString(R.string.title_home_detail1)
                listVocabulary = db.viewVocabularyOne("1")
            }
            2 -> {
                tvTitle.text = getString(R.string.title_home_detail2)
                listVocabulary = db.viewVocabularyOne("2")
            }
            3 -> {
                tvTitle.text = getString(R.string.title_home_detail3)
                listVocabulary = db.viewVocabularyOne("3")
            }
            4 -> {
                tvTitle.text = getString(R.string.title_home_detail4)
                listVocabulary = db.viewVocabularyOne("4")
            }
            5 -> {
                tvTitle.text = getString(R.string.title_home_detail5)
                listVocabulary = db.viewVocabularyOne("5")
            }
            else -> {
                tvTitle.text = getString(R.string.title_home_detail6)
                listVocabulary = db.viewVocabularyOne("6")
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}