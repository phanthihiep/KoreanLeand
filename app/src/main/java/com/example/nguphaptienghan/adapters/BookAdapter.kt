package com.example.nguphaptienghan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.modle.Book
import com.example.nguphaptienghan.modle.onClickItemBook

class BookAdapter(private val listBook: ArrayList<Book>, private  var onClickItemBook: onClickItemBook) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binItem(listBook[position])
        holder.itemView.setOnClickListener {
            onClickItemBook.onClick(position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binItem(book: Book) {
            val tvBook: TextView = itemView.findViewById(R.id.tvBook)

            tvBook.text = book.nameBook
        }
    }
}