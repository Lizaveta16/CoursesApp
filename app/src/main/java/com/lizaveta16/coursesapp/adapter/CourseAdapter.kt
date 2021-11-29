package com.lizaveta16.coursesapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.model.Category

class CourseAdapter(var context: Context, var courses : List<Category>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>(){

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return courses.count()
    }
}