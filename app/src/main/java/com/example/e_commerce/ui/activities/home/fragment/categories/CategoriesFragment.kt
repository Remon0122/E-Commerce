package com.example.e_commerce.ui.activities.home.fragment.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce.databinding.FragmentCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CategoriesViewModel by viewModels()
    private lateinit var categoriesAdapter: CategoriesRecyclerAdapter
    private lateinit var subCategoriesAdapter: SubCategoriesAdapter

    private var selectedCategoryId: String? = null // ✅ نخزن الكاتيجوري الحالي

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategoriesRecycler()
        setupSubCategoriesRecycler()
        observeViewModel()

        // زرار Shop Now
        binding.shopNowBtn.setOnClickListener {
            selectedCategoryId?.let { id ->
                viewModel.getSubCategories(id)
            } ?: Toast.makeText(requireContext(), "اختر كاتيجوري الأول", Toast.LENGTH_SHORT).show()
        }

        // نادينا الكاتيجوريز أول ما الفراجمنت يفتح
        viewModel.getCategories()
    }

    private fun setupCategoriesRecycler() {
        categoriesAdapter = CategoriesRecyclerAdapter { category ->
            Log.d("CategoriesFragment", "Clicked Category: ${category.id}, name=${category.name}")
            binding.selectedCategoryName.text = category.name
            selectedCategoryId = category.id // ✅ نخزن الكاتيجوري الحالي
            viewModel.getSubCategories(category.id ?: "")
        }

        binding.categoriesRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = categoriesAdapter
        }
    }

    private fun setupSubCategoriesRecycler() {
        subCategoriesAdapter = SubCategoriesAdapter { subCategory ->
            Toast.makeText(
                requireContext(),
                "Clicked SubCategory: ${subCategory.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.subcategoryRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = subCategoriesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) showLoading() else hideLoading()
        }

        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            categories?.let {
                categoriesAdapter.submitList(it)

                // ✅ أول مرة: عرض أول كاتيجوري تلقائيًا
                if (it.isNotEmpty()) {
                    val firstCategory = it[0]
                    binding.selectedCategoryName.text = firstCategory.name
                    selectedCategoryId = firstCategory.id
                    viewModel.getSubCategories(firstCategory.id ?: "")
                }
            }
        }

        viewModel.subCategories.observe(viewLifecycleOwner) { subCategories ->
            subCategories?.let {
                subCategoriesAdapter.submitList(it)
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoading() {
        binding.categoriesShimmerViewContainer.startShimmer()
        binding.categoriesShimmerViewContainer.visibility = View.VISIBLE
        binding.actualView.visibility = View.GONE
    }

    private fun hideLoading() {
        binding.categoriesShimmerViewContainer.stopShimmer()
        binding.categoriesShimmerViewContainer.visibility = View.GONE
        binding.actualView.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



