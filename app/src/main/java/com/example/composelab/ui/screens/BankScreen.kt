package com.example.composelab.ui.screens


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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalTaxi
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.R

data class NavigationItem(
    val title: String,
    val icon: ImageVector
)

val navigationItem = listOf(
    NavigationItem(title = "Home", icon = Icons.Filled.Home),
    NavigationItem(title = "Map", icon = Icons.Filled.Map),
    NavigationItem(title = "Transfer", icon = Icons.AutoMirrored.Filled.CompareArrows),
    NavigationItem(title = "Settings", icon = Icons.Filled.Settings),
    NavigationItem(title = "Profile", icon = Icons.Default.Person)

)

val backGroundColor = Color(0xFFF6F6F6)
val cardColor = Color(0xFFD0F64F)
val btnColor = Color(0xFF1A1A1A)

@Composable
fun BankScreen() {


    Scaffold(
        containerColor = backGroundColor,
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            item {
                TopBarSection()
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                BalanceCard()
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                YourCards()
                Spacer(modifier = Modifier.height(20.dp))
            }
            item { Transactions() }
        }
    }
}

@Composable
fun TopBarSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Good morning, Lary",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Welcome to Neonbank",
                fontSize = 15.sp,
                color = Color.Gray.copy(alpha = 0.9f)
            )
        }
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .size(44.dp)
                .background(color = Color.White)
        )
        {
            Icon(
                Icons.Outlined.Notifications, null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(30.dp)
            )
        }
    }
}

@Composable
fun BalanceCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(contentColor = Color.White),
        shape = RoundedCornerShape(32.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    )
    {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        )
        {
            Text(
                text = "Your balance",
                fontSize = 17.sp,
                color = Color.Gray
            )
            Icon(
                imageVector = Icons.Outlined.VisibilityOff,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.align(Alignment.End)
            )
            Text(
                text = "$3,200.00",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.offset(y = -20.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = btnColor)
            )
            {
                Text(
                    text = "Add money",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun YourCards() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Your cards",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "+ New Card",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(18.dp)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(cardColor, cardColor.copy(alpha = 0.2f)),
                    )
                )
                .padding(16.dp)
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "N.",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(R.drawable.mastercard),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    tint = Color.Unspecified
                )
            }
            Column(modifier = Modifier.align(Alignment.BottomStart))
            {
                Text(
                    text = "Debit Card",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "****4568",
                    color = Color.Black,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.BottomEnd),
                colors = ButtonDefaults.buttonColors(Color.White)
            )
            {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Visibility,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Details",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Composable
fun Transactions() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(contentColor = Color.White),
        shape = RoundedCornerShape(32.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Transactions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "See all",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(
            icon = Icons.Default.Coffee,
            title = "Starbucks Coffee",
            date = "October 17,09:00 PM",
            amount = "-$44.80"
        )
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(
            icon = Icons.Default.LocalTaxi,
            title = "Taxi",
            date = "October 29,18:00 PM",
            amount = "-$7.80"
        )
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(
            icon = Icons.Default.Fastfood,
            title = "Fast Food",
            date = "November 02,22:00 PM",
            amount = "-$16.99"
        )
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(
            icon = Icons.Default.ShoppingBag,
            title = "Shopping",
            date = "October 04,12:00 PM",
            amount = "-$97.62"
        )
    }
}

@Composable
fun TransactionItem(icon: ImageVector, title: String, date: String, amount: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .size(44.dp)
                .background(color = Color.White)
        )
        {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        )
        {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                date,
                color = Color.Gray,
                fontSize = 15.sp
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = amount,
                modifier = Modifier.align(Alignment.CenterEnd),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val selectedNavigationIndex = remember { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItem.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = { selectedNavigationIndex.intValue = index },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title,
                        tint = if(index ==  selectedNavigationIndex.intValue)
                                Color.Black
                                else
                             Color.Gray.copy(alpha = 0.8f)
                    )
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black
                        else
                            Color.Gray.copy(alpha = 0.8f),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BankScreenPreview() {
    BankScreen()
}
