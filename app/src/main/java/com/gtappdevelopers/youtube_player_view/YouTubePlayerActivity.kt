package com.gtappdevelopers.youtube_player_view

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class YouTubePlayerActivity : AppCompatActivity() {
   // var video_id = "5lmhxob61eg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // below two lines are used to set our screen orientation in landscape mode.
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_you_tube_player)

        // below line of code is to hide our action bar.
        supportActionBar?.hide()

        val videoID = intent.getStringExtra("url");

        // declaring variable for youtubePlayer view
        val youTubePlayerView: YouTubePlayerView = findViewById(R.id.videoPlayer)

        // below line is to place your youtube player in a full screen mode (i.e landscape mode)
        youTubePlayerView.enterFullScreen()
        youTubePlayerView.toggleFullScreen()

        // here we are adding observer to our youtubeplayerview.
        lifecycle.addObserver(youTubePlayerView)

        // below method will provides us the youtube player ui controller such
        // as to play and pause a video to forward a video and many more features.
        youTubePlayerView.getPlayerUiController()

        // below line is to enter full screen mode.
        youTubePlayerView.enterFullScreen()
        youTubePlayerView.toggleFullScreen()

        // adding listener for our youtube player view.
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(videoID.toString(), 0F)
            }

            override fun onStateChange(
                youTubePlayer: YouTubePlayer,
                state: PlayerConstants.PlayerState
            ) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state)
            }
        })


    }
}