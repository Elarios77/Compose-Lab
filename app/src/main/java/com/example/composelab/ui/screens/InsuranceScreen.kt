package com.example.composelab.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.PedalBike
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.R

val backgroundTopColor = Color(0xFFCFD7EF)
val backgroundBottomColor = Color(0xFFFDE3E3)
val seeAllColor = Color(0xFF4C9EEB)
val badgeColor = Color(0xFFE0F7FA)
val badgeTextColor = Color(0xFF006064)

@Composable
fun InsuranceScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        backgroundTopColor,
                        backgroundBottomColor
                    )
                )
            )
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
                .verticalScroll(rememberScrollState())
        )
        {
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(Color.Transparent)
            )
            {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            TopBarSearch()
            Spacer(modifier = Modifier.height(30.dp))
            InsuranceItems()
            Spacer(modifier = Modifier.height(65.dp))
            TipsRow()
            Spacer(modifier = Modifier.height(20.dp))
            TipsCard()
            Spacer(modifier = Modifier.height(80.dp))
            Surface(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(32.dp),
                color = Color.White,
                shape = CircleShape
            )
            {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(
                        painter = painterResource(R.drawable.gemini),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "How can I help?",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSearch() {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = "Explore",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Search",
                    color = Color.Gray.copy(alpha = 0.8f),
                    fontSize = 18.sp
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray.copy(alpha = 0.8f)
                )
            },
            colors = SearchBarDefaults.colors(
                Color.White.copy(alpha = 0.4f)
            )
        ) {}
    }
}

@Composable
fun InsuranceItems() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        InsuranceItemCard(
            icon = Icons.Filled.Favorite,
            text = "Health",
            color = Color.Red,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        )
        InsuranceItemCard(
            icon = Icons.Filled.PedalBike,
            text = "Vehicle",
            color = Color.Black,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        )
        InsuranceItemCard(
            icon = Icons.Filled.Pets,
            text = "Pet",
            color = Color.Blue,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        )
        InsuranceItemCard(
            icon = Icons.Filled.House,
            text = "House",
            color = Color.Green,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        )
    }
}

@Composable
fun InsuranceItemCard(
    icon: ImageVector,
    text: String,
    color: Color,
    modifier: Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.7f)),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
        {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun TipsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Tips For Your Plan",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "See all",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = seeAllColor
        )
    }
}

@Composable
fun TipsCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.shadow(elevation = 10.dp, spotColor = Color.Black)
    )
    {
        Column(modifier = Modifier.padding(18.dp))
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Optimize Your Policy",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Surface(
                    shape = CircleShape,
                    color = badgeColor
                )
                {
                    Text(
                        text = "1/16",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(8.dp),
                        color = badgeTextColor
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            TipsCardItem(
                title = "Check unsued benefits",
                subtitle = "Check-up? Take advantage before renewal."
            )
            Spacer(modifier = Modifier.height(20.dp))
            TipsCardItem(
                title = "Track your deductible progress",
                subtitle = "Some services might now be nearly free."
            )
            Spacer(modifier = Modifier.height(20.dp))
            TipsCardItem(
                title = "Update your health profile",
                subtitle = "Let AI find your hidden options."
            )
        }
    }
}

@Composable
fun TipsCardItem(
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            Icons.Filled.Circle,
            contentDescription = null,
            tint = seeAllColor
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                color = Color.Gray
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InsuranceScreenPreview() {
    InsuranceScreen()
}