package com.azeem.buttonvisibility;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //create buttons
    private Button btn1;
    private Button btn2;

    // To track visibility of button2
    private boolean isButton2Visible = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        btn1 = new Button(this);
        btn2 = new Button(this);




        //set button texts
        btn1.setText("1:Toggle Button2");
        btn2.setText("2:Move Button1");
        //generate Id for each buttons
        btn1.setId(LinearLayout.generateViewId());
        btn2.setId(LinearLayout.generateViewId());
        //sett button colors
        btn1.setBackgroundColor(Color.RED);
        btn2.setBackgroundColor(Color.GREEN);

        //set layout parameters
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        //
        btn1.setLayoutParams(params);
        btn2.setLayoutParams(params);
        //add buttons to layout
        layout.addView(btn1);
        layout.addView(btn2);

        //set layout as contentVie
        setContentView(layout);

        // Set Click Listner for Buttons

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButton2Visible){
                    btn2.setVisibility(View.INVISIBLE);
                } else {
                    btn2.setVisibility(View.VISIBLE);
                }
                isButton2Visible = !isButton2Visible;

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setTranslationY(btn1.getTranslationY() + 50);
            }
        });







    }

}