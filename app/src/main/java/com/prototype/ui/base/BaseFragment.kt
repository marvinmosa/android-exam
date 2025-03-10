package com.prototype.ui.base

import androidx.fragment.app.Fragment


abstract class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract fun setupUi()
    abstract fun setupObservers()
}
