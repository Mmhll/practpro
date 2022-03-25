package com.imn.practpro.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imn.practpro.room.employer.dao.EmployerDao
import com.imn.practpro.room.employer.entity.Employer
import com.imn.practpro.room.student.dao.StudentDao
import com.imn.practpro.room.student.entity.Student
import com.imn.practpro.room.vacancy.dao.VacancyDao
import com.imn.practpro.room.vacancy.entity.Vacancy

@Database(entities = [Employer::class, Student::class, Vacancy::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun employerDao() : EmployerDao
    abstract fun studentDao() : StudentDao
    abstract fun vacancyDao() : VacancyDao
}