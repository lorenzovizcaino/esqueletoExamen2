package com.antonio.esqueletoexamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antonio.esqueletoexamen2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coche=intent.getStringExtra("Coche")
        println(coche)
        binding.resultados.text=coche.toString()


    }
}