package com.example.composelab.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.BorderAll
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MarkChatUnread
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.R

val basicColor = Color(0xFFFFB300)
val blackCardColor = Color(0xFF212121)
val grayCardColor = Color(0xFF37474F)
val creamCardsColor = Color(0xFFFFF8E1)


@Composable
fun TrackParcelScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to basicColor,
                        0.7f to Color.White,
                        1.0f to Color.White
                    )
                )
            )
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        )
        {
            TopRowIcons()
            Spacer(modifier = Modifier.height(25.dp))
            MessageAndSearchBar()
            Spacer(modifier = Modifier.height(20.dp))
            CardParcelOffer()
            Spacer(modifier = Modifier.height(25.dp))
            ParcelToDo()
            Spacer(modifier = Modifier.height(25.dp))
            RecentActivity()
            Spacer(modifier = Modifier.height(150.dp))
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            FloatingBottomBar()
        }
    }
}

@Composable
fun TopRowIcons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .size(44.dp)
                .background(Color.White.copy(alpha = 0.85f))
        ) {
            Icon(
                imageVector = Icons.Default.BorderAll,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(30.dp)
            )
        }
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .size(44.dp)
                .background(Color.White.copy(alpha = 0.85f))
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(30.dp)
            )
        }
    }
}

@Composable
fun MessageAndSearchBar() {
    Column(horizontalAlignment = Alignment.Start)
    {
        Column()
        {
            Text(
                text = "Hello!",
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Track your parcel!",
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()
                .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.searchparcel),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp),
                            tint = Color.Black
                        )
                    },
                    value = "Search",
                    onValueChange = {},
                    enabled = false
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(basicColor),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                    )
                    {
                        Icon(
                            Icons.Default.QrCode,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.Black
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun CardParcelOffer() {
    Card(shape = RoundedCornerShape(18.dp))
    {
        Box(modifier = Modifier.background(brush = Brush.verticalGradient(
            listOf(grayCardColor,blackCardColor)
        ))) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(horizontalAlignment = Alignment.Start)
                {
                    Text(
                        text = "30% Off for Truck",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Booking",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Up to 2 Time Per Week",
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {}, shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = basicColor)
                    )
                    {
                        Text(
                            text = "Order Now",
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                    }
                }
                Image(
                    painter = painterResource(R.drawable.truck),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun ParcelToDo() {
    Column(horizontalAlignment = Alignment.Start)
    {
        Row(modifier = Modifier.fillMaxWidth())
        {
            Text(
                text = "What would you like to do?",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp))
        {
            ToDoItemCard(
                title = "Request Pickup",
                image = Icons.Filled.AllInbox,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            ToDoItemCard(
                title = "Receipt",
                image = Icons.Filled.Newspaper,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            ToDoItemCard(
                title = "Calculate",
                image = Icons.Filled.Calculate,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
        }
    }
}

@Composable
fun ToDoItemCard(
    title : String,
    image : ImageVector,
    modifier: Modifier
) {
    Card(shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(creamCardsColor),
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
        modifier = modifier
    )
    {
        Box(modifier = Modifier.padding(12.dp)
            .fillMaxSize())
        {
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                imageVector = image,
                contentDescription = null,
                modifier = Modifier.size(50.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun RecentActivity() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Recent Activity",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "See All",
            color = basicColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(creamCardsColor))
    {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(horizontalAlignment = Alignment.Start)
            {
                Text(
                    text = "Tracking Number",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "ID - #81328704",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row()
                {
                    Icon(Icons.Default.CheckCircle,contentDescription = null,
                        modifier = Modifier.size(19.dp)
                    , tint = basicColor)
                    HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.size(40.dp).offset(y=8.dp)
                    )
                    Icon(Icons.Default.Circle,contentDescription = null,
                        modifier = Modifier.size(19.dp)
                        , tint = basicColor)
                    HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.size(40.dp).offset(y=8.dp)
                    )
                    Icon(Icons.Default.Circle,contentDescription = null,
                        modifier = Modifier.size(19.dp)
                        , tint = basicColor)
                }
            }
            Image(
                painter = painterResource(R.drawable.container),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

@Composable
fun NavBarItem(
    item: BottomNavItem,
    isSelected:Boolean,
    onCLick: ()-> Unit
){
    val backgroundColor by animateColorAsState(
        targetValue = if(isSelected) basicColor else Color.Transparent,
    )

    val contentColor = if(isSelected) Color.Black else Color.Gray

    Box(modifier = Modifier.clip(CircleShape)
        .background(backgroundColor)
        .clickable {onCLick()})
    {
        Row(modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(30.dp)
            )

            AnimatedVisibility(visible = isSelected)
            {
                Row {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = item.title,
                        color = contentColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun FloatingBottomBar(){
    val items = listOf(
        BottomNavItem("Home",Icons.Outlined.Home),
        BottomNavItem("Package",Icons.Outlined.AllInbox),
        BottomNavItem("Location",Icons.Outlined.LocationOn),
        BottomNavItem("Chat",Icons.Outlined.MarkChatUnread),
        BottomNavItem("Profile",Icons.Outlined.Person)
    )
    
    var selectedIndex by remember{ mutableIntStateOf(0) }

    Surface(
        modifier = Modifier
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp) // Αέρας από κάτω
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(50.dp)), // Σκιά
        color = Color.White,
        shape = RoundedCornerShape(50.dp)
    ){
        Row(modifier = Modifier.padding(8.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            items.forEachIndexed { index, item ->
                NavBarItem(
                    item = item,
                    isSelected = index == selectedIndex,
                    onCLick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun FloatingBottomBarPreview(){
    FloatingBottomBar()
}


@Preview(showBackground = true)
@Composable
fun NavBarItemPreview(
){
    NavBarItem(
        item = BottomNavItem("Home", Icons.Outlined.Home),
        isSelected = true,
        onCLick = {}

    )
}
@Preview(showBackground = true)
@Composable
fun TrackParcelPreview() {
    TrackParcelScreen()
}

data class BottomNavItem(
    val title:String,
    val icon: ImageVector
)