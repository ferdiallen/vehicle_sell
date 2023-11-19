package com.ferdialif.vehicleseller.presentation.homescreen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import coil.compose.AsyncImage
import com.ferdialif.vehicleseller.R
import com.ferdialif.vehicleseller.core.cardata.carData
import com.ferdialif.vehicleseller.domain.model.CarType
import com.ferdialif.vehicleseller.ui.theme.MainColorAccent

val listCar = listOf(
    R.raw.civic,
    R.raw.aventador
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
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
                val soldCars = remember {
                    carData.map {
                        it.sold
                    }.reduce { acc, i ->
                        acc + i
                    }.toString()
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1F)
                ) {
                    Text(text = soldCars , fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
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
                    modifier = Modifier.weight(1F)
                ) {
                    Text(
                        text = "Rp.37.000.000",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                    Text(text = stringResource(R.string.gross), color = Color.LightGray)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.search_by_categories), fontSize = 15.sp)
        Spacer(modifier = Modifier.height(6.dp))
        var selectedTag by remember {
            mutableStateOf(CarType.SEDAN)
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(CarType.entries) {
                Card(
                    modifier = Modifier.height(30.dp),
                    shape = CircleShape,
                    onClick = {
                        selectedTag = it
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = if (it == selectedTag) MainColorAccent else Color.Transparent
                    ),
                    border = BorderStroke(
                        1.dp,
                        color = if (it == selectedTag) MainColorAccent else Color.LightGray
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
                            color = if (it == selectedTag) Color.White else Color.LightGray
                        )
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp), contentPadding = PaddingValues(
                bottom = 64.dp
            )
        ) {
            itemsIndexed(carData) { index, data ->
                VehicleItem(
                    modifier = Modifier
                        .height(240.dp)
                        .offset(y = if (index % 2 == 0) 0.dp else 50.dp),
                    name = data.name,
                    image = data.image,
                    type = data.type?.name ?: "",
                    price = data.price
                )
            }
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
    image: Any? = null
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = {

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
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold, maxLines = 1
                )
                Text(text = price, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.weight(0.1F))
            }

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