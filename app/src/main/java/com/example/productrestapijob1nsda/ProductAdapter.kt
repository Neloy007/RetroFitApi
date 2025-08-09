package com.example.productrestapijob1nsda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productrestapijob1nsda.databinding.ProductListBinding

class ProductAdapter(private var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ProductListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            Glide.with(binding.root.context)
                .load(product.images[0])
                .into(binding.productImage)

            binding.nametxt.text = product.title
            binding.pricetxt.text = "$${product.price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

    fun updateProducts(newList: List<Product>) {
        products = newList
        notifyDataSetChanged()
    }
}
