package com.example.display_settings;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Text_settings_Activity extends AppCompatActivity {
    int textSize = 20;
    TextView textViewFont, textViewSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_settings);

        textViewFont = findViewById(R.id.textViewFont);
        textViewSize = findViewById(R.id.textViewSize);
        SeekBar seekBar = findViewById(R.id.seekBar);
        textViewFont.setTextSize(textSize);
        textViewSize.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressNew = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSize = textSize + (progress - progressNew);
                progressNew = progress;
                textViewFont.setTextSize(textSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}