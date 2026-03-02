package com.example.candles.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.candles.data.MockData
import com.example.candles.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen(onProductClick: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Our Collection", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { /* Search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            ScrollableTabRow(
                selectedTabIndex = 0,
                edgePadding = 16.dp,
                containerColor = MaterialTheme.colorScheme.background,
                divider = {}
            ) {
                listOf("All", "Floral", "Woody", "Sweet", "Fresh").forEachIndexed { index, title ->
                    Tab(
                        selected = index == 0,
                        onClick = { /* Select category */ },
                        text = { Text(title) }
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(MockData.products) { product ->
                    ProductCard(
                        product = product,
                        onClick = { onProductClick(product.id) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
