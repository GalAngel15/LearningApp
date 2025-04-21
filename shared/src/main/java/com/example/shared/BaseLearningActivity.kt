package com.example.shared

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseLearningActivity : AppCompatActivity() {

    // פעולה כללית להצגת טוסט
    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // פעולה כללית ללוג
    protected fun logScreen(name: String) {
        println("Screen started: $name")
    }

    // פעולה אבסטרקטית שכל יורש חייב לממש
    abstract fun loadData()
}
