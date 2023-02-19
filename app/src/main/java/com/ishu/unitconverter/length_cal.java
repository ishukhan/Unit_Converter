package com.ishu.unitconverter;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class length_cal extends AppCompatActivity {

    CardView cv_fromLength, cv_toLength,  cv_convert;

    RelativeLayout  mClayout;

    String fromLength = "Meter";
    String toLength = "CentiMeter";

    TextView tv_formLength, tv_toLength;

    EditText et_formLength, et_toLength;

    final String[] values = new String[]{
            "Meter",
            "CentiMeter"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_cal);

        cv_fromLength = findViewById(R.id.fromLength);
        cv_toLength = findViewById(R.id.toLength);
        cv_convert = findViewById(R.id.cv_convert);

        mClayout = findViewById(R.id.length_relativeLayout);

        tv_formLength = findViewById(R.id.tv_fromLength);
        tv_toLength = findViewById(R.id.tv_toLenght);

        tv_formLength.setText(values[0]);
        tv_toLength.setText(values[0]);

        et_formLength = findViewById(R.id.et_fromLength);
        et_toLength = findViewById(R.id.et_toLength);

        cv_convert.setOnClickListener(v->{
          String tempInput = et_formLength.getText().toString();
          if(tempInput.equals("")){
              et_formLength.setError("Please enter some value");
          } else{
              if(tv_formLength.getText().toString().equals(values[0])) {
                  if (tv_toLength.getText().toString().equals(values[0])) {
                      et_toLength.setText(tempInput);
                  } else if (tv_toLength.getText().toString().equals(values[1])) {
                      et_toLength.setText(MeterIntoCentiMeter(Double.parseDouble(tempInput)));
                  }
              }  else if (tv_formLength.getText().toString().equals(values[1])) {
                      if (tv_toLength.getText().toString().equals(values[0])){
                          et_toLength.setText(CentiMeterIntoMeter(Double.parseDouble(tempInput)));
                      }
                  }
              }
        });

        cv_fromLength.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(length_cal.this);
            builder.setTitle("Choose Length");

            final String[] flowers = new String[]{
                    "Meter",
                    "CentiMeter",
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        fromLength = Arrays.asList(flowers).get(i);
                        tv_formLength.setText(fromLength);
                    });

            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
                // Just dismiss the alert dialog after selection
                // Or do something now
                dialogInterface.dismiss();

            });
            // Finally, display the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        cv_toLength.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(length_cal.this);
            builder.setTitle("Choose Length");

            final String[] flowers = new String[]{
                    "Meter",
                    "CentiMeter",

            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        toLength = Arrays.asList(flowers).get(i);
                        tv_toLength.setText(toLength);
                    });

            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
                // Just dismiss the alert dialog after selection
                // Or do something now
                dialogInterface.dismiss();

            });
            // Finally, display the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        });

    }

    //Meter Into Centimeter
    private String MeterIntoCentiMeter(double Meter){
        double Centimeter = Meter*100;
        return String.valueOf(Centimeter);
    }

    //CentiMeter into Meter
    private String  CentiMeterIntoMeter(double CentiMeter){
        double Meter = CentiMeter/100;
        return String.valueOf(Meter);
    }
}