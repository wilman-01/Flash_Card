package com.example.wilman.flash_card;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean isShowingAnswers = true;
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

    public int getRandomNumber(int minNumber, int maxNumber) {
        Random rand = new Random();
        return rand.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(this);
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(0).getAnswer());
        }


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
        findViewById(R.id.go_to_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                String question = ((TextView) findViewById(R.id.flashcard_question)).getText().toString();
                String answer = ((TextView) findViewById(R.id.flashcard_answer)).getText().toString();
                intent.putExtra("stringKey1", (Parcelable[]) null);
                intent.putExtra("stringKey2", (Parcelable[]) null);
                intent.putExtra("stringKey3", question);
                intent.putExtra("stringKey4", answer);
                MainActivity.this.startActivityForResult(intent,100);

            }
        });
        findViewById(R.id.edit_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                String question = ((TextView) findViewById(R.id.flashcard_question)).getText().toString();
                String answer = ((TextView) findViewById(R.id.flashcard_answer)).getText().toString();
                //while (i<0)int card_to_edit =
                intent.putExtra("stringKey1", question);
                intent.putExtra("stringKey2", answer);
                MainActivity.this.startActivityForResult(intent,100);
            }
        });


        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // advance our pointer index so we can show the next card
                //currentCardDisplayedIndex++;
                currentCardDisplayedIndex= getRandomNumber(0,allFlashcards.size()-1);
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);

                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if ( allFlashcards.size() > 0) {
                    //currentCardDisplayedIndex = 0;
                    // set the question and answer TextViews with data from the database
                    ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                    ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                }
                else if (allFlashcards.size() == 0){
                    ((TextView) findViewById(R.id.flashcard_question)).setText("Introduce a new Flashcard");
                }


            }
        });

        findViewById(R.id.deleteBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                allFlashcards = flashcardDatabase.getAllCards();
                currentCardDisplayedIndex++;
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String string1 = data.getExtras().getString("Question"); // 'string1' needs to match the key we used when we put the string in the Intent
            String string2 = data.getExtras().getString("Answer");
            ((TextView) findViewById(R.id.flashcard_question)).setText(string1);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(string2);
            flashcardDatabase.insertCard(new Flashcard(string1, string2));
            allFlashcards = flashcardDatabase.getAllCards();

        }

    }

}
