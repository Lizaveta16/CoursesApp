package com.lizaveta16.coursesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.adapter.CategoryAdapter
import com.lizaveta16.coursesapp.adapter.CourseAdapter
import com.lizaveta16.coursesapp.databinding.ActivityMainBinding
import com.lizaveta16.coursesapp.model.Category
import com.lizaveta16.coursesapp.model.Course

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var categoryList = mutableListOf<Category>()
        categoryList.add(Category(1, "Игры"))
        categoryList.add(Category(2, "Сайты"))
        categoryList.add(Category(3, "Языки"))
        categoryList.add(Category(4, "Прочее"))

        setCategoryRecycler(categoryList)


        var courseList = mutableListOf<Course>()
        courseList.add(Course(1, "java", "Профессия Java\n разработчик", "1 января", "начальный", "#424345", "Test"))
        courseList.add(Course(2, "python", "Профессия Python\n разработчик", "10 января", "начальный", "#9FA52D", "Test"))
        courseList.add(Course(3, "unity", "Разработка на \n Unity", "1 декабря", "начальный", "#690058", "Test"))
        courseList.add(Course(4, "frontend", "Профессия Frontend\n разработчик", "15 декабря", "начальный", "#C5371D", "Test"))
        courseList.add(Course(5, "backend", "Профессия Backend\n разработчик", "3 февраля", "начальный", "#201CEE", "Test"))
        courseList.add(Course(6, "fullstack", "Профессия Fullstack\n разработчик", "10 января", "начальный", "#FFC107", "Test"))
        setCourseRecycler(courseList)
    }

    private fun setCourseRecycler(courseList: MutableList<Course>) {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.courseRecycler.layoutManager = layoutManager

        val courseAdapter = CourseAdapter(this, courseList)
        binding.courseRecycler.adapter = courseAdapter
    }

    private fun setCategoryRecycler(categoryList: MutableList<Category>) {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.categoryRecycler.layoutManager = layoutManager

        val categoryAdapter = CategoryAdapter(this, categoryList)
        binding.categoryRecycler.adapter = categoryAdapter
    }
}