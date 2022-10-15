package com.example.mbcetslipapp.data

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.mbcetslipapp.R

data class Slip(
    @StringRes val name: Int,
    @StringRes val slipType: Int,
    val title: String,
    val slipDescribe: String,
    val status: MutableState<Boolean> = mutableStateOf(false),
    val semester: Int,
    @StringRes val className: Int,
    @StringRes val rollNo: Int,
    @StringRes val advisors: List<Int> = listOf(),
    @StringRes val HoD: Int
)
{
    fun acceptStatus() {
        status.value = true
    }
}

val slips = mutableListOf(
    Slip(name = R.string.name_1, slipType = R.string.slip_misc, title = "Trials", slipDescribe = "Trial And Error", className = R.string.class_1, semester = 3, advisors = listOf(R.string.advisor_1, R.string.advisor_2, R.string.advisor_3), HoD = R.string.hod_cs, rollNo = R.string.roll_1),
    Slip(name = R.string.name_2, slipType = R.string.slip_id, title = "Request for new ID", slipDescribe = "This is to request for a new id. Unfortunately, my ID is lost, and I would like to request a replacement.", semester = 7, className = R.string.class_2, advisors = listOf(R.string.advisor_4, R.string.advisor_3), HoD = R.string.hod_cs, rollNo = R.string.roll_2),
    Slip(name = R.string.name_3, slipType = R.string.slip_misc, title = "Trials", slipDescribe = "Trial And Error", semester = 5, className = R.string.class_1, advisors = listOf(R.string.advisor_2), HoD = R.string.hod_cs, rollNo = R.string.roll_3),
    Slip(name = R.string.name_1, slipType = R.string.slip_misc, title = "Trials", slipDescribe = "Trial And Error", semester = 1, className = R.string.class_2, HoD = R.string.hod_cs, rollNo = R.string.roll_2),
    Slip(name = R.string.name_2, slipType = R.string.slip_gate, title = "Permission to Leave Early", slipDescribe = "I am feeling fever and extreme headaches. Please excuse me for the day.", semester = 1, className = R.string.class_2, advisors = listOf(R.string.advisor_4, R.string.advisor_1), HoD = R.string.hod_cs, rollNo = R.string.roll_2),
    Slip(name = R.string.name_6, slipType = R.string.slip_misc, title = "Trials", slipDescribe = "Trial And Error",  semester = 3, className = R.string.class_1, HoD = R.string.hod_cs, rollNo = R.string.roll_4)
)