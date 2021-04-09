package com.undencem.sharedpreferencesexample1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch aSwitch;
    private View view ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.colorswitch);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean("Key",false);
        aSwitch.setChecked(isChecked);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                editor.putBoolean("Key",isChecked);
                view.setBackgroundColor(isChecked? Color.GREEN : Color.RED);
            }
        });

    }
}