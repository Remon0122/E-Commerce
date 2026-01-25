package com.mis.route.e_commerce.ui.activities.home.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.mis.route.domain.models.offer.Offer
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.FragmentHomeBinding
import com.mis.route.e_commerce.ui.activities.home.fragments.categories.CategoriesFragment
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.CategoriesRecyclerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.OfferViewPagerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.ProductsRecyclerAdapter
import com.mis.route.e_commerce.ui.activities.product_details.ProductDetailsActivity
import com.mis.route.e_commerce.ui.base.BaseFragment
import com.mis.route.e_commerce.ui.utils.Resource
import com.mis.route.e_commerce.ui.utils.UIConstants.whenViewIsShown
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeVM by viewModels<HomeViewModel>()
    private val categoriesAdapter = CategoriesRecyclerAdapter(null)
    private val productsAdapter = ProductsRecyclerAdapter(null){
        val intent = Intent(requireContext(), ProductDetailsActivity::class.java)
        intent.putExtra(ProductDetailsActivity.PRODUCT_KEY,it)
        startActivity(intent)
    }
    private val offersAdapter = OfferViewPagerAdapter(null)
    private var isProductsAlreadyVisible = false

    override fun getViewBinding(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeVM.loadCategories()
        homeVM.loadProductApi()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOffersViewPager()
        initCategoriesRecyclerView()
        initProductsRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        homeVM.categoryApi.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.LoadingState -> {
                    binding.categoriesRecyclerViewShimmer.visibility = View.VISIBLE
                    binding.categoriesRecyclerViewShimmer.startShimmer()
                }
                is Resource.SuccessState -> {
                    binding.categoriesRecyclerViewShimmer.stopShimmer()
                    binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
                    categoriesAdapter.categoriesList = it.data
                    categoriesAdapter.notifyDataSetChanged()
                }
                is Resource.ErrorState -> {
                    binding.categoriesRecyclerViewShimmer.stopShimmer()
                    binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
                    handleError(it.errorMassage) { homeVM.loadCategories() }
                }
                else -> Unit
            }
        }

        homeVM.productApi.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.LoadingState -> {
                    binding.lapsAccessoriesRecyclerViewShimmer.visibility = View.VISIBLE
                    binding.lapsAccessoriesRecyclerViewShimmer.startShimmer()
                }
                is Resource.SuccessState -> {
                    binding.lapsAccessoriesRecyclerViewShimmer.stopShimmer()
                    binding.lapsAccessoriesRecyclerViewShimmer.visibility = View.INVISIBLE
                    productsAdapter.productsList = resource.data
                    productsAdapter.notifyDataSetChanged()
                }
                is Resource.ErrorState -> {
                    binding.lapsAccessoriesRecyclerViewShimmer.stopShimmer()
                    binding.lapsAccessoriesRecyclerViewShimmer.visibility = View.INVISIBLE
                    handleError(resource.errorMassage) { homeVM.loadProductApi() }
                }
                else -> Unit
            }
        }
    }

    private fun initCategoriesRecyclerView() {
        binding.categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun initProductsRecyclerView() {
        binding.lapsAccessoriesRecyclerView.adapter = productsAdapter
        binding.root.whenViewIsShown(binding.lapsAccessoriesRecyclerViewShimmer, ::startLoadingProducts)
    }

    private fun initOffersViewPager() {
        binding.offersViewPager.adapter = offersAdapter
        TabLayoutMediator(binding.tabLayout, binding.offersViewPager) { _, _ -> }.attach()
        bindOffers(DummyDataProvider.getOffers())
    }

    private fun bindOffers(offersList: List<Offer>?) {
        if (offersList.isNullOrEmpty()) return
        offersAdapter.offersList = offersList
        offersAdapter.notifyDataSetChanged()
    }

    private fun startLoadingProducts() {
        if (isProductsAlreadyVisible) return
        isProductsAlreadyVisible = true
    }
}

object DummyDataProvider {
    fun getOffers(): List<Offer> = listOf(
        Offer(1, 25, R.drawable.image_headset, "1", "For all Headphones \n& AirPods"),
        Offer(2, 30, R.drawable.image_beauty_products, "2", "For all Makeup\n& Skincare"),
        Offer(3, 20, R.drawable.image_laptop, "3", "For Laptops\n& Mobiles")
    )
}

