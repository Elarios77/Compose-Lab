package com.example.composelab.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.ui.navigation.ComposeNavigation

@Composable
fun MainScreen(
    screens:List<ComposeNavigation>,
    onButtonClick:(String)-> Unit
){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.LightGray)
    {
        LazyColumn(modifier = Modifier.padding(16.dp).fillMaxSize())
        {
            item {
                Text(text = "Select a demo:",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(8.dp))

            }
            items(screens){screen->
                MenuButton(
                    text = stringResource(id = screen.title),
                    onClick = {onButtonClick(screen.name)}
                )
            }
        }
    }
}

@Composable
fun MenuButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(top = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text,
            fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    val mockScreens = listOf(ComposeNavigation.Main, ComposeNavigation.Bank)
    MainScreen(
        screens = mockScreens,
        onButtonClick = {}
    )
}