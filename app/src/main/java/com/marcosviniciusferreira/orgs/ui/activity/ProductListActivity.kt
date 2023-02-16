package com.marcosviniciusferreira.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcosviniciusferreira.orgs.dao.ProductsDAO
import com.marcosviniciusferreira.orgs.databinding.ActivityMainBinding
import com.marcosviniciusferreira.orgs.ui.recyclerview.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { ProductListAdapter(this, ProductsDAO().searchAll()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingRecyclerView()

    }


    override fun onResume() {
        super.onResume()
        settingFab()
        adapter.updateData(ProductsDAO().searchAll())
    }


    private fun settingRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.hasFixedSize()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun settingFab() {
        binding.fab.setOnClickListener { view ->
            startActivity(Intent(this, ProductFormActivity::class.java))
        }
    }
}