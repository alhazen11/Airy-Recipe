package com.apps.airyrecipe.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeList(@Expose @SerializedName("recipe") val recipe: List<Recipe>)