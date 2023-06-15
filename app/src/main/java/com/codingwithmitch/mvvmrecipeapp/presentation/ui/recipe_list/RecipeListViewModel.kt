package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


const val PAGE_SIZE=30


@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeListUseCase: RecipeListUseCase,
):ViewModel() {

    val recipes:MutableState<List<Recipe>> = mutableStateOf(listOf())
    val query= mutableStateOf("Chicken")
    val selectedCategory:MutableState<FoodCategory?> = mutableStateOf(null)
    var categoryScrollPositionInt=0
    val loading = mutableStateOf(false)
    val page= mutableStateOf(1)
    private var recipeListScrollPosition=0

    init {
        newSearch()
    }

    fun newSearch(){
        viewModelScope.launch {
            loading.value=true
            resetSearchState()
            delay(1000)
            val result = recipeListUseCase.search(
                page = 1,
                query=query.value
            )
            recipes.value=result
            loading.value=false
        }
    }



    fun nextPage(){
        if((recipeListScrollPosition+1)>=(page.value* PAGE_SIZE))
        viewModelScope.launch {
            //the issue with this code that it will keep calling the code inside , leading to continuously calling the api to get hundreds of pages
            //to stop this we put condition that , position that the user stands must be greater or equal the number of pages multiplied by page size
            //in other word , user stands in position 55 , this means page 2 , so we load page 3 if the position that user stands at "55" is greater than or equal "2x30=60" so
            //if 55 is greater than or equal 60 , load the page ,which is incorrect , the value must be 60 to load the next page and at that case the position must be 60 "position of last item is 59 and we add 1"
                loading.value=true
                incrementPage()
                delay(1000)
                if(page.value>1){
                    val newRecipeList=recipeListUseCase.search(
                        page=page.value,
                        query=query.value
                    )
                    appendRecipes(newRecipeList)
                }
                loading.value=false
        }
    }



    private fun appendRecipes(recipe: List<Recipe>){
        //getting old list
        val current=ArrayList(this.recipes.value)
        //add new list got from api to old list
        current.addAll(recipe)
        this.recipes.value=current
    }

    private fun incrementPage(){
        page.value=page.value+1
    }
    fun onChangeRecipeScrollPosition(position: Int){
        recipeListScrollPosition=position
    }


    fun onQueryChanged(query:String){
        this.query.value=query
    }

    fun onChangeCategoryScrollPosition(position: Int){
        categoryScrollPositionInt=position
    }

    fun onSelectedCategoryChanged(category: String){
        val newCategory= getFoodCategory(category)
        //if nothing is selected
        if(selectedCategory.value==null)
            selectedCategory.value=newCategory
//        //if the same value is selected
        else if (selectedCategory.value?.value==category)
            selectedCategory.value=null
        //if different value is selected
        else
            selectedCategory.value=newCategory
        onQueryChanged(category)
    }

    private fun clearSelectedCategory(){
        selectedCategory.value=null
    }
    private fun resetSearchState(){
        recipes.value= listOf()
        page.value=1
        onChangeRecipeScrollPosition(0)
        if (selectedCategory.value?.value!=query.value)
            clearSelectedCategory()
    }
}