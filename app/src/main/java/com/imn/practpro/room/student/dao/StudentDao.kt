package com.imn.practpro.room.student.dao

import androidx.room.*
import com.imn.practpro.room.student.entity.Student

@Dao
interface StudentDao {
    @Query("SELECT * from Student where email is :studentEmail and password is :studentPassword")
    fun getStudent(studentEmail : String, studentPassword : String) : Student
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun putStudent(student : Student)
    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateStudent(student : Student)
}