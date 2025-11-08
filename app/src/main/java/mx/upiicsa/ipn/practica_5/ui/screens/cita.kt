package mx.upiicsa.ipn.practica_5.ui.screens

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import java.util.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.clip
import mx.upiicsa.ipn.practica_5.ui.theme.*

@Composable
fun ScheduleScreen(
    onConfirm: (selectedDateMillis: Long, selectedTime: String) -> Unit = { _, _ -> }
) {
    var selectedDate by remember { mutableStateOf(Calendar.getInstance().timeInMillis) }

    val hours = listOf(
        "09:00 a.m.", "10:00 a.m.", "11:00 a.m.", "12:00 p.m.",
        "01:00 p.m.", "02:00 p.m.", "03:00 p.m.", "04:00 p.m.", "05:00 p.m."
    )
    var selectedHourIndex by remember { mutableStateOf(6) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp)
    ) {
        Text(
            text = "Fecha",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = White,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(DarkSurface)
                .padding(8.dp)
        ) {
            AndroidView(
                factory = { ctx ->
                    CalendarView(ctx).apply {
                        date = selectedDate
                        setOnDateChangeListener { _, year, month, dayOfMonth ->
                            val cal = Calendar.getInstance()
                            cal.set(year, month, dayOfMonth, 0, 0, 0)
                            selectedDate = cal.timeInMillis
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Hora",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = White,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(DarkSurface),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = hours.getOrElse(selectedHourIndex) { "03:00 p.m." },
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        val itemsPerRow = 4
        val rows: List<List<String>> = hours.chunked(itemsPerRow)

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            rows.forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEachIndexed { indexInRow, hour ->
                        val globalIndex = rows.takeWhile { it !== rowItems }.sumOf { it.size } + indexInRow
                        val isSelected = globalIndex == selectedHourIndex
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isSelected) PrimaryBlue else DarkSurface)
                                .clickable { selectedHourIndex = globalIndex },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = hour,
                                color = if (isSelected) Color.White else GrayText,
                                fontSize = 14.sp
                            )
                        }
                    }

                    val missing = itemsPerRow - rowItems.size
                    repeat(missing) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                onConfirm(selectedDate, hours.getOrElse(selectedHourIndex) { "03:00 p.m." })
            },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Aceptar", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Pie de página
        Text(
            text = "© 2025 TechFix Inc.",
            fontSize = 12.sp,
            color = GrayText,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SchedulePreview() {
    TechFixTheme {
        ScheduleScreen()
    }
}
