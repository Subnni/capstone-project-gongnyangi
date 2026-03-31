package com.example.gongnyangi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController

class TextBook_ConfirmPhotoFragment : Fragment() {

    private lateinit var textbookCompleteButton : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_book__confirm_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //상단 상태바 높이만큼 패딩 부여
        StatusBarUtils.addStatusBarPadding(view)

        textbookCompleteButton = view.findViewById(R.id.textbookCompleteButton)
        textbookCompleteButton.setOnClickListener {
            findNavController().navigate(R.id.gotoTextbook_Loading)
        }
    }

}