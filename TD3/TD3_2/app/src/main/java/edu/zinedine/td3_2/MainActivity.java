package edu.zinedine.td3_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements PizzaAdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupération de la liste des personnes
        PizzaList listP = new PizzaList();
        //Création et initialisation de l'Adapter pour les personnes
        PizzaAdapter adapter = new PizzaAdapter(this, listP);
        //Récupération du composant ListView
        ListView list = (ListView)findViewById(R.id.listView);
        //Initialisation de la liste avec les données
        list.setAdapter(adapter);
        //Ecoute des évènements sur la liste
        adapter.addListener(this);

    }

    public void onClickNom(Pizza item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("PIZZA");
        builder.setMessage("Vous avez cliqué sur : " + item.getName());
        builder.setPositiveButton("Oui", null);
        builder.setNegativeButton("Non", null);
        builder.show();
    }
}