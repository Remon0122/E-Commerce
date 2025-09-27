package com.example.e_commerce.ui.activities.home.fragment.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.data.api.model.product.Product
import com.example.e_commerce.databinding.ItemProductBinding

class ProductsRecyclerAdapter(
    private val onProductClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder>() {

    var productsList: List<Product> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = productsList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productsList[position]
        holder.binding.product = product

        holder.binding.root.setOnClickListener {
            onProductClick(product)
        }
    }
}