package com.mis.route.e_commerce.data.mappers

import com.mis.route.domain.models.category.CategoryDM
import com.mis.route.e_commerce.domain.model.category.Category
import javax.inject.Inject

class CategoryMappers @Inject constructor(){

    fun fromDataModel(model: CategoryDM): Category =
        Category(
            id = model.id.orEmpty(),
            name = model.name ?: "Unknown",
            image = model.image.orEmpty()
        )

    fun fromDataModels(models: List<CategoryDM>): List<Category>{
       return models.map{
            fromDataModel(it)
        }
    }
}