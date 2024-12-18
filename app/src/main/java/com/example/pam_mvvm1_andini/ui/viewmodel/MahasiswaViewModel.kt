package com.example.pam_mvvm1_andini.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pam_mvvm1_andini.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    //Request
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>){
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                gender = listDM[1],
                email = listDM[2],
                alamat = listDM[3],
                nim = listDM[4]
            )
        }
    }
}