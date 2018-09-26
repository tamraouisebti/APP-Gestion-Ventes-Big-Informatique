package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_bon_livraison extends BaseAdapter {
    LayoutInflater bon_livraison_inflater;
    List<String> numero_liste= new LinkedList<>();
    List<String> commande_liste= new LinkedList<>();
    List<String> facture_liste= new LinkedList<>();
    List<String> client_liste= new LinkedList<>();
    List<String> date_liste= new LinkedList<>();
    List<String> montant_ttc_liste= new LinkedList<>();
    List<String> etat_compta_liste= new LinkedList<>();
    List<String> ods_liste= new LinkedList<>();
    List<String> unite_liste= new LinkedList<>();


    public item_bon_livraison(Context c, List<String> numero,List<String> commande, List<String> facture,List<String> client,List<String> date,
                              List<String> montant_ttc,List<String> etat_compta,List<String> ods,List<String> unite)
    {
        bon_livraison_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        numero_liste=numero;
        commande_liste=commande;
        facture_liste=facture;
        client_liste=client;
        date_liste=date;
        montant_ttc_liste=montant_ttc;
        etat_compta_liste=etat_compta;
        ods_liste=ods;
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

        View v= bon_livraison_inflater.inflate(R.layout.liste_bon_livraison_layout,null);

        TextView numero=(TextView) v.findViewById(R.id.numero_liste_bon_livraison_txt);
        TextView commande=(TextView) v.findViewById(R.id.commande_liste_bon_livraison_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_bon_livraison_txt);
        TextView montant_ttc=(TextView) v.findViewById(R.id.montant_ttc_liste_bon_livraison_txt);
        TextView date=(TextView) v.findViewById(R.id.date_liste_bon_livraison_txt);
        TextView facture=(TextView) v.findViewById(R.id.facture_liste_bon_livraison_txt);
        TextView ods=(TextView) v.findViewById(R.id.ods_liste_bon_livraison_txt);
        TextView etat_compta=(TextView) v.findViewById(R.id.etat_compta_liste_bon_livraison_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_bon_livraison_txt);


        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(commande_liste.get(position)!=null)commande.setText(commande_liste.get(position));
        if(client_liste.get(position)!=null)client.setText(client_liste.get(position));
        if(facture_liste.get(position)!=null)facture.setText(facture_liste.get(position));
        if(date_liste.get(position)!=null)date.setText(date_liste.get(position));
        if(montant_ttc_liste.get(position)!=null)montant_ttc.setText(montant_ttc_liste.get(position));
        if(ods_liste.get(position)!=null)ods.setText(ods_liste.get(position));
        if(etat_compta_liste.get(position)!=null)etat_compta.setText(etat_compta_liste.get(position));
        if(unite_liste.get(position)!=null)unite.setText(unite_liste.get(position));





        return v;
    }
}
