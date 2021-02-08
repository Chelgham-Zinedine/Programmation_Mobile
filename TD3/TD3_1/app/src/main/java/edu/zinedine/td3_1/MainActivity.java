package edu.zinedine.td3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CharactersList characters = new CharactersList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spiner = findViewById(R.id.spinner);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Character c = characters.get(spiner.getSelectedItemPosition());
                ImageView img = findViewById(R.id.imageView);
                img.setBackgroundResource(c.getPictureNumber());
                TextView tv = findViewById(R.id.textView);
                tv.setText(c.getDescription());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"Rien de selectionné", Toast.LENGTH_SHORT).show();
            }
        });
    }
}