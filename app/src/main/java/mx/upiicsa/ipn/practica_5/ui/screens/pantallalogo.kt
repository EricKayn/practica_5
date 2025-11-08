package mx.upiicsa.ipn.practica_5.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import mx.upiicsa.ipn.practica_5.R
import mx.upiicsa.ipn.practica_5.ui.theme.*

@Composable
fun Pantallalogo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.techfix_logo),
                contentDescription = "TechFix Logo",
                modifier = Modifier.size(400.dp)
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
                text = "Comenzar",
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

@Preview(showBackground = true)
@Composable
fun PantallalogoPreview() {
    TechFixTheme {
        Pantallalogo()
    }
}
