package me.kalpanadhurpate.fetchrewardscodingexercise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem
import me.kalpanadhurpate.fetchrewardscodingexercise.util.NetworkResult

@Composable
fun HiringList(modifier: Modifier, viewModel: HiringViewModel = viewModel()) {
    val hiringResponse = viewModel.listOfItems.observeAsState(NetworkResult.Loading)
    when (hiringResponse.value) {
        is NetworkResult.Error -> {
            ErrorScreen(hiringResponse.value as NetworkResult.Error)
        }

        NetworkResult.Loading -> {
            LoadingScreen()
        }

        is NetworkResult.Success -> {
            val items = (hiringResponse.value as NetworkResult.Success<List<HiringListItem>>).data
            ShowList(modifier, items)
        }
    }
}

@Composable
fun ShowList(modifier: Modifier, hiringResponse: List<HiringListItem>) {
    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Hiring List", style = MaterialTheme.typography.labelLarge, fontSize = 20.sp)
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            items(hiringResponse) { item ->
                HiringItemView(item,modifier)
            }

        }
    }

}

@Composable
fun HiringItemView(item: HiringListItem,modifier: Modifier) {
    Card(modifier = Modifier.fillMaxSize().padding(4.dp)) {
        Text(modifier = Modifier.padding(4.dp),
        text = "List ID :${item.listId}   Name :${item.name}",
        style = MaterialTheme.typography.bodyLarge
    ) }


}

@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(value: NetworkResult.Error) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Error: $value")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}
