package com.example.learningapp

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.learningapp.databinding.ActivityMainBinding
import com.example.shared.BaseLearningActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class StudentMainActivity : BaseLearningActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupListeners()
        loadQuestions()

        showToast("ברוך הבא תלמיד")
        logScreen("StudentMainActivity")
    }

    private fun setupUI() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "תלמיד"
    }

    private fun setupListeners() {
        binding.btnSendAnswer.setOnClickListener {
            val input = binding.edtAnswer.editText?.text?.toString()
            val amount = input?.toIntOrNull() ?: 0
            binding.btnSendAnswer.visibility = View.INVISIBLE

            if (amount > 0) {
                onSuccess()
            } else {
                onError()
            }
        }
    }

    private fun loadQuestions() {
        addQuestion("כמה זה 3 + 4?")
        addQuestion("חשוב: מה תוצאת 10 * 5?")
    }

    private fun addQuestion(questionText: String) {
        val questionLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 16, 32, 16)
        }

        val questionView = TextView(this).apply {
            text = questionText
            textSize = 18f
        }

        val answerInput = TextInputLayout(this).apply {
            hint = "התשובה שלך"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            addView(TextInputEditText(this@StudentMainActivity).apply {
                id = View.generateViewId()
            })
        }

        val submitBtn = MaterialButton(this).apply {
            text = "הגש"
            setOnClickListener {
                val answer = (answerInput.editText?.text ?: "").toString()
                if (answer.isNotBlank()) {
                    this.text = "נשלח בהצלחה ✅"
                    isEnabled = false
                } else {
                    showToast("הזן תשובה לפני הגשה")
                }
            }
        }

        questionLayout.addView(questionView)
        questionLayout.addView(answerInput)
        questionLayout.addView(submitBtn)

        binding.questionsContainer.addView(questionLayout)
    }

    private fun onSuccess() {
        binding.anmCheck.apply {
            visibility = View.VISIBLE
            playAnimation()
        }
        binding.btnSendAnswer.visibility = View.VISIBLE
        binding.lblBanner.text = "ההגשה נקלטה בהצלחה"
    }

    private fun onError() {
        binding.lblBanner.text = "אנא הזן ערך תקין"
        binding.btnSendAnswer.visibility = View.VISIBLE
    }

    override fun loadData() {
        println("Student is loading lessons...")
    }
}
