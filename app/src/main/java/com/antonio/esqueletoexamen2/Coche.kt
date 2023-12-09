package com.antonio.esqueletoexamen2

class Coche (color:String,
             marca:String,
             var modelo:String,
             var climatizador: Boolean,
             var caballos:Double,
             var puertas:Int,
             var navegador:Boolean,
             var androidAuto:Boolean,
             var asientosCalefactables:Boolean):Vehiculo(color,marca) {

    override fun toString(): String {
        return "Coche(marca='$marca',modelo='$modelo',color='$color', climatizador=$climatizador, caballos=$caballos, puertas=$puertas, navegador=$navegador, androidAuto=$androidAuto, asientosCalefactables=$asientosCalefactables)"
    }
}