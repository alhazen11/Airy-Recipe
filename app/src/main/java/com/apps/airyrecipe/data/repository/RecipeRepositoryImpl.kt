package com.apps.airyrecipe.data.repository

import com.apps.airyrecipe.data.entity.RecipeList
import com.apps.airyrecipe.data.services.NetworkServices
import io.reactivex.Observable
import javax.inject.Inject

class RecipeRepositoryImpl  @Inject constructor(
        private val service: NetworkServices
): RecipeRepository {
    override fun getRecipe(): Observable<RecipeList> {
        return service.getRecipe()
    }
}