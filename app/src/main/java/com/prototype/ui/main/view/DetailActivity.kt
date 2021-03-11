package com.prototype.ui.main.view

import android.os.Bundle
import com.prototype.R
import com.prototype.data.model.Person
import com.prototype.ui.base.BaseActivity
import com.prototype.utils.Constant.EXTRA_DATA

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val user = intent.getSerializableExtra(EXTRA_DATA) as Person
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(user))
                .commitNow()
        }
    }
}