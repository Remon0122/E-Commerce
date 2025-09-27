package com.example.e_commerce.ui.activities.home.fragment.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.domain.UseCases.CategoriesUseCase
import com.example.e_commerce.domain.UseCases.GetSubCategoriesUseCase
import com.example.e_commerce.domain.models.SubCategory.SubCategoryDomain
import com.example.e_commerce.domain.models.categories.Category
import com.example.e_commerce.domain.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    private val subCategoriesUseCase: GetSubCategoriesUseCase
) : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    private val _subCategories = MutableLiveData<List<SubCategoryDomain>>()
    val subCategories: LiveData<List<SubCategoryDomain>> get() = _subCategories

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun getCategories() {
        _loading.value = true
        viewModelScope.launch {
            when (val result = categoriesUseCase()) {
                is ApiResult.SuccessApiResult<*> -> {
                    _categories.value = result.data as? List<Category> ?: emptyList()
                }
                is ApiResult.ErrorApiResult<*> -> {
                    _error.value = result.error ?: "Unknown Error"
                }
            }
            _loading.value = false
        }
    }

    fun getSubCategories(categoryId: String) {
        _loading.value = true
        viewModelScope.launch {
            when (val result = subCategoriesUseCase(categoryId)) {
                is ApiResult.SuccessApiResult<*> -> {
                    _subCategories.value = result.data as? List<SubCategoryDomain> ?: emptyList()
                }
                is ApiResult.ErrorApiResult<*> -> {
                    _error.value = result.error ?: "Unknown Error"
                }
            }
            _loading.value = false
        }
    }
}
