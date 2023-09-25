package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sorabh.grabfood.ui.component.QNACard
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.QNAViewModel

@Composable
fun QNAScreen(viewModel: QNAViewModel) {
    QNAContent(viewModel = viewModel)
}

@Composable
fun QNAContent(viewModel: QNAViewModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(MaterialTheme.spacing.space16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space16)
    ) {
        items(viewModel.qna) { qna ->
            QNACard(
                modifier = Modifier.fillMaxWidth(),
                qnaData = qna
            )
        }
    }
}