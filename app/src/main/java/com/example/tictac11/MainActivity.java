package com.example.tictac11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //1 = x, 0 = o
    int turn = 1;
    int[][] bourd = { {-1,-2,-3},{-4,-5,-6},{-7,-8,-9} };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBoard(View v) {
        String name = v.getResources().getResourceName(v.getId()).split("/")[1];
        if (turn == 0) {
            v.setBackgroundResource(R.drawable.o);
        } else {
            v.setBackgroundResource(R.drawable.x);
        }
        addToMatrix(name, turn);

        if (turn == 1) {
            findViewById(R.id.HowPlay).setBackgroundResource(R.drawable.oplay);
        } else {
            findViewById(R.id.HowPlay).setBackgroundResource(R.drawable.xplay);
        }
        if (turn == 0) turn = 1;
        else turn = 0;
        int win = howWin();
        if (win == 1){
            findViewById(R.id.win).setBackgroundResource(R.drawable.xwin);
            findViewById(R.id.playAgain).setVisibility(View.VISIBLE);

        }
        if (win == 0){
            findViewById(R.id.win).setBackgroundResource(R.drawable.owin);
            findViewById(R.id.playAgain).setVisibility(View.VISIBLE);

        }
    }

    public void reset(View v) {
        //1 = x, 0 = o
        turn = 1;
        bourd = new int[][]{{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
        findViewById(R.id.p1).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p2).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p3).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p4).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p5).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p6).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p7).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p8).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.p9).setBackgroundResource(R.drawable.empty);

        findViewById(R.id.win).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.mark).setBackgroundResource(R.drawable.empty);
        findViewById(R.id.HowPlay).setBackgroundResource(R.drawable.xplay);

    }
    public void addToMatrix(String id, int howPlay) {
        if (id.equals("p1")) bourd[0][0] = howPlay;
        if (id.equals("p2")) bourd[0][1] = howPlay;
        if (id.equals("p3")) bourd[0][2] = howPlay;
        if (id.equals("p4")) bourd[1][0] = howPlay;
        if (id.equals("p5")) bourd[1][1] = howPlay;
        if (id.equals("p6")) bourd[1][2] = howPlay;
        if (id.equals("p7")) bourd[2][0] = howPlay;
        if (id.equals("p8")) bourd[2][1] = howPlay;
        if (id.equals("p9")) bourd[2][2] = howPlay;
    }

    public int howWin() {
        //****
       if (bourd[0][0] == bourd[0][1] && bourd[0][1] == bourd[0][2]) {
            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark1);
           return bourd[0][0];
        }
        if (bourd[0][0] == bourd[1][0] && bourd[1][0] == bourd[2][0]) {
            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark3);
            return bourd[0][0];
        }
        //***
//        if (bourd[2][0] == bourd[2][1] && bourd[2][1] == bourd[2][2]) {
//            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark1);
//            return bourd[2][0];
//        }
        if (bourd[0][1] == bourd[1][1] && bourd[1][1] == bourd[2][1]) {
            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark4);
            return bourd[0][1];
        }
        ////****
//        if (bourd[1][0] == bourd[1][1] && bourd[1][1] == bourd[1][2]) {
//            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark5);
//            return bourd[1][0];
//        }
        if (bourd[0][2] == bourd[1][2] && bourd[1][2] == bourd[2][2]) {
            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark5);
            return bourd[0][2];
        }
        if (bourd[0][0] == bourd[1][1] && bourd[1][1] == bourd[2][2]) {
            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark1);
            return bourd[0][0];
        }
        if (bourd[0][2] == bourd[1][1] && bourd[1][1] == bourd[2][0]) {
            findViewById(R.id.mark).setBackgroundResource(R.drawable.mark2);
            return bourd[2][0];
        }
        return -1;
    }
//TODO::: visabel +
}