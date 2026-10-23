package com.example.catalogandroarch.view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.catalogandroarch.R
import com.example.catalogandroarch.data.Product
import com.example.catalogandroarch.databinding.ItemProductBinding

/**
 * @author Munif
 * @since 21/10/26.
 */
class ProductViewHolder(private var binding: ItemProductBinding) : ViewHolder(binding.root) {

    fun onBind(product: Product) {
        with(binding) {
            tvTitle.text = product.title
            tvDescription.text = product.description
            tvPrice.text = itemView.context.getString(R.string.price_format, product.price)
        }
    }
}