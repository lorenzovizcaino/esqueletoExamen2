package com.antonio.esqueletoexamen2

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.antonio.esqueletoexamen2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        var marca:String=""
        var modelo:String
        var color:String
        var caballos:Double
        var puertas:Int
        var climatizador:Boolean
        var navegador:Boolean
        var androidAuto:Boolean
        var asientosCalefactables:Boolean

        binding.radiogroup.setOnCheckedChangeListener  { _,clave ->

            when (clave){
                R.id.rb1 -> showToast(getString(R.string.climatizadorSI))
                R.id.rb2 -> showToast(getString(R.string.climatizadorNO))

            }
        }

        //Inicio del Spinner de la marca
        val marcaSpinner: Spinner=binding.marca
        val marcas= arrayOf("Renault", "Seat","Mazda")

        // Crear un ArrayAdapter de strings
        val adapterMarcas = ArrayAdapter(this, android.R.layout.simple_spinner_item,marcas)

        // Especificar el diseño a utilizar cuando aparece la lista de opciones
        adapterMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        marcaSpinner.adapter = adapterMarcas

        // Manejar eventos de selección del Spinner

        marcaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Manejar la selección de la marca
                marca = parentView.getItemAtPosition(position).toString()
                showToast("Marca seleccionada: $marca")
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                marca="No selecionada"
            }
        }
        //Fin del spinner de marcas

        binding.modelo.onFocusChangeListener  = View.OnFocusChangeListener { view, tieneFoco ->
            if (!tieneFoco) {
                // El EditText ha perdido el foco
                val textoModelo =  binding.modelo.text.toString()
                showToast("Modelo Selecionado $textoModelo")
            }
        }

        binding.caballos.onFocusChangeListener  = View.OnFocusChangeListener { view, tieneFoco ->
            if (!tieneFoco) {
                // El EditText ha perdido el foco
                val textoCaballos =  binding.caballos.text.toString()
                showToast("Caballos Selecionados $textoCaballos")
            }
        }

        binding.puertas.onFocusChangeListener  = View.OnFocusChangeListener { view, tieneFoco ->
            if (!tieneFoco) {
                // El EditText ha perdido el foco
                val textoPuertas =  binding.puertas.text.toString()
                showToast("Caballos Selecionados $textoPuertas")
            }
        }

        //eventos de checkbox
        binding.chB1.setOnClickListener{
            DiferenciarCheckbox(binding.chB1)
        }
        binding.chB2.setOnClickListener{
            DiferenciarCheckbox(binding.chB2)
        }
        binding.chB3.setOnClickListener{
            DiferenciarCheckbox(binding.chB3)
        }


        //evento de boton
        binding.boton1.setOnClickListener {

            modelo=binding.modelo.text.toString()
            color="Rojo"
            caballos=binding.caballos.text.toString().toDouble()
            puertas=binding.puertas.text.toString().toInt()
            climatizador = binding.rb1.isChecked

            navegador = binding.chB1.isChecked
            androidAuto = binding.chB2.isChecked
            asientosCalefactables = binding.chB3.isChecked
            var coche:Coche= Coche(color,marca,modelo,climatizador,caballos,puertas,navegador,androidAuto,asientosCalefactables)


            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("Coche",coche)
            startActivity(intent)
        }





    }

    private fun showToast(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_SHORT).show()

    }
    private fun DiferenciarCheckbox(checkBox: CheckBox){
        val estaChequeado=checkBox.isChecked
        val checkBoxText=checkBox.text
        if(estaChequeado){
            showToast("$checkBoxText "+getString(R.string.selecionado))
        }else{
            showToast("$checkBoxText "+getString(R.string.deselecionado))
        }
    }


}