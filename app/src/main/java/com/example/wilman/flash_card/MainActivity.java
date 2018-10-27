package com.example.wilman.flash_card;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isShowingAnswers = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.rootView).setBackgroundColor(getResources().getColor(R.color.black, null));
        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_1).setBackgroundColor(getResources().getColor(R.color.none, null));
                findViewById(R.id.answer_2).setBackgroundColor(getResources().getColor(R.color.none, null));
                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.none, null));
                ((TextView) findViewById(R.id.answer_1)).setTextColor(
                        getResources().getColor(R.color.orange));
                ((TextView) findViewById(R.id.answer_2)).setTextColor(
                        getResources().getColor(R.color.orange));
                ((TextView) findViewById(R.id.answer_3)).setTextColor(
                        getResources().getColor(R.color.orange));
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.answer_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_1).setBackgroundColor(getResources().getColor(R.color.light_red, null));
                ((TextView) findViewById(R.id.answer_1)).setTextColor(
                        getResources().getColor(R.color.my_red_color));
                ((TextView) findViewById(R.id.answer_3)).setTextColor(
                        getResources().getColor(R.color.green));
                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.light_green, null));
            }
        });
        findViewById(R.id.answer_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_2).setBackgroundColor(getResources().getColor(R.color.light_red, null));
                ((TextView) findViewById(R.id.answer_2)).setTextColor(
                        getResources().getColor(R.color.my_red_color));
                ((TextView) findViewById(R.id.answer_3)).setTextColor(
                        getResources().getColor(R.color.green));
                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.light_green, null));
            }
        });
        findViewById(R.id.answer_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.light_green, null));
                ((TextView) findViewById(R.id.answer_3)).setTextColor(
                        getResources().getColor(R.color.green));
            }
        });


        //findViewById(R.id.toggle_choices_visibility).setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {

        findViewById(R.id.toggle_choices_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingAnswers == true) {
                    ((ImageView) findViewById(R.id.toggle_choices_visibility)).setImageResource(R.drawable.ic_eye);
                    findViewById(R.id.answer_1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer_2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer_3).setVisibility(View.INVISIBLE);
                    isShowingAnswers = false;
                }
                else {
                    ((ImageView) findViewById(R.id.toggle_choices_visibility)).setImageResource(R.drawable.ic_eye_off);
                    findViewById(R.id.answer_1).setVisibility(View.VISIBLE);
                    findViewById(R.id.answer_2).setVisibility(View.VISIBLE);
                    findViewById(R.id.answer_3).setVisibility(View.VISIBLE);
                    isShowingAnswers = true;
                }
            }
        });




    }

}
