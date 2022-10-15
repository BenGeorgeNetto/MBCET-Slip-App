package com.example.mbcetslipapp.data

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.mbcetslipapp.R

data class Slip(
    @StringRes val name: Int,
    @StringRes val slipType: Int,
    @StringRes val title: Int,
    @StringRes val slipDescribe: Int,
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
    Slip(name = R.string.name_1, slipType = R.string.slip_misc, title = R.string.title_1, slipDescribe = R.string.disc_1, className = R.string.class_1, semester = 3, advisors = listOf(R.string.advisor_1, R.string.advisor_2, R.string.advisor_3), HoD = R.string.hod_cs, rollNo = R.string.roll_1),
    Slip(name = R.string.name_2, slipType = R.string.slip_id, R.string.title_2, slipDescribe = R.string.disc_2, semester = 7, className = R.string.class_2, advisors = listOf(R.string.advisor_4, R.string.advisor_3), HoD = R.string.hod_cs, rollNo = R.string.roll_2),
    Slip(name = R.string.name_3, slipType = R.string.slip_misc, title = R.string.title_1, slipDescribe = R.string.disc_1, semester = 5, className = R.string.class_1, advisors = listOf(R.string.advisor_2), HoD = R.string.hod_cs, rollNo = R.string.roll_3),
    Slip(name = R.string.name_1, slipType = R.string.slip_misc, title = R.string.title_1, slipDescribe = R.string.disc_1, semester = 1, className = R.string.class_2, HoD = R.string.hod_cs, rollNo = R.string.roll_2),
    Slip(name = R.string.name_2, slipType = R.string.slip_gate, title = R.string.title_3, slipDescribe = R.string.disc_3, semester = 1, className = R.string.class_2, advisors = listOf(R.string.advisor_4, R.string.advisor_1), HoD = R.string.hod_cs, rollNo = R.string.roll_2),
    Slip(name = R.string.name_6, slipType = R.string.slip_misc, title = R.string.title_1, slipDescribe = R.string.disc_1,  semester = 3, className = R.string.class_1, HoD = R.string.hod_cs, rollNo = R.string.roll_4)
)