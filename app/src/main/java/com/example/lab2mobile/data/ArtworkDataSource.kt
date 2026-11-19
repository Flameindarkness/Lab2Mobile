package com.example.lab2mobile.data

import com.example.lab2mobile.R

/**
 * Коллекция экспонатов. Все строки берутся из strings.xml, изображения из res/drawable
 */
object ArtworkDataSource {

    val artworks: List<Artwork> = listOf(
        Artwork(
            imageRes = R.drawable.school_81,
            titleRes = R.string.artwork_school_title,
            authorRes = R.string.author_nagovitsyn,
            year = 2022,
            descriptionRes = R.string.artwork_school_description
        ),
        Artwork(
            imageRes = R.drawable.view_from_roof,
            titleRes = R.string.artwork_roof_view_title,
            authorRes = R.string.author_nagovitsyn,
            year = 2022,
            descriptionRes = R.string.artwork_roof_view_description
        ),
        Artwork(
            imageRes = R.drawable.roof_looking_down,
            titleRes = R.string.artwork_looking_down_title,
            authorRes = R.string.author_nagovitsyn,
            year = 2022,
            descriptionRes = R.string.artwork_looking_down_description
        )
    )
}
