package com.prototype.ui.main.view

import android.os.Bundle
import com.prototype.R
import com.prototype.data.model.User
import com.prototype.ui.base.BaseActivity

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val user = intent.getSerializableExtra("data") as User
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(user))
                .commitNow()
        }
    }
}