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

public class pop_contrat extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_contrat);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width=dm.widthPixels;
        int heignt = dm.heightPixels;


        getWindow().setLayout((int)(width*.8),(int)(heignt*.6));


        data_contrat_pop data=new data_contrat_pop();
        data.execute("");


    }

    ////////////////////////   data






    private class data_contrat_pop extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;
        List<String> numero_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> date_echeance_list=new LinkedList<>();
        List<String> montant_ttc_list=new LinkedList<>();
        List<String> date_livraison_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();
        List<String> code_contrat=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM vte_contrat";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    code_contrat.add(result.getString("CodeDoc"));
                    numero_list.add(result.getString("NumDoc"));
                    client_list.add(result.getString("NomTiers"));
                    date_list.add(result.getString("DateDoc"));
                    date_echeance_list.add(result.getString("DateEch"));
                    montant_ttc_list.add(result.getString("MTTC"));
                    date_livraison_list.add(result.getString("DateDeb"));
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
            ListView list=(ListView) findViewById(R.id.liste_contrat_pop);
            final item_contrat  contrat_adapter= new item_contrat(getApplicationContext(),numero_list,client_list,
                    date_list,date_echeance_list,montant_ttc_list,date_livraison_list,unite_list,code_contrat);
            list.setAdapter(contrat_adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String[] info = (String[]) contrat_adapter.getItem(position);
                    Intent send_result=new Intent();
                    Bundle entras=new Bundle();
                    entras.putString("codectr",info[0]);
                    entras.putString("numctr",info[1]);

                    send_result.putExtra("bundle_contrat",entras);
                    setResult(Activity.RESULT_OK,send_result);
                    finish();
                }
            });

        }



    }



///////////////////////////////////// data
}
