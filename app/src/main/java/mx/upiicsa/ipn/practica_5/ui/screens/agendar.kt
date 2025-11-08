package mx.upiicsa.ipn.practica_5.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import mx.upiicsa.ipn.practica_5.R
import mx.upiicsa.ipn.practica_5.ui.theme.*
import androidx.compose.ui.graphics.Color

@Composable
fun Agendar() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {

                Text(
                    text = "Agendar Servicio",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )

            }

            Spacer(modifier = Modifier.height(40.dp)) // bajamos las categorías

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿Qué necesitas reparar?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AgendarItem(
                    title = "Laptop",
                    icon = R.drawable.ic_laptop,
                    modifier = Modifier
                        .weight(1f)
                        .height(170.dp)
                )
                AgendarItem(
                    title = "PC",
                    icon = R.drawable.ic_pc,
                    modifier = Modifier
                        .weight(1f)
                        .height(170.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AgendarItem(
                    title = "Celular",
                    icon = R.drawable.ic_phone,
                    modifier = Modifier
                        .weight(1f)
                        .height(170.dp)
                )
                AgendarItem(
                    title = "Impresora",
                    icon = R.drawable.ic_printer,
                    modifier = Modifier
                        .weight(1f)
                        .height(170.dp)
                )
            }
        }

        Button(
            onClick = { /* Navegar al LoginScreen */ },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 100.dp)
                .height(56.dp)

        ) {
            Text(
                text = "Continuar",
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
fun AgendarItem(title: String, icon: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(45.dp))
            .background(DarkSurface)
            .clickable { /* acción */ }
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgendarPreview() {
    TechFixTheme {
        Agendar()
    }
}
