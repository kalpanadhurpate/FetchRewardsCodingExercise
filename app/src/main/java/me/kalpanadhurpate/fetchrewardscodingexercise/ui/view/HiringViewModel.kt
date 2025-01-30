package me.kalpanadhurpate.fetchrewardscodingexercise.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.kalpanadhurpate.fetchrewardscodingexercise.api.RetrofitInstance
import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem
import me.kalpanadhurpate.fetchrewardscodingexercise.repository.HiringRepository
import me.kalpanadhurpate.fetchrewardscodingexercise.util.NetworkResult

class HiringViewModel : ViewModel() {
    private val apiService = RetrofitInstance.retrofit
    private val repository=HiringRepository(apiService)

    private val _listOfItems = MutableLiveData<NetworkResult<List<HiringListItem>>>()
    val listOfItems: LiveData<NetworkResult<List<HiringListItem>>> = _listOfItems

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            val response = repository.fetchItems()
            _listOfItems.value = response
            println("response$response")
        }


    }

}