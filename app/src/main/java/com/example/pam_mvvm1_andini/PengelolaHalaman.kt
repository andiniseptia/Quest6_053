package com.example.pam_mvvm1_andini

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_mvvm1_andini.model.DataJenisKelamin
import com.example.pam_mvvm1_andini.ui.view.DetailMahasiswaView
import com.example.pam_mvvm1_andini.ui.view.FormMahasiswaview
import com.example.pam_mvvm1_andini.ui.viewmodel.MahasiswaViewModel

enum class Halaman{
    Formulir,
    Detail,
}

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Halaman.Formulir.name) {
        composable(route = Halaman.Formulir.name) {
            val konteks = LocalContext.current
            FormMahasiswaview(
                listJK = DataJenisKelamin.listJK.map { id ->
                    konteks.resources.getString(
                        id
                    )
                },
                onSubmitClicked = { data ->
                    // Menyimpan data mahasiswa ke ViewModel
                    viewModel.saveDataMahasiswa(data)
                    // Navigasi ke halaman Detail
                    navController.navigate(Halaman.Detail.name)
                }
            )
        }
        composable(route = Halaman.Detail.name) {
            DetailMahasiswaView(
                uiStateMahasiswa = uiState,
                onBackButton = {
                    // Kembali ke halaman Formulir
                    navController.popBackStack()
                }
            )
        }
    }
}