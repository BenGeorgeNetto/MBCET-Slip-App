package com.example.mbcetslipapp.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbcetslipapp.R


@Composable
fun MoreDetails(){  // more student details
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        Column {
            Spacer(Modifier.height(0.dp))
            Text(
                text = stringResource(R.string.adno),

                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.bldgrp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.dob),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.phone),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
        }
        // data , get it somehow
        Column {
            Spacer(Modifier.height(0.dp))
            Text(
                text = stringResource(id =R.string.adnod1) ,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(id =R.string.bldgrpd1),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(id =R.string.dobd1),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(id =R.string.phoned1),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
        }
    }

}


@Composable
fun ViewBut(expanded: Boolean, onClick: () -> Unit){ // view more/less button needs work
    IconButton(onClick = onClick) {
        Row {
            Text(
                text = if (expanded) {
                    "View Less"
                } else {
                    "View More"
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                tint = MaterialTheme.colors.primaryVariant,
                contentDescription = "None"
            )
        }
    }
}

@Composable
fun IdCard() {
    var expanded by remember { mutableStateOf(false) }
    val shape = RoundedCornerShape(25.dp,25.dp,20.dp,20.dp)
    val image = painterResource(R.drawable.qr)
    val imgpad: Dp by animateDpAsState(if (expanded) 450.dp else 0.dp,
        tween(1000, easing = LinearOutSlowInEasing))
    val pad: Dp by animateDpAsState(if (expanded) 25.dp else 360.dp,
        tween(1000, easing = LinearOutSlowInEasing))

    var color3=Color(0xFFFFFFFF)



    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            painterResource(R.drawable.dp),
            contentDescription = null,
            modifier = Modifier
                .padding( 1.dp)
                .offset(x = imgpad, y = (-200).dp)
                .fillMaxSize()
                .clip(shape)
            ,
        )
        Column (Modifier.padding(1.dp))
        {
            Spacer(Modifier.height(pad))
            Card(elevation = 1.dp,
                contentColor = MaterialTheme.colors.primaryVariant,
                backgroundColor = MaterialTheme.colors.onSurface.copy(alpha=0.7f),
                modifier = Modifier
                    .clip(shape)
                    .fillMaxWidth())
            {
                Row (horizontalArrangement = Arrangement.SpaceBetween){
                    Spacer(Modifier.weight(0.3f))
                    Column(Modifier.padding(10.dp))
                    {
                        Spacer(Modifier.height(20.dp))
                        Text(
                            text = stringResource(id =R.string.id_name),
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = stringResource(id =R.string.id),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = stringResource(id =R.string.clas),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Column {

                        Crossfade(
                            expanded
                            ,
                            animationSpec = tween(1000)
                        ) { targetState ->
                            Image(
                                painterResource(if (targetState) R.drawable.dp else R.drawable.qr),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clip(shape)
                                    .size(120.dp, 120.dp),

                                )
                        }

                    }
                    Spacer(Modifier.weight(0.2f))

                }
                Column(modifier = Modifier
                    .fillMaxWidth(),) {
                    Spacer(Modifier.height(170.dp))
                    MoreDetails()
                }
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(Modifier.height(320.dp))
                    if (!expanded) {

                        ViewBut(expanded = expanded, onClick = { expanded = !expanded })
                    }

                    if (expanded) {
                        Image(
                            modifier = Modifier
                                .padding(top = 0.dp)
                                .fillMaxSize(0.8f)
                            ,
                            painter = image,
                            contentDescription = null
                        )
                        ViewBut(expanded = expanded, onClick = { expanded = !expanded })
                    }
                }
            }
        }

    }
}