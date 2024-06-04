package fr.nexhub.homedia.features.settings.screens.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.R
import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ProfilesContent(user: User)  {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Image(
            modifier = Modifier.width(200.dp),
            painter = painterResource(id = R.drawable.boy),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.width(200.dp),
            text = user.name.uppercase(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}