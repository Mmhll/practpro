package com.imn.practpro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.imn.practpro.R
import com.imn.practpro.adapters.VacancyRecyclerAdapter
import com.imn.practpro.databinding.FragmentVacanciesBinding
import com.imn.practpro.room.database.Db

class VacanciesFragment : Fragment() {

    var binding : FragmentVacanciesBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVacanciesBinding.inflate(inflater)
        val db = Db().getDatabase(requireContext())
        val vacancies = db.vacancyDao().getVacancy()
        binding?.recyclerVacancies?.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        binding?.recyclerVacancies?.adapter = VacancyRecyclerAdapter(vacancies, requireContext(), requireActivity())
        binding?.searchButton?.setOnClickListener {
            Toast.makeText(requireContext(), "Функция находится в разработке", Toast.LENGTH_SHORT).show()
        }
        binding?.myVacsButton?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MyVacanciesFragment())
                .commit()
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}