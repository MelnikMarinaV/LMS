package hse.diploma.cybersecplatform.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hse.diploma.cybersecplatform.R
import hse.diploma.cybersecplatform.ui.theme.CyberSecPlatformTheme
import hse.diploma.cybersecplatform.ui.theme.Typography

@Composable
fun SearchBar(
    searchQuery: TextFieldValue,
    enableFiltering: Boolean,
    onSearchQueryChange: (TextFieldValue) -> Unit,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(50.dp),
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(50.dp),
                    )
                    .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                tint = Color(0xFF5C5C5C),
                contentDescription = "Search Icon",
            )
            TextField(
                value = searchQuery,
                textStyle = Typography.bodySmall,
                onValueChange = onSearchQueryChange,
                modifier =
                    Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                colors =
                    TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_bar_label),
                        style = Typography.labelLarge,
                    )
                },
                singleLine = true,
            )
            if (enableFiltering) {
                Icon(
                    painter = painterResource(R.drawable.ic_filter),
                    tint = Color(0xFF5C5C5C),
                    contentDescription = "Filter Icon",
                    modifier = Modifier.padding(start = 8.dp).clickable(onClick = onFilterClick, enabled = true),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    CyberSecPlatformTheme {
        SearchBar(
            searchQuery = TextFieldValue(""),
            enableFiltering = true,
            onSearchQueryChange = {},
            onFilterClick = {},
        )
    }
}
