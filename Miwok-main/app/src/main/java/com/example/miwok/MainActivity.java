package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //demo for creating a onclicklistener
        //find the view we want to use
        //1st text view
        TextView numbers = (TextView) findViewById(R.id.Numbers);
        //Set a clicklistener on that view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(sendIntent);
            }
        });

        TextView family = (TextView) findViewById(R.id.Family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(sendIntent);
            }
        });

        TextView color = (TextView) findViewById(R.id.Color);
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, ColorActivity.class);
                startActivity(sendIntent);
            }
        });

        TextView phrase = (TextView) findViewById(R.id.Phrase);
        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, PhraseActivity.class);
                startActivity(sendIntent);
            }
        });
    }
}