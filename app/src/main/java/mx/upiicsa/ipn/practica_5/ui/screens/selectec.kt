package mx.upiicsa.ipn.practica_5.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import mx.upiicsa.ipn.practica_5.R
import mx.upiicsa.ipn.practica_5.ui.theme.*

@Composable
fun TechnicianSelectScreen(onSelect: (String) -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Elige un técnico",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TechnicianCard(
                name = "Juan Pérez",
                specialty = "Especialista en laptops",
                imageRes = R.drawable.ic_profile, // coloca tu drawable aquí
                available = true,
                onClick = { onSelect("Juan Pérez") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            TechnicianCard(
                name = "María López",
                specialty = "Reparación de celulares",
                imageRes = R.drawable.ic_profile,
                available = false,
                onClick = { onSelect("María López") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            TechnicianCard(
                name = "Carlos Gómez",
                specialty = "Soporte de PC y redes",
                imageRes = R.drawable.ic_profile,
                available = true,
                onClick = { onSelect("Carlos Gómez") }
            )
        }

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 100.dp)
                .height(56.dp)

        ) {
            Text(
                text = "Seleccionar",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = White
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ){Text(
            text = "© 2025 TechFix Inc.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = GrayText

        )
        }
    }
}

@Composable
fun TechnicianCard(
    name: String,
    specialty: String,
    imageRes: Int,
    available: Boolean,
    onClick: () -> Unit = {}
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = DarkSurface,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "$name foto",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(DarkBackground)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = name, color = White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = specialty, color = GrayText, fontSize = 13.sp)
            }

            val statusText = if (available) "Disponible" else "No disponible"
            val statusColor = if (available) SuccessGreen else ErrorRed

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = statusText,
                    color = statusColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TechnicianSelectPreview() {
    TechFixTheme {
        TechnicianSelectScreen()
    }
}
