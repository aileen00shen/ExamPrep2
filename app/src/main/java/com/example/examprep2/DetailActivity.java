package com.example.examprep2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    //public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covid19tracker.intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //capture the layout's TextView and set the string as its text
        TextView textView2 = findViewById(R.id.textView);
        System.out.println(message);

        textView2.setText(message);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-_Aid5_AqbU&ab_channel=ABCNews%28Australia%29"));
                startActivity(intent);
            }
        });
    }
}