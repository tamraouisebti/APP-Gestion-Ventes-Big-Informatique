package com.example.tamrouikarim.bigsoftweb;

import android.content.ClipData;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class client_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout draw_client;
    private ActionBarDrawerToggle tri_bar;
    private ClipData.Item catlogue;
    private NavigationView navigationView_client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_activity);



        // ajouter le Mtuggle au Bar D'action
        draw_client = (DrawerLayout) findViewById(R.id.draw_client);
        tri_bar=new ActionBarDrawerToggle(this,draw_client,R.string.open,R.string.close);
        draw_client.addDrawerListener(tri_bar);
        tri_bar.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_client=(NavigationView) findViewById(R.id.navigationview_client);
        if (navigationView_client != null){navigationView_client.setNavigationItemSelectedListener(this);}


        /////////////////////////////////////////////////////liste

        data_fiche_client data=new data_fiche_client();

        data.execute("");
        ////////////////////////////////////////////////////////////////////////////////////// ajouter un nouveau Client




        Button client=(Button) findViewById(R.id.nv_fiche_client);

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewFlipper vf= (ViewFlipper) findViewById(R.id.vf);
                vf.setDisplayedChild(2);
            }
        });








        ///spinners /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Spinner type_spinner = (Spinner)findViewById(R.id.type_fiche_nv_spinner);
        ArrayAdapter<CharSequence> type_sadapter=ArrayAdapter.createFromResource(this,R.array.type_fiche_nv_array_spinner,android.R.layout.simple_spinner_item);
        type_sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_sadapter);


        Spinner etat_spinner = (Spinner)findViewById(R.id.etat_fiche_nv_spinner);
        ArrayAdapter<CharSequence> etat_adapter=ArrayAdapter.createFromResource(this,R.array.etat_fiche_nv_array_spinner,android.R.layout.simple_spinner_item);
        etat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etat_spinner.setAdapter(etat_adapter);

        //////////////////////////////////////////////////////////////////////////////////////changé les layout d ajout d un nouvelle client

        final ViewFlipper nv_client_vp =(ViewFlipper) findViewById(R.id.nv_client_viewflipper);
        Button nv_client_gestion =(Button) findViewById(R.id.nv_gestion_client);
        Button nv_client_support =(Button) findViewById(R.id.nv_support_client);
        Button nv_client_type =(Button) findViewById(R.id.nv_type_categorie_client);
        Button nv_client_compabilite =(Button) findViewById(R.id.nv_comptabilite_client);
        Button nv_client_identite =(Button) findViewById(R.id.nv_identite_client);


        nv_client_identite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv_client_vp.setDisplayedChild(0);
            }
        });

        nv_client_gestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv_client_vp.setDisplayedChild(1);
            }
        });

        nv_client_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv_client_vp.setDisplayedChild(2);
            }
        });

        nv_client_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv_client_vp.setDisplayedChild(3);
            }
        });

        nv_client_compabilite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv_client_vp.setDisplayedChild(4);
            }
        });




        Button save =(Button) findViewById(R.id.fiche_client_save_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView numero = (TextView) findViewById(R.id.numero_fiche_save_txt);
                TextView raison = (TextView) findViewById(R.id.raison_social_fiche_save_txt);
                TextView type = (TextView) findViewById(R.id.type_fiche_save_txt);
                TextView etat = (TextView) findViewById(R.id.etat_fiche_save_txt);



                EditText numero_edit=(EditText)findViewById(R.id.nv_numero_client);
                EditText raison_edit=(EditText)findViewById(R.id.nv_raison_sociale_client);






                if((numero_edit.getText().toString().trim().length()<1)||
                (raison_edit.getText().toString().trim().length()<1))




                {


                }
            }
        });












    }


    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar.onOptionsItemSelected(item)) return true;
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


        return false;    }











    ////////////////////////   data






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
                {
                    codetiers.add(result.getString("CodeTiers"));
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
            ListView list=(ListView) findViewById(R.id.liste_client);
            final item_client_adapter  fiche_client_adapter= new item_client_adapter(getApplicationContext(),numero_client_list,raison_social_list,
                    categorie_list,chiffre_affaire_list,paiement_list, solde_list,adresse_list,codetiers);
            list.setAdapter(fiche_client_adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String info_selected[]=new String[3];

                    info_selected=(String[])fiche_client_adapter.getItem(position);

                    Intent goto_popup = new Intent(getApplicationContext(), pop_info_client.class);
                    goto_popup.putExtra("CodeTiers",info_selected[0]);
                    startActivity(goto_popup);

                }
            });


        }



    }



///////////////////////////////////// data










}
