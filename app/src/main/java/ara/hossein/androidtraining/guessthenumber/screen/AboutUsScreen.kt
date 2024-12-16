package ara.hossein.androidtraining.guessthenumber.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AboutUsScreen(onNavigateBack: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("About Us: This app is developed to help users guess the number.")
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = onNavigateBack) {
            Text("Back to Home")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AboutUsScreenPreview() {
    AboutUsScreen(onNavigateBack = {})
}
