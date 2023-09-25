package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.component.CartCard
import com.sorabh.grabfood.ui.component.EmptySection
import com.sorabh.grabfood.ui.component.OderPlaceBottomSheet
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.CartViewModel
import kotlinx.coroutines.launch

@Composable
fun CartScreen(viewModel: CartViewModel) {
    CartContent(viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartContent(viewModel: CartViewModel) {
    val menus = viewModel.menuFlow.collectAsStateWithLifecycle().value
    val isOrderPlaced = viewModel.oderConfirmationFlow.collectAsStateWithLifecycle().value
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(isOrderPlaced) {
        if (isOrderPlaced is Result.Success)
            sheetState.show()
    }

    if (sheetState.isVisible)
        ModalBottomSheet(
            onDismissRequest = {
                if (sheetState.hasExpandedState)
                    coroutineScope.launch {
                        sheetState.hide()
                    }
            }, sheetState = sheetState,
            modifier = Modifier.fillMaxSize()
        ) {
            OderPlaceBottomSheet(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = MaterialTheme.spacing.space16),
                isOderPlaced = isOrderPlaced is Result.Success,
                onOkayBtnClicked = {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                }
            )
        }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(MaterialTheme.spacing.space16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space16)
    ) {
        if (menus.isEmpty())
            item {
                EmptySection(modifier = Modifier.fillMaxWidth())
            }
        else
            items(menus) { menu ->
                CartCard(
                    modifier = Modifier.fillMaxWidth(),
                    menu = menu,
                    onBtnPlaceOrderClicked = viewModel::placeOrder
                )
            }
    }
}

