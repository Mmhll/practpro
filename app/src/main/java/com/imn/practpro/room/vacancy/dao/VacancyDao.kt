package com.imn.practpro.room.vacancy.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.imn.practpro.room.vacancy.entity.Vacancy
import com.imn.practpro.room.vacancy.entity.VacancyWithEmployer

@Dao
interface VacancyDao {
    @Query("SELECT Vacancy.vacancyId as id," +
            " Employer.orgName as organization," +
            " Vacancy.vacName as vacName," +
            " Vacancy.describe AS describe," +
            " Vacancy.address AS address " +
            "FROM Vacancy, Employer WHERE" +
            " employerId = employer_id")
    fun getVacancy() : Array<VacancyWithEmployer>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun putVacancy(vacancy: Vacancy)
}