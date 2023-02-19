package com.ishu.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class weight_cal extends AppCompatActivity {

    CardView cv_formWeight, cv_toWeight, cv_Convert;

    RelativeLayout mClayout;

    String fromWeight = "KiloGram";
    String toWeight = "Gram";
    TextView tv_fromWeight, tv_toWeight;

    EditText et_fromWeight, et_toWeigth;

    final String[] values = new String[]{
            "Kilogram",
            "Gram",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_cal);

        cv_formWeight = findViewById(R.id.fromWeight);
        cv_toWeight = findViewById(R.id.toWeight);
        cv_Convert = findViewById(R.id.cv_convert);

        mClayout = findViewById(R.id.weight_relativeLayout);

        tv_fromWeight = findViewById(R.id.tv_fromWeight);
        tv_toWeight = findViewById(R.id.tv_toWeigth);

        tv_fromWeight.setText(values[0]);
        tv_toWeight.setText(values[0]);

        et_fromWeight = findViewById(R.id.et_fromWeight);
        et_toWeigth = findViewById(R.id.et_toWeight);

        cv_Convert.setOnClickListener(v->{
            String tempInput  = et_fromWeight.getText().toString();
            if(tempInput.equals("")){
                et_fromWeight.setError("Please enter Some value");
            }
            else {
                if(tv_fromWeight.getText().toString().equals(values[0])){
                    if(tv_toWeight.getText().toString().equals(values[0])){
                        et_toWeigth.setText(tempInput);
                    } else if (tv_toWeight.getText().toString().equals(values[1])) {
                        et_toWeigth.setText(KilogramToGram(Double.parseDouble(tempInput)));
                    }
                } else if (tv_fromWeight.getText().toString().equals(values[1])) {
                    if(tv_toWeight.getText().toString().equals(values[0])){
                        et_toWeigth.setText(GramtoKilogram(Double.parseDouble(tempInput)));
                    }
                }
            }
        });

        cv_formWeight.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
            builder.setTitle("Choose Weight");

            final String[] flowers = new String[]{
                    "Kilogram",
                    "Gram",

            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        String selectedItem = Arrays.asList(flowers).get(i);
                        fromWeight = selectedItem;
                        tv_fromWeight.setText(fromWeight);
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


        cv_toWeight.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
            builder.setTitle("Choose Weight");

            final String[] flowers = new String[]{
                    "Kilogram",
                    "Gram",

            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        String selectedItem = Arrays.asList(flowers).get(i);
                        toWeight = selectedItem;
                        tv_toWeight.setText(toWeight);
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

    //Kilogram
    private String KilogramToGram(double Kilogram){
       double Gram = Kilogram*1000;
       return String.valueOf(Gram);
    };

//    Gram
    private String GramtoKilogram(double Gram){
        double Kilogram = Gram/1000;
        return String.valueOf(Kilogram);
    }

}