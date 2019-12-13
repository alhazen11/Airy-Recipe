package com.apps.airyrecipe.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.airyrecipe.abstraction.utils.state.LoaderState
import com.apps.airyrecipe.data.entity.Recipe
import com.apps.airyrecipe.data.entity.RecipeList
import com.apps.airyrecipe.data.repository.RecipeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val repository: RecipeRepository): ViewModel(), MainContract {
    override fun errorCache() {
        _error.postValue("cache time out")
    }

    override fun getRecipe(){
        _state.value = LoaderState.ShowLoading
        repository.getRecipe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { data ->
                        _repoData.postValue(filterSortByIngredient(data,"Chicken"))
                        _state.value = LoaderState.HideLoading
                    },
                    { e -> _error.postValue(e.toString()) }
                )
    }

    fun filterSortByIngredient(list:RecipeList,search:String):List<Recipe>{
        var listData =list.recipe.filter { it.ingredients.contains(search) }.sortedWith(compareBy({ it.rating })).asReversed()
        return listData
    }

    private val _repoData = MutableLiveData<List<Recipe>>()
    val repoData: LiveData<List<Recipe>>
        get() = _repoData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _state = MutableLiveData<LoaderState>()
    val state: LiveData<LoaderState>
        get() = _state

}