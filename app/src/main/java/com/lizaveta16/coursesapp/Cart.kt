package com.lizaveta16.coursesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.lizaveta16.coursesapp.databinding.ActivityCartBinding
import com.lizaveta16.coursesapp.model.Order

class Cart : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var coursesTitles = mutableListOf<String>()
        for (item in MainActivity.fullCoursesList){
            if(Order.itemsInCart.contains(item.id)){
                coursesTitles.add(item.title)
            }
        }
        binding.ordersList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,coursesTitles)
    }
}