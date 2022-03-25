package com.imn.practpro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imn.practpro.R
import com.imn.practpro.databinding.FragmentEmployerRegistrationBinding

class EmployerRegistrationFragment : Fragment() {

    private lateinit var binding : FragmentEmployerRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployerRegistrationBinding.inflate(inflater)


        return binding.root
    }
}