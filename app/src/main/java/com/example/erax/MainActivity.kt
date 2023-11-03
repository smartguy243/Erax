package com.example.erax

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.erax.ui.theme.EraxTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EraxTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen(print("My Homescreen"))
            }
        }
    }

}

@Composable
fun HomeScreen(s: String) {
// instanced Object Notification
    val notifications = listOf<Notification>(
        Notification(
            contact = "Eraste",
            message = "Surtout n'abandonnes pas",
            "il y'a 6 min",
            Icons.Default.Face
        ),
        Notification(
            contact = "Bible",
            message = "Philippiens 4:13",
            "il y'a 10 min",
            Icons.Default.Email
        ),
        Notification(
            contact = "Frere Godson",
            message = "Je te donne 2 semaines, frère",
            "il y'a 16 min",
            Icons.Default.Face
        ),
        Notification(
            contact = "Papa",
            message = "Je compte beaucoup sur toi",
            "il y'a 21 min",
            Icons.Default.Face
        )

    )

//    Starting building the Home screen
    Box {

//    Background image
        Image(
            modifier = Modifier.fillMaxSize(),
            contentDescription = "fond d'ecran principal",
            painter = painterResource(id = R.mipmap.jesus),
            contentScale = ContentScale.FillHeight
        )

//    Date and Time on the Top
        Column(
            modifier = Modifier
                .padding(top = 70.dp, bottom = 30.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text (text = "Lundi 23 octobre",
                    fontSize = 20.sp,
                    color = Color.White,)

                Text(text = "12:30",
                    fontSize = 100.sp,
                    color = Color.White,
                   textDecoration = TextDecoration.None)
            }
//            Notifications
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                //Scrolling notifications area
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 7.dp)
                        .height(300.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(notifications) { notification ->
                        NotificationCard(notification)
                    }

                }
//                End of Notifications
                Spacer(modifier = Modifier.height(30.dp))

//                Bottom of the Home screen
                Row(
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.Default.Info,
                        contentDescription = "icon",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(text = "4 notifications", color = Color.White)
                    Image(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "icon",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }

    }
}

// Notifications appearance
@Composable
fun NotificationCard(notification: Notification) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(
                Color.Black.copy(alpha = 0.5f),
                shape = RoundedCornerShape(15.dp)
            )
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            shape = CircleShape,
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Image(
                imageVector = notification.icon,
                contentDescription = "profil"
            )
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = notification.contact,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = notification.time,
                    color = Color.White.copy(alpha = .5f)
                )
            }

            Text(text = notification.message, color = Color.White)
        }
    }
}

// Creating Notification class to store data
data class Notification (
    var contact: String,
    var message: String,
    var time: String,
    var icon: ImageVector
)

fun print(str: String): String = str
