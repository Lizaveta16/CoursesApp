package com.lizaveta16.coursesapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.R
import com.lizaveta16.coursesapp.model.Course

class CourseAdapter(private var context: Context, private var courses : List<Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>(){

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val courseBg : CardView = itemView.findViewById(R.id.courseBg)
        val courseImg : ImageView = itemView.findViewById(R.id.courseImg)
        val courseTitle : TextView = itemView.findViewById(R.id.courseTitle)
        val courseDate : TextView = itemView.findViewById(R.id.courseDate)
        val courseLevel : TextView = itemView.findViewById(R.id.courseLevel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val courseItems : View = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false)
        return CourseAdapter.CourseViewHolder(courseItems)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses[position].color))

        val imgId : Int = context.resources.getIdentifier("ic_" + courses[position].img, "drawable", context.packageName)
        holder.courseImg.setImageResource(imgId)

        holder.courseTitle.text = courses[position].title
        holder.courseDate.text = courses[position].date
        holder.courseLevel.text = courses[position].level
    }

    override fun getItemCount(): Int {
        return courses.count()
    }
}