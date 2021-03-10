package com.prototype.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.Calendar

object Constant {
    const val CACHE_SIZE = 5 * 1024 * 1024
    const val CACHE_MAX_AGE = 60 * 60 * 24 * 7
    const val CACHE_MAX_STALE = 60 * 60 * 24 * 7

    const val EXTRA_DATA = "data"
    const val BUNDLE_DATA = "data"
}