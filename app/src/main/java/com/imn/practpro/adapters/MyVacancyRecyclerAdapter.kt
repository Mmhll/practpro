package com.imn.practpro.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.imn.practpro.R
import com.imn.practpro.fragments.MyVacanciesFragment
import com.imn.practpro.room.database.Db
import com.imn.practpro.room.vacancy.entity.VacancyWithEmployer

class MyVacancyRecyclerAdapter(val array : ArrayList<VacancyWithEmployer>, val context : Context, val activity : FragmentActivity) : RecyclerView.Adapter<MyVacancyRecyclerAdapter.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vacancyName : TextView = itemView.findViewById(R.id.myVacancyName)
        val companyName : TextView = itemView.findViewById(R.id.myCompanyName)
        val vacancyDescription : TextView = itemView.findViewById(R.id.myVacancyDescription)
        val vacancyAddress : TextView = itemView.findViewById(R.id.myVacancyAddress)
        val button : Button = itemView.findViewById(R.id.buttonCancel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.recycler_item_my, parent, false))
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
            var vacs = ""
            for (i in arraySplited){
                if (array[position].id.toString() == i){
                    continue
                }
                vacs += "$i "
            }

            student.vacancies = vacs
            db.studentDao().updateStudent(student)
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MyVacanciesFragment())
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}