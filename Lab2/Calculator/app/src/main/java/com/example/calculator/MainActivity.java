package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1Text, num2Text;
    private Spinner oprSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1Text = findViewById(R.id.num1);
        num2Text = findViewById(R.id.num2);
        oprSpinner = findViewById(R.id.opr);
        Button calculateButton = findViewById(R.id.button);

        calculateButton.setOnClickListener(v -> {
            String num1Str = num1Text.getText().toString();
            String num2Str = num2Text.getText().toString();
            String opr = oprSpinner.getSelectedItem().toString();

            //both nums not null
            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;

                switch (opr) {
                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            result = Double.NaN;
                        }
                        break;
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                intent.putExtra("opr", opr);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }
}