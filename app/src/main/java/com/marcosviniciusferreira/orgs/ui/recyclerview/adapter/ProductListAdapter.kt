package com.marcosviniciusferreira.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.marcosviniciusferreira.orgs.R
import com.marcosviniciusferreira.orgs.model.Product
import java.util.zip.Inflater

class ProductListAdapter(
    private val context: Context,
    products: List<Product>

) : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private val products = products.toMutableList()


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.productName)
            val description = itemView.findViewById<TextView>(R.id.productDescription)
            val price = itemView.findViewById<TextView>(R.id.productPrice)

            name.text = product.name
            description.text = product.description
            price.text = product.price.toPlainString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return MyViewHolder(view)
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
