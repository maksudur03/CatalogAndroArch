package com.example.catalogandroarch.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Munif
 * @since 19/10/26.
 */

@Serializable
data class Products(
    @SerialName("products") val data: List<Product>? = null
)
