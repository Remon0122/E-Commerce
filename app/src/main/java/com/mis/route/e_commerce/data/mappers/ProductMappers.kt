package com.mis.route.e_commerce.data.mappers

import com.mis.route.domain.models.category.CategoryDM
import com.mis.route.domain.models.product.ProductDM
import com.mis.route.e_commerce.domain.model.product.Product
import javax.inject.Inject

class ProductMappers @Inject constructor(
    private val categoryMappers: CategoryMappers
) {

    fun fromDataModel(dm: ProductDM): Product {
        return Product(
            id = dm.id.orEmpty(),
            title = dm.title.orEmpty(),
            description = dm.description.orEmpty(),
            imageCover = dm.imageCover.orEmpty(),
            images = dm.images
                ?.mapNotNull { it }
                ?: emptyList(),
            price = dm.price?.toDouble() ?: 0.0,
            priceAfterDiscount = dm.priceAfterDiscount,
            ratingsAverage = dm.ratingsAverage ?: 0.0,
            ratingsQuantity = dm.ratingsQuantity ?: 0,
            quantity = dm.quantity ?: 0,
            availableColors = dm.availableColors
                ?.mapNotNull { it?.toString() }
                ?: emptyList(),
            category = categoryMappers.fromDataModel(
                dm.category ?: CategoryDM()
            )
        )
    }

    fun fromDataModels(models: List<ProductDM>): List<Product> =
        models.map { fromDataModel(it) }
}
