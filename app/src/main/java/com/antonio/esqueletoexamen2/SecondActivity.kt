package com.antonio.esqueletoexamen2

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


        binding.boton2.setOnClickListener {
            showAlertDialog()
        }


    }

    private fun showToast(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_SHORT).show()

    }

    private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle(getString(R.string.confirmacion_de_pedido))
        alertDialogBuilder.setMessage(getString(R.string.el_pedido_va_a_ser_procesado))
        alertDialogBuilder.setPositiveButton(getString(R.string.aceptar)) { dialog: DialogInterface, which: Int ->
            val string = getString(R.string.pedido_confirmado)

            showToast(string)
        }
        alertDialogBuilder.setNegativeButton(getString(R.string.cancelar)) { dialog: DialogInterface, which: Int ->
            showToast(getString(R.string.pedido_cancelado))
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}