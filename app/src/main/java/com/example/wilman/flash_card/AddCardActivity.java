package com.example.wilman.flash_card;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.rootView2).setBackgroundColor(getResources().getColor(R.color.black, null));

        findViewById(R.id.go_to_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.save_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string1 = ((EditText) findViewById(R.id.new_question)).getText().toString();
                String string2 = ((EditText) findViewById(R.id.new_answer)).getText().toString();
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("Question", string1); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("Answer",string2); // puts another string into the Intent, with the key as 'string2
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity
            }
        });
    }
}
