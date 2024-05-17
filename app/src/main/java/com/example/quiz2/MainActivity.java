package com.example.quiz2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupIphones, radioGroupExtras;
    private EditText editTextDays;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupIphones = findViewById(R.id.radioGroupIphones);
        radioGroupExtras = findViewById(R.id.radioGroupExtras);
        editTextDays = findViewById(R.id.editTextDays);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        int selectedIphoneId = radioGroupIphones.getCheckedRadioButtonId();
        int selectedExtraId = radioGroupExtras.getCheckedRadioButtonId();
        String daysText = editTextDays.getText().toString();

        if (selectedIphoneId == -1 || daysText.isEmpty()) {
            Toast.makeText(this, "Silakan pilih iPhone dan masukkan jumlah hari.", Toast.LENGTH_SHORT).show();
            return;
        }

        int days = Integer.parseInt(daysText);

        RadioButton selectedIphone = findViewById(selectedIphoneId);
        String iphoneName = selectedIphone.getText().toString();
        int iphonePrice = Integer.parseInt(selectedIphone.getTag().toString());

        String extraName = "Tidak ada tambahan";
        int extraPrice = 0;
        if (selectedExtraId != -1) {
            RadioButton selectedExtra = findViewById(selectedExtraId);
            extraName = selectedExtra.getText().toString();
            extraPrice = Integer.parseInt(selectedExtra.getTag().toString());
        }

        int total = (iphonePrice + extraPrice) * days;

        // Buat intent untuk memulai ResultActivity
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("IPHONE_NAME", iphoneName);
        intent.putExtra("EXTRA_NAME", extraName);
        intent.putExtra("DAYS", days);
        intent.putExtra("TOTAL_PRICE", total);

        // Start ResultActivity
        startActivity(intent);
    }
}
