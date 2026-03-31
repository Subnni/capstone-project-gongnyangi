package com.example.gongnyangi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    private lateinit var gotoBookcaseImageButton : ImageButton
    private lateinit var gotoNoticeImageView : ImageView
    private lateinit var gotoMyPageImageView : ImageView

    //레이아웃 생성
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setNavVisible(true)

        //상단 상태바 높이만큼 패딩 부여
        StatusBarUtils.addStatusBarPadding(view)

        //UI 연결
        gotoBookcaseImageButton = view.findViewById(R.id.gotoBookcaseImageButton)
        gotoNoticeImageView = view.findViewById(R.id.gotoNoticeImageView)
        gotoMyPageImageView = view.findViewById(R.id.gotoMyPageImageView)

        //페이지 이동 버튼 리스너 연결
        val currentFragment = parentFragmentManager.findFragmentById(R.id.fragmentContainer)
        gotoNoticeImageView.setOnClickListener {
            findNavController().navigate(R.id.gotoNotice)
        }
        gotoMyPageImageView.setOnClickListener {
            findNavController().navigate(R.id.MyPageFragment)

        }
        gotoBookcaseImageButton.setOnClickListener {
            findNavController().navigate(R.id.gotoBookcase)
        }

    }

}