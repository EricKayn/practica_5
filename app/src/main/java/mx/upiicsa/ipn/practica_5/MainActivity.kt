package mx.upiicsa.ipn.practica_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mx.upiicsa.ipn.practica_5.ui.theme.TechFixTheme
import mx.upiicsa.ipn.practica_5.ui.screens.Pantallalogo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechFixTheme {
                Pantallalogo()
            }
        }
    }
}