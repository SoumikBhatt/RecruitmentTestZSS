package com.soumik.zsrecruitmenttest.data.models

import com.google.gson.annotations.SerializedName


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

data class DashboardResponse(
    @SerializedName("results")
    val results: Results
)

data class Results(
    @SerializedName("resources")
    val resources: List<Resources>
)

data class Resources(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("event")
    val event: Event,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("uploaded")
    val uploaded: String,
    @SerializedName("video")
    val video: String
)

data class Event(
    @SerializedName("end_event")
    val endEvent: String,
    @SerializedName("start_event")
    val startEvent: String,
    @SerializedName("title")
    val title: String
)

data class Owner(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("primary_team")
    val primaryTeam: String,
    @SerializedName("username")
    val username: String
)
