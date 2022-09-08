package com.gtappdevelopers.youtube_player_view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    lateinit var playButton: Button
    lateinit var urlEdt: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton = findViewById(R.id.idBtnPlayVideo)
        urlEdt = findViewById(R.id.idEdtYouTubeURL)
        playButton.setOnClickListener {
            //https://www.youtube.com/watch?v=imRxEskXGx8
            val url = urlEdt.text.toString()
            if (url.length != 0) {
                var videoID = "";
                if (url.length > 11) {
                    videoID = url.subSequence(17, 28).toString()
                    Log.e("tag", "Video iD = " + url.subSequence(17, 28))
                }
                val i = Intent(this, YouTubePlayerActivity::class.java)
                i.putExtra("url", videoID)
                startActivity(i)
            }

        }
    }
}