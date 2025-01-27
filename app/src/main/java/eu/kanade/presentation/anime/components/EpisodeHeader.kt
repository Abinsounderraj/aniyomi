package eu.kanade.presentation.anime.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.util.quantityStringResource
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.util.system.getResourceColor

@Composable
fun EpisodeHeader(
    episodeCount: Int?,
    isEpisodeFiltered: Boolean,
    onFilterButtonClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onFilterButtonClicked)
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = if (episodeCount == null) {
                stringResource(R.string.episodes)
            } else {
                quantityStringResource(id = R.plurals.anime_num_episodes, quantity = episodeCount)
            },
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onBackground,
        )
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = stringResource(R.string.action_filter),
            tint = if (isEpisodeFiltered) {
                Color(LocalContext.current.getResourceColor(R.attr.colorFilterActive))
            } else {
                MaterialTheme.colorScheme.onBackground
            },
        )
    }
}
