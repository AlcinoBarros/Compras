package com.alcinojose.compras.ui.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alcinojose.compras.ui.feature.Compras
import com.alcinojose.compras.domain.Todo
import com.alcinojose.compras.domain.todo1
import com.alcinojose.compras.domain.todo2

@Composable
fun TodoItem(
    todo: Todo,
    onCompletedChange: (Boolean) -> Unit = {},
    onItemClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    modifier: Modifier = Modifier) {


    Surface(
        onClick = onItemClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 1.dp,
        color = MaterialTheme.colorScheme.outline,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
    ){
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                checked = todo.isCompleted,
                onCheckedChange = onCompletedChange,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column (
                modifier = Modifier
                    .weight(1f),
            ){
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleMedium

                )

                todo.description?.let {

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = todo.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onDeleteClick,
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }

}

@Preview
@Composable
private fun TodoItemPreview() {
    Compras{
        TodoItem(
            todo = todo1,
            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {},
        )
    }

}

@Preview
@Composable
private fun TodoItemCompletedPreview() {
    Compras{
        TodoItem(
            todo = todo2,

            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {},
        )
    }

}