package com.example.shared

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.example.shared.R

abstract class SplashBaseActivity : AppCompatActivity() {

    abstract fun getLogoRes(): Int
    abstract fun getNextActivity(): Class<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.splash_IMG_logo)
        logo.setImageResource(getLogoRes())

        animateLogo(logo)
    }

    private fun animateLogo(view: View) {
        view.scaleX = 0f
        view.scaleY = 0f
        view.alpha = 0f

        view.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(3000)
            .setInterpolator(LinearOutSlowInInterpolator())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    view.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(animation: Animator) {
                    startNext()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
    }

    private fun startNext() {
        startActivity(Intent(this, getNextActivity()))
        finish()
    }
}
