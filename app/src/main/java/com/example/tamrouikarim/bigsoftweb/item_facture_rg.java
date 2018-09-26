package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_facture_rg extends BaseAdapter {
    LayoutInflater facture_rg_inflater;
    List<String> numero_liste= new LinkedList<>();
    List<String>  client_liste= new LinkedList<>();
    List<String>  date_liste= new LinkedList<>();
    List<String>  date_echeance_liste= new LinkedList<>();
    List<String> montant_rg_liste= new LinkedList<>();
    List<String>  mode_paiement_liste= new LinkedList<>();
    List<String>  mode_reg_liste= new LinkedList<>();
    List<String>  unite_liste= new LinkedList<>();


    public item_facture_rg(Context c, List<String> numero, List<String>  client, List<String>  date, List<String>  date_echeance,
                           List<String> montant_rg, List<String>  mode_paiement, List<String>  mode_reg, List<String>  unite)
    {   facture_rg_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        numero_liste=numero;
        client_liste=client;
        date_liste=date;
        date_echeance_liste=date_echeance;
        montant_rg_liste=montant_rg;
        mode_paiement_liste=mode_paiement;
        mode_reg_liste=mode_reg;
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

        View v =facture_rg_inflater.inflate(R.layout.liste_facture_rg_layout,null);
        TextView numero=(TextView)v.findViewById(R.id.numero_liste_facture_rg_txt);
        TextView client=(TextView)v.findViewById(R.id.client_liste_facture_rg_txt);
        TextView date =(TextView)v.findViewById(R.id.date_liste_facture_rg_txt);
        TextView date_echeance=(TextView)v.findViewById(R.id.date_echeance_liste_facture_rg_txt);
        TextView montant_rg=(TextView)v.findViewById(R.id.montant_rg_liste_facture_rg_txt);
        TextView mode_paiement=(TextView)v.findViewById(R.id.mode_paiement_liste_facture_rg_txt);
        TextView mode_reg=(TextView)v.findViewById(R.id.mode_reg_liste_facture_rg_txt);
        TextView unite=(TextView)v.findViewById(R.id.unite_liste_facture_rg_txt);


        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(client_liste.get(position)!=null)client.setText(client_liste.get(position));
        if(date_liste.get(position)!=null)date.setText(date_liste.get(position));
        if(date_echeance_liste.get(position)!=null)date_echeance.setText(date_echeance_liste.get(position));
        if(montant_rg_liste.get(position)!=null)montant_rg.setText(montant_rg_liste.get(position));
        if(mode_paiement_liste.get(position)!=null)mode_paiement.setText(mode_paiement_liste.get(position));
        if(mode_reg_liste.get(position)!=null)mode_reg.setText(mode_reg_liste.get(position));
        if(unite_liste.get(position)!=null)unite.setText(unite_liste.get(position));


        return v;
    }
}
