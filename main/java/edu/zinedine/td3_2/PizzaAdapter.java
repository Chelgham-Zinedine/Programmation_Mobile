package edu.zinedine.td3_2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class PizzaAdapter extends BaseAdapter {
    private Context context;
    private PizzaList pizzaList;
    private LayoutInflater inflater;


    public PizzaAdapter(Context context, PizzaList pizzaList){
    this.context = context;
    this.pizzaList = pizzaList;
    this.inflater =  LayoutInflater.from(context);


    }

    @Override
    public int getCount() {
        return pizzaList.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        // Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir de "personne_layout.xml"
            layoutItem = (LinearLayout) inflater.inflate(R.layout.pizza_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }
        // Récupération des TextView du layout
        TextView tv_pizza_info = (TextView) layoutItem.findViewById(R.id.TV_pizza_info);
        ImageView img_pizza = (ImageView) layoutItem.findViewById(R.id.pizza_img);
        // Renseignement des valeurs
        tv_pizza_info.setText(pizzaList.get(position).getName() + "     " + pizzaList.get(position).getPrice() + " €");
        img_pizza.setBackgroundResource(pizzaList.get(position).getPictureNumber());

        //Changement de la couleur du fond de l item
        if (pizzaList.get(position).getPrice() > 5) {
            tv_pizza_info.setBackgroundColor(Color.RED);
        } else {
            tv_pizza_info.setBackgroundColor(Color.GREEN);
            tv_pizza_info.setTag(position);

            //On ajoute un listener
            tv_pizza_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer position = (Integer) v.getTag();
                    sendListener(pizzaList.get(position), position);
                }
            });
        }
        //On retourne l'item créé.
        return layoutItem;
    }





    private ArrayList<PizzaAdapterListener> mListListener = new ArrayList<>();

    //Pour ajouter un listener sur l’ adapter
    public void addListener(PizzaAdapterListener aListener) {
        mListListener.add(aListener);
    }
    //permet de prévenir tous les listeners en même temps pour diffuser une information
    private void sendListener(Pizza item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }
}



