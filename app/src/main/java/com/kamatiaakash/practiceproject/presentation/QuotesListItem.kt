package com.kamatiaakash.practiceproject.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamatiaakash.practiceproject.domain.model.Quote

@Composable
fun QuotesListItem(quote : Quote,modifier: Modifier = Modifier) {

    Box(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth()
        .background(color = Color.DarkGray, shape = RoundedCornerShape(10.dp))

        ){
        Column(modifier = Modifier.fillMaxWidth().padding(7.dp)) {
            Text(text = quote.quote, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "~${quote.author}", fontStyle = FontStyle.Italic, fontWeight = FontWeight.SemiBold, fontSize = 18.sp, modifier = modifier.align(Alignment.End).padding(2.dp))
        }
    }

}