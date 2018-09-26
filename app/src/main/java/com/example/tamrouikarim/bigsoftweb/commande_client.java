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

public class commande_client extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_commande_client;
    private ActionBarDrawerToggle tri_bar_commande_client;
    private NavigationView navigationView_commande_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande_client);
        // ajouter le Mtuggle au Bar D'action
        draw_commande_client = (DrawerLayout) findViewById(R.id.draw_commande_client);
        tri_bar_commande_client=new ActionBarDrawerToggle(this,draw_commande_client,R.string.open,R.string.close);
        draw_commande_client.addDrawerListener(tri_bar_commande_client);
        tri_bar_commande_client.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_commande_client=(NavigationView) findViewById(R.id.navigationview_commande_client);
        if (navigationView_commande_client != null){navigationView_commande_client.setNavigationItemSelectedListener(this);}

///////////////////////////////////////////////
        data_commande data=new data_commande();
        data.execute("");
        ///////////////////////////////////////////////////




        Button nv_btn_commande=(Button) findViewById(R.id.nv_commande_btn);
        final ViewFlipper vf_commande=(ViewFlipper) findViewById(R.id.vf_commande);
        nv_btn_commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_commande.setDisplayedChild(1);
            }
        });





        Spinner commande_spinner = (Spinner)findViewById(R.id.commande_spinner);
        ArrayAdapter<CharSequence> sadapter=ArrayAdapter.createFromResource(this,R.array.commande_array_spinner,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        commande_spinner.setAdapter(sadapter);
        commande_spinner.setOnItemSelectedListener(this);




    }

    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_commande_client.onOptionsItemSelected(item)) return true;
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
        ViewFlipper commande_vf=(ViewFlipper)findViewById(R.id.nv_commande_vf);

        commande_vf.setDisplayedChild((int) item_id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }






    ////////////////////////   data






    private class data_commande extends AsyncTask<String,String,String>
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
                {   code.add(result.getString("CodeDoc"));
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
            ListView list=(ListView) findViewById(R.id.liste_commande);
            item_commande  adapter= new item_commande(getApplicationContext(),numero_list,client_list,
                    date_list,montant_ttc_list,mt_reste_facturer_list,etat_list,etat_livraison_list,unite_list,code);
            list.setAdapter(adapter);

        }



    }



///////////////////////////////////// data


}
