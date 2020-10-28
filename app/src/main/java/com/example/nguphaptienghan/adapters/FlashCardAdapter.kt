package com.example.nguphaptienghan.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.modle.Vocabulary

class FlashCardAdapter(private val list: ArrayList<Vocabulary>): RecyclerView.Adapter<FlashCardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun binItem(vocabulary: Vocabulary) {
            val mTvContent = itemView.findViewById<TextView>(R.id.tv_Content)
            mTvContent.text = vocabulary.korean
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flash_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binItem(list[position])
    }
}