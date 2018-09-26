package com.example.tamrouikarim.bigsoftweb;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewFlipper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class paiement_client extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_paiement_client;
    private ActionBarDrawerToggle tri_bar_paiement_client;
    private NavigationView navigationView_paiement_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement_client);
        // ajouter le Mtuggle au Bar D'action
        draw_paiement_client = (DrawerLayout) findViewById(R.id.draw_paiement_client);
        tri_bar_paiement_client=new ActionBarDrawerToggle(this,draw_paiement_client,R.string.open,R.string.close);
        draw_paiement_client.addDrawerListener(tri_bar_paiement_client);
        tri_bar_paiement_client.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_paiement_client=(NavigationView) findViewById(R.id.navigationview_paiement_client);
        if (navigationView_paiement_client != null){navigationView_paiement_client.setNavigationItemSelectedListener(this);}

/////////////////////////////////////////////////////////////////
        data_paiement data=new data_paiement();
        data.execute("");
        /////////////////////////////////////////////////////////////////////


        Button nv_btn_paiement=(Button) findViewById(R.id.nv_paiement_btn);
        final ViewFlipper vf_paiement=(ViewFlipper) findViewById(R.id.vf_paiement);
        nv_btn_paiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_paiement.setDisplayedChild(1);
            }
        });



        /////////////////////////////button
        Button paiement_facture=(Button) findViewById(R.id.facture_paiement_btn);
        Button paiement_description=(Button) findViewById(R.id.description_paiement_btn);
        Button paiement_montant=(Button) findViewById(R.id.montant_paiement_btn);
        final ViewFlipper paiement_vf=(ViewFlipper)findViewById(R.id.nv_paiement_vf);
        paiement_facture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paiement_vf.setDisplayedChild(0);
            }
        });

        paiement_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paiement_vf.setDisplayedChild(1);
            }
        });

        paiement_montant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paiement_vf.setDisplayedChild(2);
            }
        });





    }

    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_paiement_client.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int numero_item= menuItem.getItemId();
        ViewFlipper vf= (ViewFlipper) findViewById(R.id.vf);





        if(numero_item== R.id.fiche_client){

            Intent gotofiche = new Intent(getApplicationContext(),client_activity.class);
            startActivity(gotofiche);
        }

        if(numero_item==R.id.catalogue_prix)
        {
            Intent gotocatalogue = new Intent(getApplicationContext(),catalogue_activity.class);
            startActivity(gotocatalogue);
        }

        if(numero_item==R.id.pro_client)
        {
            Intent gotoproforma = new Intent(getApplicationContext(),proforma_client_activity.class);
            startActivity(gotoproforma);
        }



        if(numero_item==R.id.contrat_client)
        {
            Intent gotocontrat = new Intent(getApplicationContext(),contrat_client_activity.class);
            startActivity(gotocontrat);
        }

        if(numero_item==R.id.cmd_client)
        {
            Intent gotocommande = new Intent(getApplicationContext(),commande_client.class);
            startActivity(gotocommande);
        }

        if(numero_item==R.id.location_cl)
        {
            Intent gotolocation_calendrier = new Intent(getApplicationContext(),location_calendrier.class);
            startActivity(gotolocation_calendrier);
        }

        if(numero_item==R.id.location_list)
        {
            Intent gotolocation_list = new Intent(getApplicationContext(),location_liste.class);
            startActivity(gotolocation_list);
        }

        if(numero_item==R.id.fct_client)
        {
            Intent gotofacture_client = new Intent(getApplicationContext(),facture_client.class);
            startActivity(gotofacture_client);
        }

        if(numero_item==R.id.fct_rg)
        {
            Intent gotofacture_rg = new Intent(getApplicationContext(),facture_rg.class);
            startActivity(gotofacture_rg);
        }

        if(numero_item==R.id.fct_avoir)
        {
            Intent gotofacture_avoir = new Intent(getApplicationContext(),facture_avoir.class);
            startActivity(gotofacture_avoir);
        }

        if(numero_item==R.id.bon_liv)
        {
            Intent gotobon_livraison = new Intent(getApplicationContext(),bon_livraison.class);
            startActivity(gotobon_livraison);
        }


        if(numero_item==R.id.bon_retour)
        {
            Intent gotobon_retour = new Intent(getApplicationContext(),bon_retour.class);
            startActivity(gotobon_retour);
        }

        if(numero_item==R.id.paiement_client)
        {
            Intent gotopaiement = new Intent(getApplicationContext(),paiement_client.class);
            startActivity(gotopaiement);
        }

        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    ////////////////////////   data






    private class data_paiement extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;
        List<String> numero_list=new LinkedList<>();
        List<String> type_mvt_list=new LinkedList<>();
        List<String> cpt_entreprise_list=new LinkedList<>();
        List<String> designation_list=new LinkedList<>();
        List<String> numero_tiers_list=new LinkedList<>();
        List<String> mouvement_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> mode_paie_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> montant_recu_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();
        List<String> code_mvt_list = new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM trs_encaiss";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    numero_list.add(result.getString("NumEncaiss"));
                    type_mvt_list.add(result.getString("TypeMvt"));
                    cpt_entreprise_list.add(result.getString("CompteEntr"));
                    designation_list.add(result.getString("RefEncaiss"));
                    client_list.add(result.getString("NomTiers"));
                    numero_tiers_list.add(result.getString("NumTiers"));
                    code_mvt_list.add(result.getString("CodeType"));
                    mouvement_list.add(result.getString("CodeUnit"));
                    date_list.add(result.getString("DateDoc"));
                    mode_paie_list.add(result.getString("ModePai"));
                    montant_recu_list.add(result.getString("MTPaie"));
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
            ListView list=(ListView) findViewById(R.id.liste_paiement);
            item_paiement  adapter= new item_paiement(getApplicationContext(),numero_list,type_mvt_list,cpt_entreprise_list,designation_list,client_list,
                    numero_tiers_list,code_mvt_list,mouvement_list,date_list,mode_paie_list,montant_recu_list,unite_list);
            list.setAdapter(adapter);

        }



    }



///////////////////////////////////// data

}
