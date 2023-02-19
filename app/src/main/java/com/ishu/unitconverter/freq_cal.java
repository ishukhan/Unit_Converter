package com.ishu.unitconverter;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class freq_cal extends AppCompatActivity {

    CardView cv_fromFreq, cv_toFreq, cv_convert;

    RelativeLayout mClayout;

    String fromFreq = "MegaHertz";
    String toFreq= "Hertz";

    TextView tv_fromFreq, tv_toFreq;

    EditText et_fromFreq, et_toFreq;

    String[] values = new String[]{
            "MegaHertz",
            "Hertz"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freq_cal);

        cv_fromFreq= findViewById(R.id.fromFreq);
        cv_toFreq = findViewById(R.id.toFreq);
        cv_convert = findViewById(R.id.cv_convert);
        mClayout = findViewById(R.id.freq_relativeLayout);

        tv_fromFreq = findViewById(R.id.tv_fromFreq);
        tv_toFreq = findViewById(R.id.tv_toFreq);

        tv_fromFreq.setText(values[0]);
        tv_toFreq.setText(values[0]);

        et_fromFreq = findViewById(R.id.et_fromFreq);
        et_toFreq = findViewById(R.id.et_toFreq);

        cv_convert.setOnClickListener(v->{
             String tempInput = et_fromFreq.getText().toString();
            if(tempInput.equals("")){
                et_fromFreq.setError("Please Enter Some Value");
            }else{
                if(tv_fromFreq.getText().toString().equals(values[0])){
                    if(tv_toFreq.getText().toString().equals(values[0])){
                        et_toFreq.setText(tempInput);
                    } else if (tv_toFreq.getText().toString().equals(values[1])) {
                        et_toFreq.setText(MeagaHertzTohertz(Double.parseDouble(tempInput)));
                    } else if (tv_fromFreq.getText().toString().equals(values[1])) {
                        if(tv_toFreq.getText().toString().equals(values[0])){
                            et_toFreq.setText(HertzToMegaHertz(Double.parseDouble(tempInput)));
                        }
                    }
                }
            }
        });

        cv_fromFreq.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(freq_cal.this);
            builder.setTitle("Choose Frequency");

            final String[] flowers = new String[]{
                    "MegaHertz",
                    "Hertz",
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        String selectedItem = Arrays.asList(flowers).get(i);
                        fromFreq = selectedItem;
                        tv_fromFreq.setText(fromFreq);
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

        cv_toFreq.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(freq_cal.this);
            builder.setTitle("Choose Frequency");

            final String[] flowers = new String[]{
                    "MegaHertz",
                    "Hertz",
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        String selectedItem = Arrays.asList(flowers).get(i);
                        toFreq = selectedItem;
                        tv_toFreq.setText(toFreq);
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
    private String MeagaHertzTohertz(double megaHertz){
        double Hertz = megaHertz*1000000 ;
        return String.valueOf(Hertz);
    };

    private String HertzToMegaHertz(double Hz){
        double MhZ = Hz/1000000;
        return String.valueOf(MhZ);
    };
}