package com.example.nguphaptienghan.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.database.DatabaseHandler
import com.example.nguphaptienghan.modle.Vocabulary
import kotlinx.android.synthetic.main.activity_add_vocabulary.*

class addVocabulary : AppCompatActivity() {
    lateinit var db : DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vocabulary)
        db = DatabaseHandler(this)
        val btAdd = findViewById<Button>(R.id.add)
        btAdd.setOnClickListener {
            addVocabulary();
        }
    }

    private fun addVocabulary(){
        val id = id.text.toString()
        val korean = korean.text.toString()
        val vietnamese =vietnam.text.toString()
        val type = type.text.toString()
        val result = db.addVocabulary(Vocabulary(Integer.parseInt(id),korean,vietnamese,type))
        if(result >-1) {
            Toast.makeText(applicationContext,"add success",Toast.LENGTH_SHORT).show()
            this.id.text.clear()
            this.korean.text.clear()
            this.vietnam.text.clear()
            this.type.text.clear()
        } else {
            Toast.makeText(applicationContext,"fail",Toast.LENGTH_SHORT).show()
        }
    }
}