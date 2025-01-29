package me.kalpanadhurpate.fetchrewardscodingexercise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem

@Composable
fun HiringItemList(modifier: Modifier, viewModel: HiringViewModel = viewModel()) {
// val viewModel: HiringViewModel = viewModel()
    val hiringResponse = viewModel.listOfItems.observeAsState()
    //hiringResponse.value?.let { ShowList(it) }
    hiringResponse.value?.let { ShowList(modifier, it) }


}

@Composable
fun ShowList(modifier: Modifier, hiringResponse: List<HiringListItem>) {
    Column(
        modifier.fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Item List")
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(hiringResponse) { item ->
                println("name is: $item")
                Text(text = item.name)

            }

        }
    }

}