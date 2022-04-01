package com.sergio.aplicacion.Clases

class Funciones {

    companion object {
        var Estudiante= arrayListOf<Estudiante>()
    }

    fun agregarEstudiante(estudiante: Estudiante){
        Estudiante.add(estudiante)
    }

    fun mostrarCantidadEstudiantes():Int{
        return Estudiante.count()
    }

    fun validarNotas(calificacion:Double):Boolean {
        return calificacion in 0.0 .. 5.0
    }

    fun calcularPromedio(estudiante: Estudiante):Double{
        var promedio = (estudiante.nota1+estudiante.nota2+estudiante.nota3+estudiante.nota4+estudiante.nota5)/5
        return  promedio
    }

    fun AprobarNotas(estudiante: Estudiante):Boolean {
        return (validarNotas(estudiante.nota1)===true && validarNotas(estudiante.nota2)===true && validarNotas(estudiante.nota3)===true &&
                validarNotas(estudiante.nota4)===true && validarNotas(estudiante.nota5)===true)
    }

    fun conocerEstado(estudiante: Estudiante):String {
        var estado=""
        if (estudiante.promedio > 3.5){
            estado = "gana"
        } else if (estudiante.promedio > 2.5){
            estado="recupera"
        } else{
            estado = "pierde"
        }
        return estado
    }

    fun mostrarCantidadEstados(estado:String):Int {
        var contador:Int = 0
        for (i in Estudiante){
            if (i.estado == estado){
                contador ++
            }
        }
        return contador
    }
}