package com.example.yatay.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

val yatayPoint = LatLng(-34.31368216370679, -58.63717247204937)
val lanchasJilguero = LatLng(-34.42088376603455, -58.579923961282425)
val trenTigre = LatLng(-34.423264462129694, -58.581887338271024)

@Composable
fun ScreenMap(
    onClick: () -> Unit
) {

    val defaultCameraPosition = CameraPosition.fromLatLngZoom(yatayPoint, 11f)
    val cameraPositionState = rememberCameraPositionState {
        position = defaultCameraPosition
    }
    var isMapLoaded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMapView(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            }
        )
    }

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 12.dp, top = 12.dp),
        onClick = { onClick() }
    ) {
        Icon(Icons.Filled.ArrowBackIosNew, "Localized description")
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Back")
    }


}
// }


//   }

//}

@Composable
fun GoogleMapView(
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    val yatayPointState = rememberMarkerState(position = yatayPoint)
    val lanchasJilgueroState = rememberMarkerState(position = lanchasJilguero)
    val trenTigreState = rememberMarkerState(position = trenTigre)
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        onMapLoaded = onMapLoaded,

        ) {
        //only marker:
        Marker(
            state = lanchasJilgueroState,
            title = "LANCHAS JILGUERO",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE),
            visible = true,
        )
        //marker with window:
        Marker(

            visible = true,
            state = trenTigreState,
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET),
            title = "ESTACION DE TREN TIGRE",
            infoWindowAnchor = Offset(x = 25f, y = 15f)
        )

        //marker with infoWindow:
        Marker(
            snippet = "Atendido por su dueña\nDescanso\nHermosas vistas",
            flat = true,
            visible = true,
            state = yatayPointState,
            //   icon = BitmapDescriptorFactory.fromResource(R.drawable.collage)
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW),
            title = "WELCOME TO YATAY"
        )
        // }

        // }

        content()
    }

}
