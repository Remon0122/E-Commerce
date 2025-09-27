import com.example.e_commerce.data.api.model.subCategories.SubCategory



data class SubCategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<SubCategory?>? = null,
)