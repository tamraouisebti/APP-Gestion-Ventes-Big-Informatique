package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_location_liste extends BaseAdapter {

    LayoutInflater location_liste_inflater;
    List<String> numero_location= new LinkedList<>();
    List<String>  commande_location = new LinkedList<>();
    List<String>  contrat_location = new LinkedList<>();
    List<String> client_location = new LinkedList<>();
    List<String>  date_debut_loc_location = new LinkedList<>();
    List<String>  date_fin_loc_location = new LinkedList<>();
    List<String> commercial_location = new LinkedList<>();
    List<String>  unite_location = new LinkedList<>();

    public item_location_liste(Context c, List<String> numero_location_liste, List<String>  commande_location_liste, List<String>  contrat_location_liste,
                               List<String> client_location_liste, List<String>  date_debut_loc_location_liste, List<String>  date_fin_loc_location_liste,
                               List<String> commercial_location_liste, List<String>  unite_location_liste)
    {location_liste_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        numero_location=numero_location_liste;
        commande_location=commande_location_liste;
        contrat_location=contrat_location_liste;
        client_location=client_location_liste;
        date_debut_loc_location=date_debut_loc_location_liste;
        date_fin_loc_location=date_fin_loc_location_liste;
        commercial_location=commercial_location_liste;
        unite_location=unite_location_liste;

    }



    @Override
    public int getCount() {
        return numero_location.size();
    }

    @Override
    public Object getItem(int position) {
        return numero_location.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =location_liste_inflater.inflate(R.layout.liste_location_liste_layout,null);

        TextView numero =(TextView) v.findViewById(R.id.numero_liste_location_liste_txt);
        TextView commande=(TextView) v.findViewById(R.id.commande_liste_location_liste_txt);
        TextView contrat=(TextView) v.findViewById(R.id.contrat_liste_location_liste_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_location_liste_txt);
        TextView date_debut=(TextView) v.findViewById(R.id.date_debut_loc_liste_location_liste_txt);
        TextView date_fin=(TextView) v.findViewById(R.id.date_fin_loc_liste_location_liste_txt);
        TextView commercial=(TextView) v.findViewById(R.id.commercial_liste_location_liste_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_location_liste_txt);



        if(numero_location.get(position)!=null)numero.setText(numero_location.get(position));
        if(commande_location.get(position)!=null)commande.setText(commande_location.get(position));
        if(contrat_location.get(position)!=null)contrat.setText(contrat_location.get(position));
        if(client_location.get(position)!=null)client.setText(client_location.get(position));
        if(date_debut_loc_location.get(position)!=null)date_debut.setText(date_debut_loc_location.get(position));
        if(date_fin_loc_location.get(position)!=null)date_fin.setText(date_fin_loc_location.get(position));
        if(commercial_location.get(position)!=null)commercial.setText(commercial_location.get(position));
        if(unite_location.get(position)!=null)unite.setText(unite_location.get(position));








        return v;
    }
}
