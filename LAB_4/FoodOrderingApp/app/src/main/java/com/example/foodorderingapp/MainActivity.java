// MainActivity.java
package com.example.foodorderingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbBurger = findViewById(R.id.cbBurger);
        CheckBox cbPizza = findViewById(R.id.cbPizza);
        CheckBox cbPasta = findViewById(R.id.cbPasta);
        CheckBox cbFries = findViewById(R.id.cbFries);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder orderDetails = new StringBuilder();
                int totalCost = 0;

                if (cbBurger.isChecked()) {
                    orderDetails.append("Burger - $5\n");
                    totalCost += 5;
                }
                if (cbPizza.isChecked()) {
                    orderDetails.append("Pizza - $10\n");
                    totalCost += 10;
                }
                if (cbPasta.isChecked()) {
                    orderDetails.append("Pasta - $8\n");
                    totalCost += 8;
                }
                if (cbFries.isChecked()) {
                    orderDetails.append("Fries - $3\n");
                    totalCost += 3;
                }

                // Disable checkboxes after submission
                cbBurger.setEnabled(false);
                cbPizza.setEnabled(false);
                cbPasta.setEnabled(false);
                cbFries.setEnabled(false);

                // Pass data to the next activity
                Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
                intent.putExtra("ORDER_DETAILS", orderDetails.toString());
                intent.putExtra("TOTAL_COST", totalCost);
                startActivity(intent);
            }
        });
    }
}