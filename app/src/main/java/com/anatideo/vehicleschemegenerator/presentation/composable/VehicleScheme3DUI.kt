package com.anatideo.vehicleschemegenerator.presentation.composable

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.graphics.graphicsLayer
import com.anatideo.vehicleschemegenerator.data.model.VehicleScheme

@Composable
fun VehicleScheme3DUI(
    vehicleScheme: VehicleScheme,
    modifier: Modifier = Modifier
) {
    var rotX by remember { mutableStateOf(0f) }
    var rotY by remember { mutableStateOf(0f) }
    var scale by remember { mutableStateOf(1f) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        Box(
            Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        rotY += pan.x
                        rotX -= pan.y
                        scale = (scale * zoom).coerceIn(0.5f, 3f)
                    }
                }
                .graphicsLayer {
                    rotationX = rotX
                    rotationY = rotY
                    scaleX = scale
                    scaleY = scale
                    cameraDistance = 12 * density
                }
        ) {
            VehicleContent3DUI(vehicleScheme)
        }
    }
}
