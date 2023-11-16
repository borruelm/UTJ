package com.utj.permitease.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.utj.permitease.R;

public class MainMenu extends AppCompatActivity {
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
}