package me.kalpanadhurpate.fetchrewardscodingexercise.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem
import me.kalpanadhurpate.fetchrewardscodingexercise.repository.HiringRepository
import me.kalpanadhurpate.fetchrewardscodingexercise.util.NetworkResult
import javax.inject.Inject

@HiltViewModel
class HiringViewModel @Inject constructor(private val repository: HiringRepository) : ViewModel() {

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