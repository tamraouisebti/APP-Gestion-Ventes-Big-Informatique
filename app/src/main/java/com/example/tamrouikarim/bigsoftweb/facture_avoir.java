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

public class facture_avoir extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_facture_avoir;
    private ActionBarDrawerToggle tri_bar_facture_avoir;
    private NavigationView navigationView_facture_avoir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture_avoir);
        // ajouter le Mtuggle au Bar D'action
        draw_facture_avoir = (DrawerLayout) findViewById(R.id.draw_facture_avoir);
        tri_bar_facture_avoir=new ActionBarDrawerToggle(this,draw_facture_avoir,R.string.open,R.string.close);
        draw_facture_avoir.addDrawerListener(tri_bar_facture_avoir);
        tri_bar_facture_avoir.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_facture_avoir=(NavigationView) findViewById(R.id.navigationview_facture_avoir);
        if (navigationView_facture_avoir != null){navigationView_facture_avoir.setNavigationItemSelectedListener(this);}



        /////////////////////////////////////////////////////////
        data_facture_avoir data =new data_facture_avoir();
        data.execute("");
        /////////////////////////////////////////////////////////


/////////////// nv btn spinner




        final Spinner avoir_btn_nv_spinner = (Spinner)findViewById(R.id.avoir_btn_nv_spinner);
        ArrayAdapter<CharSequence> sadapter=ArrayAdapter.createFromResource(this,R.array.avoir_btn_nv_array_spinner,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        avoir_btn_nv_spinner.setAdapter(sadapter);
        avoir_btn_nv_spinner.setOnItemSelectedListener(this);
        ViewFlipper vf_facture_avoir=(ViewFlipper) findViewById(R.id.vf_facture_avoir);
        vf_facture_avoir.setDisplayedChild(0);






        ///////////facture avoir valeur spinner ////////////////////////////////////////////


        final Spinner facture_avoir_valeur_spinner = (Spinner)findViewById(R.id.facture_avoir_valeur_spinner);
        ArrayAdapter<CharSequence> ssadapter=ArrayAdapter.createFromResource(this,R.array.facture_avoir_valeur_array_spinner,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facture_avoir_valeur_spinner.setAdapter(ssadapter);
        facture_avoir_valeur_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ViewFlipper vf_facture_avoir_valeur=(ViewFlipper) findViewById(R.id.nv_facture_avoir_valeur_vf);
                long item_id=parent.getItemIdAtPosition(position);
                vf_facture_avoir_valeur.setDisplayedChild((int) item_id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ///////////facture avoir valeur spinner ///////////////////////////////////////////

        final Spinner facture_avoir_qte_spinner = (Spinner)findViewById(R.id.facture_avoir_qte_spinner);
        ArrayAdapter<CharSequence> sssadapter=ArrayAdapter.createFromResource(this,R.array.facture_avoir_qte_array_spinner,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facture_avoir_qte_spinner.setAdapter(sssadapter);
        facture_avoir_qte_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ViewFlipper vf_facture_avoir_qte=(ViewFlipper) findViewById(R.id.nv_facture_avoir_qte_vf);
                long item_id=parent.getItemIdAtPosition(position);
                vf_facture_avoir_qte.setDisplayedChild((int) item_id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ////////////////////////////nv btn listner

        Button nv_btn_facture_avoir=(Button) findViewById(R.id.nouveau_facture_avoir_btn);
        nv_btn_facture_avoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewFlipper vf_facture_avoir=(ViewFlipper) findViewById(R.id.vf_facture_avoir);
                vf_facture_avoir.setDisplayedChild(1);
            }
        });

        Button supp_btn_facture_avoir=(Button) findViewById(R.id.supp_facture_avoir_btn);
        supp_btn_facture_avoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewFlipper vf_facture_avoir=(ViewFlipper) findViewById(R.id.vf_facture_avoir);
                vf_facture_avoir.setDisplayedChild(2);
            }
        });
    }

    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_facture_avoir.onOptionsItemSelected(item)) return true;
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
    int i=0;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ViewFlipper vf_facture_avoir=(ViewFlipper) findViewById(R.id.vf_facture_avoir);
        long item_id=parent.getItemIdAtPosition(position);
        vf_facture_avoir.setDisplayedChild((int) item_id+1);
        i=1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }






    private class data_facture_avoir extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;



        List<String> numero_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> facture_list=new LinkedList<>();
        List<String> montant_ttc_list=new LinkedList<>();
        List<String> reste_payer_list=new LinkedList<>();
        List<String> etat_compta_list=new LinkedList<>();
        List<String> mode_avoir_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM vte_avoir";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    numero_list.add(result.getString("NumDoc"));
                    client_list.add(result.getString("NomTiers"));
                    date_list.add(result.getString("DateDoc"));
                    facture_list.add(result.getString("NumOrig"));
                    montant_ttc_list.add(result.getString("MTTC"));
                    reste_payer_list.add(result.getString("RestePaye"));
                    etat_compta_list.add(result.getString("EtatCompta"));
                    mode_avoir_list.add(result.getString("ModeAv"));
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
            ListView list=(ListView) findViewById(R.id.liste_facture_avoir);
            item_facture_avoir  adapter= new item_facture_avoir(getApplicationContext(),numero_list,client_list,
                    date_list,facture_list,montant_ttc_list,reste_payer_list,etat_compta_list,mode_avoir_list,unite_list);
            list.setAdapter(adapter);

        }



    }



///////////////////////////////////// data

}
