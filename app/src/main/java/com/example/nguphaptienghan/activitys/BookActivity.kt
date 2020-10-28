package com.example.nguphaptienghan.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
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
import com.example.nguphaptienghan.modle.Vocabulary
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookActivity : AppCompatActivity() {
    private var adapter: VocabularyAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var db: DatabaseHandler
    private lateinit var toolbar: Toolbar
    lateinit var mRecyclerView: RecyclerView
    lateinit var tvNumWord: TextView
    private lateinit var tvTitle: TextView
    lateinit var mTvExam: TextView
    lateinit var mTvStudy: TextView
    lateinit var mFab: FloatingActionButton
    private lateinit var mFabExam: FloatingActionButton
    private lateinit var mFabStudy: FloatingActionButton
    private var listVocabulary: ArrayList<Vocabulary> = ArrayList()
    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book1)

        val type = intent.getIntExtra("type", 0)
        initView()
        actionToolBar()
        db = DatabaseHandler(this)
       // addData()
        getData(type)
        setAdapter()
        actionFloatingButton()
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
        mFab = findViewById(R.id.fab)
        mFabExam = findViewById(R.id.fab_exam)
        mFabStudy = findViewById(R.id.fab_study)
        mTvExam = findViewById(R.id.tvExam)
        mTvStudy = findViewById(R.id.tv_study)

    }

    private fun actionFloatingButton() {
        mFab.setOnClickListener {
            if(!isFabOpen) {
                mFab.setImageResource(R.drawable.ic_minus)
               showMenuFab()
            } else {
                mFab.setImageResource(R.drawable.ic_plus)
                closeMenuFab()
            }
        }

        mFabStudy.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("name", 1)
            startActivity(intent)
        }

        mFabExam.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("name", 2)
            startActivity(intent)
        }
    }

    // Method show menu fab
    private fun showMenuFab() {
        isFabOpen = true
        mFabExam.animate().translationY(-resources.getDimension(R.dimen.dimen_65))
        mTvExam.animate().translationY(-resources.getDimension(R.dimen.dimen_97))
        mFabStudy.animate().translationY(-resources.getDimension(R.dimen.dimen_115))
        mTvStudy.animate().translationY(-resources.getDimension(R.dimen.dimen_147))
        mTvStudy.visibility = View.VISIBLE
        mTvExam.visibility = View.VISIBLE

    }

    // method close menu fab
    private fun closeMenuFab() {
        isFabOpen=false
        mFabExam.animate().translationY(0F)
        mFabStudy.animate().translationY(0F)
        mTvStudy.animate().translationY(0F)
        mTvExam.animate().translationY(0F)
        mTvStudy.visibility = View.GONE
        mTvExam.visibility = View.GONE
    }
    // set action tool bar
    private fun actionToolBar() {
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


    fun addData() {
        val lis = ArrayList<Vocabulary>()
        lis.add(Vocabulary(361, "새", "Chim", "1"))
            lis.forEach{vocabulary -> db.addVocabulary(vocabulary)
        }
    }
}