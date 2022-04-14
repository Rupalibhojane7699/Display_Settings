package com.example.display_settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Theme_settingsActivity extends AppCompatActivity {

    private View parentView;
    private SwitchMaterial themeSwitch;
    private TextView themetv,titletv;
    private Usersettings settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_settings);
        settings=(Usersettings) getApplication();
        initWidgets();
        loadsharedpreferences();
        initSwitchListener();
    }

    private void initSwitchListener() {
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked)
                settings.setCustomTheme(Usersettings.DARK_THEME);
                else
                    settings.setCustomTheme(Usersettings.LIGHT_THEME);
                SharedPreferences.Editor editor= getSharedPreferences(Usersettings.PREFERENCES,MODE_PRIVATE).edit();
                editor.putString(Usersettings.CUSTOM_THEME,settings.getCustomTheme());
                editor.apply();
                updateView();

            }
        });


    }

    private void updateView() {
        final int black= ContextCompat.getColor(this,R.color.black);
        final int white=ContextCompat.getColor(this,R.color.white);

        if (settings.getCustomTheme().equals(Usersettings.DARK_THEME))
        {
            titletv.setTextColor(white);
            themetv.setTextColor(white);
            themetv.setText("Dark");
            parentView.setBackgroundColor(black);
            themeSwitch.setChecked(true);
        }
        else {
            titletv.setTextColor(black);
            themetv.setTextColor(black);
            themetv.setText("Light");
            parentView.setBackgroundColor(white);
            themeSwitch.setChecked(false);
        }

    }

    private void loadsharedpreferences() {

        SharedPreferences sharedPreferences=getSharedPreferences(Usersettings.PREFERENCES,MODE_PRIVATE);
        String theme= sharedPreferences.getString(Usersettings.CUSTOM_THEME,Usersettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
    }

    private void initWidgets() {
        themetv=findViewById(R.id.themeTV);
        titletv=findViewById(R.id.titleTV);
        themeSwitch=findViewById(R.id.themeswitch);
        parentView=findViewById(R.id.parentView);
    }
}