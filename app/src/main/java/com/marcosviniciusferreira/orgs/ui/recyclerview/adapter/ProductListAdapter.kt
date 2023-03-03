package com.marcosviniciusferreira.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marcosviniciusferreira.orgs.R
import com.marcosviniciusferreira.orgs.databinding.ProductItemBinding
import com.marcosviniciusferreira.orgs.model.Product
import java.text.NumberFormat
import java.util.*

class ProductListAdapter(
    private val context: Context,
    products: List<Product>,
    var itemClickListener: (product: Product) -> Unit = {}

) : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private val products = products.toMutableList()

    inner class MyViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var product: Product

        init {
            itemView.setOnClickListener {
                if (::product.isInitialized) {
                    itemClickListener(product)
                }
            }
        }


        fun bind(product: Product) {
            this.product = product
            val name = itemView.findViewById<TextView>(R.id.productName)
            val description = itemView.findViewById<TextView>(R.id.productDescription)
            val price = itemView.findViewById<TextView>(R.id.productPrice)

            name.text = product.name
            description.text = product.description

            val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val currencyPriceValue: String = formatter.format(product.price)
            price.text = currencyPriceValue

            binding.imageProductItem.load(product.image) {
                fallback(R.drawable.imagem_padrao)
                error(R.drawable.product_image_not_found)
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
