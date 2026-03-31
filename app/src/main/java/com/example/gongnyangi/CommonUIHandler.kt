package com.example.gongnyangi

import android.content.Intent
import android.graphics.Rect
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController

class CommonUIHandler {

    private lateinit var homeMenu : LinearLayout
    private lateinit var bookcaseMenu : LinearLayout
    private lateinit var cameraMenu : LinearLayout
    private lateinit var mistakeNoteMenu : LinearLayout
    private lateinit var closetMenu : LinearLayout

    public fun setupListener(activity : AppCompatActivity, navController: NavController, navigationBarView: View) {

        //edge-to-edge 하단 UI 겹침 이슈 해결
        //val rootView = activity.window.decorView.findViewById<View>(android.R.id.content)
        //applyTopBottomPaddingForEdgeToEdge(rootView)

        //하단 네비게이션 바

        homeMenu = activity.findViewById(R.id.homeMenu)
        bookcaseMenu = activity.findViewById(R.id.bookcaseMenu)
        cameraMenu = activity.findViewById(R.id.cameraMenu)
        mistakeNoteMenu = activity.findViewById(R.id.mistakeNoteMenu)
        closetMenu = activity.findViewById(R.id.closetMenu)

        //각 버튼에 리스너 연결
        homeMenu.setOnClickListener {
            navController.navigate(R.id.HomeFragment)
        }
        bookcaseMenu.setOnClickListener {
            navController.navigate(R.id.BookcaseFragment)
        }
        cameraMenu.setOnClickListener {
            val intent = Intent(activity, CreateBookActivity::class.java)
            activity.startActivity(intent)
        }
        mistakeNoteMenu.setOnClickListener {
            navController.navigate(R.id.MistakeNoteFragment)
        }
        closetMenu.setOnClickListener {
            navController.navigate(R.id.ClosetFragment)
        }
    }

    private fun applyTopBottomPaddingForEdgeToEdge(rootView: View) {

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            // 상태바와 내비게이션 바 높이 얻기
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val naviBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom

            // 키보드가 올라왔을 때 아래쪽 패딩 계산
            val bottomPadding = getBottomPaddingChangedByKeyboard(view, naviBarHeight)

            // 상단/하단 패딩 적용
            view.setPadding(0, 0, 0, bottomPadding)
            insets
        }
    }

    private fun getBottomPaddingChangedByKeyboard(view: View, naviBarHeight: Int): Int {
        // 화면에 키보드가 올라왔는지 확인하고, 올려졌으면 키보드 높이만큼 패딩 적용
        val rect = Rect().apply { view.rootView.getWindowVisibleDisplayFrame(this) }
        return if (isKeyBoardVisible(view.height, rect)) {
            view.height - rect.bottom
        } else {
            naviBarHeight
        }
    }

    private fun isKeyBoardVisible(screenHeight: Int, rect: Rect): Boolean {
        // 키보드가 화면에 올라왔는지 체크 (높이가 화면 높이의 13% 이상일 경우 키보드가 올라왔다고 판단)
        val keyboardHeight = screenHeight - rect.bottom
        return keyboardHeight > screenHeight * 0.13
    }

}