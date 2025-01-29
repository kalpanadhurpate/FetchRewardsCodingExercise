package me.kalpanadhurpate.fetchrewardscodingexercise.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.kalpanadhurpate.fetchrewardscodingexercise.api.RetrofitInstance
import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem

class HiringViewModel : ViewModel() {
    private val apiService = RetrofitInstance.retrofit
    private val _listOfItems = MutableLiveData<List<HiringListItem>>()
    val listOfItems: LiveData<List<HiringListItem>> = _listOfItems

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            val response = apiService.getItems()
            _listOfItems.value = response
            println("response$response")
        }


    }

}