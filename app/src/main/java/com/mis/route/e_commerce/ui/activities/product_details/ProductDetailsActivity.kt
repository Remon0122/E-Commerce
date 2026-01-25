package com.mis.route.e_commerce.ui.activities.product_details

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.mis.route.e_commerce.domain.model.product.Product
import com.mis.route.e_commerce.databinding.ActivityProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {
    companion object{
        const val PRODUCT_KEY = "product"
    }

    private var _binding: ActivityProductDetailsBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product =
            intent.getParcelableExtra<Product>(PRODUCT_KEY)

        binding.product = product
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}