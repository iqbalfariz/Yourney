package com.izo.yourney.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityOnBoardingBinding

import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.launchscreen.LaunchScreenActivity
import com.izo.yourney.ui.register.RegisterActivity

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    private val viewPagerAdapter = ViewPagerAdapter(
        listOf(
            IntroSlide(
                "Ketahui Potensi Dalam Dirimu Dengan Mudah",
                "Aplikasi YOURNEY membantumu mengenali Potensi yang ada di dalam diri melalui serangkaian tes dan pertanyaan, sehingga kamu dengan mudah mengetahui dan mengembangkan potensimu bersama YOURNEY.",
                R.drawable.image_page1
            ),
            IntroSlide(
                "Buat Harimu Lebih Produktif Dengan Mencatat Jadwal",
                "Aplikasi YOURNEY membantumu dalam membuat jadwal harian maupun jadwal lain agar lebih mempermudah kamu dalam beraktivitas.",
                R.drawable.image_page2
            ),
            IntroSlide(
                "Gapai Masa Depan Bersama Ney Smart Virtual Assistant",
                "Aplikasi YOURNEY memiliki smart virtual assistant yang dapat membantu kamu dalam memberi tahu dan merekomendasikan minat kamu untuk mencapai masa depan dengan kemampuan yang sesuai. ",
                R.drawable.image_page3
            ),
            IntroSlide(
                "Konsultasikan Masalahmu dengan Konselor",
                "Aplikasi YOURNEY memiliki layanan konsultasi untuk membantu kamu menyelesaikan permasalahan yang sedang kamu alami dalam menggapai mimpimu.",
                R.drawable.image_page4
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()


        val viewPager = binding.viewPager

        viewPager.adapter = viewPagerAdapter
        setUpIndicators()
        setCurrentIndicator(0)

        // change indicator
        viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        }
        )

        // change page
        binding.tvNext.setOnClickListener {
            if (viewPager.currentItem + 1 < viewPagerAdapter.itemCount) {
                viewPager.currentItem += 1
            } else {
                val intentToMain = Intent(this, LaunchScreenActivity::class.java)
                startActivity(intentToMain)
                finish()
            }
        }

        // skip page
        binding.tvPass.setOnClickListener {
            val intentToMain = Intent(this, LaunchScreenActivity::class.java)
            startActivity(intentToMain)
            finish()
        }


    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

    private fun setUpIndicators() {
        val indicators = arrayOfNulls<ImageView>(viewPagerAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setUpView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}