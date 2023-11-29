package com.common.api.data.android.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.common.api.data.android.MyApplicationTheme
import com.common.api.data.android.ui.screens.cat.*
import com.common.api.data.android.ui.screens.post.*
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel: PostViewModel by inject()
    private val catViewModel: CatViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val response = viewModel.postResponse.value
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //PostScreen(response)
                    CatScreen(viewModel = catViewModel)
                }
            }
        }
    }
}
