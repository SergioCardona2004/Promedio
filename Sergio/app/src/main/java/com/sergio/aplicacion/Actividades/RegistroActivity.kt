package com.sergio.aplicacion.Actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sergio.aplicacion.Clases.Estudiante
import com.sergio.aplicacion.Clases.Funciones
import com.sergio.aplicacion.R

class RegistroActivity : AppCompatActivity() {

    var funciones:Funciones? = null
    var documento:EditText?=null
    var nombre:EditText?=null
    var edad:EditText?=null
    var direccion:EditText?=null
    var telefono:EditText?=null

    var nota1:EditText?=null
    var nota2:EditText?=null
    var nota3:EditText?=null
    var nota4:EditText?=null
    var nota5:EditText?=null

    var materia1:EditText?=null
    var materia2:EditText?=null
    var materia3:EditText?=null
    var materia4:EditText?=null
    var materia5:EditText?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        obtenerDatos()
    }

    private fun obtenerDatos() {
        funciones = Funciones()
        documento = findViewById(R.id.txtDocumento)
        nombre = findViewById(R.id.txtNombre)
        edad = findViewById(R.id.txtEdad)
        direccion = findViewById(R.id.txtDireccion)
        telefono = findViewById(R.id.txtTelefono)

        nota1 = findViewById(R.id.txtNota1)
        nota2 = findViewById(R.id.txtNota2)
        nota3 = findViewById(R.id.txtNota3)
        nota4 = findViewById(R.id.txtNota4)
        nota5=findViewById(R.id.txtNota5)

        materia1 = findViewById(R.id.txtMateria1)
        materia2 = findViewById(R.id.txtMateria2)
        materia3 = findViewById(R.id.txtMateria3)
        materia4 = findViewById(R.id.txtMateria4)
        materia5 = findViewById(R.id.txtMateria5)

        val btnGuardar: Button = findViewById(R.id.btnRegistrar)
        btnGuardar.setOnClickListener { agregarEstudiante() }
    }

    private fun agregarEstudiante() {
        var estudiante: Estudiante = Estudiante()
        if(
            nombre?.text.toString() == ""
        ){
            Toast.makeText(this,"Se solicita este campo",Toast.LENGTH_SHORT)}
        else {
            estudiante.nombre = nombre?.text.toString()
            estudiante.documento = documento?.text.toString()
            estudiante.edad = edad?.text.toString().toInt()
            estudiante.direccion = direccion?.text.toString()
            estudiante.telefono = telefono?.text.toString()

            estudiante.materia1 = materia1?.text.toString()
            estudiante.materia2 = materia2?.text.toString()
            estudiante.materia3 = materia3?.text.toString()
            estudiante.materia4 = materia4?.text.toString()
            estudiante.materia5 = materia5?.text.toString()

            estudiante.nota1 = nota1?.text.toString().toDouble()
            estudiante.nota2 = nota2?.text.toString().toDouble()
            estudiante.nota3 = nota3?.text.toString().toDouble()
            estudiante.nota4 = nota4?.text.toString().toDouble()
            estudiante.nota5 = nota5?.text.toString().toDouble()

            estudiante.promedio = funciones!!.calcularPromedio(estudiante)
            estudiante.estado = funciones!!.conocerEstado(estudiante)

            if(funciones?.AprobarNotas(estudiante)===true){
                funciones?.agregarEstudiante(estudiante)
                enviarDatos(estudiante)
            }
        }

    }

    private fun enviarDatos(estudiante: Estudiante) {
        val bundle:Bundle = Bundle()

        bundle.putString("nombre",estudiante.nombre)
        bundle.putString("materia1",estudiante.materia1)
        bundle.putString("materia2",estudiante.materia2)
        bundle.putString("materia3",estudiante.materia3)
        bundle.putString("materia4",estudiante.materia4)
        bundle.putString("materia5",estudiante.materia5)
        bundle.putDouble("nota1",estudiante.nota1)
        bundle.putDouble("nota2",estudiante.nota2)
        bundle.putDouble("nota3",estudiante.nota3)
        bundle.putDouble("nota4",estudiante.nota4)
        bundle.putDouble("nota5",estudiante.nota5)
        bundle.putString("estado", estudiante.estado)
        bundle.putDouble("promedio",estudiante.promedio)

        intent.putExtras(bundle)
        startActivity(Intent(this,DatosActivity::class.java))
    }
}