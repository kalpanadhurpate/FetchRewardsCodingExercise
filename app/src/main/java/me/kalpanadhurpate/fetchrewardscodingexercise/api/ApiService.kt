package me.kalpanadhurpate.fetchrewardscodingexercise.api

import me.kalpanadhurpate.fetchrewardscodingexercise.hiringListItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
@GET("hiring.json")
suspend fun getItems():Result<hiringListItem>

}