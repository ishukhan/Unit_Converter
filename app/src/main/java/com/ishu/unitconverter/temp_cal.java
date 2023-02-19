package com.ishu.unitconverter;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class temp_cal extends AppCompatActivity {

    CardView cv_fromUnit, cv_toUnit, cv_convert;
    RelativeLayout mCLayout;
    String fromUnit = "Celcius";
    String toUnit = "Farenheit";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;
    final String[] values = new String[]{
            "Celcius",
            "Fahrenheit",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_cal);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);

        mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[0]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);

        cv_convert.setOnClickListener(v -> {
            String tempInput = et_fromUnit.getText().toString();
            if (tempInput.equals("")) {
                et_fromUnit.setError("Please enter some value");
            } else {
                if (tv_fromUnit.getText().toString().equals(values[0])) {
                    if (tv_toUnit.getText().toString().equals(values[0])) {
                        et_toUnit.setText(tempInput);
                    } else if (tv_toUnit.getText().toString().equals(values[1])) {
                        et_toUnit.setText(celciusToFarenheit(Double.parseDouble(tempInput)));
                    }
//
                } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                    if (tv_toUnit.getText().toString().equals(values[0])) {
                        et_toUnit.setText(fahrenheitToCelcius(Double.parseDouble(tempInput)));
                    }
                    }

            }
        });
        cv_toUnit.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(temp_cal.this);
            builder.setTitle("choose Unit");

            final String[] flowers = new String[]{
                    "Celcius",
                    "Fahrenheit",

            };

            // Item click listener
            builder.setSingleChoiceItems(
                    flowers, // Items list
                    -1, // Index of checked item (-1 = no selection)
                    (dialogInterface, i) -> {
// Get the alert dialog selected item's text
                        String selectedItem = Arrays.asList(flowers).get(i);
                        toUnit = selectedItem;
                        tv_toUnit.setText(toUnit);

                    });

            builder.setPositiveButton("OK", (dialogInterface, i) -> {
// Just dismiss the alert dialog after selection
// Or do something now
                dialogInterface.dismiss();
            });

            AlertDialog dialog = builder.create();

// Finally, display the alert dialog
            dialog.show();

        });

        cv_fromUnit.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(temp_cal.this);
            builder.setTitle("choose Unit");

            final String[] flowers = new String[]{
                    "Celcius",
                    "Fahrenheit",
            };

            // Item click listener
            builder.setSingleChoiceItems(
                    flowers, // Items list
                    -1, // Index of checked item (-1 = no selection)
                    (dialogInterface, i) -> {


// Get the alert dialog selected item's text
                        String selectedItem = Arrays.asList(flowers).get(i);
                        fromUnit = selectedItem;
                        tv_fromUnit.setText(fromUnit);

                    });

            builder.setPositiveButton("OK", (dialogInterface, i) -> {
// Just dismiss the alert dialog after selection
// Or do something now
                dialogInterface.dismiss();
            });

            AlertDialog dialog = builder.create();

// Finally, display the alert dialog
            dialog.show();

        });

    }
    private String celciusToFarenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return String.valueOf(fahrenheit);
    }

    private String fahrenheitToCelcius(double fahrenheit) {
        double celcius = (fahrenheit - 32) * 5 / 9;
        return String.valueOf(celcius);
    }


}
