package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.component.OrderHistoryCard
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel

@Composable
fun OderHistoryScreen(modifier: Modifier,viewModel: OderHistoryVieModel) {
    OderHistoryContent(modifier = modifier,viewModel = viewModel)
}

@Composable
private fun OderHistoryContent(modifier: Modifier,viewModel: OderHistoryVieModel) {
    val oderHistory = viewModel.oderHistoryFlow.collectAsStateWithLifecycle().value
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(MaterialTheme.spacing.space16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space16)
    ) {
        when (oderHistory) {
            is Result.Error -> {}
            is Result.Loading -> {}
            is Result.Success -> items(oderHistory.body?.data?.data ?: emptyList()) { bill ->
                OrderHistoryCard(modifier = Modifier.fillMaxWidth(), bill = bill)
            }
        }
    }
}