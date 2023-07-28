package com.fftools.youtube.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fftools.youtube.R
import com.fftools.youtube.ui.theme.YoutubeTheme
import com.fftools.youtube.viewmodels.RetrofitModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: RetrofitModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                HomeScreen()
            }
        }
        initMain()

    }

    private fun initMain() {
        setupData()
        setupListener()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.categoryUIDataSate.observe(this) {
            val dataState = it ?: return@observe
            dataState.result?.let {

            }
        }
    }

    private fun setupListener() {

    }

    private fun setupData() {
        viewModel.getCategories("snippet", "vi")
    }
}

@Composable
fun HomeScreen() {
    Column {
        BannerCompose()
        Spacer(modifier = Modifier.height(12.dp))
        SimpleButton()
        Spacer(modifier = Modifier.height(12.dp))

    }
}

@Composable
fun BannerCompose() {
    Image(
        painterResource(id = R.drawable.ic_color),
        contentDescription = null,
        modifier = Modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(size = 30.dp)
            )

    )
}


@Composable
fun SimpleButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {

        Icon(Icons.Default.ShoppingCart, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Click me",
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    YoutubeTheme {
        HomeScreen()
    }
}