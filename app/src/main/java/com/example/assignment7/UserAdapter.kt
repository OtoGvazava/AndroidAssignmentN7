package com.example.assignment7

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment7.model.Users

class UserAdapter(private val users: Users): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(userView: View): RecyclerView.ViewHolder(userView) {
        val firstName: TextView = userView.findViewById(R.id.textViewFirstName)
        val lastName: TextView = userView.findViewById(R.id.textViewLastName)
        val cardView: CardView = userView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.data[position]
        holder.firstName.text = user.firstName
        holder.lastName.text = user.lastName
        holder.cardView.setOnClickListener {
            val userInformationActivity = Intent(it.context, UserInformationActivity::class.java)
            userInformationActivity.putExtra("userId", user.id)
            it.context.startActivity(userInformationActivity)
        }
    }

    override fun getItemCount(): Int {
        return users.data.size
    }
}