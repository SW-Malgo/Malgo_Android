package com.example.swmalgo.ui.uploadgroup

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


data class UploadImageUiState(
    val name: String = "",
    val tag: String = "",
    val content: String = "",
    val imageList: List<Uri> = emptyList(),
    val tagList: List<String> = emptyList()
)

@HiltViewModel
class UploadViewModel @Inject constructor(

) : ViewModel() {

    private val _name = MutableStateFlow("")
    private val _tag = MutableStateFlow("")
    private val _content = MutableStateFlow("")
    private val _imageList = MutableStateFlow(emptyList<Uri>())
    private val _tagList = MutableStateFlow(emptyList<String>())

    val uiState = combine(
        _name, _tag, _content, _imageList, _tagList
    ) { it ->
        UploadImageUiState(
            name = it[0] as String,
            tag = it[1] as String,
            content = it[2] as String,
            imageList = it[3] as List<Uri>,
            tagList = it[4] as List<String>
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UploadImageUiState())

    fun updateName(name: String) {
        _name.value = name
    }

    fun updateTag(tag: String) {
        _tag.value = tag
    }

    fun updateContent(content: String) {
        _content.value = content
    }

    fun updateImageList(imageList: List<Uri>) {
        _imageList.value = imageList
    }

    fun updateTagList(tagList: List<String>) {
        _tagList.value = tagList
    }

    fun addTag(tag: String) {
        _tagList.value = _tagList.value + tag
    }

    fun addImage(image: Uri) {
        _imageList.value = _imageList.value + image
    }

    fun removeImage(image: Uri) {
        _imageList.value = _imageList.value - image
    }

}