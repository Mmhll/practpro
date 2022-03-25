package com.imn.practpro.room.student.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey
    val studentId : Int,
    @ColumnInfo
    val initials : String,
    @ColumnInfo
    val number : String,
    @ColumnInfo
    val city : String,
    @ColumnInfo
    val studyIn : String,
    @ColumnInfo
    val course : String,
    @ColumnInfo
    val speciality : String,
    @ColumnInfo
    val email : String,
    @ColumnInfo
    val password : String
)
