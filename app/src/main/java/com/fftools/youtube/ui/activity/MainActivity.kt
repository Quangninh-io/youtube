package com.fftools.youtube.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fftools.youtube.ui.theme.YoutubeTheme
import com.fftools.youtube.viewmodels.RetrofitModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: RetrofitModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoutubeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YoutubeTheme {
        Greeting("Android")
    }
}