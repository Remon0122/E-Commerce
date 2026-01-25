package com.mis.route.e_commerce.ui.activities.home.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mis.route.e_commerce.databinding.FragmentCategoriesBinding
import com.mis.route.e_commerce.domain.model.category.Category
import com.mis.route.e_commerce.ui.base.BaseFragment
import com.mis.route.e_commerce.ui.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {

    companion object{
        const val CATEGORY_KEY = "Category"
    }

    private val categoryViewModel by viewModels<CategoryViewModel>()

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var subCategoriesAdapter: SubCategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel.loadCategories()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategoriesBinding {
        return FragmentCategoriesBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCategoryRecyclerView()
        initSubCategoriesRecyclerView()
        observeCategories()
        observeSubCategories()
    }

    // ================== RecyclerViews ==================

    private fun initCategoryRecyclerView() {
        categoriesAdapter = CategoriesAdapter { category ->
            categoryViewModel.loadSubCategoryApi(category.id)
        }
        binding.categoriesRv.adapter = categoriesAdapter
    }

    private fun initSubCategoriesRecyclerView() {
        subCategoriesAdapter = SubCategoriesAdapter()
        binding.subcategoryRv.adapter = subCategoriesAdapter
    }

    // ================== Observers ==================

    private fun observeCategories() {
        categoryViewModel.categoryApi.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.LoadingState -> {
                    binding.categoriesShimmerViewContainer.startShimmer()
                }

                is Resource.SuccessState -> {
                    binding.categoriesShimmerViewContainer.stopShimmer()
                    binding.categoriesShimmerViewContainer.visibility = View.GONE

                    it.data?.let { categories ->
                        categoriesAdapter.setCategories(categories)

                        // Load first sub category by default
                        if (categories.isNotEmpty()) {
                            categoryViewModel.loadSubCategoryApi(categories[0].id)
                        }
                    }
                }

                is Resource.ErrorState -> {
                    handleError(it.errorMassage)
                }

                else -> {}
            }
        }
    }

    private fun observeSubCategories() {
        categoryViewModel.SubCategoryApi.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.LoadingState -> {
                    // show subcategory loading if needed
                }

                is Resource.SuccessState -> {
                    it.data?.let { subCategories ->
                        subCategoriesAdapter.setSubCategories(subCategories)
                    }
                }

                is Resource.ErrorState -> {
                    handleError(it.errorMassage)
                }

                else -> {}
            }
        }
    }
}


