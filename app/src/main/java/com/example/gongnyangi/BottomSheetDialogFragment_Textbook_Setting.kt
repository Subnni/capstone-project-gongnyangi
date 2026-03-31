package com.example.gongnyangi

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class BottomSheetDialogFragment_Textbook_Setting : BottomSheetDialogFragment() {

    var onCompleteSelectListener: (() -> Unit)? = null
    private lateinit var selectBtn : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog__textbook__setting_list_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectBtn = view.findViewById(R.id.selectBtn)
        selectBtn.setOnClickListener {
            //부모 프래그먼트가 정의한 동작 실행
            onCompleteSelectListener?.invoke()
        }
    }

}