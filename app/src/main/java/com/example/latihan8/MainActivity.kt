package com.example.latihan8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(emptyList())
        recyclerView.adapter = adapter

        Thread {
            val userDao = MyApp.database.userDao()
            val users = userDao.getAllUsers()
            runOnUiThread {
                adapter.setData(users)
            }
        }.start()
    }
}