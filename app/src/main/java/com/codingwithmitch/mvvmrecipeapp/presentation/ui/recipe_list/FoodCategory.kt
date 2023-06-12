package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

enum class FoodCategory(val value:String) {
    CHICKEN("chicken"),
    BEEF("beef"),
    SOUP("soup"),
    DESSERT("dessert"),
    VEGETARIAN("vegetarian"),
    MILK("milk"),
    VEGAN("vegan"),
    PIZZA("pizza"),
    DONUT("donut"),
}
fun getAllFoodCategories():List<FoodCategory>{
    return listOf(
        FoodCategory.CHICKEN,
        FoodCategory.BEEF,
        FoodCategory.SOUP,
        FoodCategory.DESSERT,
        FoodCategory.VEGETARIAN,
        FoodCategory.MILK,
        FoodCategory.VEGAN,
        FoodCategory.PIZZA,
        FoodCategory.DONUT
    )
}
//we have list of string values , will map them to the original list of enums
//then get the enum that has string value equal the one passed
fun getFoodCategory(value: String):FoodCategory?{
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}