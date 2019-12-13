package com.apps.airyrecipe.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Recipe (
        @Expose @SerializedName("name") val name: String,
        @Expose @SerializedName("creator") val creator: String,
        @Expose @SerializedName("review") val review: String,
        @Expose @SerializedName("rating") val rating: String,
        @Expose @SerializedName("image") val image: String,
        @Expose @SerializedName("ingredients") val ingredients: List<String>
        )