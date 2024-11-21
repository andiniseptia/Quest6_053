package com.example.pam_mvvm1_andini.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns

@Composable
//Fungsi untuk form input
fun FormMahasiswaview(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
){
    //Variable yang menampung input user secara langsung
    var nama by rememberSaveable { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableListOf(nama, selectedGender, email, alamat, nim)

    //Menampilkan form input, button, dan card (wadah)
    Column (modifier.fillMaxSize().padding(16.16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        //Form input user
        OutlinedTextField(value = nama, //Mengambil value nama
            onValueChange = {nama = it}, //Memperbarui value nama setiap user menginput teks
            placeholder = { Text("Masukkan Nama")}, //Menampilkan "masukkan nama" setiap teks kosong
            label = { Text("Nama")}, //Menyediakan label di atas
            modifier = Modifier.fillMaxWidth().padding(5.dp) //mengatur lebar komponen
        )

        //Radio button untuk kelamin
        Row (){
            listJK.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) { RadioButton(
                    selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    }
                )
                    Text(item)
                }
            }
        }

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email")},
            label = { Text("Email")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat")},
            label = { Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(value = nim,
            onValueChange = {nim = it},
            placeholder = { Text("Masukkan NIM")},
            label = { Text("NIM")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = { onSubmitClicked(dataMahasiswa) })
        { Text("Simpan") }
    }
}

