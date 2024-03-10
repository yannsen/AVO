package fr.yansen.avo


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener {
            showInfoPage("1er degré", R.color.green, R.raw.m1)
        }

        button2.setOnClickListener {
            showInfoPage("2nd degré", R.color.red, R.raw.m2)
        }

        button3.setOnClickListener {
            showInfoPage("Sous-entendu sexuel", R.color.pink, R.raw.m3)
        }
    }

    private fun showInfoPage(text: String, colorId: Int, audioId: Int) {
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("text", text)
        intent.putExtra("colorId", colorId)
        intent.putExtra("audioId", audioId)
        startActivity(intent)
    }
}