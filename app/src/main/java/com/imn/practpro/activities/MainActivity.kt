package com.imn.practpro.activities

import android.app.AlertDialog
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imn.practpro.R
import com.imn.practpro.fragments.EmployerRegistrationFragment
import com.imn.practpro.room.database.AppDatabase
import com.imn.practpro.room.employer.dao.EmployerDao
import com.imn.practpro.room.employer.entity.Employer
import com.imn.practpro.room.student.dao.StudentDao
import com.imn.practpro.room.student.entity.Student
import com.imn.practpro.room.vacancy.dao.VacancyDao
import com.imn.practpro.room.vacancy.entity.Vacancy
import com.imn.practpro.room.vacancy.entity.VacancyWithEmployer

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "PEPEGA"
        ).allowMainThreadQueries().build()*/
        var f = EmployerRegistrationFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, f)
            .commit()

       /* db.employerDao().putEmployer(
            Employer(
                employerId = 0,
                orgName = "PEPEGA NAME",
                initials = "Valeriy Jmishenko",
                number = "111111111",
                city = "Tyumen",
                email = "JmishenkoPepegster@gmail.com",
                password = "qwerty"
            )
        )
        db.employerDao().putEmployer(
            Employer(
                employerId = 1,
                orgName = "POPOGA NAME",
                initials = "Valeriy Jmishenko",
                number = "111111111",
                city = "Tyumen",
                email = "JmishenkoPepegster@gmail.com",
                password = "qwerty"
            )
        )
        db.vacancyDao().putVacancy(
            Vacancy(
                vacancyId = 0,
                vacName = "Name",
                employerId = 0,
                address = "UL PUPA DOM ZALUPA",
                describe = "BEST WORK"
            )
        )
        db.vacancyDao().putVacancy(
            Vacancy(
                vacancyId = 1,
                vacName = "Name",
                employerId = 0,
                address = "UL PUPA DOM ZALUPA",
                describe = "BEBEGA"
            )
        )

        val vacs = db.vacancyDao().getVacancy()

        AlertDialog.Builder(this)
            .setMessage(vacs[0].describe + "\n" + vacs[1].describe)
            .create()
            .show()*/
    }
}

