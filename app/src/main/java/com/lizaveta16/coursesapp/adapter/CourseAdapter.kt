package com.lizaveta16.coursesapp.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.util.Pair
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.CoursePage
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

        holder.itemView.setOnClickListener(View.OnClickListener{ view ->
            var intent = Intent(context, CoursePage::class.java)

            var options = ActivityOptions.makeSceneTransitionAnimation(context as Activity,
                                                                        Pair<View, String>(holder.courseImg,"courseImg"))
            intent.putExtra("courseBg", Color.parseColor(courses[position].color))
            intent.putExtra("courseImg", context.resources.getIdentifier("ic_" + courses[position].img, "drawable", context.packageName))
            intent.putExtra("courseTitle", courses[position].title)
            intent.putExtra("courseDate", courses[position].date)
            intent.putExtra("courseLevel", courses[position].level)
            intent.putExtra("courseDesc", courses[position].description)
            context.startActivity(intent, options.toBundle())
        })
    }

    override fun getItemCount(): Int {
        return courses.count()
    }
}