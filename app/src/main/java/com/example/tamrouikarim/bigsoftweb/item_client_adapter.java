package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_client_adapter extends BaseAdapter {
    LayoutInflater minflatter;
    List<String> numero_client_list=new LinkedList<>();
    List<String> raison_social_list=new LinkedList<>();
    List<String> categorie_list=new LinkedList<>();
    List<String> chiffre_affaire_list=new LinkedList<>();
    List<String> paiement_list=new LinkedList<>();
    List<String> solde_list=new LinkedList<>();
    List<String> adresse_list=new LinkedList<>();
    List<String> codetiers=new LinkedList<>();





    public item_client_adapter(Context c,List<String> numero_client,List<String> raison_social,List<String> categorie,List<String> chiffre_affaire,
                               List<String> paiement,List<String> solde,List<String> adresse,List<String> code)
    {
        minflatter=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        numero_client_list=numero_client;
        raison_social_list=raison_social;
        categorie_list=categorie;
        chiffre_affaire_list=chiffre_affaire;
        paiement_list=paiement;
        solde_list=solde;
        adresse_list=adresse;
        codetiers=code;
    }

    @Override
    public int getCount() {
        return numero_client_list.size();
    }

    @Override
    public Object getItem(int position) {

        String info_client[]=new String[3];

        info_client[0]=codetiers.get(position);
        info_client[1]=numero_client_list.get(position);
        info_client[2]=raison_social_list.get(position);

        return info_client;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v =minflatter.inflate(R.layout.client,null);
        TextView numero=(TextView) v.findViewById(R.id.numero_fiche_client);
        TextView raison=(TextView) v.findViewById(R.id.raison_sociale_fiche_client);
        TextView categorie=(TextView) v.findViewById(R.id.categorie_fiche_client);
        TextView chiffre_affaire=(TextView) v.findViewById(R.id.chiffre_affaire_fiche_client);
        TextView paiement=(TextView) v.findViewById(R.id.paiement_fiche_client);
        TextView solde=(TextView) v.findViewById(R.id.solde_fiche_client);
        TextView adresse=(TextView) v.findViewById(R.id.adresse_fiche_client);

        if(numero_client_list.get(position)!=null)numero.setText(numero_client_list.get(position));
        if(raison_social_list.get(position)!=null)raison.setText(raison_social_list.get(position));
        if(categorie_list.get(position)!=null)categorie.setText(categorie_list.get(position));
        if(chiffre_affaire_list.get(position)!=null)chiffre_affaire.setText(chiffre_affaire_list.get(position));
        if(paiement_list.get(position)!=null)paiement.setText(paiement_list.get(position));
        if(solde_list.get(position)!=null)solde.setText(solde_list.get(position));
        if(adresse_list.get(position)!=null)adresse.setText(adresse_list.get(position));

        return v;
    }
}
