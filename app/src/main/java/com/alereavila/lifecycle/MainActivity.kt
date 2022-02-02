package com.alereavila.lifecycle

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.i("LifeCycle", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer=MediaPlayer.create(this, R.raw.ai_2)

        Log.i("LifeCycle", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        //se inicializa en la posicion guardada en onPause
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("LifeCycle", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        //se pausa la cancion
        mediaPlayer?.pause()
        //se guarda la posicion
        position=mediaPlayer!!.currentPosition
        Log.i("LifeCycle", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        //así se debe de finalizar
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer=null
        //aqui se pueden liberar recursos
        Log.i("LifeCycle", "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "OnDestroy")
    }
}