package com.example.lab_5_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerVehicleType;
    EditText editTextVehicleNumber, editTextRCNumber;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerVehicleType = findViewById(R.id.VehicleTypeSpinner);
        editTextVehicleNumber = findViewById(R.id.VehicleNumberEditText);
        editTextRCNumber = findViewById(R.id.RCNumberEditText);
        submitButton = findViewById(R.id.SubmitButton);

        submitButton.setOnClickListener(v -> {
            String vehicleType = spinnerVehicleType.getSelectedItem().toString();
            String vehicleNumber = editTextVehicleNumber.getText().toString();
            String rcNumber = editTextRCNumber.getText().toString();

            if (vehicleNumber.isEmpty() || rcNumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                // Passing data to the Confirmation Activity
                Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
                intent.putExtra("vehicleType", vehicleType);
                intent.putExtra("vehicleNumber", vehicleNumber);
                intent.putExtra("rcNumber", rcNumber);
                startActivity(intent);
            }
        });
    }
}