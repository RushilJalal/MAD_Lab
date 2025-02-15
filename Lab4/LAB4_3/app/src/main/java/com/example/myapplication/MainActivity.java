package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    Button btnChangeMode;
    ImageView imageViewMode;
    boolean isWiFi = true; // Default mode is Wi-Fi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        toggleButton = findViewById(R.id.toggleButton);
        btnChangeMode = findViewById(R.id.btnChangeMode);
        imageViewMode = findViewById(R.id.imageViewMode);

        //set init state of toggle button to on(wifi)
        toggleButton.setChecked(true);

        // Set initial image based on the default mode
        updateImageView();

        // ToggleButton listener
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update mode based on toggle state
            isWiFi = isChecked; // Update the mode based on the toggle state
            if (isWiFi) {
                Toast.makeText(MainActivity.this, "Current Mode: Wi-Fi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Current Mode: Mobile Data", Toast.LENGTH_SHORT).show();
            }
            updateImageView(); // Update the image based on the new mode
        });

        // Change Mode button listener
        btnChangeMode.setOnClickListener(v -> {
            // Toggle the mode
            isWiFi = !isWiFi; // Switch between Wi-Fi and Mobile Data
            toggleButton.setChecked(isWiFi); // Update the ToggleButton to reflect the new mode

            // Show a toast message based on the new mode
            if (isWiFi) {
                Toast.makeText(MainActivity.this, "Switched to Wi-Fi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Switched to Mobile Data", Toast.LENGTH_SHORT).show();
            }
            updateImageView(); // Update the image based on the new mode
        });
    }

    // Update the ImageView based on the current mode
    private void updateImageView() {
        if (isWiFi) {
            imageViewMode.setImageResource(R.drawable.wifi); // Set Wi-Fi image
        } else {
            imageViewMode.setImageResource(R.drawable.mobile_data); // Set Mobile Data image
        }
    }
}