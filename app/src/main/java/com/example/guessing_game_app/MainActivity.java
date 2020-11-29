package com.example.guessing_game_app;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView solution;
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonClear;

    GuessingGame game = new GuessingGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFields();
        setupToolbar();
        setupButtons();
    }

    private void setupButtons() {
        buttonClear.setVisibility(View.INVISIBLE);
        setClearButtonListener();
        setNumberButtonsListener();
    }

    private void setNumberButtonsListener() {
        View.OnClickListener numberListener = view -> {
            buttonClear.setVisibility(View.VISIBLE);
            Button currentButton = (Button) view;
            String currentButtonText = currentButton.getText().toString();
            solution.setText(game.getGuessResult(currentButtonText));
        };

        Button[] numberButtons = { buttonOne, buttonTwo, buttonThree };

        for (Button current : numberButtons) {
            current.setOnClickListener(numberListener);
        }
    }

    private void setClearButtonListener() {
        buttonClear.setOnClickListener(v -> {
            buttonClear.setVisibility(View.INVISIBLE);
            solution.setText("");
        });
    }

    private void setupFields() {
        solution = findViewById(R.id.solution);
        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonClear = findViewById(R.id.clear);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}