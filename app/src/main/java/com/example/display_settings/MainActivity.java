package com.example.display_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        if (id == R.id.action_screen_orientation) {
            Intent intent = new Intent(this, ScreenOrientationActivity.class);
            startActivity(intent);
            return true;
        }
        else
        if (id== R.id.action_screen_brightness){
            Intent intent=new Intent(this,ScreenBrightnessActivity.class);
            startActivity(intent);
            return true;
        }
        else
        if (id == R.id.action_text_settings){
            Intent intent=new Intent(this,Text_settings_Activity.class);
            startActivity(intent);
            return true;
        }
        else
        if (id == R.id.action_theme_settings){
            Intent intent=new Intent(this,Theme_settingsActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

}
