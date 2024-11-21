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
)
