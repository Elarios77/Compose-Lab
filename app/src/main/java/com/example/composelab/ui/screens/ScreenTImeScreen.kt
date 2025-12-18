package com.example.composelab.ui.screens

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.R

val backgroundColor = Color(0xFFF2F2E9)
val cardPeachColor = Color(0xFFFFE8B6)
val buttonCoral = Color(0xFFFF8370)
val starColor = Color(0xFFE55B4B)

@Composable
fun ScreenTimeScreen(){
    Column(modifier = Modifier.fillMaxSize()
        .background(color = backgroundColor))
    {
        WelcomeBackBar()
        Spacer(modifier = Modifier.height(12.dp))
        ScreenTimeCard()
        FocusScore()
    }
}

@Composable
fun WelcomeBackBar() {
    Box(modifier = Modifier.fillMaxWidth())
    {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Box(modifier = Modifier.clip(CircleShape)
                .size(80.dp)
                .background(color = Color.Gray.copy(alpha = 0.7f))){
                Icon(
                    Icons.Default.Face,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.align(Alignment.Center).size(50.dp)
                )
            }
            Column(modifier = Modifier.padding(start = 10.dp),verticalArrangement = Arrangement.Center,
                horizontalAlignment =Alignment.Start)
            {
                Text(
                    text = "Welcome Back,",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Text(
                    text = "Lary",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Box(modifier = Modifier.weight(1f)){
                Icon(
                    imageVector = Icons.Default.Tune,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                        .size(44.dp),
                    tint = Color.Black.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
fun ScreenTimeCard() {
    Card(shape = RoundedCornerShape(topStart = 70.dp, topEnd = 70.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.fillMaxWidth().height(400.dp))
    {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                text = "SCREEN TIME",
                fontSize = 15.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically)
            {
                Surface(shape = CircleShape,
                    border = BorderStroke(1.dp,Color.Gray),
                    color = Color.Transparent)
                {
                    Text(
                        text = "Thu, June 20",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Surface(shape = CircleShape,
                    border = BorderStroke(1.dp,Color.Gray),
                    color = Color.Transparent)
                {
                    Icon(
                        Icons.Outlined.CalendarToday,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Stats(
                hour = "2:41",
                title = "Today"
            )
            Stats(
                hour = "0:12",
                title = "Last hour"
            )
            Stats(
                hour = "23",
                title = "Phone pickups"
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider()
        Image(
            painter = painterResource(R.drawable.graph),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider()
    }
}

@Composable
fun Stats(
    hour:String,
    title:String
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp))
    {
        Text(
            text = hour,
            fontSize = if(hour == "2:41")40.sp
                    else
                        25.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}

@Composable
fun FocusScore() {
    Card(shape = RoundedCornerShape(topStart = 70.dp, topEnd = 70.dp),
        colors = CardDefaults.cardColors(cardPeachColor),
        modifier = Modifier.fillMaxWidth().height(300.dp)
            .offset(y=(-120).dp))
    {
        Column(modifier = Modifier.padding(24.dp))
        {
            Text(
                text = "FOCUS SCORE",
                fontSize = 15.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {
                Column{
                    Row(verticalAlignment = Alignment.CenterVertically)
                    {
                        Text(
                            text = "8.5",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.StarRate,
                            contentDescription = null,
                            tint = starColor,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = "Good",
                        fontSize = 15.sp,
                        color = Color.Black

                    )
                }
                Column(horizontalAlignment = Alignment.End)
                {
                    Row(horizontalArrangement = Arrangement.spacedBy((-12).dp)) {
                        val myIcons = listOf(
                            R.drawable.whatsapp,
                            R.drawable.ig,
                            R.drawable.ball,
                            R.drawable.youtube
                        )
                        myIcons.forEach { iconId->
                            Box(modifier = Modifier.clip(CircleShape)
                                .background(Color.White)
                                .border(2.dp,color = cardPeachColor),
                                contentAlignment = Alignment.Center){
                                Image(
                                    painter = painterResource(id = iconId),
                                    contentDescription = null,
                                    modifier = Modifier.size(44.dp)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Most used",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenTimeScreenPreview(){
    ScreenTimeScreen()
}
