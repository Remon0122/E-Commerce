package com.example.e_commerce.ui.activities.main.fragments.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce.databinding.ItemCategoryCircularBinding
import com.example.e_commerce.domain.model.category.Category

class CategoriesRecyclerAdapter(val onItemClick : (Category) -> Unit )
    : ListAdapter<Category , CategoriesRecyclerAdapter.CategoryViewHolder>(CategoryCallBack()){

    inner class CategoryViewHolder(val binding : ItemCategoryCircularBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category){
            binding.title.text = category.name
            Glide.with(binding.root.context)
                .load("https://ecommerce.routemisr.com${category.image}")
                .into(binding.image)
            binding.root.setOnClickListener {
                onItemClick(category)
            }
              }
            }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemCategoryCircularBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
    class CategoryCallBack : DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
    }
}


