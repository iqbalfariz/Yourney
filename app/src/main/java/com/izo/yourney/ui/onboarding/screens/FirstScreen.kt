package com.izo.yourney.ui.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.izo.yourney.R
import com.izo.yourney.databinding.FragmentFirstScreenBinding
import com.izo.yourney.databinding.FragmentViewPagerBinding
import com.izo.yourney.ui.MainActivity

class FirstScreen : Fragment() {

    private var _binding: FragmentFirstScreenBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        val view = binding?.root

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)


        binding?.tvNext?.setOnClickListener {
            viewPager?.currentItem = 1
        }

        binding?.tvPass?.setOnClickListener {
            val intentToMain = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intentToMain)
            requireActivity().finish()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}