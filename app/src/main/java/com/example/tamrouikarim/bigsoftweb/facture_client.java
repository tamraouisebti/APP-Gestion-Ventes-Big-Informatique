package com.example.tamrouikarim.bigsoftweb;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
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
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class facture_client extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout draw_facture_client;
    private ActionBarDrawerToggle tri_bar_facture_client;
    private NavigationView navigationView_facture_client;
    ////////////////////////////////////// data variables
    String CodeDoc=null; ////not null
    String NumDoc    =null;        ////////not null;
    String CodeOrig   =null;
    String NumOrig   =null;
    String TypeOrig =null;
    String CodeCmd  =null;
    String NumCmd  =null;
    String CodeCtr  =null;
    String NumCtr   =null;
    String CodeTiers    =null;        ////////not null;
    String NumTiers   =null;        ////////not null;
    String NomTiers   =null;        ////////not null;
    String CodeCategorie  =null;
    String TypeDoc= "FAC";
    int isPenalite=0;
    String DateDoc  =null;        ////////not null;
    String CodePer   ="0";        ////////not null;
    String CodePerUn    ="0";        ////////not null;
    String DateEchPai=null;
    long ModePai;
    long ModeReg;
    String ModeAv  =null;
    long TypeVte;
    String ExonTVA ="Non";
    String ExonTimbre="Non";
    int AppTimbre=0;
    int TypeRem=2;
    double TRem =0.000000;
    double MTRemise=0.000000;
    double MTTVA=0.000000;
    double MTTaxe=0.000000;
    double MTHT=0.000000;
    double MTHTR=0.000000;
    double MTTC=0.000000;
    double MTimbre=0.000000;
    double MTRG=0.000000;
    double TRG=0.000000;
    int FRG=0;
    double MTPaye=0.000000;
    double RestePaye=0.000000;
    double MTAv=0.000000;
    double ResteAv=0.000000;
    int isSoldeFact=0;
    String StatuDoc="N";
    String StatuBlv="N";
    String StatuPai="N";
    String StatuFL="Nouveau";
    String CodeCommercial=null;
    int EtatCompta=0;
    String InfoCompta   =null;
    String DateCompta =null;
    String NomAgtCom   =null;
    String PrenomAgtCom   =null;
    String owner   =null;
    String CodeUConsom   =null;
    String ModifiedBy   =null;
    String DateModified=null;
    String DateCreated=null;
    String CreatedBy   =null;
    String CodeUnit    ="Sys";        ////////not null;
    String CodeExc    ="0";        ////////not null;
    String DescDoc =null;
    int Reserve=0;
    double MTRGTTC;
    String NumFrTva   =null;
    String DateFrTva=null;


    //////////////////////////////////////

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture_client);
        // ajouter le Mtuggle au Bar D'action
        draw_facture_client = (DrawerLayout) findViewById(R.id.draw_facture_client);
        tri_bar_facture_client=new ActionBarDrawerToggle(this,draw_facture_client,R.string.open,R.string.close);
        draw_facture_client.addDrawerListener(tri_bar_facture_client);
        tri_bar_facture_client.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ajouter un listener au item du navigationview du client

        navigationView_facture_client=(NavigationView) findViewById(R.id.navigationview_facture_client);
        if (navigationView_facture_client != null){navigationView_facture_client.setNavigationItemSelectedListener(this);}

        /////////spinners //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //// type
        Spinner type_spinner = (Spinner)findViewById(R.id.type_facture_nv_spinner);
        ArrayAdapter<CharSequence> type_adapter=ArrayAdapter.createFromResource(this,R.array.type_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_adapter);

        //// exon tva
        Spinner exon_tva_spinner = (Spinner)findViewById(R.id.exon_tva_facture_nv_spinner);
        ArrayAdapter<CharSequence> exon_tva_adapter=ArrayAdapter.createFromResource(this,R.array.exon_tva_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        exon_tva_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exon_tva_spinner.setAdapter(exon_tva_adapter);
         //// exon_timbre
        Spinner exon_timbre_spinner = (Spinner)findViewById(R.id.exon_timbre_facture_nv_spinner);
        ArrayAdapter<CharSequence> exon_timbre_adapter=ArrayAdapter.createFromResource(this,R.array.exon_timbre_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        exon_timbre_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exon_timbre_spinner.setAdapter(exon_timbre_adapter);
        //// type_remise
        Spinner type_remise_spinner = (Spinner)findViewById(R.id.type_remise_facture_nv_spinner);
        ArrayAdapter<CharSequence> type_remise_adapter=ArrayAdapter.createFromResource(this,R.array.type_remise_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        type_remise_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_remise_spinner.setAdapter(type_remise_adapter);
        //// type_vente
        Spinner type_vente_spinner = (Spinner)findViewById(R.id.type_vente_facture_nv_spinner);
        ArrayAdapter<CharSequence> type_vente_adapter=ArrayAdapter.createFromResource(this,R.array.type_vente_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        type_vente_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_vente_spinner.setAdapter(type_vente_adapter);
        //// mode_paiememnt
        Spinner mode_paiement_spinner = (Spinner)findViewById(R.id.mode_paiement_facture_nv_spinner);
        ArrayAdapter<CharSequence> mode_paiement_adapter=ArrayAdapter.createFromResource(this,R.array.mode_paiement_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        mode_paiement_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mode_paiement_spinner.setAdapter(mode_paiement_adapter);
        //// mode_reg
        Spinner mode_reg_spinner = (Spinner)findViewById(R.id.mode_reg_facture_nv_spinner);
        ArrayAdapter<CharSequence> mode_reg_adapter=ArrayAdapter.createFromResource(this,R.array.mode_reg_facture_nv_array_spinner,android.R.layout.simple_spinner_item);
        mode_reg_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mode_reg_spinner.setAdapter(mode_reg_adapter);


/////////////////////////////////////////
        data_facture data = new data_facture();
        data.execute("");
        ///////////////////////////////





        Button nv_btn_facture_client=(Button) findViewById(R.id.nv_facture_client_btn);
        final ViewFlipper vf_facture_client=(ViewFlipper) findViewById(R.id.vf_facture_client);
        nv_btn_facture_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_facture_client.setDisplayedChild(1);
            }
        });



        Spinner facture_client_spinner = (Spinner)findViewById(R.id.facture_client_spinner);
        ArrayAdapter<CharSequence> sadapter=ArrayAdapter.createFromResource(this,R.array.facture_client_array_spinner,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facture_client_spinner.setAdapter(sadapter);
        facture_client_spinner.setOnItemSelectedListener(this);







        //////////////////////////////////////////////////////////
        Button save_btn=(Button) findViewById(R.id.facture_client_save_btn);


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ////////////////edit text
                EditText facture_edit=(EditText) findViewById(R.id.nv_numero_facture_editxt);
                EditText commercial_edit=(EditText) findViewById(R.id.nv_commercial_facture_editxt);
                EditText date_edit=(EditText) findViewById(R.id.nv_date_facture_editxt);
                EditText date_ech_edit=(EditText) findViewById(R.id.nv_date_echeance_facture_editxt);
/////////////spinners
                Spinner type=(Spinner)findViewById(R.id.type_facture_nv_spinner);
                Spinner exon_tva=(Spinner)findViewById(R.id.exon_tva_facture_nv_spinner);
                Spinner exon_timbre=(Spinner)findViewById(R.id.exon_timbre_facture_nv_spinner);
                Spinner type_remise=(Spinner)findViewById(R.id.type_remise_facture_nv_spinner);
                Spinner type_vente=(Spinner)findViewById(R.id.type_vente_facture_nv_spinner);
                Spinner mode_paiement=(Spinner)findViewById(R.id.mode_paiement_facture_nv_spinner);
                Spinner mode_reg=(Spinner)findViewById(R.id.mode_reg_facture_nv_spinner);

//////////////////////// initialiser data
                CodeDoc=facture_edit.getText().toString();
                NumDoc=facture_edit.getText().toString();
                CodeCommercial=commercial_edit.getText().toString();
                DateDoc="'"+date_edit.getText().toString()+"'";
                DateEchPai="'"+date_ech_edit.getText().toString()+"'";

                //  TypeDoc=type.getSelectedItem().toString();
                ExonTVA=exon_tva.getSelectedItem().toString();
                ExonTimbre=exon_timbre.getSelectedItem().toString();
                TypeRem= (int) type_remise.getSelectedItemId();
                TypeVte=type_vente.getSelectedItemId();
                ModePai=mode_paiement.getSelectedItemId();
                ModeReg=mode_reg.getSelectedItemId();







                add_data_facture add_data =new add_data_facture();




                if ((CodeDoc.length()==0)||(NumDoc.length()==0)||(CodeTiers==null)||(NumTiers==null)||(NomTiers==null)||(DateDoc.length()<3)||(CodePerUn==null)
                        ||(CodeUnit==null)||(CodeExc==null)||(DateEchPai.length()<3))
                {
                    Toast.makeText(getApplicationContext(),"Manque Information",Toast.LENGTH_LONG).show();
                }
                else {

                    add_data.execute("");
                    finish();
                     }

            }
        });


        //////////////////////client popup windouw
       Button select_client=(Button) findViewById(R.id.select_client_facture_btn);
       select_client.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent goto_popup = new Intent(getApplicationContext(), pop_client.class);
               startActivityForResult(goto_popup,1);


           }
       });
        Button select_commande=(Button) findViewById(R.id.select_commande_facture_btn);
        select_commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_popup = new Intent(getApplicationContext(), pop_commande.class);
                startActivityForResult(goto_popup,2);


            }
        });
        Button select_contrat=(Button) findViewById(R.id.select_contrat_facture_btn);
        select_contrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_popup = new Intent(getApplicationContext(), pop_contrat.class);
                startActivityForResult(goto_popup,3);


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
    super.onActivityResult(requestCode,resultCode,data);
    switch (requestCode)
    {
        case(1):{
            if(resultCode== Activity.RESULT_OK)
            {
                Bundle extras=data.getBundleExtra("bundle_client");
               CodeTiers=extras.getString("codetiers");
               NumTiers=extras.getString("numtiers");
               NomTiers=extras.getString("nomtiers");

                EditText client_edittxt=(EditText)findViewById(R.id.nv_client_facture_editxt);
                client_edittxt.setText(CodeTiers+" "+NomTiers+" "+NumTiers);
            }
        }break;
            case(2):{
            if(resultCode== Activity.RESULT_OK)
            {
                Bundle extras=data.getBundleExtra("bundle_commande");
                CodeCmd=extras.getString("codecmd");CodeCmd="'"+CodeCmd+"'";
                NumCmd=extras.getString("numcmd");NumCmd="'"+NumCmd+"'";

                EditText edittxt=(EditText)findViewById(R.id.nv_commande_facture_editxt);
                edittxt.setText(CodeCmd+" "+NumCmd);
            }
        }break;
        case(3):{
            if(resultCode== Activity.RESULT_OK)
            {
                Bundle extras=data.getBundleExtra("bundle_contrat");
                CodeCtr=extras.getString("codectr");CodeCtr="'"+CodeCtr+"'";
                NumCtr=extras.getString("numctr");NumCtr="'"+NumCtr+"'";

                EditText edittxt=(EditText)findViewById(R.id.nv_contrat_facture_editxt);
                edittxt.setText(CodeCtr+" "+NumCtr);
            }
        }break;
    }
    }



    // activer le Mtuggle du Bar D'action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tri_bar_facture_client.onOptionsItemSelected(item)) return true;
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
        ViewFlipper facture_client_vf=(ViewFlipper)findViewById(R.id.nv_facture_client_vf);

        facture_client_vf.setDisplayedChild((int) item_id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





    private class data_facture extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;



        List<String> numero_list=new LinkedList<>();
        List<String> commande_list=new LinkedList<>();
        List<String> client_list=new LinkedList<>();
        List<String> date_list=new LinkedList<>();
        List<String> date_echance_list=new LinkedList<>();
        List<String> montant_ttc_list=new LinkedList<>();
        List<String> mt_reste_payer_list=new LinkedList<>();
        List<String> etat_list=new LinkedList<>();
        List<String> etat_livraison_list=new LinkedList<>();
        List<String> etat_compta_list=new LinkedList<>();
        List<String> unite_list=new LinkedList<>();




        @Override
        protected String doInBackground(String... strings) {


            try
            {

                Class.forName(JDBC_DRIVER);

                con= DriverManager.getConnection(DB_URL,data_base.bd_user_name,data_base.bd_mp);
                stm=con.createStatement();
                String sql="SELECT * FROM vte_facture";
                ResultSet result= stm.executeQuery(sql);


                while(result.next())
                {
                    numero_list.add(result.getString("NumDoc"));
                    commande_list.add(result.getString("NumCmd"));
                    client_list.add(result.getString("NomTiers"));
                    date_list.add(result.getString("DateDoc"));
                    date_echance_list.add(result.getString("DateEchPai"));
                    montant_ttc_list.add(result.getString("MTTC"));
                    mt_reste_payer_list.add(result.getString("RestePaye"));
                    etat_list.add(result.getString("StatuDoc"));
                    etat_livraison_list.add(result.getString("StatuBlv"));
                    etat_compta_list.add(result.getString("EtatCompta"));
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
            ListView list=(ListView) findViewById(R.id.liste_facture_client);
            item_facture_client  adapter= new item_facture_client(getApplicationContext(),numero_list,commande_list,client_list,
                    date_list,date_echance_list,montant_ttc_list,mt_reste_payer_list,etat_list,etat_livraison_list,etat_compta_list,unite_list);
            list.setAdapter(adapter);

        }



    }






    ///////////////////////////////add data




    private class add_data_facture extends AsyncTask<String,String,String>
    {



        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://"+data_base.bd_url+"/"+data_base.bd_nom;

        Connection con=null;
        Statement stm=null;





        @Override
        protected String doInBackground(String... strings) {













            String gh="'"+ CodeDoc+"','"+ NumDoc    +"','"+ CodeOrig   +"','"+ NumOrig   +"','"+ TypeOrig +"',"+ CodeCmd  +","+ NumCmd  +","+ CodeCtr  +
                    ","+ NumCtr   +",'"+ CodeTiers    +"','"+ NumTiers   +"','"+ NomTiers   +"','"+ CodeCategorie  +"','"+ TypeDoc +"',"+ isPenalite+ ","+
                    DateDoc  +",'"+ CodePer   +"','"+ CodePerUn    +"',"+ DateEchPai+",'"+ ModePai +"','"+ ModeReg +"','"+ ModeAv  +"','"+
                    TypeVte +"','"+ ExonTVA +"','"+ ExonTimbre+"',"+ AppTimbre+","+ TypeRem+","+ TRem +","+ MTRemise+ ","+ MTTVA+","+ MTTaxe+","+
                    MTHT+","+ MTHTR+ ","+ MTTC+","+ MTimbre+ ","+ MTRG+ ","+ TRG+ ","+ FRG+ ","+ MTPaye+ ","+ RestePaye+ ","+ MTAv+ ","+
                    ResteAv+ ","+ isSoldeFact+ ",'"+ StatuDoc+ "','"+ StatuBlv+ "','"+ StatuPai+ "','"+ StatuFL+ "','"+ CodeCommercial+"',"+
                    EtatCompta+ ",'"+ InfoCompta   +"',"+ DateCompta +",'"+ NomAgtCom   +"','"+ PrenomAgtCom   +"','"+ owner   +"','"+ CodeUConsom
                    +"','"+ ModifiedBy   +"',"+ DateModified+","+ DateCreated+",'"+ CreatedBy   +"','"+ CodeUnit    +"','"+ CodeExc    +"','"+ DescDoc
                    +"',"+ Reserve+ ","+ MTRGTTC+ ",'"+ NumFrTva   +"',"+ DateFrTva+"";














                try {

                    Class.forName(JDBC_DRIVER);

                    con = DriverManager.getConnection(DB_URL, data_base.bd_user_name, data_base.bd_mp);
                    stm = con.createStatement();
                    String sql = "INSERT INTO `vte_facture` VALUES (" + gh + ")";
                    int result = stm.executeUpdate(sql);




                    ////// remmetre les valeur de variable de selection (client , contart , commande ) a null

                    CodeTiers=null;
                    NomTiers=null;
                    NumTiers=null;
                    CodeCmd=null;
                    NumCmd=null;
                    CodeCtr=null;
                    NumCtr=null;

                    stm.close();
                    con.close();


                } catch (SQLException conError) {
                    msg = "exception";
                } catch (ClassNotFoundException e) {
                    msg = "exception";
                    e.printStackTrace();
                    } finally {
                        try {
                        if (stm != null) {
                            stm.close();
                                          }
                             } catch (SQLException e) {
                        e.printStackTrace();
                             }
                         try {
                          if (con != null) {
                            con.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    }



            return msg;
        }

    }



///////////////////////////////////// data



}
