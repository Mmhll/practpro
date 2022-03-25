package com.imn.practpro.room.employer.dao

import androidx.room.*
import com.imn.practpro.room.employer.entity.Employer

@Dao
interface EmployerDao {
    @Query("SELECT * from Employer where email is :employerEmail and password is :employerPassword")
    fun getEmployer(employerEmail : String, employerPassword : String) : Employer
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun putEmployer(employer : Employer)
    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateEmployer(employer: Employer)
}