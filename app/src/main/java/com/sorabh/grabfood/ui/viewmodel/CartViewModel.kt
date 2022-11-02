package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getOderConfirmationUseCase: GetOderConfirmationUseCase,
    private val localDBRepository: LocalDBRepository
) : ViewModel() {
    private val _oderConfirmationFlow: MutableStateFlow<Result<OderConfirmation>> =
        MutableStateFlow(
            Result.Loading()
        )
    val oderConfirmationFlow: StateFlow<Result<OderConfirmation>> = _oderConfirmationFlow

    private val _menuFlow:MutableStateFlow<List<Menu>> = MutableStateFlow(emptyList())
    val menuFlow:StateFlow<List<Menu>> = _menuFlow

    init {
        viewModelScope.launch { getMenu() }
    }
    fun placeOder(oderPostModel: OderPostModel) {
        viewModelScope.launch {
            getOderConfirmationUseCase(oderPostModel).collect {
                when (it) {
                    is Result.Error -> _oderConfirmationFlow.emit(it)
                    is Result.Loading -> _oderConfirmationFlow.emit(it)
                    is Result.Success -> _oderConfirmationFlow.emit(it)
                }
            }
        }
    }

    suspend fun deleteMenu(menu: Menu):Boolean {
       val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.deleteMenu(menu)
            isMenuSaved(menu.id)
        }
        return !result.await()
    }

    suspend fun isMenuSaved(id:String):Boolean{
      val result =  CoroutineScope(Dispatchers.IO).async {
            localDBRepository.getMenuItem(id)
        }
        return result.await() > 0
    }

   private suspend fun getMenu(){
        CoroutineScope(Dispatchers.IO).launch {
            localDBRepository.getMenuList().collect{
                _menuFlow.emit(it)
            }
        }
    }

}