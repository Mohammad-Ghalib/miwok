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

        //numbers activity

        TextView numbers = (TextView) findViewById(R.id.numbers);

        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        //family activity

        TextView family = (TextView) findViewById(R.id.family);

        family.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent numbersIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(numbersIntent);
            }
        });

        //colors activity

        TextView colors = (TextView) findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        //phrases activity

        TextView phrases = (TextView) findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });


    }

//    public void openNumbersList(View view){
//
//        Intent intent = new Intent(this, NumbersActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void openFamilyList(View view){
//
//        Intent intent = new Intent(this, FamilyActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void openColorsList(View view){
//
//        Intent intent = new Intent(this, ColorsActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void openPhrasesList(View view){
//
//        Intent intent = new Intent(this, PhrasesActivity.class);
//        startActivity(intent);
//
//    }
}