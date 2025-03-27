package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Playground() {
    Row(modifier = Modifier.padding(22.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text("Xoxo")
            Text("Xoxo")
        }
        Text("Row")
        Text("Brow")
    }
}