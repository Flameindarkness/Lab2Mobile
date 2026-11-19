package com.example.lab2mobile.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Экспонат галереи
 * @param imageRes Изображение
 * @param titleRes Название
 * @param authorRes Автор
 * @param year Год съёмки
 * @param descriptionRes Описание изображения для TalkBack (contentDescription)
 */
data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val authorRes: Int,
    val year: Int,
    @StringRes val descriptionRes: Int
)
