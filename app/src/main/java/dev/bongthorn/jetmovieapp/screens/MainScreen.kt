package dev.bongthorn.jetmovieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {

    val currentIndex = remember {
        mutableStateOf(0)
    }

    MainBody(
        currentSelected = currentIndex.value,
        onValueChanged = { newValue ->
            currentIndex.value = newValue
        },
    ) {
        when (currentIndex.value) {
            0 -> HomeScreen(navController)
            1 -> FavoriteScreen()
            2 -> Text(text = "List")
            3 -> Text(text = "Profile")
        }
    }
}

@Composable
fun MainBody(
    currentSelected: Int = 0,
    onValueChanged: (Int) -> Unit = {},
    topBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = topBar,
        floatingActionButton = floatingActionButton,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = Color.White,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BottomAppBarItem(
                        title = "Home",
                        icon = Icons.Default.Home,
                        isSelected = currentSelected == 0,
                    ) {
                        onValueChanged(0)
                    }
                    BottomAppBarItem(
                        title = "Favorite",
                        icon = Icons.Default.Favorite,
                        isSelected = currentSelected == 1,
                    ) {
                        onValueChanged(1)
                    }
                    BottomAppBarItem(
                        title = "Category",
                        icon = Icons.Default.List,
                        isSelected = currentSelected == 2,
                    ) {
                        onValueChanged(2)
                    }
                    BottomAppBarItem(
                        title = "Account",
                        icon = Icons.Default.Person,
                        isSelected = currentSelected == 3,
                    ) {
                        onValueChanged(3)
                    }
                }
            }
        },
    ) {
        content()
    }
}

@Composable
fun BasePageContent(
    topBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    MainBody(
        topBar = topBar,
        floatingActionButton = floatingActionButton,
        content = content,
    )
}

@Composable
fun BottomAppBarItem(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    isSelected: Boolean = false,
    onPressed: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(corner = CornerSize(4.dp)))
            .clickable(onClick = onPressed)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = if (isSelected) MaterialTheme.colors.primary else Color.Gray
        )
        Text(
            text = title,
            style = TextStyle(
                fontSize = 12.sp,
                color = if (isSelected) MaterialTheme.colors.primary else Color.Gray
            )
        )
    }
}

