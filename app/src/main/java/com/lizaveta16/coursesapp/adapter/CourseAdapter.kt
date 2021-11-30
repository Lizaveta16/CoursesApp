package com.lizaveta16.coursesapp.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.CoursePage
import com.lizaveta16.coursesapp.R
import com.lizaveta16.coursesapp.databinding.CourseItemBinding
import com.lizaveta16.coursesapp.model.Course

class CourseAdapter(private var context: Context, private var courses : List<Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>(){

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = CourseItemBinding.bind(itemView)

        fun bind(course: Course, ctx: Context) = with(binding) {
            courseBg.setCardBackgroundColor(Color.parseColor(course.color))
            val imgId : Int = ctx.resources.getIdentifier("ic_" + course.img, "drawable", ctx.packageName)
            courseImg.setImageResource(imgId)
            courseTitle.text = course.title
            courseDate.text = course.date
            courseLevel.text = course.level
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val courseItemView : View = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false)
        return CourseAdapter.CourseViewHolder(courseItemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {

        holder.bind(courses[position], context)

        holder.itemView.setOnClickListener(View.OnClickListener{ view ->
            val intent = Intent(context, CoursePage::class.java)

            val options = ActivityOptions.makeSceneTransitionAnimation(context as Activity,
                                                                        Pair<View, String>(holder.binding.courseImg,"courseImg"))
            intent.apply {
                putExtra("courseBg", Color.parseColor(courses[position].color))
                putExtra("courseImg", context.resources.getIdentifier("ic_" + courses[position].img, "drawable", context.packageName))
                putExtra("courseTitle", courses[position].title)
                putExtra("courseDate", courses[position].date)
                putExtra("courseLevel", courses[position].level)
                putExtra("courseDesc", courses[position].description)
                putExtra("courseId", courses[position].id)
            }
            context.startActivity(intent, options.toBundle())
        })
    }

    override fun getItemCount(): Int {
        return courses.count()
    }
}