package com.example.nguphaptienghan.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import com.example.nguphaptienghan.R

class PronounceFragment : Fragment() {
    private lateinit var mVideoViewBook: VideoView
    private lateinit var mContext: Context

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
        val  view = inflater.inflate(R.layout.fragment_pronounce, container, false)
        initView(view)
        val mediaController = MediaController(mContext)
        mediaController.setAnchorView(mVideoViewBook)
        val onlineUrl: Uri = Uri.parse("https://www.youtube.com/watch?v=O4aSqBKJGI0")
        mVideoViewBook.setMediaController(mediaController)
        mVideoViewBook.setVideoURI(onlineUrl)
        mVideoViewBook.requestFocus()
        mVideoViewBook.start()
        return view
    }

    // init View
    private fun initView( view : View) {
        mVideoViewBook = view.findViewById(R.id.videoView_bookOne)
    }

    companion object {
        fun newInstance(): PronounceFragment {
            return PronounceFragment()
        }

    }
}