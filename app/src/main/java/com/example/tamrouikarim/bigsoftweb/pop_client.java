package com.example.tamrouikarim.bigsoftweb;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class pop_client extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.popup_client);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width=dm.widthPixels;
        int heignt = dm.heightPixels;


        getWindow().setLayout((int)(width*.8),(int)(heignt*.6));
        data_fiche_client data = new data_fiche_client();
        data.execute("");
    }


    private class data_fiche_client extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;
        List<String> numero_client_list=new LinkedList<>();
        List<String> raison_social_list=new LinkedList<>();
        List<String> categorie_list=new LinkedList<>();
        List<String> chiffre_affaire_list=new LinkedList<>();
        List<String> paiement_list=new LinkedList<>();
        List<String> solde_list=new LinkedList<>();
        List<String> adresse_list=new LinkedList<>();
        List<String> codetiers=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM base_tiers";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {   codetiers.add(result.getString("CodeTiers"));
                    numero_client_list.add(result.getString("NumTiers"));
                    raison_social_list.add(result.getString("NomTiers"));
                    categorie_list.add(result.getString("LibCategorie"));
                    chiffre_affaire_list.add(result.getString("ChiffreTiers"));
                    paiement_list.add(result.getString("PaieTiers"));
                    solde_list.add(result.getString("SoldeTiers"));
                    adresse_list.add(result.getString("Adresse"));
                }


                result.close();
                stm.close();
                con.close();


            }
            catch (SQLException conError)
            {
                msg="exception";
            } catch (ClassNotFoundException e) {
                msg="exception";
                e.printStackTrace();
            }
            finally {
                try{
                    if(stm!=null){stm.close();}
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try
                {
                    if (con!=null){con.close();}
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }



            return msg;
        }




        @Override
        protected void  onPostExecute(String msg)
        {
            ListView list=(ListView) findViewById(R.id.liste_client_pop);
            final item_client_adapter  fiche_client_adapter= new item_client_adapter(getApplicationContext(),numero_client_list,raison_social_list,
                    categorie_list,chiffre_affaire_list,paiement_list, solde_list,adresse_list,codetiers);
            list.setAdapter(fiche_client_adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String[] client_info = (String[])fiche_client_adapter.getItem(position);
                    Intent send_result=new Intent();
                    Bundle entras=new Bundle();
                    entras.putString("codetiers",client_info[0]);
                    entras.putString("numtiers",client_info[1]);
                    entras.putString("nomtiers",client_info[2]);
                    send_result.putExtra("bundle_client",entras);
                    setResult(Activity.RESULT_OK,send_result);
                    finish();
                }
            });

        }





    }



///////////////////////////////////// data







}
