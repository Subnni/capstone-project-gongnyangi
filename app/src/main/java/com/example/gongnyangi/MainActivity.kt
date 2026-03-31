package com.example.gongnyangi

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navigationBar: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPadding()

        navigationBar = findViewById(R.id.navigationBar)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController

        //intent 안 데이터 따라 프래그먼트 이동
        val target = intent.getStringExtra("targetFragment")
        when (target) {
            "Bookcase" -> navController.navigate(R.id.BookcaseFragment)
            "Closet" -> navController.navigate(R.id.ClosetFragment)
            "Mistake" -> navController.navigate(R.id.MistakeNoteFragment)
        }

        val commonUIHandler = CommonUIHandler()
        commonUIHandler.setupListener(
            this, navController, navigationBar)



    }

    // 네비게이션 바 숨기기(NoticeFragment, MyPageFragment에서 호출)
    public fun setNavVisible(isVisible: Boolean) {

        if (isVisible) {
            navigationBar.visibility = View.VISIBLE
        } else {
            navigationBar.visibility = View.GONE
        }
    }

    //상단 바 & 하단 네비게이션  높이만큼 여백 부여
    public fun setPadding(){
        //val fragmentContainer = findViewById<View>(R.id.fragmentContainer)
        //ViewCompat.setOnApplyWindowInsetsListener(fragmentContainer) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.updatePadding(top = systemBars.top)
        //    insets
        //}

        //val bottomNav = findViewById<View>(R.id.navigationBar)
        //ViewCompat.setOnApplyWindowInsetsListener(bottomNav) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.updatePadding(bottom = systemBars.bottom)
        //    insets
        //}
    }
}