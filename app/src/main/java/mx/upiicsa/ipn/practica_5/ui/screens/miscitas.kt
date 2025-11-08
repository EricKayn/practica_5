package mx.upiicsa.ipn.practica_5.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.upiicsa.ipn.practica_5.R
import mx.upiicsa.ipn.practica_5.ui.theme.*

@Composable
fun MyAppointmentsScreen(onCancel: (String) -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Mis citas",
                color = White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))


            AppointmentCard(
                service = "Reparación de Laptop",
                technician = "Juan Pérez",
                datetime = "27 Oct - 16:00",
                status = "Pendiente",
                statusColor = PrimaryBlue,
                imageRes = R.drawable.ic_profile,
                onCancel = { onCancel("cita1") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            AppointmentCard(
                service = "Cambio de pantalla de celular",
                technician = "María López",
                datetime = "28 Oct - 10:30",
                status = "Confirmada",
                statusColor = SuccessGreen,
                imageRes = R.drawable.ic_profile,
                onCancel = { onCancel("cita2") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            AppointmentCard(
                service = "Mantenimiento de impresora",
                technician = "Carlos Gómez",
                datetime = "30 Oct - 09:00",
                status = "Cancelada",
                statusColor = ErrorRed,
                imageRes = R.drawable.ic_profile,
                onCancel = { onCancel("cita3") }
            )
        }


        Text(
            text = "© 2025 TechFix Inc.",
            fontSize = 12.sp,
            color = GrayText,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
        )
    }
}

@Composable
fun AppointmentCard(
    service: String,
    technician: String,
    datetime: String,
    status: String,
    statusColor: Color,
    imageRes: Int,
    onCancel: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = DarkSurface,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "$technician foto",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(DarkBackground)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = service, color = White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Técnico: $technician", color = GrayText, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = datetime, color = GrayText, fontSize = 13.sp)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(horizontalAlignment = Alignment.End) {
                Text(text = status, color = statusColor, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onCancel,
                    colors = ButtonDefaults.buttonColors(containerColor = ErrorRed),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text(text = "Cancelar", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppointmentsPreview() {
    TechFixTheme {
        MyAppointmentsScreen()
    }
}
