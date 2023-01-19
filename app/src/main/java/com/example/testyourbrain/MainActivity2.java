package com.example.testyourbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = findViewById(R.id.button);
       TextView txt = findViewById(R.id.textView6);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        int intValue2 = mIntent.getIntExtra("noque", 0);

        txt.setText(intValue+"/"+intValue2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
            }
        });

    }
}