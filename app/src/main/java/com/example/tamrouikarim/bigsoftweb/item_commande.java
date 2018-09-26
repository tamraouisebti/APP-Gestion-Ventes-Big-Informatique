package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_commande extends BaseAdapter {

    LayoutInflater commande_inflater;
    List<String> numero_commande_list= new LinkedList<>();
    List<String>  client_commande_list= new LinkedList<>();
    List<String>  date_commande_list= new LinkedList<>();
    List<String>  montant_ttc_commande_list= new LinkedList<>();
    List<String>  montant_rest_commande_list= new LinkedList<>();
    List<String>  etat_commande_list= new LinkedList<>();
    List<String>  etat_livraison_commande_list= new LinkedList<>();
    List<String>  unite_commande_list= new LinkedList<>();
    List<String>  code_cmd= new LinkedList<>();


    public item_commande(Context c, List<String> numero_commande, List<String>  client_commande, List<String>  date_commande, List<String>  montant_ttc_commande,
                         List<String>  montant_rest_commande, List<String>  etat_commande, List<String>  etat_livraison_commande, List<String>  unite_commande,
                         List<String> code)
    {
        commande_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        numero_commande_list= numero_commande;
         client_commande_list= client_commande;
         date_commande_list= date_commande;
         montant_ttc_commande_list= montant_ttc_commande;
         montant_rest_commande_list= montant_rest_commande;
         etat_commande_list= etat_commande;
         etat_livraison_commande_list= etat_livraison_commande;
         unite_commande_list= unite_commande;
         code_cmd=code;
    }

    @Override
    public int getCount() {
        return numero_commande_list.size();
    }

    @Override
    public Object getItem(int position)
    {   String commande_info[]=new String[2];
         commande_info[0]=code_cmd.get(position);
         commande_info[1]=numero_commande_list.get(position);
        return commande_info;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =commande_inflater.inflate(R.layout.liste_commande_layout,null);

        TextView numero=(TextView) v.findViewById(R.id.numero_liste_commande_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_commande_txt);
        TextView date=(TextView) v.findViewById(R.id.date_liste_commande_txt);
        TextView monatnat_ttc=(TextView) v.findViewById(R.id.montant_ttc_liste_commande_txt);
        TextView montant_rest=(TextView) v.findViewById(R.id.reste_facturer_liste_commande_txt);
        TextView etat=(TextView) v.findViewById(R.id.etat_liste_commande_txt);
        TextView etat_livraison=(TextView) v.findViewById(R.id.etat_livraison_liste_commande_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_commande_txt);



        if(numero_commande_list.get(position)!=null)numero.setText(numero_commande_list.get(position));
        if(client_commande_list.get(position)!=null)client.setText(client_commande_list.get(position));
        if(date_commande_list.get(position)!=null)date.setText(date_commande_list.get(position));
        if(montant_ttc_commande_list.get(position)!=null)monatnat_ttc.setText(montant_ttc_commande_list.get(position));
        if(montant_rest_commande_list.get(position)!=null)montant_rest.setText(montant_rest_commande_list.get(position));
        if(etat_commande_list.get(position)!=null)etat.setText(etat_commande_list.get(position));
        if(etat_livraison_commande_list.get(position)!=null)etat_livraison.setText(etat_livraison_commande_list.get(position));
        if(unite_commande_list.get(position)!=null)unite.setText(unite_commande_list.get(position));








        return v;
    }
}

