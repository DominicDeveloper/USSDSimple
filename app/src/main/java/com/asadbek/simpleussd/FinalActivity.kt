package com.asadbek.simpleussd

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asadbek.simpleussd.databinding.ActivityFinalBinding
import com.asadbek.simpleussd.models.MyObject

class FinalActivity : AppCompatActivity() {
    lateinit var binding: ActivityFinalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getSerializableExtra("key") as MyObject

        binding.txtName.text = data.name
        binding.txtCode.text = data.code
        binding.txtAbout.text = data.about

    }
}