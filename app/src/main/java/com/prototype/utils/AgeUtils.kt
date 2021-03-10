package com.prototype.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.Calendar

object AgeUtils {
    fun getAge(birthday: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd")
        val formattedDay = simpleDateFormat.parse(getShortBirthday(birthday))
        val calendar = Calendar.getInstance()
        calendar.time = formattedDay
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH] + 1
        val date = calendar[Calendar.DATE]
        val newDate = LocalDate.of(year, month, date)
        val now = LocalDate.now()
        val diff = Period.between(newDate, now)
        return "${diff.years}"
    }

    fun getShortBirthday(birthday: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("yyyy/MM/dd")
        return formatter.format(parser.parse(birthday))
    }
}