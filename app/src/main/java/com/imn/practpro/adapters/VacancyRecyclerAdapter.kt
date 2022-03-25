package com.imn.practpro.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.imn.practpro.R
import com.imn.practpro.room.database.Db
import com.imn.practpro.room.vacancy.entity.Vacancy
import com.imn.practpro.room.vacancy.entity.VacancyWithEmployer
import java.util.regex.Pattern

class VacancyRecyclerAdapter(val array : Array<VacancyWithEmployer>, val context : Context, val activity : FragmentActivity) : RecyclerView.Adapter<VacancyRecyclerAdapter.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vacancyName : TextView = itemView.findViewById(R.id.vacancyName)
        val companyName : TextView = itemView.findViewById(R.id.companyName)
        val vacancyDescription : TextView = itemView.findViewById(R.id.vacancyDescription)
        val vacancyAddress : TextView = itemView.findViewById(R.id.vacancyAddress)
        val button : Button = itemView.findViewById(R.id.buttonCall)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.vacancyName.text = array[position].vacName
        holder.companyName.text = array[position].organization
        holder.vacancyDescription.text = array[position].describe
        holder.vacancyAddress.text = array[position].address
        holder.button.setOnClickListener {
            val prefs = activity.getSharedPreferences("User", Context.MODE_PRIVATE)
            val email = prefs.getString("email", "")
            val password = prefs.getString("password", "")
            val db = Db().getDatabase(context)
            var student = db.studentDao().getStudent(email!!, password!!)
            val arraySplited : List<String> = student.vacancies.split(" ")
            var contains = false
            for (i in arraySplited){
                if (array[position].id.toString() == i){
                    contains = true
                    break
                }
            }
            if (!contains){
                student.vacancies += array[position].id.toString() + " "
                db.studentDao().updateStudent(student)
            }
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}