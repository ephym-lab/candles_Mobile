package com.example.candles.data

data class Product(
    val id: Int,
    val name: String,
    val priceKES: Double,
    val rating: Float,
    val imagePlaceholder: Int, // Resource ID or simple identifier
    val description: String,
    val category: String
)

object MockData {
    val products = listOf(
        Product(
            id = 1,
            name = "Midnight Jasmine",
            priceKES = 2500.0,
            rating = 4.8f,
            imagePlaceholder = 1,
            description = "A soothing blend of night-blooming jasmine and sandalwood. Perfect for evening relaxation.",
            category = "Floral"
        ),
        Product(
            id = 2,
            name = "Ocean Breeze",
            priceKES = 2200.0,
            rating = 4.5f,
            imagePlaceholder = 2,
            description = "Fresh sea salt and citrus notes that bring the ocean into your living room.",
            category = "Fresh"
        ),
        Product(
            id = 3,
            name = "Vanilla Bean",
            priceKES = 1800.0,
            rating = 4.9f,
            imagePlaceholder = 3,
            description = "Rich and creamy vanilla with a hint of warm sugar. A classic favorite.",
            category = "Sweet"
        ),
        Product(
            id = 4,
            name = "Sandalwood & Myrrh",
            priceKES = 3000.0,
            rating = 4.7f,
            imagePlaceholder = 4,
            description = "Earthy and mysterious, this candle brings a touch of luxury to any space.",
            category = "Woody"
        ),
        Product(
            id = 5,
            name = "Lavender Fields",
            priceKES = 2400.0,
            rating = 4.6f,
            imagePlaceholder = 5,
            description = "Pure lavender essential oil for a calming and restorative atmosphere.",
            category = "Floral"
        ),
        Product(
            id = 6,
            name = "Cedarwood Pine",
            priceKES = 2600.0,
            rating = 4.4f,
            imagePlaceholder = 6,
            description = "The scent of a crisp morning walk through a pine forest.",
            category = "Woody"
        )
    )
}
