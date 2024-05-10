package `in`.vikalp.folding_cell.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TicketFolded(
    serialNumber : String,
    startDestination : String,
    endDestination : String,
    deliveryDate : String,
    requestDeadline : String,
    request : String,
    pledge : String,
    weight : String,
    onExpand : () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable { onExpand() }
    ){
        SerialBase(
            serialNo = serialNumber,
            date = deliveryDate,
            time = requestDeadline
        )

        TicketFoldedBase(
            startDestination = startDestination,
            endDestination = endDestination,
            request = request,
            pledge = pledge,
            weight = weight
        )
    }
}

@Preview
@Composable
private fun TicketFoldedPreview() {
    TicketFolded(
        serialNumber = "1",
        startDestination = "RB Colive, 1st Kormangala, Bangalore, 100124",
        endDestination = "Colulu park , 2nd Kormangala, Bangalore, 100124",
        deliveryDate = "TODAY",
        requestDeadline = "06 : 30 PM",
        request = "2",
        pledge = "$150",
        weight = "light"
    )
}

@Composable
fun TicketFoldedBase(
    startDestination : String,
    endDestination : String,
    request : String,
    pledge : String,
    weight : String,
    baseColor: Color = Color.White
) {
    Column(
        modifier = Modifier
            .background(color = baseColor)
            .padding(12.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(text = startDestination)
            Divider(modifier = Modifier.padding(vertical = 4.dp))
            Text(text = endDestination)
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Detail(title = "REQUEST", value = request , textColor = Color.Black)
            Detail(title = "PLEDGE", value = pledge , textColor = Color.Black)
            Detail(title = "WEIGHT", value = weight , textColor = Color.Black)
        }
    }
}


@Preview
@Composable
private fun TicketFoldedBasePreview() {
    TicketFoldedBase(
        startDestination = "RB Colive, 1st Kormangala, Bangalore, 100124",
        endDestination = "Colulu park , 2nd Kormangala, Bangalore, 100124",
        request = "2",
        pledge = "$150",
        weight = "light"
    )
}

@Composable
fun Detail(
    title : String,
    value : String,
    textColor : Color = Color.Black
){
    Column(
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = textColor.copy(alpha = .6f),
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            color = textColor.copy(alpha = .8f),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
fun DetailPreview(){
    Detail(title = "NAME", value = "Vikalp")
}



@Composable
fun SerialBase(
    serialNo : String,
    date : String = "TODAY",
    time : String = "06 : 30 PM",
    baseColor : Color = Color.Black
){
    Column(
        modifier = Modifier
            .height(150.dp)
            .background(color = baseColor)
            .padding(12.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = serialNo,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )

        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = date,
                color = Color.White.copy(alpha = .4f),
                style = MaterialTheme.typography.bodySmall,
            )
            Text(
                text = time,
                color = Color.White.copy(alpha = .8f),
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Preview
@Composable
fun SerialBasePreview(){
    SerialBase(serialNo = "1")
}

