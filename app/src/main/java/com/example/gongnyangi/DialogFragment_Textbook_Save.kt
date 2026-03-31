package com.example.gongnyangi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class DialogFragment_Textbook_Save : DialogFragment() {

    // 버튼 클릭 시 동작을 정의할 변수
    var onConfirmClickListener: (() -> Unit)? = null
    private lateinit var closeDialogTextView : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog__textbook__save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 확인 버튼 클릭 시
        closeDialogTextView = view.findViewById(R.id.closeDialogTextView)
        closeDialogTextView.setOnClickListener {
            onConfirmClickListener?.invoke()
            dismiss()
        }
    }

}