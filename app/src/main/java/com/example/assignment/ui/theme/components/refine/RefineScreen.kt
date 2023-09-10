package com.example.assignment.ui.theme.components.refine

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment.R
import com.example.assignment.data.Tag
import com.example.assignment.data.tags
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.ui.theme.Screen
import com.example.assignment.ui.theme.blue100
import com.example.assignment.ui.theme.blue200
import com.example.assignment.ui.theme.gray100
import com.example.assignment.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RefineScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
   Scaffold(
       topBar = {
           TopAppBar(
               title = {
                   Text(
                       text = "Refine",
                       color = white,
                       fontSize = 24.sp,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(start = 24.dp)
                   )
               },
               navigationIcon = {
                   Icon(
                       painter = painterResource(id = R.drawable.back),
                       contentDescription =  null,
                       tint = white,
                       modifier = Modifier
                           .padding(start = 12.dp, top = 4.dp, bottom = 4.dp)
                           .size(24.dp)
                           .clickable { navController.navigate(Screen.ExploreScreen.route) }
                   )
               },
               modifier = Modifier.background(blue200),
               colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = blue200)
           )
       }
   ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            SectionTitle(text = "Select Your Availability")
            Spacer(modifier = Modifier.height(8.dp))
            DropDownMenu()
            Spacer(modifier = Modifier.height(16.dp))
            SectionTitle(text = "Add Your Status")
            Spacer(modifier = Modifier.height(8.dp))
            StatusTextField()
            SectionTitle(text = "Select Hyper Local Distance")
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                DistancePicker()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1 Km",
                        color = blue200,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "100 Km",
                        color = blue200,
                        fontSize = 12.sp
                    )
                }
            }
            SectionTitle(text = "Select Purpose")
            Spacer(modifier = Modifier.height(6.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ){
                tags.forEach{tag ->
                    TagItem(tag = tag)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = blue200,
                        contentColor = white
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp , vertical = 8.dp),
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(
                        text = "Save & Explore",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
   }
}

@Composable
fun SectionTitle(
    text: String
) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = blue200
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    modifier:Modifier = Modifier
) {
    var selectedText by remember {
        mutableStateOf("Available | Hey Let Us Connect")
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val options = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do Not Disturb | I Will Catch Up Later",
        "SOS | Emergency! Need Assistance! HELP"
    )

    Column {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {selectedText = it},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = blue200,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { isExpanded = !isExpanded }
                )
            },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15),
            textStyle = TextStyle(
                color = blue200,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false},
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            options.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = label
                        isExpanded = false
                    },
                    text = {
                        Text(
                            text = label,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            overflow = TextOverflow.Ellipsis,
                            color = blue200
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusTextField(
    modifier: Modifier = Modifier
) {
    var status by remember {
        mutableStateOf("Hi Community! I am open to new connections")
    }

    Column {
        OutlinedTextField(
            value = status,
            onValueChange = { status = it },
            maxLines = 7,
            singleLine = false,
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = blue200,
                fontWeight = FontWeight.Normal
            ),
            modifier = modifier
                .height(150.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15),
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "${status.length}/250",
            color = blue200,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 4.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistancePicker(
    modifier: Modifier = Modifier
) {
    var distance by remember {
        mutableFloatStateOf(50f)
    }
    Slider(
        value = distance,
        onValueChange = { distance = it},
        valueRange = 1f..100f,
        steps = 100,
        enabled = true,
        colors = SliderDefaults.colors(
            thumbColor = blue100,
            activeTrackColor = blue100,
            inactiveTrackColor = gray100
        ),
        modifier = modifier,
        thumb = {
            Box{
                Icon(
                    painter = painterResource(id = R.drawable.indicator),
                    contentDescription = null,
                    tint = blue100,
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .size(65.dp)
                )
                Text(
                    text = distance.toInt().toString(),
                    color = white,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 21.dp, top = 5.dp)
                )
            }
        }
    )
}

@Composable
fun TagItem(
    tag: Tag
) {
    val len = tag.text.length
    Box(
        modifier = Modifier.padding(8.dp)
    ){
        Box(
            modifier = Modifier
                .width((len * 12).dp)
                .height(36.dp)
                .clip(RoundedCornerShape(50))
                .background(if (tag.isSelected) blue200 else white)
                .border(
                    1.dp, color = blue200,
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = tag.text,
                color = if(tag.isSelected) white else blue200,
                fontSize = 14.sp
            )
        }
    }
}
