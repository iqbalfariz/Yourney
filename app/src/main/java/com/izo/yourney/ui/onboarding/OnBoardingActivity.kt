package com.izo.yourney.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.izo.yourney.R
import com.izo.yourney.data.local.StateModel
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.databinding.ActivityOnBoardingBinding
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.launchscreen.LaunchScreenActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var onBoardingViewModel: OnBoardingViewModel

    private val viewPagerAdapter = ViewPagerAdapter(
        listOf(
            IntroSlide(
                "Recognize your potential",
                "YOURNEY helps you recognize your potential with test and questions, so you can easily find out and develop your potential with YOURNEY",
                R.drawable.image_page1
            ),
            IntroSlide(
                "Make your day more productive by making an schedule",
                "YOURNEY help you to make an daily schedule activity or any schedule to make it easier for you.",
                R.drawable.image_page2
            ),
            IntroSlide(
                "Reach your dream future with Ney Smart Virtual Assistant",
                "YOURNEY have a smart virtual assistant that can help you to get know where you get interest in to achieve the dream future you want. ",
                R.drawable.image_page3
            ),
            IntroSlide(
                "Consultation with counselor",
                "YOURNEY have some consultation service to help you solve your problem.",
                R.drawable.image_page4
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
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
                onBoardingViewModel.enter()
                val intentToMain = Intent(this, LaunchScreenActivity::class.java)
                startActivity(intentToMain)
                finish()
            }
        }

        // skip page
        binding.tvPass.setOnClickListener {
            onBoardingViewModel.enter()
            val intentToMain = Intent(this, LaunchScreenActivity::class.java)
            startActivity(intentToMain)
            finish()
        }


    }

    private fun setupViewModel() {
        onBoardingViewModel = ViewModelProvider(
            this,
            ViewModelFactory(StatePreference.getInstance(dataStore))
        )[OnBoardingViewModel::class.java]
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