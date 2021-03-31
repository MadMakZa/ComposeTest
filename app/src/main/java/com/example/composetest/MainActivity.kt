package com.example.composetest

import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.primary) {
                DefaultPreview()
            }
        }
    }
}

@Composable
fun NewsStory(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.egypt),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text("A day wandering through the sand hills " +
                "in Shark Fin Cove, and a few of the " +
                "sights I saw",
            style = typography.h6,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis)
        Text("Davenport, California")
        Text("December 2018")
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Counter()
    }
}
//превью функция для предварительного просмотра
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    NewsStory()
}

@Composable
fun Counter(){
    Column {
        val count = remember { mutableStateOf(0) }

        Divider(color = Color.Transparent, thickness = 32.dp)
        Button(onClick = { count.value++ }) {
            Text("Button clicked ${count.value} times")

        }
    }
}


