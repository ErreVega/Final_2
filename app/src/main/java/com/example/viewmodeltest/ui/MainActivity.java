package com.example.viewmodeltest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewmodeltest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button_suma).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentSumar = new Intent(v.getContext(), ViewModelSumarActivity.class);
                        startActivity(intentSumar);
                    }
                }
        );

        findViewById(R.id.button_users).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentUser = new Intent(v.getContext(), ViewModelUserActivity.class);
                        startActivity(intentUser);
                    }
                }
        );

    }
}

