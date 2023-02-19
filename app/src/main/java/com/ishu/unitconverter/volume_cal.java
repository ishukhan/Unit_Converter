package com.ishu.unitconverter;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class volume_cal extends AppCompatActivity {

    CardView cv_fromVolume, cv_toVolume, cv_convert;

    RelativeLayout mClayout;

    String fromVolume = "MegaLiter";
    String toVolume = "Liter";

    TextView tv_fromVolume, tv_toVolume;

    EditText et_FromVolume, et_toVolume;

    String[] values = new String[]{
            "MegaLiter",
            "Liter",
            "Ml"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_cal);

        cv_fromVolume = findViewById(R.id.fromVolume);
        cv_toVolume = findViewById(R.id.toVolume);
        cv_convert = findViewById(R.id.cv_convert);

        mClayout = findViewById(R.id.volume_relativeLayout);

        tv_fromVolume = findViewById(R.id.tv_fromVolume);
        tv_toVolume = findViewById(R.id.tv_toVolume);

        tv_fromVolume.setText(values[0]);
        tv_toVolume.setText(values[0]);

        et_FromVolume = findViewById(R.id.et_fromVolume);
        et_toVolume = findViewById(R.id.et_toVolume);

        cv_convert.setOnClickListener(v->{
            String tempInput = et_FromVolume.getText().toString();
            if(tempInput.equals("")|| tempInput == null){
                et_FromVolume.setError("Please Enter Some Value");
            }else {
                if(tv_fromVolume.getText().toString().equals(values[0])){
                    if(tv_toVolume.getText().toString().equals(values[0])){
                        et_toVolume.setText(tempInput);
                    }else if(tv_toVolume.getText().toString().equals(values[1])){
                        et_toVolume.setText(MegaLiterIntoLiter(Double.parseDouble(tempInput)));
                    } else if (tv_toVolume.getText().toString().equals(values[2])) {
                        et_toVolume.setText(MegaLiterIntoMl(Double.parseDouble(tempInput)));
                    }
                    //lITER
                    else if (tv_fromVolume.getText().toString().equals(values[1])) {
                        if (tv_toVolume.getText().toString().equals(values[2])){
                            et_toVolume.setText(LiterIntoMl(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_toVolume.getText().toString().equals(values[0])) {
                            et_toVolume.setText(LiterIntoMegaLiter(Double.parseDouble(tempInput)));
                        }

                    //Ml
                    else if (tv_fromVolume.getText().toString().equals(values[2])) {
                        if (tv_toVolume.getText().toString().equals(values[0])){
                            et_toVolume.setText(MlIntoMegaLiter(Double.parseDouble(tempInput)));
                        } else if (tv_toVolume.getText().toString().equals(values[1])) {
                            et_toVolume.setText(MlIntoLiter(Double.parseDouble(tempInput)));
                        }
                    }
                }
                }

        });

        cv_fromVolume.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(volume_cal.this);
            builder.setTitle("Choose Volume");

            final String[] flowers = new String[]{
                    "MegaLiter",
                    "Liter",
                    "Ml"
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        fromVolume = Arrays.asList(flowers).get(i);
                        tv_fromVolume.setText(fromVolume);
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

        cv_toVolume.setOnClickListener(v -> {

            final AlertDialog.Builder builder = new AlertDialog.Builder(volume_cal.this);
            builder.setTitle("Choose Volume");

            final String[] flowers = new String[]{
                    "MegaLiter",
                    "Liter",
                    "Ml"
            };

            //item click Listener

            builder.setSingleChoiceItems(
                    flowers, //treeList
                    -1, //Index of checked item (-1= no Selection)
                    (dialogInterface, i) -> {

                        // Get the alert dialog selected item's text
                        toVolume = Arrays.asList(flowers).get(i);
                        tv_toVolume.setText(toVolume);
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

    //MegaLiter into Liter
    private String MegaLiterIntoLiter(double MegaLiter){
        double liter = MegaLiter*1000000;
        return String.valueOf(liter);
    }

    //MegaLiter into Ml

    private String MegaLiterIntoMl(double MegaLiter){
        double ml = MegaLiter*1000000000;
        return String.valueOf(ml);
    }

    //Liter into Ml

    private String LiterIntoMl(double liter){
        double ml = liter*1000;
        return String.valueOf(ml);

    }

    private String LiterIntoMegaLiter(double liter){
        double megaliter = liter/1000000;
        return String.valueOf(megaliter);
    }

    //ML into Liter
    private  String MlIntoMegaLiter(double ml){
        double megaLiter = ml/1000000000;
        return String.valueOf(megaLiter);
    }

    private  String MlIntoLiter(double ml){
        double Liter = ml/1000;
        return String.valueOf(Liter);
    }
}