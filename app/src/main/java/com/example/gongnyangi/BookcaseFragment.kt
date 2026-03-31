package com.example.gongnyangi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class BookcaseFragment : Fragment() {

    private lateinit var categorySettingImageButton : TextView
    private lateinit var tempBook : LinearLayout
    private lateinit var tempWorkbook : LinearLayout

    private lateinit var popupTextView : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookcase, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setNavVisible(true)

        //상단 상태바 높이만큼 패딩 부여
        StatusBarUtils.addStatusBarPadding(view)

        //ui 연결
        categorySettingImageButton = view.findViewById(R.id.categorySettingImageButton)
        tempBook = view.findViewById(R.id.tempBook)
        tempWorkbook = view.findViewById(R.id.tempWorkbook)
        popupTextView = view.findViewById(R.id.popupTextView)

        //리스너 연결
        //1. 카테고리 변경
        categorySettingImageButton.setOnClickListener {
            val bottomSheet = BottomSheetDialogFragment_Category_Setting()
            bottomSheet.onCompleteSettingListener = {
                bottomSheet.dismiss()
                //bottomSheet_select.refreshData() //데이터 리프레쉬
            }
            bottomSheet.show(parentFragmentManager, "MyBottomSheet")
        }
        //2. 개념서 이동
        tempBook.setOnClickListener {
            val intent = Intent(requireContext(), ViewerActivity::class.java)
            intent.putExtra("BOOK_ID", 100) //임시
            intent.putExtra("BOOK_TYPE", "TEXTBOOK") //임시
            startActivity(intent)
        }
        //3. 문제집 이동
        tempWorkbook.setOnClickListener {
            val intent = Intent(requireContext(), ViewerActivity::class.java)
            intent.putExtra("BOOK_ID", 101) //임시
            intent.putExtra("BOOK_TYPE", "WORKBOOK") //임시
            startActivity(intent)
        }
        //4. 개념서 설정 관련 드롭다운 목록
        popupTextView.setOnClickListener { v ->
            //객체 생성
            val popup = androidx.appcompat.widget.PopupMenu(requireContext(), v)
            //xml 파일 연결
            popup.menuInflater.inflate(R.menu.popup_textbook, popup.menu)
            //리스너 연결
            popup.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.item_create_workbook -> {
                        true
                    }
                    R.id.item_select_category -> {
                        val bottomSheet = BottomSheetDialogFragment_Category_Select()
                        bottomSheet.onCompleteSelectListener = {
                            bottomSheet.dismiss()
                        }
                        bottomSheet.onSettingSelectListener = {
                            val settingSheet = BottomSheetDialogFragment_Category_Setting()
                            //바텀시트 안의 버튼 동작 정의
                            settingSheet.onCompleteSettingListener = {
                                settingSheet.dismiss()
                                //bottomSheet_select.refreshData() //데이터 리프레쉬
                            }
                            settingSheet.show(parentFragmentManager, "CategorySettingSheet")
                        }
                        bottomSheet.show(parentFragmentManager, "MyBottomSheet")
                        true
                    }
                    R.id.item_textbook_setting -> {
                        val bottomSheet = BottomSheetDialogFragment_Textbook_Setting()
                        bottomSheet.show(parentFragmentManager, "MyBottomSheet")
                        true
                    }
                    R.id.item_textbook_delete -> {
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }
}