package com.example.mbcetslipapp.data

import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.model.Slip

class AllSlips() {
    fun loadSlips():List<Slip>{
        return listOf<Slip>(
            Slip(R.string.Sara,R.string.s8cs1,R.string.desc3,R.string.subject3,R.string.date3,R.string.status1,R.string.Rejitha,R.string.Revathy) ,
            Slip(R.string.Satheesh,R.string.s2cs1,R.string.desc1,R.string.subject1,R.string.date3,R.string.status1,R.string.Manohar,R.string.Revathy) ,
            Slip(R.string.Justin,R.string.s8cs1,R.string.desc4,R.string.subject4,R.string.date3,R.string.status3,R.string.Manohar,R.string.Revathy),
            Slip(R.string.Divya,R.string.s6cs1,R.string.desc5,R.string.subject5,R.string.date3,R.string.status2,R.string.Rejitha,R.string.Revathy),
            Slip(R.string.Lena,R.string.s6cs2,R.string.desc5,R.string.subject5,R.string.date2,R.string.status3,R.string.Bindu,R.string.Revathy),
            Slip(R.string.Rona,R.string.s8cs2,R.string.desc1,R.string.subject1,R.string.date2,R.string.status3,R.string.Bindu,R.string.Revathy),
            Slip(R.string.Sreenanda,R.string.s4cs2,R.string.desc3,R.string.subject3,R.string.date2,R.string.status2,R.string.Mithra,R.string.Revathy),
            Slip(R.string.Neha,R.string.s4cs2,R.string.desc2,R.string.subject2,R.string.date1,R.string.status3,R.string.Mithra,R.string.Revathy),
            Slip(R.string.Alka,R.string.s8cs1,R.string.desc4,R.string.subject4,R.string.date1,R.string.status3,R.string.Bindu,R.string.Revathy),
        )


    }
}