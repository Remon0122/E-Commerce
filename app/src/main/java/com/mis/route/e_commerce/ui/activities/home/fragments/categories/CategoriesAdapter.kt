package com.mis.route.e_commerce.ui.activities.home.fragments.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.ItemCategoryRectangularBinding
import com.mis.route.e_commerce.domain.model.category.Category

class CategoriesAdapter(
    private var data: List<Category> = emptyList(),
    private val onCategoryClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private var selectedIndex = RecyclerView.NO_POSITION

    fun setCategories(categories: List<Category>) {
        data = categories
        selectedIndex = if (categories.isNotEmpty()) 0 else RecyclerView.NO_POSITION
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding: ItemCategoryRectangularBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category_rectangular,
                parent,
                false
            )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = data[position]

        holder.bind(category)

        holder.binding.isSelected = position == selectedIndex

        holder.binding.root.setOnClickListener {
            val previousIndex = selectedIndex
            selectedIndex = position

            if (previousIndex != RecyclerView.NO_POSITION) {
                notifyItemChanged(previousIndex)
            }
            notifyItemChanged(selectedIndex)

            onCategoryClick(category)
        }
    }


    override fun getItemCount(): Int = data.size

    class CategoryViewHolder(
        val binding: ItemCategoryRectangularBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }
    }

}

