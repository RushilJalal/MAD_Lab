package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView resultTextView = findViewById(R.id.textView3);

        double num1 = getIntent().getDoubleExtra("num1", 0);
        double num2 = getIntent().getDoubleExtra("num2", 0);
        String opr = getIntent().getStringExtra("opr");
        double result = getIntent().getDoubleExtra("result", 0);

        String resultStr = num1 + " " + opr + " " + num2 + " = " + result;
        resultTextView.setText(resultStr);
    }
}