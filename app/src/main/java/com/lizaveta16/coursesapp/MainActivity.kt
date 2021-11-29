package com.lizaveta16.coursesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lizaveta16.coursesapp.adapter.CategoryAdapter
import com.lizaveta16.coursesapp.databinding.ActivityMainBinding
import com.lizaveta16.coursesapp.model.Category

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
    }

    private fun setCategoryRecycler(categoryList: MutableList<Category>) {
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.categoryRecycler.layoutManager = layoutManager

        val categoryAdapter : CategoryAdapter = CategoryAdapter(this, categoryList)
        binding.categoryRecycler.adapter = categoryAdapter
    }
}