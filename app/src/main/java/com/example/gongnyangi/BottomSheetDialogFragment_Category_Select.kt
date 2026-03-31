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
import com.example.gongnyangi.databinding.FragmentBottomSheetDialogCategorySelectListDialogBinding

class BottomSheetDialogFragment_Category_Select : BottomSheetDialogFragment() {

    //리스너
    var onCompleteSelectListener: (() -> Unit)? = null
    var onSettingSelectListener: (() -> Unit)? = null
    //UI 변수
    private lateinit var selectBtn : LinearLayout
    private lateinit var gotoCategorySettingButton : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog__category__select_list_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectBtn = view.findViewById(R.id.selectBtn)
        gotoCategorySettingButton = view.findViewById(R.id.gotoCategorySettingButton)

        selectBtn.setOnClickListener {
            //부모 프래그먼트가 정의한 동작 실행
            onCompleteSelectListener?.invoke()
        }
        gotoCategorySettingButton.setOnClickListener {
            onSettingSelectListener?.invoke()
        }

    }

}