package com.example.feature.deliveries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature.deliveries.databinding.ActivityDeliveryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeliveryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeliveryBinding

    private val viewModel: DeliveriesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.deliveries.observe(this) {
            println(it)
        }
        viewModel.fetchDeliveries()
    }
}