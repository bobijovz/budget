package com.bobijovz.kalupi.presentation.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobijovz.domain.interactor.GetActivities
import com.bobijovz.domain.interactor.GetCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ActivitiesViewModel(val getCategories: GetCategories, val getActivities: GetActivities) : ViewModel() {

    private val mActivityModel = MutableStateFlow(emptyList<ActivityModel>())
    private val mCategoryModel = MutableStateFlow(emptyList<CategoryModel>())
    val activityModel: StateFlow<List<ActivityModel>> = mActivityModel
    val categoryModel: StateFlow<List<CategoryModel>> = mCategoryModel


    fun loadActivities() {
        viewModelScope.launch(Dispatchers.IO) {
            getActivities.execute().collect { activities ->
                mActivityModel.value = activities.map {
                    ActivityModel(
                        id = it.id,
                        category = it.categoryId,
                        description = it.description,
                        price = it.price,
                        timestamp = it.timestamp
                    )
                }
            }
        }
    }
}