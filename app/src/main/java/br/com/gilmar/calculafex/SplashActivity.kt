package br.com.gilmar.calculafex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity : AppCompatActivity() {

    private lateinit var preferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val preferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        val isFirstOpen = preferences.getBoolean("open_first" , true)

        if(isFirstOpen){
            markAppAlReadyOpen()
            load()
        } else{
            showMan()
        }
    }

    private fun load() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash)
        animation.reset()
        ivLogo.startAnimation(animation)

            Handler().postDelayed({
                showMan()
            },3500L)
    }
    private fun markAppAlReadyOpen(){
        val editor = preferences.edit()
        editor.putBoolean("open_first", false)
        editor.apply()
    }

    private fun showMan(){
        startActivity(Intent( this,FormActivity::class.java ))
        finish()
    }
}
