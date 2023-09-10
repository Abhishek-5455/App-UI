package com.example.assignment.ui.theme.components.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment.R
import com.example.assignment.data.BottomMenuItem
import com.example.assignment.data.User
import com.example.assignment.data.bottomMenuItems
import com.example.assignment.data.users
import com.example.assignment.ui.theme.Screen
import com.example.assignment.ui.theme.blue100
import com.example.assignment.ui.theme.blue200
import com.example.assignment.ui.theme.gray100
import com.example.assignment.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    navController: NavController
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = { BottomMenu(items = bottomMenuItems)}
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            AppBar(
                username = "Abhishek Rathod",
                location = "Nagpur, Maharashtra",
                navController = navController
            )
            TabSection(onTabSelected = {selectedTabIndex = it})
            SearchBar()
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                items(users) {user ->
                    UserDetails(user = user)
                }
            }
        }
    }
}


@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    username: String,
    location: String,
    navController: NavController
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(blue100),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(id = R.drawable.menu),
            contentDescription = null,
            tint = white,
            modifier = Modifier
                .size(30.dp)
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .weight(4f)
                .padding(start = 4.dp)
        ){
            Text(
                text = "Howdy $username !!",
                color = white,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Icon(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = null,
                    tint = white,
                    modifier = Modifier
                        .size(16.dp)
                )
                Text(
                    text = location,
                    color = white,
                    fontSize = 14.sp
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 2.dp)
                .weight(1f)
                .clickable { navController.navigate(Screen.RefineScreen.route) },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.refine),
                contentDescription = null,
                tint = white,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Refine",
                color = white,
                fontSize = 16.sp
            )
        }
    }

}

@Composable
fun BottomMenu(
    items: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    initialSelectedItem: Int = 0
) {
    var selectedItemIndex by remember {
        mutableIntStateOf(initialSelectedItem)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(white)
            .padding(16.dp)
    ){
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex
            ) {
                selectedItemIndex = index
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    item: BottomMenuItem,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    val activeColor = blue100
    val inactiveColor = gray100
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onItemClick() }
    ) {
        Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = null,
            tint = if(isSelected) activeColor else inactiveColor,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = item.text,
            color = if(isSelected) activeColor else inactiveColor,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun TabSection(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
) {

    val tabList = listOf("Personal" , "Business" , "Merchant")

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val inactiveColor = gray100
    val activeColor = white

    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = blue200,
        modifier = modifier.sizeIn(minHeight = 45.dp)
    ) {
        tabList.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                },
                selectedContentColor = activeColor,
                unselectedContentColor = inactiveColor
            ) {
                Text(
                    text = item,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = if(selectedIndex == index) white else gray100,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier:Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(50),
            label = {
                Row(
                    modifier = Modifier.padding(start = 20.dp)
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Search",
                        fontSize = 16.sp
                    )
                }
            },
            modifier = Modifier
                .height(50.dp)
                .weight(4f)
        )

        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = null,
            tint = blue100,
            modifier = Modifier
                .padding(8.dp).padding(top = 3.dp)
                .size(30.dp)
                .weight(1f)
        )
    }
}

@Composable
fun UserDetails(
    user: User,
    modifier: Modifier = Modifier
) {
    val shortForm = user.name.split(" ")[0].first() + "" + user.name.split(" ")[1].first()
    val tag = user.tags.joinToString(" | ")
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(white)
            .padding(start = 12.dp, bottom = 16.dp, end = 6.dp),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 8.dp),
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(15)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 80.dp , top = 40.dp)
                ) {
                    Text(
                        text = user.name,
                        fontSize = 18.sp,
                        color = blue100,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${user.location} | ${user.profession}",
                        fontSize = 18.sp,
                        color = blue200,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Within ${user.distance}",
                        fontSize = 18.sp,
                        color = blue200,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Bar()
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 30.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = tag,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = blue200
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = user.about,
                        color = blue200,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }

        Surface(
            modifier = Modifier.padding(top = 30.dp),
            shadowElevation = 4.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(90.dp)
                    .background(gray100)
                    .align(Alignment.TopStart),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = shortForm,
                    color = blue200,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun Bar(
    modifier:Modifier = Modifier
) {
    LinearProgressIndicator(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .width(150.dp)
            .height(15.dp),
        progress = 0.5f,
        color = Color.DarkGray,
        trackColor = gray100
    )
}