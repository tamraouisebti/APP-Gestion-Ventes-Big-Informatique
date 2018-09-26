package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_facture_client extends BaseAdapter {
    LayoutInflater facture_client_inflater;

    List<String> numero_liste= new LinkedList<>();
    List<String>  commande_liste= new LinkedList<>();
    List<String> client_liste= new LinkedList<>();
    List<String>  date_liste= new LinkedList<>();
    List<String> date_echeance_liste= new LinkedList<>();
    List<String>  montant_ttc_liste= new LinkedList<>();
    List<String>  reste_payer_liste= new LinkedList<>();
    List<String>  etat_liste= new LinkedList<>();
    List<String> etat_livraison_liste= new LinkedList<>();
    List<String>  etat_compta_liste= new LinkedList<>();
    List<String>  unite_liste= new LinkedList<>();

    public item_facture_client(Context c, List<String> numuro, List<String>  commande,  List<String> client, List<String>  date,
                               List<String> date_echeance, List<String>  montant_ttc, List<String>  reste_payer, List<String>  etat,
                               List<String> etat_livraison, List<String>  etat_compta, List<String>  unite)
    {
        facture_client_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        numero_liste=numuro;
        commande_liste=commande;
        client_liste=client;
        date_liste=date;
        date_echeance_liste=date_echeance;
        montant_ttc_liste=montant_ttc;
        reste_payer_liste=reste_payer;
        etat_liste=etat;
        etat_livraison_liste=etat_livraison;
        etat_compta_liste=etat_compta;
        unite_liste=unite;






    }
    @Override
    public int getCount() {
        return numero_liste.size();
    }

    @Override
    public Object getItem(int position) { return numero_liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v =facture_client_inflater.inflate(R.layout.liste_facture_client_layout,null);
        TextView numero=(TextView) v.findViewById(R.id.numero_liste_facture_client_txt);
        TextView commande=(TextView) v.findViewById(R.id.commande_liste_facture_client_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_facture_client_txt);
        TextView date=(TextView) v.findViewById(R.id.date_liste_facture_client_txt);
        TextView date_echeance=(TextView) v.findViewById(R.id.date_echeance_liste_facture_client_txt);
        TextView monant_ttc=(TextView) v.findViewById(R.id.montanat_ttc_liste_facture_client_txt);
        TextView reste_payer=(TextView) v.findViewById(R.id.reste_payer_liste_facture_client_txt);
        TextView etat=(TextView) v.findViewById(R.id.etat_liste_facture_client_txt);
        TextView etat_livraison=(TextView) v.findViewById(R.id.etat_livraison_liste_facture_client_txt);
        TextView etat_compta=(TextView) v.findViewById(R.id.etat_compta_liste_facture_client_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_facture_client_txt);


        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(commande_liste.get(position)!=null)commande.setText(commande_liste.get(position));
        if(client_liste.get(position)!=null)client.setText(client_liste.get(position));
        if(date_liste.get(position)!=null)date.setText(date_liste.get(position));
        if(date_echeance_liste.get(position)!=null)date_echeance.setText(date_echeance_liste.get(position));
        if(montant_ttc_liste.get(position)!=null)monant_ttc.setText(montant_ttc_liste.get(position));
        if(reste_payer_liste.get(position)!=null)reste_payer.setText(reste_payer_liste.get(position));
        if(etat_liste.get(position)!=null)etat.setText(etat_liste.get(position));
        if(etat_compta_liste.get(position)!=null)etat_compta.setText(etat_compta_liste.get(position));
        if(etat_livraison_liste.get(position)!=null)etat_livraison.setText(etat_livraison_liste.get(position));
        if(unite_liste.get(position)!=null)unite.setText(unite_liste.get(position));





        return v;
    }
}
