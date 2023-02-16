package com.marcosviniciusferreira.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcosviniciusferreira.orgs.dao.ProductsDAO
import com.marcosviniciusferreira.orgs.databinding.ActivityProductsListBinding
import com.marcosviniciusferreira.orgs.ui.recyclerview.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsListBinding

    private val adapter by lazy { ProductListAdapter(this, ProductsDAO().searchAll()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingRecyclerView()

        if (ProductsDAO().searchAll().isEmpty()) {
            binding.textEmptyList.visibility = View.VISIBLE
        }

    }

    override fun onResume() {
        super.onResume()
        settingFab()
        adapter.updateData(ProductsDAO().searchAll())
        if (ProductsDAO().searchAll().isNotEmpty()) {
            binding.textEmptyList.visibility = View.GONE
        }
    }


    private fun settingRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.hasFixedSize()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun settingFab() {
        binding.fab.setOnClickListener {
            startActivity(Intent(this, ProductFormActivity::class.java))
        }
    }
}