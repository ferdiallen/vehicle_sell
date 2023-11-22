package com.ferdialif.vehicleseller.presentation.detailscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.AirlineSeatReclineExtra
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Construction
import androidx.compose.material.icons.outlined.DirectionsCarFilled
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.ferdialif.vehicleseller.R
import com.ferdialif.vehicleseller.core.cardata.carData
import com.ferdialif.vehicleseller.core.ui.loadSVGImage
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import com.ferdialif.vehicleseller.ui.theme.MainColorAccent
import com.ferdialif.vehicleseller.utils.toProperNumberFormat

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    car: Car? = null,
    motorcycle: Motorcycle? = null,
    onBackPress: () -> Unit
) {
    val context = LocalContext.current
    var shouldShowDetailDescription by rememberSaveable {
        mutableStateOf(false)
    }
    Column(modifier.systemBarsPadding()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {
                onBackPress()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = car?.image ?: motorcycle?.image,
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
                                    text = car?.name ?: (motorcycle?.name ?: ""),
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 24.sp,
                                    modifier = Modifier.weight(1F),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = car?.price?.toProperNumberFormat()
                                        ?: motorcycle?.price?.toProperNumberFormat() ?: "",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.weight(0.5F),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = stringResource(
                                    R.string.specification, car?.name ?: motorcycle?.name ?: ""
                                )
                            )
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
                                    Text(text = car?.engine ?: motorcycle?.engine ?: "")
                                }
                                car?.passengerCapacity?.let {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.AirlineSeatReclineExtra,
                                            contentDescription = "",
                                            modifier = Modifier.size(35.dp)
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = stringResource(
                                                R.string.seat_desc, it
                                            )
                                        )
                                    }
                                }
                                motorcycle?.suspension?.let {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(0.5F)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.Construction,
                                            contentDescription = "",
                                            modifier = Modifier.size(35.dp)
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = it.name, maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
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
                                        contentDescription = "",
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = (car?.releaseYear
                                            ?: motorcycle?.releaseYear).toString()
                                    )
                                }
                                car?.type?.let {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.DirectionsCarFilled,
                                            contentDescription = "",
                                            modifier = Modifier.size(35.dp)
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(text = it.name)
                                    }

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
                                    AsyncImage(
                                        model = R.raw.manual_transmission,
                                        contentDescription = null,
                                        imageLoader = context.loadSVGImage(),
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = (car?.transmissionType
                                            ?: motorcycle?.transmissionType).toString()
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Sell,
                                        contentDescription = "",
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = stringResource(
                                            R.string.sold_title,
                                            (car?.sold ?: motorcycle?.sold) ?: 0
                                        )
                                    )
                                }

                            }
                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                text = stringResource(R.string.description_title),
                                fontWeight = FontWeight.SemiBold, color = MainColorAccent
                            )
                            Text(
                                text = stringResource(
                                    id = car?.description ?: motorcycle?.description
                                    ?: return@Column
                                ),
                                modifier = Modifier.padding(horizontal = 4.dp), maxLines = 10,
                                overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Justify
                            )
                        }

                    }
                }
                (car?.description ?: motorcycle?.description)?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.White
                                    ),
                                    startY = 10F * 140F
                                )
                            )
                            .padding(bottom = 6.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        IconButton(onClick = {
                            shouldShowDetailDescription = !shouldShowDetailDescription
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier
                                    .size(35.dp)
                            )
                        }
                    }
                }
            }
        }
    }
    if (shouldShowDetailDescription) {
        Dialog(onDismissRequest = {
            shouldShowDetailDescription = false
        }) {
            DetailDescription(
                vehicleName = car?.name ?: (motorcycle?.name ?: ""),
                text = stringResource(
                    id = car?.description ?: motorcycle?.description ?: return@Dialog
                ), dismiss = {
                    shouldShowDetailDescription = false
                }
            )
        }

    }
}

@Composable
private fun DetailDescription(
    vehicleName: String = "",
    text: String = "", dismiss: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp)
                .padding(bottom = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = vehicleName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .weight(1F),
                    maxLines = 1, overflow = TextOverflow.Ellipsis
                )
                IconButton(onClick = { dismiss() }, modifier = Modifier.weight(0.2F)) {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Justify
                )

            }
        }
    }
}