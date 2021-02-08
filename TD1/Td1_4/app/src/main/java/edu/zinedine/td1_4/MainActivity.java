package edu.zinedine.td1_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int compteur=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tCompteur = findViewById(R.id.textView);


        Button bMoins = findViewById(R.id.button2);
        bMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compteur--;
                tCompteur.setText(compteur+"");
            }
        });

        Button bPlus = findViewById(R.id.button);
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compteur++;
                tCompteur.setText(compteur+"");
            }
        });

    }


}