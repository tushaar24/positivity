package com.example.positivity.ui.fragments.walkthrough

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.models.SlideModel
import com.example.positivity.R
import com.example.positivity.databinding.FragmentWalkThroughBinding

class WalkThroughFragment : Fragment() {

    private var _binding: FragmentWalkThroughBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalkThroughBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpWalkThroughImages()

        binding.tvHeading.text = "Always Stay Happy"
        binding.tvSubHeading.text = "Happiness is a choice \n therefore, its in your \n hand to be happy"

        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(WalkThroughFragmentDirections.actionWalkThroughFragmentToPositive())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpWalkThroughImages() {
        val walkThroughImagesList = ArrayList<SlideModel>()

        val walkThroughImage1 = SlideModel(R.drawable.theme2_walk_1)
        val walkThroughImage2 = SlideModel(R.drawable.theme2_walk_2)
        val walkThroughImage3 = SlideModel(R.drawable.theme2_walk_3)

        walkThroughImagesList.add(walkThroughImage1)
        walkThroughImagesList.add(walkThroughImage2)
        walkThroughImagesList.add(walkThroughImage3)

        binding.walkthroughImages.setImageList(walkThroughImagesList)
    }

}