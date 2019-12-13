package com.apps.airyrecipe.data.repository

import com.apps.airyrecipe.data.entity.RecipeList
import io.reactivex.Observable

interface RecipeRepository {
    fun getRecipe(): Observable<RecipeList>

}