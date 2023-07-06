package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.mvvmrecipeapp.presentation.components.CircularIndeterminateProgressBar
import com.codingwithmitch.mvvmrecipeapp.presentation.components.RecipeCard
import com.codingwithmitch.mvvmrecipeapp.presentation.components.RecipeList
import com.codingwithmitch.mvvmrecipeapp.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment:Fragment() {
    private val viewModel:RecipeListViewModel by viewModels()
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes=viewModel.recipes.value
                val query=viewModel.query.value
                val selectedCategory=viewModel.selectedCategory.value
                val loading =viewModel.loading.value
                val keyboardController = LocalSoftwareKeyboardController.current
                //we can use Scaffold or not , scaffold is important if your app have many layouts as bottom , top , navDrawer and so on
                Scaffold(
                    topBar = {
                        SearchAppBar(
                            query = query,
                            onQueryChanged =viewModel::onQueryChanged ,
                            onExecuteSearch =  viewModel::newSearch ,
                            keyboardController = keyboardController,
                            selectedCategory = selectedCategory,
                            scrollPosition =viewModel.categoryScrollPositionInt ,
                            onSelectedCategoryChanged =viewModel::onSelectedCategoryChanged ,
                            onChangeCategoryScrollPosition =viewModel::onChangeCategoryScrollPosition
                        )
                    },
                    bottomBar = {
                        MyBottomBar()
                    },
                    drawerContent = {

                    }
                ) {
                    RecipeList(
                        loading = loading,
                        recipes = recipes,
                        onChangeRecipeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                        nextPage = viewModel::nextPage,
                        navController = findNavController()
                    )
                }
            }
        }
    }
}


@Composable
fun MyBottomBar(){
    BottomNavigation(
        elevation = 12.dp
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                imageVector = Icons.Filled.BrokenImage,
                contentDescription = ""
            )},
            selected =false ,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )},
            selected =true ,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountBalanceWallet,
                    contentDescription = ""
                )},
            selected =false ,
            onClick = {}
        )
    }
}
