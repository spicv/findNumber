package com.example.findnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    GridLayout gl;
    TextView tvNumber;
    Button btnStart;
    ArrayList<String> numbers=new ArrayList<>();
    HashMap<String,Integer>getNumber=new HashMap<>();
    Button[][]buttons=new Button[3][3];
    int value=1;
    String str;
    int btnNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl=findViewById(R.id.gl);
        tvNumber=findViewById(R.id.tvNumber);
        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);

        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");
        numbers.add("six");
        numbers.add("seven");
        numbers.add("eight");
        numbers.add("nine");

        for (int i = 0; i < numbers.size(); i++) {
            getNumber.put(numbers.get(i),value);
            value++;
        }

    }

    @Override
    public void onClick(View view) {
        Button b=(Button) view;
        String buttonText = b.getText().toString();
        if (!buttonText.equalsIgnoreCase("start game")) {
            btnNumber = Integer.parseInt(buttonText);
        }
        if (buttonText.equalsIgnoreCase("start game")){
            gl.setVisibility(View.VISIBLE);
            tvNumber.setVisibility(View.VISIBLE);
            createBoard();
            btnStart.setVisibility(View.INVISIBLE);
        }
        if (getNumber.get(str)==btnNumber){
            gl.setVisibility(View.INVISIBLE);
            tvNumber.setVisibility(View.INVISIBLE);
            btnStart.setVisibility(View.VISIBLE);



        }
    }


    public void createBoard(){
        int visibleButtons=0;
        int index=1;

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                LinearLayout.LayoutParams LL1=new LinearLayout.LayoutParams(200,200);
                Button btn=new Button(this);
                btn.setLayoutParams(LL1);
                btn.setTextSize(25);
                btn.setVisibility(View.INVISIBLE);
                btn.setOnClickListener(this);
                buttons[i][j]=btn;
                gl.addView(btn);
            }
        }
        while (visibleButtons<9){
            Random random = new Random();
            int max=3;
            int rnd1=random.nextInt(max);
            int rnd2=random.nextInt(max);
            if (buttons[rnd1][rnd2].getVisibility() != View.VISIBLE) {
                buttons[rnd1][rnd2].setVisibility(View.VISIBLE);
                buttons[rnd1][rnd2].setText(index+"");
                index++;
                visibleButtons++;
            }
        }
        Random random2 = new Random();
        int max2=9;
        int rnd=random2.nextInt(max2);
        str=numbers.get(rnd);
        tvNumber.setText(str.toUpperCase());
    }
}