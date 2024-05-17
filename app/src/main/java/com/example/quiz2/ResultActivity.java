package com.example.quiz2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewIphone, textViewExtra, textViewDays, textViewTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewIphone = findViewById(R.id.textViewIphone);
        textViewExtra = findViewById(R.id.textViewExtra);
        textViewDays = findViewById(R.id.textViewDays);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String iphoneName = extras.getString("IPHONE_NAME");
            String extraName = extras.getString("EXTRA_NAME");
            int days = extras.getInt("DAYS");
            int totalPrice = extras.getInt("TOTAL_PRICE");

            textViewIphone.setText("Nama iPhone: " + iphoneName);
            textViewExtra.setText("Tambahan: " + extraName);
            textViewDays.setText("Lama Rental: " + days + " hari");
            textViewTotalPrice.setText("Total Harga: " + totalPrice);
        }
    }
}
