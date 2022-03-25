package com.imn.practpro.room.vacancy.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imn.practpro.room.employer.entity.Employer

@Entity
data class Vacancy(
    @PrimaryKey val vacancyId : Int,
    @ColumnInfo val vacName : String,
    @ColumnInfo(name = "employer_id") val employerId : Int,
    @ColumnInfo val describe : String,
    @ColumnInfo val address : String
    )
