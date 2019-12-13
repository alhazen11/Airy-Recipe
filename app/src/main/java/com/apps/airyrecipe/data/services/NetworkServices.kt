package  com.apps.airyrecipe.data.services

import com.apps.airyrecipe.data.entity.RecipeList
import io.reactivex.Observable
import retrofit2.http.*

interface NetworkServices {
    @GET("bins/171v5n")
    fun getRecipe(): Observable<RecipeList>
}