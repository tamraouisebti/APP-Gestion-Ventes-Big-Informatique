package com.example.tamrouikarim.bigsoftweb;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class pop_commande extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_commande);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width=dm.widthPixels;
        int heignt = dm.heightPixels;


        getWindow().setLayout((int)(width*.8),(int)(heignt*.6));


        data_commande_pop data=new data_commande_pop();
        data.execute("");


    }

    ////////////////////////   data






    private class data_commande_pop extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;



        List<String> numero_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> montant_ttc_list=new LinkedList<>();
        List<String> mt_reste_facturer_list=new LinkedList<>();
        List<String> etat_list=new LinkedList<>();
        List<String> etat_livraison_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();
        List<String> code=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM vte_commande";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    code.add(result.getString("CodeDoc"));
                    numero_list.add(result.getString("NumDoc"));
                    client_list.add(result.getString("NomTiers"));
                    date_list.add(result.getString("DateDoc"));
                    montant_ttc_list.add(result.getString("MTTC"));
                    mt_reste_facturer_list.add(result.getString("RestePaye"));
                    etat_list.add(result.getString("StatuDoc"));
                    etat_livraison_list.add(result.getString("StatuBlv"));
                    unite_list.add(result.getString("CodeUnit"));
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
            ListView list=(ListView) findViewById(R.id.liste_commande_popup);
            final item_commande  adapter= new item_commande(getApplicationContext(),numero_list,client_list,
                    date_list,montant_ttc_list,mt_reste_facturer_list,etat_list,etat_livraison_list,unite_list,code);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String[] info = (String[]) adapter.getItem(position);
                    Intent send_result=new Intent();
                    Bundle entras=new Bundle();
                    entras.putString("codecmd",info[0]);
                    entras.putString("numcmd",info[1]);

                    send_result.putExtra("bundle_commande",entras);
                    setResult(Activity.RESULT_OK,send_result);
                    finish();
                }
            });
        }



    }



///////////////////////////////////// data

}


