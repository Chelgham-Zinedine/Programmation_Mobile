package edu.zinedine.td2exo3;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Vector;


public class MainActivity extends Activity {

    //Clé pour l'enregistrement et la récupération de la variable vitesseReapparition
    private static final String ANIM_LENGTH_PREF = "vitesseReapparition";
    private static final String LIST_BUTTON = "listOfButton";

    /**
     * Durée le l'animation de réapparition, en millisecondes. Est modifiée
     * quand on déplace la SeekBar, et sauvegardée dans les SharedPreferences
     * dans onPause().
     */
    private int vitesseReapparition; //Durée le l'animation de réapparition, en millisecondes
    private TextView texteDeLaSeekBar;


    final Vector<Button> maListeDeBoutons = new Vector<Button>(); //Liste des boutons (sauf bouton "Réapparition")



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupération de la valeur sauvegardée de vitesseReapparition
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        vitesseReapparition = preferences.getInt(ANIM_LENGTH_PREF, 400); //400 si rien de sauvé


        //récupération de la seekBar (final obligatoire car utilisé dans innerclass)
       // texteDeLaSeekBar = (TextView) findViewById(R.id.tvAnimDuration);
        SeekBar maSeekBar = (SeekBar) findViewById(R.id.seekBar);

        //récupération des boutons
        Button btFondu = (Button) findViewById(R.id.button_fondu);
        Button btRetrecissement = (Button) findViewById(R.id.button_retrecissement);
        Button btSortie = (Button) findViewById(R.id.button_sortie);
        Button btFonduAgrandissement = (Button) findViewById(R.id.button_fondu_Agrandissement);
        Button btTvOff = (Button) findViewById(R.id.button_tvOff);
        Button btvReapparition = (Button) findViewById(R.id.button_respawn);


        /*
         * Liste des boutons (sauf bouton "Réapparition"). Sert à tester la
         * visibilité des boutons et lancer ou non l'animation de réapparition
         * sur chaque bouton.
         */
        maListeDeBoutons.add(btFondu);
        maListeDeBoutons.add(btRetrecissement);
        maListeDeBoutons.add(btSortie);
        maListeDeBoutons.add(btFonduAgrandissement);
        maListeDeBoutons.add(btTvOff);



        //écouteurs sur chaque bouton pour lancer l'animation associée

        btFondu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View bt) {
                bt.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fondu));
                bt.setVisibility(View.INVISIBLE);
            }
        });


        btRetrecissement.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View bt) {
                bt.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.retrecissement));
                bt.setVisibility(View.INVISIBLE);
            }
        });


        btSortie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View bt) {
                bt.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.sortie));
                bt.setVisibility(View.INVISIBLE);
            }
        });


        btFonduAgrandissement.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View bt) {
                bt.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fondu_agrandissement));
                bt.setVisibility(View.INVISIBLE);
            }
        });


        btTvOff.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View bt) {
                bt.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.tv_off));
                bt.setVisibility(View.INVISIBLE);
            }
        });


        btvReapparition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animReapparition = AnimationUtils.loadAnimation( MainActivity.this, R.anim.respawn);
                animReapparition.setDuration(vitesseReapparition);
                /*
                 * Pour chaque bouton, s'il n'est pas visible, on lance
                 * l'animation de réapparition et on le repasse en visible
                 */
                for (Button unBouton : maListeDeBoutons)
                    if (unBouton.getVisibility() != View.VISIBLE) {
                        //button.startAnimation(reapparition);
                        unBouton.startAnimation(animReapparition);
                        unBouton.setVisibility(View.VISIBLE);
                    }
            }

        });







        maSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
                vitesseReapparition = progress;
                texteDeLaSeekBar.setText(vitesseReapparition +"");
            }
        });




        /*
         * On place la SeekBar sur la valeur de vitesseReapparition, récupérée depuis les
         * SharedPreferences, ce qui appelera le listener défini précédemment et
         * mettra aussi le TextView à jour
         */
        maSeekBar.setProgress(vitesseReapparition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        ArrayList<Integer> list = new ArrayList<>();
        maListeDeBoutons.forEach( button -> list.add(button.getVisibility()) );
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(ANIM_LENGTH_PREF, vitesseReapparition);
        savedInstanceState.putIntegerArrayList(LIST_BUTTON, list);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        vitesseReapparition = savedInstanceState.getInt(ANIM_LENGTH_PREF);
        texteDeLaSeekBar.setText(vitesseReapparition +"");
        ArrayList<Integer> list = savedInstanceState.getIntegerArrayList(LIST_BUTTON);
        int i=0;
        for (Button unBouton : maListeDeBoutons)
            unBouton.setVisibility( list.get(i++) ) ;
        Log.d("Zinedine","hello");
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*
         * Sauvegarde de la valeur de vitesseReapparition.
         */
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        preferences.edit().putInt(ANIM_LENGTH_PREF, vitesseReapparition).commit();
    }

}
