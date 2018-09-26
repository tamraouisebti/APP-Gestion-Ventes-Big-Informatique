package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_paiement extends BaseAdapter {

    LayoutInflater paiement_inflater;
    List<String> numero_liste= new LinkedList<>();
    List<String>  type_mvt_liste= new LinkedList<>();
    List<String>  cpt_entreprise_liste= new LinkedList<>();
    List<String>  designation_liste= new LinkedList<>();
    List<String>  client_liste= new LinkedList<>();
    List<String> numero_tier_liste= new LinkedList<>();
    List<String>  code_mvt_liste= new LinkedList<>();
    List<String> mouvement_liste= new LinkedList<>();
    List<String> date_liste= new LinkedList<>();
    List<String> mode_paiement_liste= new LinkedList<>();
    List<String> montant_recu_liste= new LinkedList<>();
    List<String> unite_liste= new LinkedList<>();



    public  item_paiement(Context c, List<String> numero, List<String>  type_mvt, List<String>  cpt_entreprise, List<String>  designation, List<String>  client,
                            List<String> numero_tier, List<String>  code_mvt, List<String> mouvement, List<String> date, List<String> mode_paiement,
                          List<String> montant_recu, List<String> unite)
    {
        paiement_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        numero_liste=numero;
        type_mvt_liste=type_mvt;
        cpt_entreprise_liste=cpt_entreprise;
        designation_liste=designation;
        client_liste=client;
        numero_tier_liste=numero_tier;
        code_mvt_liste=code_mvt;
        mouvement_liste=mouvement;
        date_liste=date;
        mode_paiement_liste=mode_paiement;
        montant_recu_liste=montant_recu;
        unite_liste=unite;

    }



    @Override
    public int getCount() {
        return numero_liste.size();
    }

    @Override
    public Object getItem(int position) {
        return numero_tier_liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = paiement_inflater.inflate(R.layout.liste_paiement_layout,null);


        TextView numero=(TextView) v.findViewById(R.id.numero_liste_paiement_txt);
        TextView type_mvt=(TextView) v.findViewById(R.id.type_mvt_liste_paiement_txt);
        TextView cpt=(TextView) v.findViewById(R.id.cpt_entreprise_liste_paiement_txt);
        TextView designation=(TextView) v.findViewById(R.id.designation_liste_paiement_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_paiement_txt);
        TextView numero_tier=(TextView) v.findViewById(R.id.numero_tiers_liste_paiement_txt);
        TextView code_mvt=(TextView) v.findViewById(R.id.code_mvt_liste_paiement_txt);
        TextView mouvement=(TextView) v.findViewById(R.id.mouvement_liste_paiement_txt);
        TextView date=(TextView) v.findViewById(R.id.date_liste_paiement_txt);
        TextView mode_paiement=(TextView) v.findViewById(R.id.mode_paiement_liste_paiement_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_paiement_txt);
        TextView montant_recu=(TextView) v.findViewById(R.id.montant_recu_liste_paiement_txt);



        if(numero_liste.get(position)!=null)numero.setText(numero_liste.get(position));
        if(type_mvt_liste.get(position)!=null)type_mvt.setText(type_mvt_liste.get(position));
        if(cpt_entreprise_liste.get(position)!=null)cpt.setText(cpt_entreprise_liste.get(position));
        if(designation_liste.get(position)!=null)designation.setText(designation_liste.get(position));
        if(client_liste.get(position)!=null)client.setText(client_liste.get(position));
        if(numero_tier_liste.get(position)!=null)numero_tier.setText(numero_tier_liste.get(position));
        if(code_mvt_liste.get(position)!=null)code_mvt.setText(code_mvt_liste.get(position));
        if(mouvement_liste.get(position)!=null)mouvement.setText(mouvement_liste.get(position));
        if(date_liste.get(position)!=null)date.setText(date_liste.get(position));
        if(mode_paiement_liste.get(position)!=null)mode_paiement.setText(mode_paiement_liste.get(position));
        if(unite_liste.get(position)!=null)unite.setText(unite_liste.get(position));
        if(montant_recu_liste.get(position)!=null)montant_recu.setText(montant_recu_liste.get(position));



        return v;
    }
}
