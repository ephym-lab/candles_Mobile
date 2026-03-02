package com.example.candles.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.candles.data.MockData
import com.example.candles.ui.components.ProductCardPremium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen(onProductClick: (Int) -> Unit) {
    var selectedCategory by remember { mutableIntStateOf(0) }
    val categories = listOf("All", "Floral", "Woody", "Sweet", "Fresh")

    val filteredProducts = remember(selectedCategory) {
        if (selectedCategory == 0) MockData.products
        else MockData.products.filter { it.category == categories[selectedCategory] }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Our Collection",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Tune, contentDescription = "Filter")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // ─── Category chips ─────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                categories.forEachIndexed { index, title ->
                    val isSelected = index == selectedCategory

                    val bgColor by animateColorAsState(
                        targetValue = if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                        animationSpec = tween(300),
                        label = "chipBg$index"
                    )
                    val textColor by animateColorAsState(
                        targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimary
                        else MaterialTheme.colorScheme.onSurfaceVariant,
                        animationSpec = tween(300),
                        label = "chipText$index"
                    )

                    Surface(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .clickable { selectedCategory = index },
                        shape = RoundedCornerShape(20.dp),
                        color = bgColor
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = textColor,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ─── Product grid ───────────
            AnimatedContent(
                targetState = selectedCategory,
                transitionSpec = {
                    fadeIn(tween(300)) togetherWith fadeOut(tween(200))
                },
                label = "gridContent"
            ) { _ ->
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    itemsIndexed(filteredProducts) { index, product ->
                        val itemAlpha = remember { Animatable(0f) }
                        LaunchedEffect(product.id) {
                            itemAlpha.animateTo(
                                1f,
                                animationSpec = tween(
                                    durationMillis = 400,
                                    delayMillis = index * 80,
                                    easing = EaseOutCubic
                                )
                            )
                        }

                        ProductCardPremium(
                            product = product,
                            onClick = { onProductClick(product.id) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .alpha(itemAlpha.value)
                        )
                    }
                }
            }
        }
    }
}
