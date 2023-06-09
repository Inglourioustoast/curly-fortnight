package com.example.seniorcitizenrumble

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorcitizenrumble.ui.theme.SeniorCitizenRumbleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SeniorCitizenRumbleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AlbumList(listOf(Album("fleetwood Mac", "one album"), Album("Led Zepplin", "Another album")))
                }
            }
        }
        setContentView(R.layout.activity_main)
    }

    data class Album(val artist:String, val name: String)

    @Composable
    fun AlbumList(albums: List<Album>) {
        LazyColumn{
            items(albums) { album ->
                MessageCard(album)
            }
        }
    }

    @Composable
    fun MessageCard(album: Album) {
        Row(modifier = Modifier.padding(all = 8.dp))
        {
            Image(
                painter = painterResource(R.drawable._600w_1nr6gsundkw),
                contentDescription = "no description",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    .clip(CircleShape)
                    // Clip image to be shaped as a circle
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = album.artist,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {


                    Text(
                        text = album.name,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }


    @Preview(name = "Full Preview",
        showSystemUi = true,
        showBackground = true,)
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        showSystemUi = true,
        name = "dark Mode"
    )
    @Composable
    fun PreviewGreeting() {
        SeniorCitizenRumbleTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            AlbumList(listOf(Album("fleetwood Mac", "one album"), Album("Led Zepplin", "Another album")))
        }
    }
    }
}