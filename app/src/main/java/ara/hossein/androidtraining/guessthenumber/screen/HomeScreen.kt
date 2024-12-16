package ara.hossein.androidtraining.guessthenumber.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var screenNumber = remember { mutableStateOf(0) }

    when (screenNumber.value) {
        1 -> GameScreen()
        2 -> AboutUsScreen(onNavigateBack = { screenNumber.value = 0 })
        else -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Text("Game introduction: Guess the number between 1 and 100.")
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = {
                    screenNumber.value = 1
                }) {
                    Text("Start Game")
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = {
                    screenNumber.value = 2
                }) {
                    Text("About Us")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
