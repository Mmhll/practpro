package com.imn.practpro.room.vacancy.entity


data class VacancyWithEmployer(
    val id : Int,
    val organization : String,
    val vacName : String,
    val describe : String,
    val address : String
)
