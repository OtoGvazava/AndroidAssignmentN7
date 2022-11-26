package com.example.assignment7

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.assignment7.api.ReqresApi
import com.example.assignment7.model.User
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_information)

        val firstNameView = findViewById<TextView>(R.id.textViewInfoFirstName)
        val lastNameView = findViewById<TextView>(R.id.textViewInfoLastName)
        val emailView = findViewById<TextView>(R.id.textViewInfoEmail)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val userId = intent.getIntExtra("userId", -1)
        val call = ReqresApi.requests.getUser(userId)

        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                when (response.isSuccessful) {
                    true -> {
                        val user = response.body()!!.data
                        firstNameView.text = user.firstName
                        lastNameView.text = user.lastName
                        emailView.text = user.email
                        Picasso.get().load(Uri.parse(user.avatar)).into(imageView)
                    }
                    false -> {
                        Toast.makeText(this@UserInformationActivity, "Unsuccessfully response", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@UserInformationActivity, "Request fail", Toast.LENGTH_LONG).show()
            }
        })
    }
}