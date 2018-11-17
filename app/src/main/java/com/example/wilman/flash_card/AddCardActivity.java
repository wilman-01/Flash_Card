package com.example.wilman.flash_card;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


        String s1 = getIntent().getStringExtra("stringKey1"); // this string will be 'harry potter`
        String s2 = getIntent().getStringExtra("stringKey2"); // this string will be 'voldemort'
        ((EditText) findViewById(R.id.new_question)).setText(s1);
        ((EditText) findViewById(R.id.new_answer)).setText(s2);



        findViewById(R.id.rootView2).setBackgroundColor(getResources().getColor(R.color.black, null));

        findViewById(R.id.go_to_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = getIntent().getStringExtra("stringKey1"); // this string will be 'harry potter`
                String s2 = getIntent().getStringExtra("stringKey2"); // this string will be 'voldemort'
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                if (TextUtils.isEmpty(s1)|TextUtils.isEmpty(s2)){
                    String string1 = getIntent().getStringExtra("stringKey3");
                    String string2 = getIntent().getStringExtra("stringKey4");
                    data.putExtra("Question", string1); // puts one string into the Intent, with the key as 'string1'
                    data.putExtra("Answer", string2); // puts another string into the Intent, with the key as 'string2
                    //"editcard",
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                }

                else{
                    String string1 = getIntent().getStringExtra("stringKey1");
                    String string2 = getIntent().getStringExtra("stringKey2");
                    data.putExtra("Question", string1); // puts one string into the Intent, with the key as 'string1'
                    data.putExtra("Answer", string2); // puts another string into the Intent, with the key as 'string2
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                }
                finish(); // closes this activity and pass data to the original activity that launched this activity

            }
        });

        findViewById(R.id.save_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string1 = ((EditText) findViewById(R.id.new_question)).getText().toString();
                String string2 = ((EditText) findViewById(R.id.new_answer)).getText().toString();
                String s1 = getIntent().getStringExtra("stringKey1"); // this string will be 'harry potter`
                String s2 = getIntent().getStringExtra("stringKey2"); // this string will be 'voldemort'
                ((EditText) findViewById(R.id.new_question)).setText(s1);
                ((EditText) findViewById(R.id.new_answer)).setText(s2);
                if (TextUtils.isEmpty(string1)|TextUtils.isEmpty(string2)){
                    Toast.makeText(getApplicationContext(), "Must enter both Question and Answer!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent data = new Intent(); // create a new Intent, this is where we will put our data
                    data.putExtra("Question", string1); // puts one string into the Intent, with the key as 'string1'
                    data.putExtra("Answer", string2); // puts another string into the Intent, with the key as 'string2
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                    finish(); // closes this activity and pass data to the original activity that launched this activity
                }
            }
        });
    }
}
