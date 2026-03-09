import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun RandomPageName(navHostController: NavHostController){
    Column() {
        Text(text = "Random Page")
    }
}

