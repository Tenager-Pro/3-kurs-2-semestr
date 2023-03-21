package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class ColorActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        var flag: Int? = 0
        val button: Button = findViewById(R.id.buttonBackMenu)

        val imageButton: ImageButton = findViewById(R.id.imageButton)
        val imageButton2: ImageButton = findViewById(R.id.imageButton2)
        val imageButton3: ImageButton = findViewById(R.id.imageButton3)
        val imageButton4: ImageButton = findViewById(R.id.imageButton4)
        val imageButton5: ImageButton = findViewById(R.id.imageButton5)
        val imageButton6: ImageButton = findViewById(R.id.imageButton6)
        val imageButton7: ImageButton = findViewById(R.id.imageButton7)
        val imageButton8: ImageButton = findViewById(R.id.imageButton8)
        val imageButton9: ImageButton = findViewById(R.id.imageButton9)

        imageButton.setOnClickListener{
            System.out.println(flag)
            flag=1
        }
        imageButton2.setOnClickListener{
            flag=2
        }
        imageButton3.setOnClickListener{
            flag=3
        }
        imageButton4.setOnClickListener{
            flag=4
        }
        imageButton5.setOnClickListener{
            flag=5
        }
        imageButton6.setOnClickListener{
            flag=6
        }
        imageButton7.setOnClickListener{
            flag=7
        }
        imageButton8.setOnClickListener{
            flag=8
        }
        imageButton9.setOnClickListener{
            flag=9
        }
        button.setOnClickListener {

            val intent = Intent(this@ColorActivity, MainActivity::class.java)
            intent.putExtra("color", flag)
            startActivity(intent)
        }

    }
}

