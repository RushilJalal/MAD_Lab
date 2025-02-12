// OrderSummaryActivity.java
package com.example.foodorderingapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        TextView tvOrderDetails = findViewById(R.id.tvOrderDetails);
        TextView tvTotalCost = findViewById(R.id.tvTotalCost);

        // Retrieve data from the intent
        String orderDetails = getIntent().getStringExtra("ORDER_DETAILS");
        int totalCost = getIntent().getIntExtra("TOTAL_COST", 0);

        // Display the data
        tvOrderDetails.setText(orderDetails);
        tvTotalCost.setText("Total Cost: $" + totalCost);
    }
}