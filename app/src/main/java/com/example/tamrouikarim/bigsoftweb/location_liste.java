package com.example.tamrouikarim.bigsoftweb;

import android.content.Intent;
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
import android.widget.ViewFlipper;

public class location_liste extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_location_liste;
    private ActionBarDrawerToggle tri_bar_location_liste;
    private NavigationView navigationView_location_liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_liste);
        // ajouter le Mtuggle au Bar D'action
        draw_location_liste = (DrawerLayout) findViewById(R.id.draw_location_liste);
        tri_bar_location_liste=new ActionBarDrawerToggle(this,draw_location_liste,R.string.open,R.string.close);
        draw_location_liste.addDrawerListener(tri_bar_location_liste);
        tri_bar_location_liste.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_location_liste=(NavigationView) findViewById(R.id.navigationview_location_liste);
        if (navigationView_location_liste != null){navigationView_location_liste.setNavigationItemSelectedListener(this);}



        Button nv_btn_location_liste=(Button) findViewById(R.id.nv_location_liste_btn);
        final ViewFlipper vf_location_liste=(ViewFlipper) findViewById(R.id.vf_location_liste);
        nv_btn_location_liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_location_liste.setDisplayedChild(1);
            }
        });

    }

    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_location_liste.onOptionsItemSelected(item)) return true;
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
}
