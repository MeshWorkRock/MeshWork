package com.example.meshworkapp.common

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.R
import com.example.meshworkapp.UserInfoDataClass
import com.example.meshworkapp.common.dataclass.AnnouncementDataClass
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.ui.theme.LightBlueText
import com.example.meshworkapp.viewmodels.AnnouncementsViewModel

@Composable
fun OrganizationNameAndLogoComposable(
    name: String,
    logo: Painter? = null,
    modifier: Modifier
) {
    Row {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
                .weight(7f)
        ) {

            Text(
                text = "MeshWork",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(top = 30.dp, end = 20.dp)
                .weight(1f), alignment = Alignment.TopStart)

    }
}

@Composable
fun UserInfoCard(
    userInfo: UserInfoDataClass,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
//            .padding(12.dp)
//            .background(Color.Transparent),
        backgroundColor = Color.White,
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(vertical = 10.dp)
//                .background(CardBackground())
        ) {
            Image(
                painter = userInfo.profilePhoto,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
                    .padding(6.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = userInfo.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlueText
                )
                Text(
                    text = userInfo.id,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = DarkBlueText
                )
            }
        }
    }
}
@Composable
fun AnnouncementList(
    announcementMessages: AnnouncementsViewModel
) {
    Toast.makeText(LocalContext.current, "Ann", Toast.LENGTH_SHORT).show()
    if(announcementMessages.announcements.value == null)
        return
    val announcementsList = announcementMessages.announcements.value!!.announcementsList
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = announcementsList, itemContent = { announcement ->
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Row() {
                        Text(
                            text = announcement.Heading,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.h6,
                            color = DarkBlueText
                        )
                        Text(
                            text = announcement.Date,
                            textAlign = TextAlign.End,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.body2,
                            color = DarkBlueText
                        )
                    }
                    Text(
                        text = announcement.announcementBody,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Left,
                        color = DarkBlueText,
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                }
            }
        })
    }

}

//@Preview(showBackground = true)
//@Composable
//fun UserInfoCardPreview() {
//    val data =
//
//    UserInfoCard()
//
//}