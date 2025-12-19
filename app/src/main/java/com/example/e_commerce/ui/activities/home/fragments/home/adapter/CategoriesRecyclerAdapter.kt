package com.example.e_commerce.ui.activities.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.data.models.categort.Category
import com.example.e_commerce.databinding.ItemCategoryCircularBinding

class CategoriesRecyclerAdapter(var categoriesList: List<Category?>?) :
    RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCategoryCircularBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category?) {
            binding.title.setBackgroundColor(Color.TRANSPARENT)
            binding.image.setBackgroundColor(Color.TRANSPARENT)
            binding.category = category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryCircularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = categoriesList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoriesList!![position]
        holder.bind(category)
        // set click listener
    }
}