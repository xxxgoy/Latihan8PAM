package com.example.latihan8

import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this, AppDatabase::class.java, "my_database")
            .build()

        Thread {
            val userDao = database.userDao()
            userDao.insertUser(User(
                username = "John Doe", email = "john@example.com"))
            userDao.insertUser(User(
                username = "Jane Smith", email = "jane@example.com"))
            userDao.insertUser(User(
                username = "Mike Johnson", email = "mike@example.com"))
        }.start()
    }
}