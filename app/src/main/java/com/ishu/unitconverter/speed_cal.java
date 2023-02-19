package com.ishu.unitconverter;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class speed_cal extends AppCompatActivity {

    CardView cv_fromSpeed, cv_toSpeed, cv_convert;

    RelativeLayout mClayout;

    String fromSpeed =  "KiloMeter/Hour";

    String toSpeed = "Meter/Second";

    TextView  tv_fromSpeed, tv_toSpeed;

    EditText et_fromSpeed, et_toSpeed;

    final String[] values = new  String[]{
            "KiloMeter/Hour",
            "Meter/Minute"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_cal);

        cv_fromSpeed = findViewById(R.id.fromSpeed);
        cv_toSpeed = findViewById(R.id.toSpeed);
        cv_convert = findViewById(R.id.cv_convert);


        mClayout = findViewById(R.id.speed_relativeLayout);

        tv_fromSpeed = findViewById(R.id.tv_fromSpeed);
        tv_toSpeed = findViewById(R.id.tv_toSpeed);

        tv_fromSpeed.setText(values[0]);
        tv_toSpeed.setText(values[0]);

        et_fromSpeed = findViewById(R.id.et_fromSpeed);
        et_toSpeed = findViewById(R.id.et_toSpeed);

        cv_convert.setOnClickListener(v->{
            String tempInput = et_fromSpeed.getText().toString();
            if(tempInput.equals("")){
                et_fromSpeed.setError("Please Enter Some Value");
            }else {
                if (tv_fromSpeed.getText().toString().equals(values[0])) {
                    if (tv_toSpeed.getText().toString().equals(values[0])) {
                        et_toSpeed.setText(tempInput);
                    } else if (tv_toSpeed.getText().toString().equals(values[1])) {
                        et_toSpeed.setText(KpHintoMpS(Double.parseDouble(tempInput)));
                    }
                }else if (tv_fromSpeed.getText().toString().equals(values[1])) {
                        if(tv_toSpeed.getText().toString().equals(values[0])){
                            et_toSpeed.setText(MpMintoKmPh(Double.parseDouble(tempInput)));
                        }
                    }
            }
        });

        cv_fromSpeed.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(speed_cal.this);
            builder.setTitle("Choose Speed");

            final String[] flowers = new String[]{
                    "KiloMeter/Hour",
                    "Meter/Minute",
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        fromSpeed = Arrays.asList(flowers).get(i);
                        tv_fromSpeed.setText(fromSpeed);
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

        cv_toSpeed.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(speed_cal.this);
            builder.setTitle("Choose Speed");

            final String[] flowers = new String[]{
                    "KiloMeter/Hour",
                    "Meter/Minute",
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        toSpeed = Arrays.asList(flowers).get(i);
                        tv_toSpeed.setText(toSpeed);
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

    private String KpHintoMpS(double kilomiter){
        double Miter = kilomiter*16.6666667 ;
        return String.valueOf(Miter);
    }

    private String MpMintoKmPh(double Miter){
        double KiloMiter = Miter*3.6   ;
        return  String.valueOf(KiloMiter);
    }
}