package edu.zinedine.td1_4;

import androidx.annotation.NonNull;
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
        if(savedInstanceState != null) {
            compteur = savedInstanceState.getInt("count");
            tCompteur.setText(String.valueOf(compteur));
        }

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",compteur);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.get("count");
    }
}