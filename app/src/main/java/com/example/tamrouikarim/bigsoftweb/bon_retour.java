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

public class bon_retour extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_bon_retour;
    private ActionBarDrawerToggle tri_bar_bon_retour;
    private NavigationView navigationView_bon_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_retour);
        // ajouter le Mtuggle au Bar D'action
        draw_bon_retour = (DrawerLayout) findViewById(R.id.draw_bon_retour);
        tri_bar_bon_retour=new ActionBarDrawerToggle(this,draw_bon_retour,R.string.open,R.string.close);
        draw_bon_retour.addDrawerListener(tri_bar_bon_retour);
        tri_bar_bon_retour.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_bon_retour=(NavigationView) findViewById(R.id.navigationview_bon_retour);
        if (navigationView_bon_retour != null){navigationView_bon_retour.setNavigationItemSelectedListener(this);}


////////////////////////////////////////
        data_bon_retour data=new data_bon_retour();
        data.execute("");
        /////////////////////////////////////



        Button nv_btn_bon_retour=(Button) findViewById(R.id.nv_bon_retour_btn);
        final ViewFlipper vf_bon_retour=(ViewFlipper) findViewById(R.id.vf_bon_retour);
        nv_btn_bon_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_bon_retour.setDisplayedChild(1);
            }
        });





        /////////////////////////////button
        Button bon_retour_article=(Button) findViewById(R.id.article_bon_retour_btn);
        Button bon_retour_description=(Button) findViewById(R.id.description_bon_retour_btn);
        final ViewFlipper bon_retour_vf=(ViewFlipper)findViewById(R.id.nv_bon_retour_vf);
        bon_retour_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bon_retour_vf.setDisplayedChild(0);
            }
        });

        bon_retour_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bon_retour_vf.setDisplayedChild(1);
            }
        });

    }

    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_bon_retour.onOptionsItemSelected(item)) return true;
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


    private class data_bon_retour extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;



        List<String> numero_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> livraison_list=new LinkedList<>();
        List<String> etat_compta_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM vte_retour";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    numero_list.add(result.getString("NumDoc"));
                    client_list.add(result.getString("NomTiers"));
                    date_list.add(result.getString("DateDoc"));
                    livraison_list.add(result.getString("NumOrig"));
                    etat_compta_list.add(result.getString("StatuDoc"));
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
            ListView list=(ListView) findViewById(R.id.liste_bon_retour);
            item_bon_retour  adapter= new item_bon_retour(getApplicationContext(),numero_list,client_list,
                    date_list,livraison_list,etat_compta_list,unite_list);
            list.setAdapter(adapter);

        }



    }



///////////////////////////////////// data




}
