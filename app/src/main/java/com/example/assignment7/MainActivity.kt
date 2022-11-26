package com.example.assignment7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.assignment7.api.ReqresApi
import com.example.assignment7.model.User
import com.example.assignment7.model.Users
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCredate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        GlobalScope.launch {
//            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//            recyclerView.adapter = UserAdapter(ReqresApi.requests.getUsers(1))
//        }

        val users = ReqresApi.requests.getUsers(1)
        users.enqueue()
    }
}