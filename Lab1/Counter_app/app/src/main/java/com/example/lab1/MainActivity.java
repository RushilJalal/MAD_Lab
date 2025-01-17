package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtCount;
    Button btnCount;
    Button resetButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtCount = findViewById(R.id.textView);
        txtCount.setText("0");
        txtCount.setTextSize(45);

        btnCount = findViewById(R.id.button);

        btnCount.setOnClickListener(v -> {
            count++;
            txtCount.setText(String.valueOf(count));
        });

        resetButton = findViewById(R.id.reset_button);

        resetButton.setOnClickListener(v -> {
            count = 0;
            txtCount.setText(String.valueOf(count));
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}