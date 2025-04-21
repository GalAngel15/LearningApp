package com.example.learningapp

import com.example.shared.SplashBaseActivity

class StudentSplashActivity : SplashBaseActivity() {
    override fun getLogoRes(): Int = R.drawable.ic_logo_student
    override fun getNextActivity(): Class<*> = StudentMainActivity::class.java
}
