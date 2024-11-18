package ara.hossein.androidtraining.guessthenumber.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ara.hossein.androidtraining.guessthenumber.MAX_ATTEMPTS
import kotlin.random.Random

@Composable
fun GameScreen(modifier: Modifier = Modifier) {

    val attempts = remember { mutableStateOf(0) }
    val number = remember { mutableStateOf("") }
    val targetNumber = remember { mutableStateOf(5) }
    val dialogText = remember { mutableStateOf("") }

    fun generateNumber() {
        targetNumber.value = Random.nextInt(1, 10)
    }

    LaunchedEffect(true) {
        generateNumber()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("The number is between 1 and 10")
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                TextField(
                    value = number.value,
                    onValueChange = { a -> number.value = a },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(onClick = {
                    if (number.value.toIntOrNull() == targetNumber.value) {
                        dialogText.value = "Correct!"
                    } else {
                        dialogText.value = "Incorrect!"
                        attempts.value++
                        if (attempts.value >= MAX_ATTEMPTS) {
                            dialogText.value = "Game Over!"
                            attempts.value = 0
                        }
                    }
                }) {
                    Text("Submit")
                }
            }
            Text("Attempts: ${attempts.value}")
            Text("Remaining attempts: " + (MAX_ATTEMPTS - attempts.value))
        }

        if (dialogText.value.isNotEmpty())
            Dialog(onDismissRequest = {
                dialogText.value = ""
            }) {
                Column {
                    Text(dialogText.value)
                    Button(onClick = {
                        dialogText.value = ""
                    }) {
                        Text("OK")
                    }
                }
            }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GameScreenPrev() {
    GameScreen()
}