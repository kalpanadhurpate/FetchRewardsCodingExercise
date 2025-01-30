package me.kalpanadhurpate.fetchrewardscodingexercise.api

import me.kalpanadhurpate.fetchrewardscodingexercise.model.HiringListItem
import retrofit2.http.GET

interface NetworkService {
    @GET("hiring.json")
    suspend fun hiringService(): List<HiringListItem>

}