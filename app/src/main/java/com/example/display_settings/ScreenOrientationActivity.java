    package com.example.display_settings;

    import android.content.pm.ActivityInfo;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.CheckBox;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.SwitchCompat;

    public class ScreenOrientationActivity extends AppCompatActivity {

        private CheckBox ch;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_screen_orientation);
            ch = findViewById(R.id.checkbox);
            SwitchCompat switchCompat;

            ch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ch.isChecked()) {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    } else {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                }
            });
        }
    }