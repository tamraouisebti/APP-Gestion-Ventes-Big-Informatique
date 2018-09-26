package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_proforma extends BaseAdapter {

    LayoutInflater proforma_inflatter;
    List<String>   numero_proforma_list=new LinkedList<>();
    List<String>   client_proforma_list=new LinkedList<>();
    List<String>  categorie_proforma_list=new LinkedList<>();
    List<String>  date_echeanche_proforma_list=new LinkedList<>();
    List<String>  montant_ttc_proforma_list=new LinkedList<>();
    List<String>  unite_proforma_list=new LinkedList<>();


    public item_proforma(Context c, List<String> numero_proforma ,List<String>  client_proforma,List<String>  categorie_proforma,
                         List<String>  date_echeanche_proforma,List<String>  montant_ttc_proforma,List<String>  unite_proforma)
    {
        proforma_inflatter=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        numero_proforma_list=numero_proforma;
        client_proforma_list=client_proforma;
        categorie_proforma_list=categorie_proforma;
        date_echeanche_proforma_list=date_echeanche_proforma;
        montant_ttc_proforma_list=montant_ttc_proforma;
        unite_proforma_list=unite_proforma;
    }



    @Override
    public int getCount() {
        return numero_proforma_list.size();
    }

    @Override
    public Object getItem(int position) {
        return numero_proforma_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =proforma_inflatter.inflate(R.layout.liste_proforma_layout,null);


        TextView numero=(TextView) v.findViewById(R.id.numero_liste_proforma_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_proforma_txt);
        TextView categorie=(TextView) v.findViewById(R.id.categorie_liste_proforma_txt);
        TextView date_echeance=(TextView) v.findViewById(R.id.date_echeance_liste_proforma_txt);
        TextView montant_ttc=(TextView) v.findViewById(R.id.montant_ttc_liste_proforma_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_proforma_txt);


        if(numero_proforma_list.get(position)!=null){numero.setText(numero_proforma_list.get(position));}
        if(client_proforma_list.get(position)!=null){client.setText(client_proforma_list.get(position));}
        if(categorie_proforma_list.get(position)!=null){categorie.setText(numero_proforma_list.get(position));}
        if(date_echeanche_proforma_list.get(position)!=null){date_echeance.setText(date_echeanche_proforma_list.get(position));}
        if(montant_ttc_proforma_list.get(position)!=null){montant_ttc.setText(montant_ttc_proforma_list.get(position));}
        if(unite_proforma_list.get(position)!=null){unite.setText(unite_proforma_list.get(position));}



        return v;
    }
}
