package com.example.catalogandroarch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catalogandroarch.data.Product
import com.example.catalogandroarch.databinding.ActivityMainListBinding
import com.example.catalogandroarch.di.component.DaggerProductComponent
import com.example.catalogandroarch.view.ProductAdapter

class MainListActivity : AppCompatActivity(), ProductContract.ProductView {

    private lateinit var binding: ActivityMainListBinding
    private lateinit var presenter: ProductContract.ProductPresenter
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainListBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        presenter = DaggerProductComponent.builder()
            .appComponent((application as CatalogAndroArchApplication).appComponent)
            .build().productPresenter
        presenter.onAttach(this)
        presenter.getProducts()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun setProducts(list: List<Product>) {
        adapter = ProductAdapter(list)
        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
    }

    override fun setEmpty() {
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun showMessage(msg: String) {
    }
}