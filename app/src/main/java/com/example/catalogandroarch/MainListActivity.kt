package com.example.catalogandroarch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catalogandroarch.data.Product
import com.example.catalogandroarch.databinding.ActivityMainListBinding
import com.example.catalogandroarch.di.component.DaggerProductComponent
import com.example.catalogandroarch.view.ProductAdapter
import kotlinx.coroutines.launch

class MainListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainListBinding
    private lateinit var adapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels {
        viewModelFactory {
            initializer {
                DaggerProductComponent.builder()
                    .appComponent((application as CatalogAndroArchApplication).appComponent)
                    .build()
                    .productViewModel
            }
        }
    }

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
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    setProducts(state)
                }
            }
        }
    }

    private fun setProducts(state: ProductUiState) {
        when(state) {
            is ProductUiState.Success -> {
                adapter = ProductAdapter(state.products)
                binding.rvProducts.adapter = adapter
                binding.rvProducts.layoutManager = LinearLayoutManager(this)
            }
            is ProductUiState.Loading -> {

            }
            is ProductUiState.Error -> {

            }
        }
    }
}