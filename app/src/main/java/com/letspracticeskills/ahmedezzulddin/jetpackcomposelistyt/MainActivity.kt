package com.letspracticeskills.ahmedezzulddin.jetpackcomposelistyt

import android.os.Bundle
import android.widget.GridView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil


val iconsItem = listOf(
    Icons.Filled.Check,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.Delete,
    Icons.Filled.Home,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.ThumbUp,
    Icons.Filled.Call

    )

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            MyColumnScrolling(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .verticalScroll(rememberScrollState())
//            )
//
//            MyRowScrolling(modifier = Modifier.horizontalScroll(rememberScrollState()))

//            LazyVerticalGrid(
//                cells = GridCells.Adaptive(88.dp)
//                , content = {
//                    items (myItems) { item ->
//                        GridIcon(item)
//                    }
//                }
//            )

            //MyList()

            GridView(columnCount = 3)


        }
    }
}

data class IconResource(val imageVector: ImageVector, val isVisible: Boolean)

@Composable
fun GridView(columnCount: Int) {

    val itemSize = iconsItem.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    val gridItems = mutableListOf<List<IconResource>>()

    var position = 0

    for (i in 0 until rowCount){
        val rowItem = mutableListOf<IconResource>()
        for (j in 0 until columnCount){
            if (position.inc() <= itemSize){
                rowItem.add(IconResource(iconsItem[position++], true))
            }
        }

        val itemToFill = columnCount - rowItem.size
        for (z in 0 until itemToFill){
            rowItem.add(IconResource(Icons.Filled.Done, false))
        }

        gridItems.add(rowItem)
    }

    LazyColumn (modifier = Modifier.fillMaxSize()){
        items(gridItems) { item ->
            RowItem(rowItem = item)
        }
    }

}

@Composable
fun RowItem(rowItem: List<IconResource>) {
    Row {
       for (element in rowItem) {
           GridIcon(myIcons = element)
       }
    }
}

@Composable
fun RowScope.GridIcon(myIcons: IconResource) {
    
    val color = if (myIcons.isVisible) colorResource(id = R.color.purple_200)
    else Color.Transparent

    Icon(
        modifier = Modifier
            .size(72.dp)
            .weight(1f)
            .padding(4.dp),
        imageVector = myIcons.imageVector,
        tint = color,
        contentDescription = "My Icons",
    )
}


//@Composable
//fun GridIcon(myIcons: MyIcons) {
//    Image(
//        modifier = Modifier
//            .size(72.dp)
//            .padding(4.dp),
//        painter = painterResource(id = myIcons.icon),
//        contentDescription = "My Icons"
//    )
//}


@Composable
fun MyColumnScrolling(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "What is Lorem Ipsum?\n" +
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            fontSize = 22.sp,
            color = Color.Black
        )

        Text(
            text = "Where can I get some?\n" +
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
            fontSize = 22.sp,
            color = Color.Black
        )
    }
}


@Composable
fun MyRowScrolling(modifier: Modifier) {

    Row(modifier = modifier) {
        Text(
            text = "What is Lorem Ipsum?\n" +
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            fontSize = 22.sp,
            color = Color.Black
        )

        Text(
            text = "Where can I get some?\n" +
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
            fontSize = 22.sp,
            color = Color.Black
        )
    }
}

@Composable
fun MyList() {

    LazyColumn {

        items(myItems) {

            ListItem(it)
        }
    }

}


val myItems = listOf(
    MyIcons(R.drawable.calendar_1, "Calendar"),
    MyIcons(R.drawable.camera_1, "Camera"),
    MyIcons(R.drawable.clock_1, "Clock"),
    MyIcons(R.drawable.facebook_messenger_1, "Facebook"),
    MyIcons(R.drawable.instagram_1, "Instagram"),
    MyIcons(R.drawable.mail_1, "Mail"),
    MyIcons(R.drawable.maps_weather_1, "Maps_Weather"),
    MyIcons(R.drawable.messages_1, "Messages"),
    MyIcons(R.drawable.music_spotify_1, "Music Spotify"),
    MyIcons(R.drawable.notes_1, "Notes"),
    MyIcons(R.drawable.phone_1, "Phone"),
    MyIcons(R.drawable.photos_1, "Photos"),
    MyIcons(R.drawable.settings_1, "Settings"),
    MyIcons(R.drawable.twitter_1, "Twitter"),
    MyIcons(R.drawable.weather_1, "Weather"),
)

@Composable
fun ListItem(myIcons: MyIcons) {

    Row {

        Image(
            painter = painterResource(id = myIcons.icon),
            modifier = Modifier
                .size(72.dp)
                .padding(4.dp),
            contentDescription = "My Icons"
        )

        Text(
            text = myIcons.name,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically),
            color = Color.Blue,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}


@Composable
fun Title() {

    Row {

        Text(
            text = "My Icons Below")
    }

}

data class MyIcons(val icon: Int, val name: String)
