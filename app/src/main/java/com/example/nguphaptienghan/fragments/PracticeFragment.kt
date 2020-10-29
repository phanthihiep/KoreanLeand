package com.example.nguphaptienghan.fragments

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.adapters.FlashCardAdapter
import com.example.nguphaptienghan.database.DatabaseHandler
import com.example.nguphaptienghan.modle.OnClickItemFlashCard
import com.example.nguphaptienghan.modle.Vocabulary

class PracticeFragment : Fragment(), OnClickItemFlashCard {
    private lateinit var mContext: Context
    private lateinit var mAlertDialog: AlertDialog
    private lateinit var mDialogBundle: AlertDialog.Builder
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
        mAdapter = FlashCardAdapter(listVocabulary, this)
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

    override fun onClickItem(vocanulary: Vocabulary) {
        showContentMean(R.layout.dialog_mean_word, vocanulary.vietnamese)
    }

    //show dialog content
    private fun showContentMean( layout: Int, content: String) {
        mDialogBundle = AlertDialog.Builder(mContext)
        val layoutView = layoutInflater.inflate(layout, null)
        val btClose = layoutView.findViewById<Button>(R.id.bt_Close)
        val tvContent = layoutView.findViewById<TextView>(R.id.tv_Mean)
        tvContent.text = content

        mDialogBundle.setView(layoutView)
        mAlertDialog = mDialogBundle.create()
        mAlertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mAlertDialog.show()
        btClose.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }
}