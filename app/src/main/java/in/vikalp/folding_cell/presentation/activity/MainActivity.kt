package `in`.vikalp.folding_cell.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.vikalp.folding_cell.presentation.screen.TicketFolded
import `in`.vikalp.folding_cell.presentation.screen.TicketUnfolded
import `in`.vikalp.folding_cell.ui.theme.FoldingCellTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoldingCellTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.inverseOnSurface
                ) {
                    FoldingCellContent()
                }
            }
        }
    }
}

@Composable
fun FoldingCellContent() {
    val ticketState   = remember {
        mutableStateOf(TicketState.FOLDED)
    }
    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {

        AnimatedContent(targetState = ticketState.value, label = "ticketState") {
            when(it) {
                TicketState.FOLDED -> {
                    TicketFolded(
                        serialNumber = "1",
                        startDestination = "RB Colive, 1st Kormangala, Bangalore, 100124",
                        endDestination = "Colulu park , 2nd Kormangala, Bangalore, 100124",
                        deliveryDate = "TODAY",
                        requestDeadline = "06 : 30 PM",
                        request = "2",
                        pledge = "$150",
                        weight = "light",
                        onExpand = {
                            ticketState.value = TicketState.UNFOLDED
                        }
                    )
                }
                TicketState.UNFOLDED -> {
                    TicketUnfolded(
                        serialNumber = "1",
                        price = "$150",
                        startDestination = "RB Colive, 1st Kormangala, Bangalore, 100124",
                        endDestination = "Colulu park , 2nd Kormangala, Bangalore, 100124",
                        deliveryDate = "12th June 2021",
                        requestDeadline = "10th June 2021",
                        request = "2",
                        pledge = "$150",
                        weight = "light",
                        onFold = {
                            ticketState.value = TicketState.FOLDED
                        }
                    )
                }
            }
        }
    }
}

enum class TicketState {
    FOLDED,
    UNFOLDED
}
