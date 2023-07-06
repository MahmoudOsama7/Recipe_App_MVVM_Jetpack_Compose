package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codingwithmitch.mvvmrecipeapp.presentation.BaseApplication
import com.codingwithmitch.mvvmrecipeapp.presentation.components.CircularIndeterminateProgressBar
import com.codingwithmitch.mvvmrecipeapp.presentation.components.RecipeView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RecipeFragment:Fragment() {

    private var recipeId:MutableState<Int?> = mutableStateOf(null)
    private val viewModel:RecipeViewModel by viewModels()
    @Inject
    lateinit var application:BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("recipeId")?.let { recipeId->
            this.recipeId.value=recipeId

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                LaunchedEffect(Unit){
                    recipeId.value?.let { viewModel.getRecipe(it)}
                }

                val loading = viewModel.loading.value
                val recipe=viewModel.recipe.value
                val scaffoldState= rememberScaffoldState()
                Scaffold(
                    scaffoldState=scaffoldState
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ){
                        if(loading && recipe==null)
                            Text(text = "Loading...")
                        else
                            recipe?.let {recipe->
                                RecipeView(recipe = recipe)
                            }
                    }
                    CircularIndeterminateProgressBar(isDisplayed = loading)
                }
            }
        }
    }
}