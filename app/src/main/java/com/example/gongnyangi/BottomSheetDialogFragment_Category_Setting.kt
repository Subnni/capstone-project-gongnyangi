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
import android.widget.TextView
import com.example.gongnyangi.databinding.FragmentBottomSheetDialogCategorySettingListDialogBinding

// MyBottomSheetFragment.kt
class BottomSheetDialogFragment_Category_Setting : BottomSheetDialogFragment() {

    var onCompleteSettingListener: (() -> Unit)? = null

    private lateinit var settingCompleteButton : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog__category__setting_list_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingCompleteButton = view.findViewById(R.id.settingCompleteButton)
        settingCompleteButton.setOnClickListener {
            //부모 프래그먼트가 정의한 동작 실행
            onCompleteSettingListener?.invoke()
        }
    }
}