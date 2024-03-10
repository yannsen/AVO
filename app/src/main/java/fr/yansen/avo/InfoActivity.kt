package fr.yansen.avo

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val text = intent.getStringExtra("text")
        val colorId = intent.getIntExtra("colorId", android.R.color.black)
        val audioId = intent.getIntExtra("audioId", -1)

        val textView = findViewById<TextView>(R.id.infoTextView)
        textView.text = text
        //textView.setTextColor(resources.getColor(colorId))
        textView.setBackgroundResource(colorId)
        mediaPlayer = MediaPlayer.create(this, audioId)
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
