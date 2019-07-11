package com.robert.starwarsquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mWelcomeTextView;
    private TextView mBeginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface solidFont = Typeface.createFromAsset(getAssets(), "fonts/Star_Jedi_Rounded.ttf");
        Typeface hollowFont = Typeface.createFromAsset(getAssets(), "fonts/Starjhol.ttf");

        mWelcomeTextView = findViewById(R.id.welcome_text_view);
        mWelcomeTextView.setTypeface(solidFont);

        mBeginTextView = findViewById(R.id.begin_text_view);
        mBeginTextView.setTypeface(solidFont);
        mBeginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
