package com.lizaveta16.coursesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lizaveta16.coursesapp.databinding.ActivityCoursePageBinding
import com.lizaveta16.coursesapp.model.Order

class CoursePage : AppCompatActivity() {

    lateinit var binding : ActivityCoursePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coursePageBg.setBackgroundColor(intent.getIntExtra("courseBg",0))
        binding.coursePageImg.setImageResource(intent.getIntExtra("courseImg", 0))
        binding.coursePageTitle.setText(intent.getStringExtra("courseTitle"))
        binding.coursePageDate.setText(intent.getStringExtra("courseDate"))
        binding.coursePageLevel.setText(intent.getStringExtra("courseLevel"))
        binding.coursePageDesc.setText(intent.getStringExtra("courseDesc"))

        binding.addToCart.setOnClickListener(View.OnClickListener { view ->
            var itemId : Int = intent.getIntExtra("courseId", 0)
            Order.items_id.add(itemId)
            Toast.makeText(this, "Добавлено!", Toast.LENGTH_SHORT).show()
        })
    }
}