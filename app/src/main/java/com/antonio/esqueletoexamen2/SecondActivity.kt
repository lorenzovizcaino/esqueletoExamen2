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

        val coche=intent?.getSerializableExtra("Coche") as? Coche

        val clima:String
        val navi:String
        val androAuto:String
        val asiCalefac:String
        println(coche.toString())



        if (coche != null) {
            println("HOLA")
            if(coche.climatizador) clima=getString(R.string.climatizadorSI)
            else clima=getString(R.string.climatizadorNO)

            if(coche.navegador) navi=getString(R.string.navegadorSI)
            else navi=getString(R.string.navegadorNO)

            if(coche.androidAuto) androAuto=getString(R.string.androidAutoSI)
            else androAuto=getString(R.string.androidAutoNO)

            if(coche.asientosCalefactables) asiCalefac=getString(R.string.asientoCalefactableSI)
            else asiCalefac=getString(R.string.asientoCalefactableNO)


            val cadena=getString(R.string.cocheselecionado)+"\n"+
                    getString(R.string.marca)+coche.marca+"\n"+
                    getString(R.string.modelo)+coche.modelo+"\n"+
                    getString(R.string.color)+coche.color+"\n"+
                    getString(R.string.caballos)+coche.caballos+"\n"+
                    getString(R.string.marca)+coche.marca+"\n"+
                    getString(R.string.climatizador)+clima+"\n"+
                    getString(R.string.navegador)+navi+"\n"+
                    getString(R.string.androidAuto)+androAuto+"\n"+
                    getString(R.string.asientoCalefactable)+asiCalefac+"\n"
            println(cadena)

            binding.resultados.text=cadena
        }


    }
}