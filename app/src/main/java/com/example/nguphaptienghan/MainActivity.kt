package com.example.nguphaptienghan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.activitys.BookActivity
import com.example.nguphaptienghan.activitys.addVocabulary
import com.example.nguphaptienghan.adapters.BookAdapter
import com.example.nguphaptienghan.modle.Book
import com.example.nguphaptienghan.modle.onClickItemBook
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    onClickItemBook {

    private lateinit var toolbar: Toolbar
    private lateinit var recycleHome: RecyclerView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private var adapter: BookAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var listBook = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        // show data recycle view book
        setLitBook()

        layoutManager = GridLayoutManager(this, 2)
        adapter = BookAdapter(listBook, this)
        recycleHome.layoutManager = layoutManager
        recycleHome.adapter = adapter


    }

    // Method init View
    private fun initView() {
        toolbar = findViewById(R.id.toolbar)
        recycleHome = findViewById(R.id.recycle_home)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                val intent = Intent(this, addVocabulary::class.java)
                startActivity(intent)
            }
            R.id.nav_exam -> {
                Toast.makeText(this,"User setting", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_favorite -> {
                Toast.makeText(this,"User setting", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this,"User setting", Toast.LENGTH_SHORT).show()
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    // Set on click item book
    override fun onClick(id: Int) {
        when (id) {
            1 -> {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("type", 1)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("type", 2)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("type", 3)
                startActivity(intent)
            }
            4 -> {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("type", 4)
                startActivity(intent)
            }
            5 -> {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("type", 5)
                startActivity(intent)
            }
            else -> {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("type", 6)
                startActivity(intent)
            }
        }
    }

    // Add name Book
    private fun setLitBook() {
        listBook.add(Book(1, "Quyển 1"))
        listBook.add(Book(2, "Quyển 2"))
        listBook.add(Book(3, "Quyển 3"))
        listBook.add(Book(4, "Quyển 4"))
        listBook.add(Book(5, "Quyển 5"))
        listBook.add(Book(6, "Quyển 6"))
    }
}
