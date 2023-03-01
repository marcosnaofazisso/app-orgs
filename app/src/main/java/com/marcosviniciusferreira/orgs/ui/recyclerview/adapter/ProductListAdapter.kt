package com.marcosviniciusferreira.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.marcosviniciusferreira.orgs.R
import com.marcosviniciusferreira.orgs.databinding.ProductItemBinding
import com.marcosviniciusferreira.orgs.model.Product
import java.text.NumberFormat
import java.util.*
import java.util.zip.Inflater

class ProductListAdapter(
    private val context: Context,
    products: List<Product>

) : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private val products = products.toMutableList()


    class MyViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.productName)
            val description = itemView.findViewById<TextView>(R.id.productDescription)
            val price = itemView.findViewById<TextView>(R.id.productPrice)

            name.text = product.name
            description.text = product.description

            val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val currencyPriceValue: String = formatter.format(product.price)
            price.text = currencyPriceValue

            if (product.image != null) {
                binding.imageProductItem.load(product.image)
            } else {
                binding.imageProductItem.load(R.drawable.imagem_padrao)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun updateData(updatedProducts: List<Product>) {
        this.products.clear()
        this.products.addAll(updatedProducts)
        notifyDataSetChanged()
    }
}
