package com.ferdialif.vehicleseller.presentation.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferdialif.vehicleseller.core.cardata.carData
import com.ferdialif.vehicleseller.domain.repository.VehicleRepository
import com.ferdialif.vehicleseller.utils.toProperNumberFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: VehicleRepository
) : ViewModel() {
    val carList = repository.readCarValue().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(),
        emptyList()
    )
    val motorcycleList = repository.readMotorcycleValue().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(),
        emptyList()
    )

}