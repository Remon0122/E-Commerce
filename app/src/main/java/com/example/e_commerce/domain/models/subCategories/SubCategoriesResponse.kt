import com.example.e_commerce.domain.models.subCategories.SubCategory



data class SubCategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<SubCategory?>? = null,
)