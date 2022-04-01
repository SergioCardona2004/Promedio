package com.sergio.aplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sergio.aplicacion.Actividades.InformacionActivity
import com.sergio.aplicacion.Actividades.RegistroActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        var btnRegistro:Button=findViewById(R.id.btnRegistro)
        var btnInformacion:Button=findViewById(R.id.btnInformacion)
        btnRegistro.setOnClickListener{ OnClick(1) }
        btnInformacion.setOnClickListener { OnClick(2) }
    }

    private fun OnClick(button: Int) {
        when(button){
            1 -> { startActivity(Intent(this,RegistroActivity::class.java)) }
            2 -> { startActivity(Intent(this, InformacionActivity::class.java)) }
        }
    }


}