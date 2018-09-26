package com.example.tamrouikarim.bigsoftweb;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;







public class pop_info_client extends Activity {

    String CodeTiers_received;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_client_info);

        CodeTiers_received=getIntent().getStringExtra("CodeTiers");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width=dm.widthPixels;
        int heignt = dm.heightPixels;


        getWindow().setLayout((int)(width*.8),(int)(heignt*.6));

        data_pop_client_info data= new data_pop_client_info();
        data.execute("");


    }


    ////////////////////////   data






    private class data_pop_client_info extends AsyncTask<String,String,String>
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
                String sql="SELECT * FROM base_tiers where CodeTiers='"+CodeTiers_received+"'";
                ResultSet result= stm.executeQuery(sql);


                result.next();
                 String CodeTiers=result.getString("CodeTiers");

    
                    String NumTiers=result.getString("NumTiers");
                    String NomTiers=result.getString("NomTiers");
                    String CodeFJ=result.getString("CodeFJ");
                    String CodeCategorie=result.getString("CodeCategorie");
                    String LibCategorie=result.getString("LibCategorie");
                    String DateCreation=result.getString("DateCreation");
                    String Couleur=result.getString("Couleur");
                    String RefTiers=result.getString("RefTiers");
                    String CodeActivite=result.getString("CodeActivite");
                    String CodeGroupe=result.getString("CodeGroupe");
                    String CodeSecteur=result.getString("CodeSecteur");
                    String Cpte=result.getString("Cpte");
                    String CpteB=result.getString("CpteB");
                    String CpteAv=result.getString("CpteAv");
                    String CpteInvest=result.getString("CpteInvest");
                    String CptePrestation=result.getString("CptePrestation");
                    String FnAcht=result.getString("FnAcht");
                    String FnEqp=result.getString("FnEqp");
                    String FnST=result.getString("FnST");
                    String FnCons=result.getString("FnCons");
                    String FnTrp=result.getString("FnTrp");
                    String FnInt=result.getString("FnInt");
                    String FnCol=result.getString("FnCol");
                    String ModePaie=result.getString("ModePaie");
                    String CodeDevise=result.getString("CodeDevise");
                    String TauxDevise=result.getString("TauxDevise");
                    String NegoDevise=result.getString("NegoDevise");
                    String DateNegoDevise=result.getString("DateNegoDevise");
                    String CodeTva=result.getString("CodeTva");
                    String ExonTVA=result.getString("ExonTVA");
                    String ExonTimbre=result.getString("ExonTimbre");
                    String TypeTiers=result.getString("TypeTiers");
                    String IsLocal=result.getString("IsLocal");
                    String ChiffreTiers=result.getString("ChiffreTiers");
                    String SoldeTiers=result.getString("SoldeTiers");
                    String PaieTiers=result.getString("PaieTiers");
                    String CreditAlloue=result.getString("CreditAlloue");
                    String AncienSolde=result.getString("AncienSolde");
                    String Adresse=result.getString("Adresse");
                    String Telephone=result.getString("Telephone");
                    String Fax=result.getString("Fax");
                    String CodeBnk=result.getString("CodeBnk");
                    String LibBnk=result.getString("LibBnk");
                    String CompteTiers=result.getString("CompteTiers");
                    String RegistreTiers=result.getString("RegistreTiers");
                    String CodeFisc=result.getString("CodeFisc");
                    String ARTFISC=result.getString("ARTFISC");
                    String NumIdStat=result.getString("NumIdStat");
                    String Web=result.getString("Web");
                    String CodePostal=result.getString("CodePostal");
                    String CodeVille=result.getString("CodeVille");
                    String Ville=result.getString("Ville");
                    String CodeRegion=result.getString("CodeRegion");
                    String Region=result.getString("Region");
                    String CodePays=result.getString("CodePays");
                    String Pays=result.getString("Pays");
                    String Email=result.getString("Email");
                    String StatuTiers=result.getString("StatuTiers");
                    String Telephone2=result.getString("Telephone2");
                    String Facebook=result.getString("Facebook");
                    String Skype=result.getString("Skype");
                    String Mobile=result.getString("Mobile");
                    String Abrege=result.getString("Abrege");
                    String Info=result.getString("Info");
                    String InfoCmdFour=result.getString("InfoCmdFour");
                    String MentionCmdFour=result.getString("MentionCmdFour");
                    String InfoBLClt=result.getString("InfoBLClt");
                    String InfoFactClt=result.getString("InfoFactClt");
                    String LivPor=result.getString("LivPor");
                    String LivAPartirDe=result.getString("LivAPartirDe");
                    String LivAccRecp=result.getString("LivAccRecp");
                    String Export=result.getString("Export");
                    String BIC=result.getString("BIC");
                    String IBAN=result.getString("IBAN");
                    String SWIFT=result.getString("SWIFT");
                    String CTVA=result.getString("CTVA");
                    String CCat=result.getString("CCat");
                    String NumEtabSecondaire=result.getString("NumEtabSecondaire");
                    String Escompte=result.getString("Escompte");
                    String Parafiscale=result.getString("Parafiscale");
                    String Releve=result.getString("Releve");
                    String BFA=result.getString("BFA");
                    String BLFac=result.getString("BLFac");
                    String Risque=result.getString("Risque");
                    String StatuQlt=result.getString("StatuQlt");
                    String CodeCertif=result.getString("CodeCertif");
                    String DateCertif=result.getString("DateCertif");
                    String ValidCertif=result.getString("ValidCertif");
                    String isAudit=result.getString("isAudit");
                    String DateAudit=result.getString("DateAudit");
                    String NoteAudit=result.getString("NoteAudit");
                    String CodeFactor=result.getString("CodeFactor");
                    String ForfLigCmd=result.getString("ForfLigCmd");
                    String ForfFact=result.getString("ForfFact");
                    String AccuRec=result.getString("AccuRec");
                    String MargHeur=result.getString("MargHeur");
                    String MargArt=result.getString("MargArt");
                    String CodeComInt=result.getString("CodeComInt");
                    String CodeChargAff=result.getString("CodeChargAff");
                    String CodeModLiv=result.getString("CodeModLiv");
                    String InfoLiv=result.getString("InfoLiv");
                    String TmpLiv=result.getString("TmpLiv");
                    String CodeCommercial=result.getString("CodeCommercial");
                    String TauxCommercial=result.getString("TauxCommercial");
                    String ObjChiffAffairMois=result.getString("ObjChiffAffairMois");
                    String CodeUConsom=result.getString("CodeUConsom");
                    String owner=result.getString("owner");
                    String ModifiedBy=result.getString("ModifiedBy");
                    String DateModified=result.getString("DateModified");
                    String DateCreated=result.getString("DateCreated");
                    String CreatedBy=result.getString("CreatedBy");
                    String CodeUnit=result.getString("CodeUnit");
                    String TauxRemise=result.getString("TauxRemise");
                    String NumArtisant=result.getString("NumArtisant");













                TextView CodeTiers_txtview= (TextView)findViewById(R.id.CodeTiers_pop_info_client);




   
                    TextView NumTiers_txtview= (TextView)findViewById(R.id.NumTiers_pop_info_client);
                    TextView NomTiers_txtview= (TextView)findViewById(R.id.NomTiers_pop_info_client);
                    TextView CodeFJ_txtview= (TextView)findViewById(R.id.CodeFJ_pop_info_client);
                    TextView CodeCategorie_txtview= (TextView)findViewById(R.id.CodeCategorie_pop_info_client);
                    TextView LibCategorie_txtview= (TextView)findViewById(R.id.LibCategorie_pop_info_client);
                    TextView DateCreation_txtview= (TextView)findViewById(R.id.DateCreation_pop_info_client);
                    TextView Couleur_txtview= (TextView)findViewById(R.id.Couleur_pop_info_client);
                    TextView RefTiers_txtview= (TextView)findViewById(R.id.RefTiers_pop_info_client);
                    TextView CodeActivite_txtview= (TextView)findViewById(R.id.CodeActivite_pop_info_client);
                    TextView CodeGroupe_txtview= (TextView)findViewById(R.id.CodeGroupe_pop_info_client);
                    TextView CodeSecteur_txtview= (TextView)findViewById(R.id.CodeSecteur_pop_info_client);
                    TextView Cpte_txtview= (TextView)findViewById(R.id.Cpte_pop_info_client);
                    TextView CpteB_txtview= (TextView)findViewById(R.id.CpteB_pop_info_client);
                    TextView CpteAv_txtview= (TextView)findViewById(R.id.CpteAv_pop_info_client);
                    TextView CpteInvest_txtview= (TextView)findViewById(R.id.CpteInvest_pop_info_client);
                    TextView CptePrestation_txtview= (TextView)findViewById(R.id.CptePrestation_pop_info_client);
                    TextView FnAcht_txtview= (TextView)findViewById(R.id.FnAcht_pop_info_client);
                    TextView FnEqp_txtview= (TextView)findViewById(R.id.FnEqp_pop_info_client);
                    TextView FnST_txtview= (TextView)findViewById(R.id.FnST_pop_info_client);
                    TextView FnCons_txtview= (TextView)findViewById(R.id.FnCons_pop_info_client);
                    TextView FnTrp_txtview= (TextView)findViewById(R.id.FnTrp_pop_info_client);
                    TextView FnInt_txtview= (TextView)findViewById(R.id.FnInt_pop_info_client);
                    TextView FnCol_txtview= (TextView)findViewById(R.id.FnCol_pop_info_client);
                    TextView ModePaie_txtview= (TextView)findViewById(R.id.ModePaie_pop_info_client);
                    TextView CodeDevise_txtview= (TextView)findViewById(R.id.CodeDevise_pop_info_client);
                    TextView TauxDevise_txtview= (TextView)findViewById(R.id.TauxDevise_pop_info_client);
                    TextView NegoDevise_txtview= (TextView)findViewById(R.id.NegoDevise_pop_info_client);
                    TextView DateNegoDevise_txtview= (TextView)findViewById(R.id.DateNegoDevise_pop_info_client);
                    TextView CodeTva_txtview= (TextView)findViewById(R.id.CodeTva_pop_info_client);
                    TextView ExonTVA_txtview= (TextView)findViewById(R.id.ExonTVA_pop_info_client);
                    TextView ExonTimbre_txtview= (TextView)findViewById(R.id.ExonTimbre_pop_info_client);
                    TextView TypeTiers_txtview= (TextView)findViewById(R.id.TypeTiers_pop_info_client);
                    TextView IsLocal_txtview= (TextView)findViewById(R.id.IsLocal_pop_info_client);
                    TextView ChiffreTiers_txtview= (TextView)findViewById(R.id.ChiffreTiers_pop_info_client);
                    TextView SoldeTiers_txtview= (TextView)findViewById(R.id.SoldeTiers_pop_info_client);
                    TextView PaieTiers_txtview= (TextView)findViewById(R.id.PaieTiers_pop_info_client);
                    TextView CreditAlloue_txtview= (TextView)findViewById(R.id.CreditAlloue_pop_info_client);
                    TextView AncienSolde_txtview= (TextView)findViewById(R.id.AncienSolde_pop_info_client);
                    TextView Adresse_txtview= (TextView)findViewById(R.id.Adresse_pop_info_client);
                    TextView Telephone_txtview= (TextView)findViewById(R.id.Telephone_pop_info_client);
                    TextView Fax_txtview= (TextView)findViewById(R.id.Fax_pop_info_client);
                    TextView CodeBnk_txtview= (TextView)findViewById(R.id.CodeBnk_pop_info_client);
                    TextView LibBnk_txtview= (TextView)findViewById(R.id.LibBnk_pop_info_client);
                    TextView CompteTiers_txtview= (TextView)findViewById(R.id.CompteTiers_pop_info_client);
                    TextView RegistreTiers_txtview= (TextView)findViewById(R.id.RegistreTiers_pop_info_client);
                    TextView CodeFisc_txtview= (TextView)findViewById(R.id.CodeFisc_pop_info_client);
                    TextView ARTFISC_txtview= (TextView)findViewById(R.id.ARTFISC_pop_info_client);
                    TextView NumIdStat_txtview= (TextView)findViewById(R.id.NumIdStat_pop_info_client);
                    TextView Web_txtview= (TextView)findViewById(R.id.Web_pop_info_client);
                    TextView CodePostal_txtview= (TextView)findViewById(R.id.CodePostal_pop_info_client);
                    TextView CodeVille_txtview= (TextView)findViewById(R.id.CodeVille_pop_info_client);
                    TextView Ville_txtview= (TextView)findViewById(R.id.Ville_pop_info_client);
                    TextView CodeRegion_txtview= (TextView)findViewById(R.id.CodeRegion_pop_info_client);
                    TextView Region_txtview= (TextView)findViewById(R.id.Region_pop_info_client);
                    TextView CodePays_txtview= (TextView)findViewById(R.id.CodePays_pop_info_client);
                    TextView Pays_txtview= (TextView)findViewById(R.id.Pays_pop_info_client);
                    TextView Email_txtview= (TextView)findViewById(R.id.Email_pop_info_client);
                    TextView StatuTiers_txtview= (TextView)findViewById(R.id.StatuTiers_pop_info_client);
                    TextView Telephone2_txtview= (TextView)findViewById(R.id.Telephone2_pop_info_client);
                    TextView Facebook_txtview= (TextView)findViewById(R.id.Facebook_pop_info_client);
                    TextView Skype_txtview= (TextView)findViewById(R.id.Skype_pop_info_client);
                    TextView Mobile_txtview= (TextView)findViewById(R.id.Mobile_pop_info_client);
                    TextView Abrege_txtview= (TextView)findViewById(R.id.Abrege_pop_info_client);
                    TextView Info_txtview= (TextView)findViewById(R.id.Info_pop_info_client);
                    TextView InfoCmdFour_txtview= (TextView)findViewById(R.id.InfoCmdFour_pop_info_client);
                    TextView MentionCmdFour_txtview= (TextView)findViewById(R.id.MentionCmdFour_pop_info_client);
                    TextView InfoBLClt_txtview= (TextView)findViewById(R.id.InfoBLClt_pop_info_client);
                    TextView InfoFactClt_txtview= (TextView)findViewById(R.id.InfoFactClt_pop_info_client);
                    TextView LivPor_txtview= (TextView)findViewById(R.id.LivPor_pop_info_client);
                    TextView LivAPartirDe_txtview= (TextView)findViewById(R.id.LivAPartirDe_pop_info_client);
                    TextView LivAccRecp_txtview= (TextView)findViewById(R.id.LivAccRecp_pop_info_client);
                    TextView Export_txtview= (TextView)findViewById(R.id.Export_pop_info_client);
                    TextView BIC_txtview= (TextView)findViewById(R.id.BIC_pop_info_client);
                    TextView IBAN_txtview= (TextView)findViewById(R.id.IBAN_pop_info_client);
                    TextView SWIFT_txtview= (TextView)findViewById(R.id.SWIFT_pop_info_client);
                    TextView CTVA_txtview= (TextView)findViewById(R.id.CTVA_pop_info_client);
                    TextView CCat_txtview= (TextView)findViewById(R.id.CCat_pop_info_client);
                    TextView NumEtabSecondaire_txtview= (TextView)findViewById(R.id.NumEtabSecondaire_pop_info_client);
                    TextView Escompte_txtview= (TextView)findViewById(R.id.Escompte_pop_info_client);
                    TextView Parafiscale_txtview= (TextView)findViewById(R.id.Parafiscale_pop_info_client);
                    TextView Releve_txtview= (TextView)findViewById(R.id.Releve_pop_info_client);
                    TextView BFA_txtview= (TextView)findViewById(R.id.BFA_pop_info_client);
                    TextView BLFac_txtview= (TextView)findViewById(R.id.BLFac_pop_info_client);
                    TextView Risque_txtview= (TextView)findViewById(R.id.Risque_pop_info_client);
                    TextView StatuQlt_txtview= (TextView)findViewById(R.id.StatuQlt_pop_info_client);
                    TextView CodeCertif_txtview= (TextView)findViewById(R.id.CodeCertif_pop_info_client);
                    TextView DateCertif_txtview= (TextView)findViewById(R.id.DateCertif_pop_info_client);
                    TextView ValidCertif_txtview= (TextView)findViewById(R.id.ValidCertif_pop_info_client);
                    TextView isAudit_txtview= (TextView)findViewById(R.id.isAudit_pop_info_client);
                    TextView DateAudit_txtview= (TextView)findViewById(R.id.DateAudit_pop_info_client);
                    TextView NoteAudit_txtview= (TextView)findViewById(R.id.NoteAudit_pop_info_client);
                    TextView CodeFactor_txtview= (TextView)findViewById(R.id.CodeFactor_pop_info_client);
                    TextView ForfLigCmd_txtview= (TextView)findViewById(R.id.ForfLigCmd_pop_info_client);
                    TextView ForfFact_txtview= (TextView)findViewById(R.id.ForfFact_pop_info_client);
                    TextView AccuRec_txtview= (TextView)findViewById(R.id.AccuRec_pop_info_client);
                    TextView MargHeur_txtview= (TextView)findViewById(R.id.MargHeur_pop_info_client);
                    TextView MargArt_txtview= (TextView)findViewById(R.id.MargArt_pop_info_client);
                    TextView CodeComInt_txtview= (TextView)findViewById(R.id.CodeComInt_pop_info_client);
                    TextView CodeChargAff_txtview= (TextView)findViewById(R.id.CodeChargAff_pop_info_client);
                    TextView CodeModLiv_txtview= (TextView)findViewById(R.id.CodeModLiv_pop_info_client);
                    TextView InfoLiv_txtview= (TextView)findViewById(R.id.InfoLiv_pop_info_client);
                    TextView TmpLiv_txtview= (TextView)findViewById(R.id.TmpLiv_pop_info_client);
                    TextView CodeCommercial_txtview= (TextView)findViewById(R.id.CodeCommercial_pop_info_client);
                    TextView TauxCommercial_txtview= (TextView)findViewById(R.id.TauxCommercial_pop_info_client);
                    TextView ObjChiffAffairMois_txtview= (TextView)findViewById(R.id.ObjChiffAffairMois_pop_info_client);
                    TextView CodeUConsom_txtview= (TextView)findViewById(R.id.CodeUConsom_pop_info_client);
                    TextView owner_txtview= (TextView)findViewById(R.id.owner_pop_info_client);
                    TextView ModifiedBy_txtview= (TextView)findViewById(R.id.ModifiedBy_pop_info_client);
                    TextView DateModified_txtview= (TextView)findViewById(R.id.DateModified_pop_info_client);
                    TextView DateCreated_txtview= (TextView)findViewById(R.id.DateCreated_pop_info_client);
                    TextView CreatedBy_txtview= (TextView)findViewById(R.id.CreatedBy_pop_info_client);
                    TextView CodeUnit_txtview= (TextView)findViewById(R.id.CodeUnit_pop_info_client);
                    TextView TauxRemise_txtview= (TextView)findViewById(R.id.TauxRemise_pop_info_client);
                    TextView NumArtisant_txtview= (TextView)findViewById(R.id.NumArtisant_pop_info_client);



                CodeTiers_txtview.setText(CodeTiers);
    
                     NumTiers_txtview.setText(NumTiers);
                     NomTiers_txtview.setText(NomTiers);
                     CodeFJ_txtview.setText(CodeFJ);
                     CodeCategorie_txtview.setText(CodeCategorie);
                     LibCategorie_txtview.setText(LibCategorie);
                     DateCreation_txtview.setText(DateCreation);
                     Couleur_txtview.setText(Couleur);
                     RefTiers_txtview.setText(RefTiers);
                     CodeActivite_txtview.setText(CodeActivite);
                     CodeGroupe_txtview.setText(CodeGroupe);
                     CodeSecteur_txtview.setText(CodeSecteur);
                     Cpte_txtview.setText(Cpte);
                     CpteB_txtview.setText(CpteB);
                     CpteAv_txtview.setText(CpteAv);
                     CpteInvest_txtview.setText(CpteInvest);
                     CptePrestation_txtview.setText(CptePrestation);
                     FnAcht_txtview.setText(FnAcht);
                     FnEqp_txtview.setText(FnEqp);
                     FnST_txtview.setText(FnST);
                     FnCons_txtview.setText(FnCons);
                     FnTrp_txtview.setText(FnTrp);
                     FnInt_txtview.setText(FnInt);
                     FnCol_txtview.setText(FnCol);
                     ModePaie_txtview.setText(ModePaie);
                     CodeDevise_txtview.setText(CodeDevise);
                     TauxDevise_txtview.setText(TauxDevise);
                     NegoDevise_txtview.setText(NegoDevise);
                     DateNegoDevise_txtview.setText(DateNegoDevise);
                     CodeTva_txtview.setText(CodeTva);
                     ExonTVA_txtview.setText(ExonTVA);
                     ExonTimbre_txtview.setText(ExonTimbre);
                     TypeTiers_txtview.setText(TypeTiers);
                     IsLocal_txtview.setText(IsLocal);
                     ChiffreTiers_txtview.setText(ChiffreTiers);
                     SoldeTiers_txtview.setText(SoldeTiers);
                     PaieTiers_txtview.setText(PaieTiers);
                     CreditAlloue_txtview.setText(CreditAlloue);
                     AncienSolde_txtview.setText(AncienSolde);
                     Adresse_txtview.setText(Adresse);
                     Telephone_txtview.setText(Telephone);
                     Fax_txtview.setText(Fax);
                     CodeBnk_txtview.setText(CodeBnk);
                     LibBnk_txtview.setText(LibBnk);
                     CompteTiers_txtview.setText(CompteTiers);
                     RegistreTiers_txtview.setText(RegistreTiers);
                     CodeFisc_txtview.setText(CodeFisc);
                     ARTFISC_txtview.setText(ARTFISC);
                     NumIdStat_txtview.setText(NumIdStat);
                     Web_txtview.setText(Web);
                     CodePostal_txtview.setText(CodePostal);
                     CodeVille_txtview.setText(CodeVille);
                     Ville_txtview.setText(Ville);
                     CodeRegion_txtview.setText(CodeRegion);
                     Region_txtview.setText(Region);
                     CodePays_txtview.setText(CodePays);
                     Pays_txtview.setText(Pays);
                     Email_txtview.setText(Email);
                     StatuTiers_txtview.setText(StatuTiers);
                     Telephone2_txtview.setText(Telephone2);
                     Facebook_txtview.setText(Facebook);
                     Skype_txtview.setText(Skype);
                     Mobile_txtview.setText(Mobile);
                     Abrege_txtview.setText(Abrege);
                     Info_txtview.setText(Info);
                     InfoCmdFour_txtview.setText(InfoCmdFour);
                     MentionCmdFour_txtview.setText(MentionCmdFour);
                     InfoBLClt_txtview.setText(InfoBLClt);
                     InfoFactClt_txtview.setText(InfoFactClt);
                     LivPor_txtview.setText(LivPor);
                     LivAPartirDe_txtview.setText(LivAPartirDe);
                     LivAccRecp_txtview.setText(LivAccRecp);
                     Export_txtview.setText(Export);
                     BIC_txtview.setText(BIC);
                     IBAN_txtview.setText(IBAN);
                     SWIFT_txtview.setText(SWIFT);
                     CTVA_txtview.setText(CTVA);
                     CCat_txtview.setText(CCat);
                     NumEtabSecondaire_txtview.setText(NumEtabSecondaire);
                     Escompte_txtview.setText(Escompte);
                     Parafiscale_txtview.setText(Parafiscale);
                     Releve_txtview.setText(Releve);
                     BFA_txtview.setText(BFA);
                     BLFac_txtview.setText(BLFac);
                     Risque_txtview.setText(Risque);
                     StatuQlt_txtview.setText(StatuQlt);
                     CodeCertif_txtview.setText(CodeCertif);
                     DateCertif_txtview.setText(DateCertif);
                     ValidCertif_txtview.setText(ValidCertif);
                     isAudit_txtview.setText(isAudit);
                     DateAudit_txtview.setText(DateAudit);
                     NoteAudit_txtview.setText(NoteAudit);
                     CodeFactor_txtview.setText(CodeFactor);
                     ForfLigCmd_txtview.setText(ForfLigCmd);
                     ForfFact_txtview.setText(ForfFact);
                     AccuRec_txtview.setText(AccuRec);
                     MargHeur_txtview.setText(MargHeur);
                     MargArt_txtview.setText(MargArt);
                     CodeComInt_txtview.setText(CodeComInt);
                     CodeChargAff_txtview.setText(CodeChargAff);
                     CodeModLiv_txtview.setText(CodeModLiv);
                     InfoLiv_txtview.setText(InfoLiv);
                     TmpLiv_txtview.setText(TmpLiv);
                     CodeCommercial_txtview.setText(CodeCommercial);
                     TauxCommercial_txtview.setText(TauxCommercial);
                     ObjChiffAffairMois_txtview.setText(ObjChiffAffairMois);
                     CodeUConsom_txtview.setText(CodeUConsom);
                     owner_txtview.setText(owner);
                     ModifiedBy_txtview.setText(ModifiedBy);
                     DateModified_txtview.setText(DateModified);
                     DateCreated_txtview.setText(DateCreated);
                     CreatedBy_txtview.setText(CreatedBy);
                     CodeUnit_txtview.setText(CodeUnit);
                     TauxRemise_txtview.setText(TauxRemise);
                     NumArtisant_txtview.setText(NumArtisant);


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


        }



    }



///////////////////////////////////// data
}
