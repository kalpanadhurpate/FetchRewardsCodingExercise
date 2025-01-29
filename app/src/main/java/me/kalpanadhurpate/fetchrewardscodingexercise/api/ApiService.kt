package me.kalpanadhurpate.fetchrewardscodingexercise.api

import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    suspend fun getItems(): List<HiringListItem>

}