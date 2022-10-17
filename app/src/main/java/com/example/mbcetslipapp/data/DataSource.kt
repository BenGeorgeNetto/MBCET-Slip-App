package com.example.mbcetslipapp.data

import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.model.Credit

class DataSource() {
    fun loadCredits():List<Credit>{
        return listOf<Credit>(
            Credit(R.string.Ben,R.string.user1,R.string.mail1),
            Credit(R.string.Noel,R.string.user2,R.string.mail2),
            Credit(R.string.Adithya,R.string.user3,R.string.mail3),
            Credit(R.string.Ritin,R.string.user4,R.string.mail4),
            Credit(R.string.Samuel,R.string.user5,R.string.mail5),
            Credit(R.string.Abhishek,R.string.user6,R.string.mail6),
            Credit(R.string.Liya,R.string.user7,R.string.mail7)


        )
    }
}