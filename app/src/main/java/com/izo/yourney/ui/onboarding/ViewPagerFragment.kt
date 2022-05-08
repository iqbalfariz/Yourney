//package com.izo.yourney.ui.onboarding
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.viewpager.widget.ViewPager
//import androidx.viewpager2.widget.ViewPager2
//import com.izo.yourney.R
//import com.izo.yourney.databinding.FragmentViewPagerBinding
//import com.izo.yourney.ui.onboarding.screens.FirstScreen
//import com.izo.yourney.ui.onboarding.screens.FourthScreen
//import com.izo.yourney.ui.onboarding.screens.SecondScreen
//import com.izo.yourney.ui.onboarding.screens.ThirdScreen
//
//class ViewPagerFragment : Fragment() {
//
//    private var _binding: FragmentViewPagerBinding? = null
//    private val binding get() = _binding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
//        val view = binding?.root
//
//        val fragmentList = arrayListOf(
//            FirstScreen(),
//            SecondScreen(),
//            ThirdScreen(),
//            FourthScreen()
//        )
//
//        val adapter = ViewPagerAdapter(
//            fragmentList,
//            requireActivity().supportFragmentManager,
//            lifecycle
//        )
//
//
//        binding?.viewPager?.adapter = adapter
//
//        return view
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//}