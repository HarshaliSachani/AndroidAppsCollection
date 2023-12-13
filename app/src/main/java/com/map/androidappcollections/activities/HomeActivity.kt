package com.map.androidappcollections.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.map.androidappcollections.databinding.ActivityHomeBinding
import com.map.androidappcollections.extensions.startActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRecyclerViewWithAds.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnRecyclerViewWithAds -> startActivity<RecyclerViewWithAdsActivity>()
        }
    }
}