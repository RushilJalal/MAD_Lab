package com.example.lab_5_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class ConfirmationActivity extends AppCompatActivity {
    TextView textViewVehicleDetails;
    Button buttonConfirm, buttonEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmation);

        textViewVehicleDetails = findViewById(R.id.textViewVehicleDetails);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonEdit = findViewById(R.id.buttonEdit);

        // Retrieve the data passed from the MainActivity
        Intent intent = getIntent();
        String vehicleType = intent.getStringExtra("vehicleType");
        String vehicleNumber = intent.getStringExtra("vehicleNumber");
        String rcNumber = intent.getStringExtra("rcNumber");

        // Display the details
        String vehicleDetails = "Vehicle Type: " + vehicleType + "\n" +
                "Vehicle Number: " + vehicleNumber + "\n" +
                "RC Number: " + rcNumber;
        textViewVehicleDetails.setText(vehicleDetails);

        // Handle confirmation
        buttonConfirm.setOnClickListener(v -> {
            String uniqueSerialNumber = "SN-" + UUID.randomUUID().toString();
            Toast.makeText(ConfirmationActivity.this, "Parking Allotment Confirmed: " + uniqueSerialNumber, Toast.LENGTH_LONG).show();
            finish();
        });

        // Handle editing
        buttonEdit.setOnClickListener(v -> finish());
    }
}