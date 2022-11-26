package com.example.assignment7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment7.api.ReqresApi
import com.example.assignment7.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val prevButton = findViewById<Button>(R.id.buttonPrevPage)
        val nextButton = findViewById<Button>(R.id.buttonNextPage)

        fun loadData(page: Int) {
            val call = ReqresApi.requests.getUsers(page)
            call.enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                    when (response.isSuccessful) {
                        true -> {
                            val users = response.body()!!
                            recyclerView.adapter = UserAdapter(users)
                            if (users.page <= 1) {
                                prevButton.isActivated = false
                            } else {
                                prevButton.setOnClickListener {
                                    loadData(users.page-1)
                                }
                            }
                            if (users.page >= users.totalPages) {
                                nextButton.isActivated = false
                            } else {
                                nextButton.setOnClickListener {
                                    loadData(users.page+1)
                                }
                            }

                        }
                        false -> Toast.makeText(this@MainActivity, "Unsuccessfully response", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Request fail", Toast.LENGTH_LONG).show()
                }
            })
        }

        loadData(1)
    }
}