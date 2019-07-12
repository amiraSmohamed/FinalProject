package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.javajokes.MyJokes;
import com.example.telljokes.TellJoke;

public class MainActivity extends AppCompatActivity {
    Button tellJokeBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tellJokeBT = findViewById(R.id.tell_joke_bt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void tellJoke(View view) {
//        new EndpointAsyncTask(this).execute();
//    }
//
//    @Override
//    public void onFinish(String result) {
//        Intent intent = new Intent(this, TellJoke.class);
//        intent.putExtra(Intent.EXTRA_TEXT, result);
//        startActivity(intent);
//    }
}
