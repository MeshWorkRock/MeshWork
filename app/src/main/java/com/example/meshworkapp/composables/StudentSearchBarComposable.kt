package com.example.meshworkapp

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

// Search Bar Composable For Student List Screen
// It Contain ViewModel Of Type SearchViewModel
// Contains TextField With Search Icon(LeadingIcon), Cross Icon(TrailingIcon)
@Composable
fun StudentSearchBarComposable(
    viewModel: StudentViewModel, modifier: Modifier
) {
    var query: String by rememberSaveable { mutableStateOf("") }
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (query.isEmpty())
        showClearIcon = false
    else if (query.isNotEmpty())
        showClearIcon = true

    // Takes Text From User, Store in query
    TextField(
        value = query,
        onValueChange = { onQueryChanged ->
            query = onQueryChanged
            if (onQueryChanged.isNotEmpty()) {
                viewModel.performQuery(onQueryChanged)
            } else {
                viewModel.performQuery(onQueryChanged)
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "Search Icon",
            )
        },
        trailingIcon = {
            if (showClearIcon) {
                IconButton(
                    onClick = {
                        query = ""
                        viewModel.performQuery(query)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = "Clear Icon"
                    )
                }
            }
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
//        placeholder = { Text(text = "Search Student") },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = modifier
    )


}

@Composable
fun StudentListTopBar(className: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Student List",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.Bold
//            color = Color.White
        )
        Box(
            modifier = Modifier.fillMaxSize()
//                .background(Color.Red),
        ) {
            Text(
                text = className,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.BottomEnd)
                //            color = Color.White
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopMenuPreview() {
    StudentListTopBar("22BSc - 1")
}
