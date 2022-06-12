package com.izo.yourney.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.databinding.FragmentHomeBinding
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.dailycheckin.DailyActivity

//private val HomeFragment.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

        clickEvents()

        setupViewModel()
//
//        binding.btnLogout.setOnClickListener {
//
//        }
    }

    private fun clickEvents() {
        binding.btnGood.setOnClickListener {
            val intentToDaily = Intent(requireActivity(), DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnVeryGood.setOnClickListener {
            val intentToDaily = Intent(requireActivity(), DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnBad.setOnClickListener {
            val intentToDaily = Intent(requireActivity(), DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnVeryGood.setOnClickListener {
            val intentToDaily = Intent(requireActivity(), DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnLogout.setOnClickListener {
            homeViewModel.logout()

        }
    }

    private fun setupViewModel() {
//        homeViewModel = ViewModelProvider(
//            requireActivity(),
//            ViewModelFactory(StatePreference.getInstance(dataStore))
//        )[HomeViewModel::class.java]
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}