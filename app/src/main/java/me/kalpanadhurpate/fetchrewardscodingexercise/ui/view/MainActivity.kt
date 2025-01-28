package me.kalpanadhurpate.fetchrewardscodingexercise.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import me.kalpanadhurpate.fetchrewardscodingexercise.HiringItemList
import me.kalpanadhurpate.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsCodingExerciseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HiringItemList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
