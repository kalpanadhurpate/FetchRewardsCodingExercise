package me.kalpanadhurpate.fetchrewardscodingexercise.repository

import me.kalpanadhurpate.fetchrewardscodingexercise.api.ApiService
import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem
import me.kalpanadhurpate.fetchrewardscodingexercise.util.NetworkResult

class HiringRepository(private val apiService: ApiService) {
    suspend fun fetchItems(): NetworkResult<List<HiringListItem>> {
        return try {
            val response = apiService.fetchItems()
            // Display all the items grouped by "listId"
            // Sort the results first by "listId" then by "name" when displaying.
            // Filter out any items where "name" is blank or null.
            val filteredResponse = response.filter { !it.name.isNullOrBlank() }
                .sortedWith(compareBy<HiringListItem> { it.listId }.thenBy { it.name })
            NetworkResult.Success(filteredResponse)

        } catch (e: Exception) {
            NetworkResult.Error("Failed to fetch items")

        }
    }
}