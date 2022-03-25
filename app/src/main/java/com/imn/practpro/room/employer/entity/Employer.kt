package com.imn.practpro.room.employer.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity()
data class Employer(
    @PrimaryKey val employerId : Int,
    @ColumnInfo val orgName : String,
    @ColumnInfo val initials : String,
    @ColumnInfo val number : String,
    @ColumnInfo val city : String,
    @ColumnInfo val email : String,
    @ColumnInfo val password : String
)
