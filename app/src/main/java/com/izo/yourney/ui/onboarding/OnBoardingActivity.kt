package com.izo.yourney.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.izo.yourney.R

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        supportActionBar?.hide()

        val mFragmentManager = supportFragmentManager
        val mViewPagerFragment = ViewPagerFragment()
        val fragment = mFragmentManager.findFragmentByTag(ViewPagerFragment::class.java.simpleName)

        if (fragment !is ViewPagerFragment) {
            Log.d("OnBoardingActivity", "Fragment Name :" + ViewPagerFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mViewPagerFragment, ViewPagerFragment::class.java.simpleName)
                .commit()
        }
    }
}