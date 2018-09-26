package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_article_bon_livraison extends BaseAdapter {

    LayoutInflater minflater;
    List<String> numero_liste = new LinkedList<>();
    List<String> lib_article_liste = new LinkedList<>();
    List<String> um_liste = new LinkedList<>();
    List<String>magasin_liste = new LinkedList<>();
    List<String> magasin_l_liste = new LinkedList<>();
    List<String> qte_stock_liste = new LinkedList<>();
    List<String> qte_reserve_liste = new LinkedList<>();
    List<String> qte_cmd_liste = new LinkedList<>();
    List<String> qte_fact_liste = new LinkedList<>();
    List<String> reste_liv_liste = new LinkedList<>();
    List<String> qte_liste = new LinkedList<>();
    List<String> prix_u_liste = new LinkedList<>();
    List<String> rem_liste=new LinkedList<>();
    List<String> tva_liste = new LinkedList<>();
    List<String> montant_liste = new LinkedList<>();

    public item_article_bon_livraison(Context c, List<String> numero, List<String> lib_article, List<String> um,  List<String>magasin,
                                      List<String> magasin_l, List<String> qte_stock,  List<String> qte_reserve, List<String> qte_cmd,
                                      List<String> qte_fact,  List<String> reste_liv, List<String> qte, List<String> prix_u,List<String> rem,
                                      List<String> tva, List<String> montant)
    {
        minflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        numero_liste=numero;
        lib_article_liste=lib_article;
        um_liste=um;
        magasin_liste=magasin;
        magasin_l_liste=magasin_l;
        qte_stock_liste=qte_stock;
        qte_reserve_liste=qte_reserve;
        qte_cmd_liste=qte_cmd;
        qte_fact_liste=qte_fact;
        reste_liv_liste=reste_liv;
        qte_liste=qte;
        prix_u_liste=prix_u;
        rem_liste=rem;
        tva_liste=tva;
        montant_liste=montant;

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
        View v = minflater.inflate(R.layout.liste_article_bon_livraison_layout,null);

        TextView numero=(TextView) v.findViewById(R.id.numero_article_bon_liv_article_txt);
        TextView lib=(TextView) v.findViewById(R.id.libelle_article_bon_liv_article_txt);
        TextView um=(TextView) v.findViewById(R.id.um_article_bon_liv_article_txt);
        TextView magasin=(TextView) v.findViewById(R.id.magasin_article_bon_livraison_txt);
        TextView magasin_l=(TextView) v.findViewById(R.id.magasin_l_article_bon_livraison_txt);
        TextView qte_stock=(TextView) v.findViewById(R.id.qte_stock_article_bon_liv_article_txt);
        TextView qte_reserve=(TextView) v.findViewById(R.id.qte_reserve_article_bon_liv_article_txt);
        TextView qte_cmd=(TextView) v.findViewById(R.id.qte_cmd_article_bon_liv_article_txt);
        TextView qte_fact=(TextView) v.findViewById(R.id.qte_fact_article_bon_liv_article_txt);
        TextView reste_liv=(TextView) v.findViewById(R.id.reste_liv_article_article_bon_livraison_txt);
        TextView qte=(TextView) v.findViewById(R.id.qte_article_bon_liv_article_txt);
        TextView prix_u=(TextView) v.findViewById(R.id.prix_u_article_bon_liv_article_txt);
        TextView rem=(TextView) v.findViewById(R.id.rem_article_bon_livraison_txt);
        TextView tva=(TextView) v.findViewById(R.id.tva_article_bon_liv_article_txt);
        TextView montant=(TextView) v.findViewById(R.id.montant_article_bon_liv_article_txt);


        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(lib_article_liste.get(position)!=null)lib.setText(lib_article_liste.get(position));
        if(um_liste.get(position)!=null)um.setText(um_liste.get(position));
        if(magasin_liste.get(position)!=null)magasin.setText(magasin_liste.get(position));
        if(magasin_l_liste.get(position)!=null)magasin_l.setText(magasin_l_liste.get(position));
        if(qte_stock_liste.get(position)!=null)qte_stock.setText(qte_stock_liste.get(position));
        if(qte_reserve_liste.get(position)!=null)qte_reserve.setText(qte_reserve_liste.get(position));
        if(qte_cmd_liste.get(position)!=null)qte_cmd.setText(qte_cmd_liste.get(position));
        if(qte_fact_liste.get(position)!=null)qte_fact.setText(qte_fact_liste.get(position));
        if(reste_liv_liste.get(position)!=null)reste_liv.setText(reste_liv_liste.get(position));
        if(qte_liste.get(position)!=null)qte.setText(qte_liste.get(position));
        if(prix_u_liste.get(position)!=null)prix_u.setText(prix_u_liste.get(position));
        if(rem_liste.get(position)!=null)rem.setText(rem_liste.get(position));
        if(tva_liste.get(position)!=null)tva.setText(tva_liste.get(position));
        if(montant_liste.get(position)!=null)montant.setText(montant_liste.get(position));








        return v;
    }
}
