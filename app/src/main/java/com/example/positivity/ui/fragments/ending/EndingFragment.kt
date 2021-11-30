package com.example.positivity.ui.fragments.ending

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.positivity.R
import com.example.positivity.databinding.FragmentEndingBinding

class EndingFragment : Fragment() {

    private var _binding : FragmentEndingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEndingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRestart.setOnClickListener {
            findNavController().navigate(EndingFragmentDirections.actionEndingFragment2ToPositive())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}