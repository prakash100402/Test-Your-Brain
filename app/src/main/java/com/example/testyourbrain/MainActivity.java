package com.example.testyourbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {


    Button  btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView txt;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    GridLayout gridLayout;
    int correct;
    int score=0;
    int noque=0;
    ArrayList<Integer> ans = new ArrayList<Integer>();

    public void playagain(View view)
    {
        score=0;
        noque=0;
        txt2.setText("30s");
        txt1.setText(Integer.toString(score)+"/"+Integer.toString(noque));
        newque();

        new CountDownTimer(31000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                txt2.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                txt3.setTextColor(Color.parseColor("#FD0101"));
                txt3.setText("Time Over!");

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("score",score);
                intent.putExtra("noque",noque);
                startActivity(intent);

            }
        }.start();


    }

    public void chooseans(View view)
    {
       if (Integer.toString(correct).equals(view.getTag().toString()))
       {
           txt3.setTextColor(Color.parseColor("#009688"));
           txt3.setText("Correct :)");
           score++;
       }
       else
       {
           txt3.setTextColor(Color.parseColor("#E91E63"));
           txt3.setText("Wrong :(");
       }
       noque++;
       txt1.setText(Integer.toString(score)+"/"+Integer.toString(noque));
       newque();
    }

    public void newque()
    {
        Random rand = new Random();
        int a = rand.nextInt(201);
        int b = rand.nextInt(150);
        txt.setText(Integer.toString(a) + "+" + Integer.toString(b));
        correct = rand.nextInt(4);
        ans.clear();

        for (int i = 0; i < 4; i++)
        {
            if (i==correct)
            {
                ans.add(a+b);
            }
            else
            {
                int wrongans=rand.nextInt(350);
                while ((a+b) == wrongans)
                {
                    wrongans=rand.nextInt(350);
                }
                ans.add(wrongans);
            }
        }
        btn1.setText(Integer.toString(ans.get(0)));
        btn2.setText(Integer.toString(ans.get(1)));
        btn3.setText(Integer.toString(ans.get(2)));
        btn4.setText(Integer.toString(ans.get(3)));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView3);
        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView4);
        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);
        btn3 = findViewById(R.id.button4);
        btn4 = findViewById(R.id.button5);

        playagain(findViewById(R.id.button3));


    }
}