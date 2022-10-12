package dev.bongthorn.jetmovieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bongthorn.jetmovieapp.navigation.MovieScreens


@Composable
fun HomeScreen(navController: NavController) {

    val movieList = remember {
        mutableListOf(
            "Movie 01",
            "Movie 002",
            "Movie 002",
            "Movie 002",
            "Movie 002",
            "Movie 002",
            "Movie 002",
        )
    }

    BasePageContent(
        topBar = {
            TopAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu icon")
                    Text(text = "Movie")
                    Row(
                        modifier = Modifier.padding(end = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Shopping"
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = MovieScreens.MovieDetail.name)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            LazyColumn(
                modifier = Modifier.padding(bottom = 56.dp)
            ) {
                items(items = movieList) {
                    MovieCardItem(title = it) {
                        navController.navigate(route = MovieScreens.MovieDetail.name + "/$it")
                    }
                }
            }
        }
    }
}

@Composable
fun MovieCardItem(title: String, onPressed: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clickable(onClick = onPressed),
        backgroundColor = Color.White,
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
                modifier = Modifier
                    .size(56.dp, 56.dp)
            )
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(text = title)
                Text(
                    text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

