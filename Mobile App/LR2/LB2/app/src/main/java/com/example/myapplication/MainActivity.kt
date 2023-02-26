package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView4);
        registerForContextMenu(textView);


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val textView: TextView = findViewById(R.id.textView3);
        val animation: Animation;
        when (item.itemId) {
            R.id.scale -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
            textView.startAnimation(animation)}

            R.id.alfa -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.alfa);
                textView.startAnimation(animation)}

            R.id.tranclate -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                textView.startAnimation(animation)}

            else -> { // Note the block
                return super.onOptionsItemSelected(item);
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.example_menu, menu);
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val textView: TextView = findViewById(R.id.textView4);
        when (item.itemId) {
            R.id.red -> textView.setTextColor(Color.RED)

            R.id.green -> textView.setTextColor(Color.GREEN)

            R.id.blue -> textView.setTextColor(Color.BLUE)

            R.id.text_22 -> textView.setTextSize(22F);

            R.id.text_26 -> textView.setTextSize(30F);

            R.id.text_30 -> textView.setTextSize(30F);
            else -> { // Note the block
                return super.onContextItemSelected(item);
            }

        }
        return super.onContextItemSelected(item)
    }
}
