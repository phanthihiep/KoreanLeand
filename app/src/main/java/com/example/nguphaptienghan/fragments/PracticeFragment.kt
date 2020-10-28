package com.example.nguphaptienghan.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.adapters.BookAdapter
import com.example.nguphaptienghan.adapters.FlashCardAdapter
import com.example.nguphaptienghan.adapters.VocabularyAdapter
import com.example.nguphaptienghan.database.DatabaseHandler
import com.example.nguphaptienghan.modle.Vocabulary

class PracticeFragment : Fragment() {
    private lateinit var mContext: Context
    private lateinit var mRcFlashCard: RecyclerView
    private  var mAdapter: FlashCardAdapter?= null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var db: DatabaseHandler
    private var listVocabulary: ArrayList<Vocabulary> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            mContext = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_practice, container, false)
        mRcFlashCard = view.findViewById(R.id.rc_FlashCard)

        db = DatabaseHandler(mContext)
        getVocabulary()
        setAdapter()
        return view
    }

    // set data for adapter
    private fun setAdapter() {
        layoutManager = GridLayoutManager(mContext, 3)
        mAdapter = FlashCardAdapter(listVocabulary)
        mRcFlashCard.layoutManager = layoutManager
        mRcFlashCard.adapter = mAdapter
    }

    // get data from db
    private fun getVocabulary() {
        db.viewVocabularyOne("1").forEach{vocabulary ->
            run {
                if (vocabulary.id <= 150) {
                    listVocabulary.add(vocabulary)
                }
            }
        }
    }

    companion object {
        fun newInstance(): PracticeFragment {
            return PracticeFragment()
        }

    }
}