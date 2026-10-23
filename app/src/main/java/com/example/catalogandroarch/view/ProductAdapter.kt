package com.example.catalogandroarch.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.catalogandroarch.data.Product
import com.example.catalogandroarch.databinding.ItemProductBinding

/**
 * @author Munif
 * @since 21/10/26.
 */
class ProductAdapter(private val products: List<Product>) : Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        return ProductViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        holder.onBind(products[position])
    }

    override fun getItemCount(): Int = products.size
}