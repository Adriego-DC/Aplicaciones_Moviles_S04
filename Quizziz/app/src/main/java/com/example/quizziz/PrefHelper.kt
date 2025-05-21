package com.example.quizziz

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PrefsHelper {
    private const val PREF_NAME = "QuizzizPrefs"
    private const val USERS_KEY = "usuarios"
    private const val CURRENT_USER_KEY = "usuarioActual"

    fun guardarUsuarios(context: Context, usuarios: List<User>) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val json = Gson().toJson(usuarios)
        editor.putString(USERS_KEY, json)
        editor.apply()
    }

    fun obtenerUsuarios(context: Context): MutableList<User> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(USERS_KEY, null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<User>>() {}.type
            Gson().fromJson(json, type)
        } else {
            mutableListOf()
        }
    }

    fun guardarUsuarioActual(context: Context, usuario: User) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = Gson().toJson(usuario)
        prefs.edit().putString(CURRENT_USER_KEY, json).apply()
    }

    fun obtenerUsuarioActual(context: Context): User? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(CURRENT_USER_KEY, null)
        return if (json != null) Gson().fromJson(json, User::class.java) else null
    }
}