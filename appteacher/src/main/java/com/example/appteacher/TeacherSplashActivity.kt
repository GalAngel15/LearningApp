package com.example.appteacher

import com.example.shared.SplashBaseActivity

class TeacherSplashActivity : SplashBaseActivity() {
    override fun getLogoRes(): Int = R.drawable.ic_logo_teacher
    override fun getNextActivity(): Class<*> = TeacherMainActivity::class.java
}
