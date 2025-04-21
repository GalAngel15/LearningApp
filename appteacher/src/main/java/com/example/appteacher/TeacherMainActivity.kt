package com.example.appteacher

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.appteacher.databinding.ActivityMainBinding
import com.example.shared.BaseLearningActivity

class TeacherMainActivity : BaseLearningActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // אותו layout כמו התלמיד

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupListeners()

        showToast("ברוך הבא מורה")
        logScreen("TeacherMainActivity")

    }

    private fun setupUI() {
        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Teacher"
        binding.toolbar.setBackgroundColor(getColor(R.color.teacherPrimary))
        binding.lblBanner.setBackgroundColor(getColor(R.color.teacherPrimary))
        binding.btnUpload.setBackgroundColor(getColor(R.color.teacherPrimary))
        binding.main.setBackgroundColor(getColor(R.color.teacherBackground))
    }

    private fun setupListeners() {
        binding.btnUpload.setOnClickListener {
            val question = binding.edtProblem.editText?.text?.toString()?.trim()

            if (!question.isNullOrEmpty()) {
                addQuestionToScreen(question)
                binding.edtProblem.editText?.setText("")
                binding.lblBanner.text = "שאלה הועלתה בהצלחה"
                playSuccessAnimation()
            } else {
                binding.lblBanner.text = "יש להכניס שאלה"
            }
        }
    }

    private fun addQuestionToScreen(question: String) {
        val questionView = TextView(this).apply {
            text = question
            textSize = 18f
            setPadding(100, 8, 40, 8)
        }
        binding.questionsContainer.addView(questionView)
    }

    private fun playSuccessAnimation() {
        binding.anmCheck.apply {
            visibility = View.VISIBLE
            playAnimation()
            postDelayed({ visibility = View.GONE }, 2000)
        }
    }
    override fun loadData() {
        println("Teacher is loading submissions...")
    }
}
