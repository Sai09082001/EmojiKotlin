package com.example.toastemoji

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.toastemoji.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    companion object {
        private val ARR_EMOJI = arrayOf(R.drawable.ic_dissapointment, R.drawable.ic_grinning,
            R.drawable.ic_happy,R.drawable.ic_love,
            R.drawable.ic_neutral,R.drawable.ic_sad,
            R.drawable.ic_shocked,R.drawable.ic_smile,R.drawable.ic_thinking)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        binding = ActivityMainBinding.bind(view)
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        val emojiAdapter = EmojiAdapter(this, ARR_EMOJI)
        binding?.rvEmoji?.layoutManager = GridLayoutManager(this, 3)
        binding?.rvEmoji?.adapter = emojiAdapter
    }
}