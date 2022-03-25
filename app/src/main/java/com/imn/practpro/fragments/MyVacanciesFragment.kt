package com.imn.practpro.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imn.practpro.R
import com.imn.practpro.adapters.MyVacancyRecyclerAdapter
import com.imn.practpro.databinding.FragmentMyVacanciesBinding
import com.imn.practpro.room.database.Db
import com.imn.practpro.room.vacancy.entity.VacancyWithEmployer
import java.lang.Exception

class MyVacanciesFragment : Fragment() {
    var binding : FragmentMyVacanciesBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentMyVacanciesBinding.inflate(inflater)
            try {
            val prefs = requireActivity().getSharedPreferences("User", Context.MODE_PRIVATE)
            val email = prefs.getString("email", "")
            val password = prefs.getString("password", "")
            val db = Db().getDatabase(requireContext())
            var student = db.studentDao().getStudent(email!!, password!!)
            Log.d("tag", student.vacancies.trim())

            val arraySplited : List<String> = student.vacancies.trim().split(" ")
            Log.d("TAG", arraySplited.toString())
            val vacancies = db.vacancyDao().getVacancy()
            var requiredVacancies = arrayListOf<VacancyWithEmployer>()
            for (i in vacancies){
                for (j in arraySplited.indices){
                    if (i.id == arraySplited[j].toInt()){
                        requiredVacancies.add(i)
                    }
                }
            }

            binding?.recyclerMyVacancies?.adapter =
                MyVacancyRecyclerAdapter(requiredVacancies, requireContext(), requireActivity())
        }
        catch (e :Exception){

        }
        binding?.backButton?.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, VacanciesFragment())
                .commit()
        }
        return binding?.root
    }

}