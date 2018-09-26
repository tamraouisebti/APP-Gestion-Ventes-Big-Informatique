package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_article_bon_retour extends BaseAdapter {

    LayoutInflater minftaler;
    List<String> numero_liste = new LinkedList<>();
    List<String>  lib_liste = new LinkedList<>();
    List<String>  um_liste = new LinkedList<>();
    List<String>  magasin_liste = new LinkedList<>();
    List<String>  magasin_l_liste = new LinkedList<>();
    List<String> qte_liv_liste = new LinkedList<>();
    List<String> reste_ret_liste = new LinkedList<>();
    List<String>  qte_liste = new LinkedList<>();
    List<String> remise_liste = new LinkedList<>();
    List<String>  tva_liste = new LinkedList<>();
    List<String> montant_liste = new LinkedList<>();
    List<String> prix_u_liste = new LinkedList<>();

    public item_article_bon_retour(Context c, List<String> numero, List<String>  lib, List<String>  um, List<String>  magasin, List<String>  magasin_l,
                                   List<String> qte_liv,  List<String> reste_ret, List<String>  qte,  List<String> remise,List<String> prix_u, List<String>  tva,
                                   List<String> montant)
    {
        minftaler= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        numero_liste=numero;
        lib_liste=lib;
        um_liste=um;
        magasin_liste=magasin;
        magasin_l_liste=magasin_l;
        qte_liv_liste=qte_liv;
        reste_ret_liste=reste_ret;
        qte_liste=qte;
        remise_liste=remise;
        tva_liste=tva;
        montant_liste=montant;
        prix_u_liste=prix_u;
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

        View v = minftaler.inflate(R.layout.liste_article_bon_livraison_layout,null);

        TextView numero=(TextView) v.findViewById(R.id.numero_article_bon_retour_txt);
        TextView lib=(TextView) v.findViewById(R.id.libelle_article_bon_retour_txt);
        TextView um=(TextView) v.findViewById(R.id.um_article_bon_retour_txt);
        TextView magasin=(TextView) v.findViewById(R.id.magasin_article_bon_retour_txt);
        TextView magasin_l=(TextView) v.findViewById(R.id.magasin_article_bon_retour_txt);
        TextView qte=(TextView) v.findViewById(R.id.qte_article_bon_retour_txt);
        TextView reste_ret=(TextView) v.findViewById(R.id.reste_ret_article_bon_retour_txt);
        TextView prix_u=(TextView) v.findViewById(R.id.prix_u_fact_article_bon_retour_txt);
        TextView remise=(TextView) v.findViewById(R.id.remise_retour_article_bon_retour_txt);
        TextView tva=(TextView) v.findViewById(R.id.tva_article_bon_retour_txt);
        TextView montant=(TextView) v.findViewById(R.id.montant_article_bon_retour_txt);
        TextView qte_liv=(TextView) v.findViewById(R.id.qte_liv_article_bon_retour_txt);


        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(lib_liste.get(position)!=null)lib.setText(lib_liste.get(position));
        if(um_liste.get(position)!=null)um.setText(um_liste.get(position));
        if(magasin_liste.get(position)!=null)magasin.setText(magasin_liste.get(position));
        if(magasin_l_liste.get(position)!=null)magasin_l.setText(magasin_l_liste.get(position));
        if(qte_liv_liste.get(position)!=null)qte_liv.setText(qte_liv_liste.get(position));
        if(remise_liste.get(position)!=null)remise.setText(remise_liste.get(position));
        if(qte_liste.get(position)!=null)qte.setText(qte_liste.get(position));
        if(prix_u_liste.get(position)!=null)prix_u.setText(prix_u_liste.get(position));
        if(reste_ret_liste.get(position)!=null)reste_ret.setText(reste_ret_liste.get(position));
        if(tva_liste.get(position)!=null)tva.setText(tva_liste.get(position));
        if(montant_liste.get(position)!=null)montant.setText(montant_liste.get(position));









        return v;
    }
}
