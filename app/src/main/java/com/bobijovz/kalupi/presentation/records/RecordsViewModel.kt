package com.bobijovz.kalupi.presentation.records

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobijovz.domain.interactor.GetRecords
import com.bobijovz.domain.interactor.GetCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecordsViewModel(val getCategories: GetCategories, val getRecords: GetRecords) : ViewModel() {

    private val mRecordModel = MutableStateFlow(emptyList<RecordModel>())
    private val mCategoryModel = MutableStateFlow(emptyList<CategoryModel>())
    val recordModel: StateFlow<List<RecordModel>> = mRecordModel
    val categoryModel: StateFlow<List<CategoryModel>> = mCategoryModel


    fun loadActivities() {
        viewModelScope.launch(Dispatchers.IO) {
            getRecords.execute().collect { activities ->
                mRecordModel.value = activities.map {
                    RecordModel(
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