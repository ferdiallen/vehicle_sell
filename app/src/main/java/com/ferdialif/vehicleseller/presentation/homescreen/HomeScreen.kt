@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.ferdialif.vehicleseller.presentation.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ferdialif.vehicleseller.R
import com.ferdialif.vehicleseller.core.cardata.carData
import com.ferdialif.vehicleseller.core.cardata.tabVehicle
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.CarType
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import com.ferdialif.vehicleseller.ui.theme.MainColorAccent
import com.ferdialif.vehicleseller.utils.toProperNumberFormat
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetailScreen: (data: Any) -> Unit,
    viewModel: HomeViewModel
) {
    val carValues by viewModel.carList.collectAsState()
    val motorcycleValue by viewModel.motorcycleList.collectAsState()
    val pagerState = rememberPagerState(pageCount = { tabVehicle.size })
    val currentPage by remember {
        derivedStateOf {
            pagerState.currentPage
        }
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier
            .statusBarsPadding()
            .systemBarsPadding()
            .padding(top = 12.dp)
    ) {
        Text(
            text = stringResource(R.string.car_shop_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Filled.Insights, contentDescription = "")
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = stringResource(R.string.current_sales_title), fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp), colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                val soldCars = remember(carValues) {
                    carData.map {
                        it.sold
                    }.reduce { acc, i ->
                        acc + i
                    }.toString()
                }
                val soldMotorcycle = remember(motorcycleValue.size) {
                    return@remember if (motorcycleValue.isNotEmpty()) {
                        motorcycleValue.map {
                            it.sold
                        }.reduce { acc, d ->
                            acc + d
                        }.toString()
                    } else {
                        ""
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1F)
                ) {
                    Text(
                        text = if (pagerState.currentPage == 0) soldCars else soldMotorcycle,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = stringResource(R.string.orders), color = Color.LightGray)
                }
                Card(
                    modifier = Modifier
                        .fillMaxHeight(0.7F)
                        .width(1.dp)

                ) {

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1F)
                        .padding(horizontal = 12.dp)
                ) {
                    val carTotalPrice = remember(carValues) {
                        if (carValues.isNotEmpty()) {
                            carValues.map {
                                Pair(it.price, it.sold)
                            }.map {
                                (it.first * it.second)
                            }.reduce { acc, d ->
                                acc + d
                            }.toProperNumberFormat()
                        } else {
                            0.0.toProperNumberFormat()
                        }
                    }
                    val motorcycleTotalPrice = remember(motorcycleValue) {
                        return@remember if (motorcycleValue.isNotEmpty()) {
                            motorcycleValue.map {
                                it.price
                            }.reduce { acc, d ->
                                acc + d
                            }.toProperNumberFormat()
                        } else {
                            0.0.toProperNumberFormat()
                        }
                    }
                    Text(
                        text = if (currentPage == 0) carTotalPrice else motorcycleTotalPrice,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                    Text(text = stringResource(R.string.gross), color = Color.LightGray)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TabRow(
            selectedTabIndex = currentPage,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            divider = {
            },
            indicator = {
                Divider(
                    modifier = Modifier
                        .tabIndicatorOffset(it[currentPage]),
                    thickness = 2.dp, color = MainColorAccent
                )
            }, containerColor = Color.Transparent
        ) {
            tabVehicle.forEach {
                Tab(selected = tabVehicle[pagerState.currentPage] == it, onClick = {
                    scope.launch {
                        pagerState.scrollToPage(tabVehicle.indexOf(it))
                    }
                }) {
                    Text(
                        text = it,
                        color = MainColorAccent,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }
        }
        var selectedVehicleType by remember {
            mutableStateOf(CarType.SEDAN)
        }
        val filteredCarValues = remember(carValues, selectedVehicleType) {
            carValues.filter {
                it.type == selectedVehicleType
            }
        }
        AnimatedVisibility(
            visible = currentPage == 0,
            enter = slideInVertically(tween(400), initialOffsetY = {
                it - 100
            }),
            exit = fadeOut(tween(400)) + slideOutVertically()
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(CarType.entries) {
                    Card(
                        modifier = Modifier.height(30.dp),
                        shape = CircleShape,
                        onClick = {
                            selectedVehicleType = it
                        },
                        colors = CardDefaults.cardColors(
                            containerColor = if (it == selectedVehicleType) MainColorAccent else Color.Transparent
                        ),
                        border = BorderStroke(
                            1.dp,
                            color = if (it == selectedVehicleType) MainColorAccent else Color.LightGray
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(horizontal = 12.dp)
                                .padding(top = 2.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = it.name,
                                fontSize = 15.sp,
                                color = if (it == selectedVehicleType) Color.White else Color.LightGray
                            )
                        }
                    }

                }
            }

        }
        HorizontalPager(state = pagerState, userScrollEnabled = false) {
            when (it) {
                0 -> {
                    Column {
                        VehiclePageItems(vehicleData = filteredCarValues, onItemClick = {out->
                            onNavigateToDetailScreen(filteredCarValues[out])
                        })
                    }
                }

                1 -> {
                    VehiclePageItems(vehicleData = motorcycleValue, onItemClick = {out->
                        onNavigateToDetailScreen(motorcycleValue[out])
                    })
                }
            }
        }
    }
}

@Composable
fun <T> VehiclePageItems(
    vehicleData: List<T>,
    onItemClick: (index: Int) -> Unit
) {
    val motorcycleValues = remember(vehicleData) {
        vehicleData.filterIsInstance(Motorcycle::class.java)
    }
    val carValues = remember(vehicleData) {
        vehicleData.filterIsInstance(Car::class.java)
    }
    Spacer(modifier = Modifier.height(32.dp))
    AnimatedVisibility(
        visible = vehicleData.isEmpty(),
        enter = fadeIn(tween(400)),
        exit = fadeOut(tween(400))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.no_car_title))
        }
        return@AnimatedVisibility
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(
            bottom = 64.dp
        )
    ) {
        itemsIndexed(carValues) { index, data ->
            VehicleItem(
                modifier = Modifier
                    .height(240.dp)
                    .offset(y = if (index % 2 == 0) 0.dp else 50.dp),
                name = data.name,
                image = data.image,
                type = data.type?.name ?: "",
                price = data.price.toProperNumberFormat(),
                onItemClick = {
                    onItemClick(index)
                }
            )
        }
        itemsIndexed(motorcycleValues) {  index, value ->
            VehicleItem(
                modifier = Modifier
                    .height(240.dp)
                    .offset(y = if (index % 2 == 0) 0.dp else 50.dp),
                name = value.name,
                image = value.image,
                type = "",
                price = value.price.toProperNumberFormat(),
                onItemClick = {
                    onItemClick(index)
                }
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleItem(
    modifier: Modifier = Modifier,
    name: String = "",
    price: String = "",
    type: String = "",
    image: Any? = null,
    onItemClick: () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = {
            onItemClick()
        },
        colors = CardDefaults.cardColors(
            if (isSystemInDarkTheme())
                MaterialTheme.colorScheme.secondaryContainer else Color.White
        )
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.45F),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold, maxLines = 2
                )
                Text(text = price, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.weight(0.1F))
            }
            if (type != "") {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Card(colors = CardDefaults.cardColors(MainColorAccent.copy(0.3F))) {
                        Text(
                            text = type, modifier = Modifier
                                .padding(horizontal = 12.dp),
                            color = MainColorAccent
                        )
                    }
                }

            }
        }
    }

}