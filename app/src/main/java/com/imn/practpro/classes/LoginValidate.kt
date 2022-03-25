package com.imn.practpro.classes

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import java.util.regex.Pattern

class LoginValidate {
    fun mailValidate(email : String) : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun passwordValidate(password : String, context : Context) : Boolean{
        if (password.isEmpty() || password.length < 6){
            Toast.makeText(context, "Длина пароля не может быть меньше 6", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}