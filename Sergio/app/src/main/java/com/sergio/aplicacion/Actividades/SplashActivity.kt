package com.sergio.aplicacion.Actividades

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergio.aplicacion.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    }
}