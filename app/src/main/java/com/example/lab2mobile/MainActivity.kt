package com.example.lab2mobile

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab2mobile.data.ArtworkDataSource

class MainActivity : AppCompatActivity() {

    private val artworks = ArtworkDataSource.artworks

    // Индекс текущего экспоната. Сохраняется в Bundle при повороте экрана
    private var currentIndex = 0

    private lateinit var artworkImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var authorText: TextView
    private lateinit var counterText: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val safeArea = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(safeArea.left, safeArea.top, safeArea.right, safeArea.bottom)
            insets
        }

        artworkImage = findViewById(R.id.artwork_image)
        titleText = findViewById(R.id.artwork_title)
        authorText = findViewById(R.id.artwork_author)
        counterText = findViewById(R.id.artwork_counter)
        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)

        // После поворота экрана Activity создаётся заново, индекс восстанавливаем из Bundle
        currentIndex = savedInstanceState?.getInt(KEY_CURRENT_INDEX, 0) ?: 0

        previousButton.setOnClickListener { showArtwork(currentIndex - 1) }
        nextButton.setOnClickListener { showArtwork(currentIndex + 1) }

        showArtwork(currentIndex)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CURRENT_INDEX, currentIndex)
    }

    /**
     * Показывает экспонат по индексу и обновляет доступность кнопок
     */
    private fun showArtwork(index: Int) {
        currentIndex = index.coerceIn(0, artworks.lastIndex)
        val artwork = artworks[currentIndex]

        artworkImage.setImageResource(artwork.imageRes)
        artworkImage.contentDescription = getString(artwork.descriptionRes)
        titleText.setText(artwork.titleRes)
        authorText.text = getString(
            R.string.artwork_author_year,
            getString(artwork.authorRes),
            artwork.year
        )
        counterText.text = getString(R.string.artwork_counter, currentIndex + 1, artworks.size)

        // Состояние кнопок вычисляется из индекса, поэтому после поворота оно тоже восстанавливается
        previousButton.isEnabled = currentIndex > 0
        nextButton.isEnabled = currentIndex < artworks.lastIndex
    }

    companion object {
        private const val KEY_CURRENT_INDEX = "current_index"
    }
}
