package com.example.positivity.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.positivity.R
import kotlinx.coroutines.*

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            delay(4000)
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToWalkThroughFragment())
        }
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

}