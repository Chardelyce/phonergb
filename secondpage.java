package com.example.phonergb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class secondpage extends AppCompatActivity {




    Object irdaService;
    Method irWrite;
    SparseArray<String> codemap;

    public final String RED_CODE = "0000 006d 0022 0002 0155 00aa 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 003e 0016 003e 0016 0016 0016 003e 0016 0016 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 0612 0155 0055 0016 0e31";
    public final String GREEN_CODE = "0000 006d 0022 0002 0155 00aa 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 0016 0016 003e 0016 003e 0016 0016 0016 003e 0016 0016 0016 0016 0016 003e 0016 003e 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 0612 0155 0055 0016 0e31";
    public final String BLUE_CODE = "0000 006d 0022 0002 0155 00aa 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 003e 0016 003e 0016 0016 0016 003e 0016 0612 0155 0055 0016 0e31";
    public final String WHITE_CODE = "0000 006d 0022 0002 0155 00aa 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 003e 0016 0016 0016 003e 0016 003e 0016 003e 0016 0016 0016 003e 0016 0612 0155 0055 0016 0e31";
    public final String POWER_CODE = "0000 006d 0022 0002 0155 00aa 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 003e 0016 0612 0155 0055 0016 0e31";

    public final String BRIGHTNESS_UP_CODE = "0000 006d 0022 0002 0155 00aa 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 003e 0016 003e 0016 003e 0016 0016 0016 003e 0016 0016 0016 003e 0016 003e 0016 0016 0016 0016 0016 0016 0016 003e 0016 0016 0016 003e 0016 0612 0155 0055 0016 0e31";
    protected String hex2dec( String irData)
    {

        List<String> list = new ArrayList<String>(Arrays.asList(irData
                .split(" ")));
        list.remove(0);
        int frequency = Integer.parseInt(list.remove(0), 16);
        list.remove(0);
        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }

        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));

        irData = "";
        for (String s : list) {
            irData += s + ",";
        }
        return irData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Button buttonexit = (Button) findViewById(R.id.buttonexit);
        buttonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(secondpage.this);
                builder.setTitle("Exit remote");
                builder.setMessage("Do you want to exit ??");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        codemap = new SparseArray<String>();
        codemap.put(R.id.buttonPower, hex2dec(POWER_CODE));
        codemap.put(R.id.buttonRed, hex2dec(RED_CODE));
        codemap.put(R.id.buttonGreen, hex2dec(GREEN_CODE));
        codemap.put(R.id.buttonBlue, hex2dec(BLUE_CODE));
        codemap.put(R.id.buttonWhite, hex2dec(WHITE_CODE));
        codemap.put(R.id.buttonBrightnessUp, hex2dec(BRIGHTNESS_UP_CODE));




        Class c = irdaService.getClass();
        Class params[] = {String.class};
        try {
            irWrite = c.getMethod("write_irsend", params);
        }
        catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }



    public void sendIR(View v){
        Log.i("button click", "pressed " + ((Button) v).getText() + " button");
        try{
            irWrite.invoke(irdaService, codemap.get(v.getId()));
        }
        catch (Exception e){
            e.printStackTrace();
        }




































    }



}