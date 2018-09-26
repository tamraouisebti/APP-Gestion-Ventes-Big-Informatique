package com.example.tamrouikarim.bigsoftweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class item_contrat extends BaseAdapter {

    LayoutInflater contrat_inflater;
    List<String> numero_contrat_list= new LinkedList<>();
    List<String>  client_contrat_list= new LinkedList<>();
    List<String>  date_contrat_list= new LinkedList<>();
    List<String>  date_echeance_contrat_list= new LinkedList<>();
    List<String> montant_ttc_contrat_list= new LinkedList<>();
    List<String>  date_livraison_contrat_list= new LinkedList<>();
    List<String>  unite_contrat_list= new LinkedList<>();
    List<String>  code_contrat= new LinkedList<>();



    public item_contrat(Context c, List<String> numero_contrat, List<String>  client_contrat, List<String>  date_contrat, List<String>  date_echeance_contrat,
                        List<String> montant_ttc_contrat, List<String>  date_livraison_contrat, List<String>  unite_contrat,List<String> code){
        contrat_inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        numero_contrat_list=numero_contrat;
        client_contrat_list=client_contrat;
        date_contrat_list=date_contrat;
        date_echeance_contrat_list=date_echeance_contrat;
        montant_ttc_contrat_list=montant_ttc_contrat;
        date_livraison_contrat_list=date_livraison_contrat;
        unite_contrat_list=unite_contrat;
        code_contrat=code;

    }



    @Override
    public int getCount() {
        return numero_contrat_list.size();
    }

    @Override
    public Object getItem(int position) {
        String info[]= new String[2];
        info[0]=code_contrat.get(position);
        info[1]=numero_contrat_list.get(position);
        return info;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v =contrat_inflater.inflate(R.layout.liste_contrat_layout,null);
        TextView numero=(TextView) v.findViewById(R.id.numero_liste_contrat_txt);
        TextView client=(TextView) v.findViewById(R.id.client_liste_contrat_txt);
        TextView date=(TextView) v.findViewById(R.id.date_liste_contrat_txt);
        TextView date_echeance=(TextView) v.findViewById(R.id.date_echeance_liste_contrat_txt);
        TextView date_livraison=(TextView) v.findViewById(R.id.date_livraison_liste_contrat_txt);
        TextView montant_ttc=(TextView) v.findViewById(R.id.montant_ttc_liste_contrat_txt);
        TextView unite=(TextView) v.findViewById(R.id.unite_liste_contrat_txt);



        if(numero_contrat_list.get(position)!=null)numero.setText(numero_contrat_list.get(position));
        if(client_contrat_list.get(position)!=null)client.setText(client_contrat_list.get(position));
        if(date_contrat_list.get(position)!=null)date.setText(date_contrat_list.get(position));
        if(date_echeance_contrat_list.get(position)!=null)date_echeance.setText(date_echeance_contrat_list.get(position));
        if(date_livraison_contrat_list.get(position)!=null)date_livraison.setText(date_livraison_contrat_list.get(position));
        if(montant_ttc_contrat_list.get(position)!=null)montant_ttc.setText(montant_ttc_contrat_list.get(position));
        if(unite_contrat_list.get(position)!=null)unite.setText(unite_contrat_list.get(position));




        return v;
    }
}
