package com.sergio.aplicacion.Actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sergio.aplicacion.Clases.Funciones
import com.sergio.aplicacion.R

class InformacionActivity : AppCompatActivity() {
    var totalStudent: TextView? = null;
    var totalWinners: TextView? = null;
    var totalLosers: TextView? = null;
    var totalInRecovery: TextView? = null;
    var funciones: Funciones? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        showStats();
    }

    private fun showStats() {
        funciones = Funciones();
        totalStudent = findViewById(R.id.txtTotal);
        totalLosers = findViewById(R.id.txtLoser);
        totalInRecovery = findViewById(R.id.txtRecovery);
        totalWinners = findViewById(R.id.txtWiner);

        processData();
    }

    private fun processData() {
        totalStudent!!.text = funciones!!.mostrarCantidadEstudiantes().toString();
        totalWinners!!.text = funciones!!.mostrarCantidadEstados("gana").toString();
        totalInRecovery!!.text = funciones!!.mostrarCantidadEstados("recupera").toString();
        totalLosers!!.text = funciones!!.mostrarCantidadEstados("pierde").toString();

    }
}