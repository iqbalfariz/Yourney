package com.izo.yourney.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.izo.yourney.R
import com.izo.yourney.databinding.FragmentHomeBinding
import com.izo.yourney.databinding.FragmentIconBinding
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.counseling.CounselingActivity

class IconFragment : Fragment() {

    private var _binding: FragmentIconBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIconBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

        clickEvents()
    }

    private fun clickEvents() {
        binding.btnChatbot.setOnClickListener {
            val intentToChatbot = Intent(requireActivity(), ChatbotActivity::class.java)
            startActivity(intentToChatbot)
            onDestroy()
        }

        binding.btnCounseling.setOnClickListener {
            val intentToCounseling = Intent(requireActivity(), CounselingActivity::class.java)
            startActivity(intentToCounseling)
            onDestroy()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}