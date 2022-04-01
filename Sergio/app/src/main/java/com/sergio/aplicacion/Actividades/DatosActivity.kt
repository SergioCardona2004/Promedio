package com.sergio.aplicacion.Actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.sergio.aplicacion.Clases.Funciones
import com.sergio.aplicacion.R

class DatosActivity : AppCompatActivity() {

    var funciones: Funciones? = null
    var nombre:TextView?=null
    var nota1:TextView?=null
    var nota2:TextView?=null
    var nota3:TextView?=null
    var nota4:TextView?=null
    var nota5:TextView?=null

    var materia1:TextView?=null
    var materia2:TextView?=null
    var materia3:TextView?=null
    var materia4:TextView?=null
    var materia5:TextView?=null

    var estado:TextView?=null
    var promedio:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        cargarComponentes()
    }

    private fun cargarComponentes() {
        funciones= Funciones()
        nombre=findViewById(R.id.txtMostrarNombre)

        materia1=findViewById(R.id.txtMostrarMateria1)
        materia2=findViewById(R.id.txtMostrarMateria2)
        materia3=findViewById(R.id.txtMostrarMateria3)
        materia4=findViewById(R.id.txtMostrarMateria4)
        materia5=findViewById(R.id.txtMostrarMateria5)

        nota1=findViewById(R.id.txtMostrarNota)
        nota2=findViewById(R.id.txtMostrarNota2)
        nota3=findViewById(R.id.txtMostrarNota3)
        nota4=findViewById(R.id.txtMostrarNota4)
        nota5=findViewById(R.id.txtMostrarNota5)

        promedio=findViewById(R.id.txtMostrarPromedio)
        estado=findViewById(R.id.txtMostrarEstado)

        mostrarDatos()

    }

    private fun mostrarDatos() {
        var bundle:Bundle? = this.intent.extras

        if (bundle !=null){
            nombre!!.text = "${bundle.getString("nombre")}"

            materia1!!.text = "${bundle.getString("materia1")}"
            materia2!!.text = "${bundle.getString("materia2")}"
            materia3!!.text = "${bundle.getString("materia3")}"
            materia4!!.text = "${bundle.getString("materia4")}"
            materia5!!.text = "${bundle.getString("materia5")}"

            nota1!!.text = "${bundle.getDouble("nota1")}"
            nota2!!.text = "${bundle.getDouble("nota2")}"
            nota3!!.text = "${bundle.getDouble("nota3")}"
            nota4!!.text = "${bundle.getDouble("nota4")}"
            nota5!!.text = "${bundle.getDouble("nota5")}"

            promedio!!.text = "${bundle.getDouble("promedio")}"
            estado!!.text = "${bundle.getString("estado")}"
        }
    }
}