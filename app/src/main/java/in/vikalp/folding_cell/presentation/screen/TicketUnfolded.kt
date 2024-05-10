package `in`.vikalp.folding_cell.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.vikalp.folding_cell.R

@Composable
fun TicketUnfolded(
    serialNumber : String,
    price : String,
    startDestination : String,
    endDestination : String,
    deliveryDate : String,
    requestDeadline : String,
    request : String,
    pledge : String,
    weight : String,
    onFold : () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)

    ){
        Topbar(
            icon = Icons.Default.Menu,
            serialNumber = serialNumber,
            price = price
        )
        Header(
            request = request,
            pledge = pledge,
            weight = weight
        )
        Body(
            startDestination = startDestination,
            endDestination = endDestination,
            deliveryDate = deliveryDate,
            requestDeadline = requestDeadline,
            onFold = onFold
        )
    }
}





@Composable
fun Topbar(
    icon :  ImageVector ,
    serialNumber : String ,
    price : String,
    backgroundColor : Color = Color.Black
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(8.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )
        Text(
            text = serialNumber,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = price,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun Body(
    startDestination : String,
    endDestination : String,
    deliveryDate : String,
    requestDeadline : String,
    onFold : () -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Row {
            Box (
                modifier = Modifier.weight(1f)
            ){
                Detail(
                    title = "FROM",
                    value = startDestination
                )
            }
            Box (
                modifier = Modifier.weight(1f)
            ){
                Detail(
                    title = "FROM",
                    value = endDestination
                )
            }
        }

        Divider()

        Row{
            Box (
                modifier = Modifier.weight(1f)
            ){
                Detail(
                    title = "DELIVERY DATE",
                    value = deliveryDate
                )
            }
            Box (
                modifier = Modifier.weight(1f)
            ){
                Detail(
                    title = "REQUEST DEADLINE",
                    value = requestDeadline
                )
            }
        }

        Button(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            onClick = onFold,
            content = {
                Text(text = "CLOSE")
            }
        )
    }
}

@Preview
@Composable
private fun BodyPreview() {
    Body(
        startDestination = "RB Colive, 1st Kormangala, Bangalore, 100124",
        endDestination = "Colulu park , 2nd Kormangala, Bangalore, 100124",
        deliveryDate = "12th June 2021",
        requestDeadline = "10th June 2021"
    )
}

@Composable
fun Header(
    request : String,
    pledge : String,
    weight : String,
    backgroundImage : Int = R.drawable.bhavik_dalal_sqqazqvart0_unsplash
) {
   Box (
       modifier = Modifier
           .fillMaxWidth()
           .height(120.dp),
         contentAlignment = Alignment.BottomStart
   ){
        Image(
            painter = painterResource(id = backgroundImage),
            contentDescription = null,
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

       Row (
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween
       ){
           Detail(
               title = "REQUEST",
               value = request ,
               textColor = Color.White
           )
           Detail(
               title = "PLEDGE",
               value = pledge ,
               textColor = Color.White
           )
           Detail(
               title = "WEIGHT",
               value = weight ,
               textColor = Color.White
           )
       }
   }
}


@Preview
@Composable
private fun TicketUnfoldedPreview() {
    TicketUnfolded(
        serialNumber = "1",
        price = "$150",
        startDestination = "RB Colive, 1st Kormangala, Bangalore, 100124",
        endDestination = "Colulu park , 2nd Kormangala, Bangalore, 100124",
        deliveryDate = "12th June 2021",
        requestDeadline = "10th June 2021",
        request = "2",
        pledge = "$150",
        weight = "light"
    )
}

@Preview
@Composable
private fun HeaderPreview() {
    Header(
        request = "2",
        pledge = "$150",
        weight = "light"
    )
}

@Preview
@Composable
private fun TopbarPreview() {
    Topbar(
        icon = Icons.Default.Menu,
        serialNumber = "1",
        price = "$150"
    )
}