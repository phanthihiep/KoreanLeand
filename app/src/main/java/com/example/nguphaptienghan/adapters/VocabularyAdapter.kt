package com.example.nguphaptienghan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.modle.Vocabulary

class VocabularyAdapter(private val list: ArrayList<Vocabulary>, val context: Context) :
    RecyclerView.Adapter<VocabularyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_vocabulary_book1, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binItem(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binItem(vocabulary : Vocabulary) {
            val tvKorean : TextView = itemView.findViewById(R.id.tvKorean)
            val tvMean : TextView = itemView.findViewById(R.id.tvMean)

            tvKorean.text = vocabulary.korean
            tvMean.text = vocabulary.vietnamese
        }
    }
}