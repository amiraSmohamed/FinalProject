package com.example.telljokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TellJoke extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_joke);
        if (getIntent().hasExtra("jokes")) {
            String joke = getIntent().getStringExtra("jokes");
            ((TextView) findViewById(R.id.joke_tv)).setText(joke);
        }
        else {
            Toast.makeText(this,"Intent is null ",Toast.LENGTH_LONG).show();
        }
    }

}
