package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_bon_retour extends BaseAdapter {

    LayoutInflater bon_retour_inflater;

    List<String> numero_liste= new LinkedList<>();
    List<String> client_liste= new LinkedList<>();
    List<String> date_liste= new LinkedList<>();
    List<String> livraison_liste= new LinkedList<>();
    List<String> etat_compta_liste= new LinkedList<>();
    List<String> unite_liste= new LinkedList<>();



    public  item_bon_retour(Context c, List<String> numero, List<String>  client, List<String> date,  List<String> livraison,  List<String> etat_compta,
                            List<String> unite)
    {
        bon_retour_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        numero_liste=numero;
        client_liste=client;
        date_liste=date;
        livraison_liste=livraison;
        etat_compta_liste=etat_compta;
        unite_liste=unite;

    }



    @Override
    public int getCount() {
        return numero_liste.size();
    }

    @Override
    public Object getItem(int position) {
        return numero_liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = bon_retour_inflater.inflate(R.layout.liste_bon_retour_layout,null);
        TextView numero=(TextView) v.findViewById(R.id.numero_liste_bon_retout_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_bon_retour_txt);
        TextView date=(TextView) v.findViewById(R.id.date_liste_bon_retour_txt);
        TextView livraison=(TextView) v.findViewById(R.id.livraison_liste_bon_retour_txt);
        TextView etat_compta=(TextView) v.findViewById(R.id.etat_compta_liste_bon_retour_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_bon_retour_txt);



        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(client_liste.get(position)!=null)client.setText(client_liste.get(position));
        if(date_liste.get(position)!=null)date.setText(date_liste.get(position));
        if(livraison_liste.get(position)!=null)livraison.setText(livraison_liste.get(position));
        if(etat_compta_liste.get(position)!=null)etat_compta.setText(etat_compta_liste.get(position));
        if(unite_liste.get(position)!=null)unite.setText(unite_liste.get(position));






        return v;
    }
}
