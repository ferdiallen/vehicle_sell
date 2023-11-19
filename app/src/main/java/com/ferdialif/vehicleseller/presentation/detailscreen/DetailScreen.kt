package com.ferdialif.vehicleseller.presentation.detailscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.AirlineSeatReclineExtra
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.DirectionsCarFilled
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.ferdialif.vehicleseller.R
import com.ferdialif.vehicleseller.core.cardata.carData
import com.ferdialif.vehicleseller.core.ui.loadSVGImage

@SuppressLint("ResourceType")
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = R.raw.civic,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1F)
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85F),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(16.dp)
                ) {
                    BoxWithConstraints {
                        val height = remember {
                            (this@BoxWithConstraints.maxHeight / 7)
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp)
                        ) {
                            Spacer(modifier = Modifier.height(height))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = carData.first().name,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 24.sp, modifier = Modifier.weight(1F), maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = carData.first().price,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.weight(0.5F),
                                    maxLines = 1, overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = stringResource(R.string.specification, carData.first().name))
                            Divider()
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 12.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(1F)
                                ) {
                                    AsyncImage(
                                        model = R.raw.car_engine,
                                        imageLoader = context.loadSVGImage(),
                                        contentDescription = "",
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(text = carData.first().engine)
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.AirlineSeatReclineExtra,
                                        contentDescription = "", modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = "${carData.first().passengerCapacity} seat")
                                }

                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 12.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(1F)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.CalendarMonth,
                                        contentDescription = "", modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(text = carData.first().releaseYear.toString())
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.DirectionsCarFilled,
                                        contentDescription = "", modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = carData.first().type.toString())
                                }

                            }
                        }

                    }
                }
            }
        }
    }
}