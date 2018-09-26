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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class bon_livraison extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_bon_livraison;
    private ActionBarDrawerToggle tri_bar_bon_livraison;
    private NavigationView navigationView_bon_livraison;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_livraison);

        // ajouter le Mtuggle au Bar D'action
        draw_bon_livraison = (DrawerLayout) findViewById(R.id.draw_bon_livraison);
        tri_bar_bon_livraison=new ActionBarDrawerToggle(this,draw_bon_livraison,R.string.open,R.string.close);
        draw_bon_livraison.addDrawerListener(tri_bar_bon_livraison);
        tri_bar_bon_livraison.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_bon_livraison=(NavigationView) findViewById(R.id.navigationview_bon_livraison);
        if (navigationView_bon_livraison != null){navigationView_bon_livraison.setNavigationItemSelectedListener(this);}



        ///////////////////////////////////////////
        data_bon_livraisonè data= new data_bon_livraisonè();
        data.execute();
        ///////////////////////////////////////////////







        Button nv_btn_bon_livraison=(Button) findViewById(R.id.nv_bon_livraison_btn);
        final ViewFlipper vf_bon_livraison=(ViewFlipper) findViewById(R.id.vf_bon_livraison);
        nv_btn_bon_livraison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_bon_livraison.setDisplayedChild(1);
            }
        });





        Spinner bon_livraison_spinner = (Spinner)findViewById(R.id.bon_livraison_spinner);
        ArrayAdapter<CharSequence> sadapter=ArrayAdapter.createFromResource(this,R.array.bon_livraison_array_spinner,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bon_livraison_spinner.setAdapter(sadapter);
        bon_livraison_spinner.setOnItemSelectedListener(this);





    }

    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_bon_livraison.onOptionsItemSelected(item)) return true;
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
        long item_id=parent.getItemIdAtPosition(position);
        ViewFlipper bon_livraison_vf=(ViewFlipper)findViewById(R.id.nv_bon_livraison_vf);

        bon_livraison_vf.setDisplayedChild((int) item_id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    private class data_bon_livraisonè extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;



        List<String> numero_list=new LinkedList<>();
        List<String> commande_list=new LinkedList<>();
        List<String> facture_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> montant_ttc_list=new LinkedList<>();
        List<String> etat_compta_list=new LinkedList<>();
        List<String> ods_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM vte_livraison";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    numero_list.add(result.getString("NumDoc"));
                    commande_list.add(result.getString("NumCmd"));
                    facture_list.add(result.getString("NumOrig"));
                    client_list.add(result.getString("NomTiers"));
                    date_list.add(result.getString("DateDoc"));
                    montant_ttc_list.add(result.getString("MTTC"));
                    etat_compta_list.add(result.getString("EtatCompta"));
                    ods_list.add(result.getString("CODODS"));
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
            ListView list=(ListView) findViewById(R.id.liste_bon_livraison);
            item_bon_livraison  adapter= new item_bon_livraison(getApplicationContext(),numero_list,commande_list,facture_list,client_list,
                    date_list,montant_ttc_list,etat_compta_list,ods_list,unite_list);
            list.setAdapter(adapter);

        }



    }



///////////////////////////////////// data




}
