package com.imn.practpro.fragments

import android.content.Context
import android.os.Bundle
import android.view.ContentInfo
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.imn.practpro.R
import com.imn.practpro.classes.LoginValidate
import com.imn.practpro.databinding.FragmentLoginBinding
import com.imn.practpro.room.database.Db

class LoginFragment : Fragment() {

    var binding : FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)

        binding?.loginButton?.setOnClickListener {
            if (LoginValidate().mailValidate(binding?.emailField?.text.toString()) &&
                LoginValidate().passwordValidate(binding?.passwordField?.text.toString(), requireContext())){

                val student = Db().getDatabase(requireContext()).studentDao().getStudent(
                    binding?.emailField?.text.toString(),
                    binding?.passwordField?.text.toString()
                )

                if(!student.equals(null)){
                    requireActivity().getSharedPreferences("User", Context.MODE_PRIVATE)
                        .edit()
                        .putString("email", binding?.emailField?.text.toString())
                        .putString("password", binding?.passwordField?.text.toString()).apply()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, VacanciesFragment())
                        .commit()
                }
            }
        }
        binding?.registrationButton?.setOnClickListener {
            Toast.makeText(requireContext(), "Раздел находится в разработке", Toast.LENGTH_SHORT).show()
        }
        return binding?.root
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}