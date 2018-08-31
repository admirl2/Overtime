package com.supp.work.soft.client.vue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.supp.work.soft.client.GreetingService;
import com.supp.work.soft.client.GreetingServiceAsync;
import com.supp.work.soft.client.service.ArchiveService;
import com.supp.work.soft.client.service.ArchiveServiceAsync;
import com.supp.work.soft.shared.FieldVerifier;
import com.supp.work.soft.shared.PdfObserver;
import com.supp.work.soft.shared.model.Archiveemployes;
import com.supp.work.soft.shared.model.ArchiveemployesPK;
import com.supp.work.soft.shared.model.Employes;

public class Formulaire implements IsWidget {

	private final GreetingServiceAsync pdfService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync rechercheService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync modifierService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync enregistrerService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync compteurService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync listerService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync rechercheServiceArchive = GWT
			.create(GreetingService.class);

	private final GreetingServiceAsync enregistrerServiceArchive = GWT
			.create(GreetingService.class);
	private final ArchiveServiceAsync modifierServiceA = GWT
			.create(ArchiveService.class);

	VerticalPanel gVPanel;
	TextBox nom;
	TextBox prenom;
	TextBox salaire;
	Label lNom;
	Label lPrenom;
	Label lSalaire;
	Label lFonction;
	TextBox tFonction;
	Label lHoraireRegulier;
	SimpleComboBox<String> tHoraireRegulier;
	Label lRaison;
	TextArea tRaison;
	SimpleComboBox<String> mois;
	SimpleComboBox<String> annee;
	Label lMois;
	Label direction;
	Label service;
	SimpleComboBox<String> tDirection;
	SimpleComboBox<String> tService;
	VerticalPanel deuxiemeForm;
	VerticalPanel teteForm;
	HorizontalPanel panelDeuxTables;
	VerticalPanel dateEtJour;
	SimplePanel sPTable2;

	FlexTable table;
	Label date;
	Label nbrH;
	Label lundi;
	Label mardi;
	Label mercredi;
	Label jeudi;
	Label vendredi;
	Label samedi;
	Label lConges;
	Label dimanche;
	Label massage;
	TextBox totLundi;
	TextBox totMardi;
	TextBox totMercredi;
	TextBox totJeudi;
	TextBox totVendredi;
	TextBox totSamedi;
	TextBox conges;
	TextBox totDimanche;
	FlexTable table2;
	FlexTable table3;

	// ComboBoxItem export;
	Button bExport;
	Button enregistrer;
	Button modifier;
	Button lister;

	Label message;

	VerticalPanel panelMessage;

	TextBox recherche;
	Button bRecherche;

	HorizontalPanel panelRecherche;
	HorizontalPanel hPanelBouton;

	TextBox tEnregistrerPar;
	TextBox tEnregitrerLe;
	TextBox tModifierPar;
	TextBox tModifierLe;
	Label lEnregistrerPar;
	Label lEnregitrerLe;
	Label lModifierPar;
	Label lModifierLe;
	Label masquer;
	FlexTable table4;
	CheckBox box;
	CheckBox cLister;
	Label liste;
	HorizontalPanel audit;
	ArrayList list ;
	public Formulaire() {
		
		// Creation de l'objet
		table4 = new FlexTable();
		audit = new HorizontalPanel();
		panelDeuxTables= new HorizontalPanel();
		panelDeuxTables.setStyleName("panelDeuxTables");
		dateEtJour=new VerticalPanel();
		dateEtJour.setStyleName("dateEtJour");
		audit.setVisible(false);
		box = new CheckBox();
		cLister = new CheckBox();
		tEnregistrerPar = new TextBox();
		tEnregitrerLe = new TextBox();
		tModifierPar = new TextBox();
		tModifierLe = new TextBox();
		lEnregistrerPar = new Label("Creer par");
		lEnregitrerLe = new Label("Creer le");
		lModifierPar = new Label("Modifier par");
		lModifierLe = new Label("Modifier le");
		masquer = new Label("Hide");
		liste = new Label("Liste");
		
		sPTable2=new SimplePanel();
		sPTable2.setStyleName("sPTable2");

		list = new ArrayList();
		hPanelBouton = new HorizontalPanel();
		hPanelBouton.setStyleName("hPanelBouton");
		panelRecherche = new HorizontalPanel();
		panelMessage = new VerticalPanel();
		message = new Label();
		message.setStyleName("messageFormulaire");
		teteForm = new VerticalPanel();
		teteForm.setStyleName("teteForm"); 
		gVPanel = new VerticalPanel();
		lNom = new Label("Nom");
		lPrenom = new Label("Prenom");
		lSalaire = new Label("Salaire");
		nom = new TextBox();
		prenom = new TextBox();
		salaire = new TextBox();
		lFonction = new Label("Fonction");
		tFonction = new TextBox();
		lHoraireRegulier = new Label("Horaire regulier");
		tHoraireRegulier = new SimpleComboBox<String>(
				new StringLabelProvider<String>());
		tHoraireRegulier.add("8h a.m - 4h p.m");
		tHoraireRegulier.add("6h p.m - 6h a.m");
		lRaison = new Label("Raison");
		tRaison = new TextArea();
		direction = new Label("Direction");
		service = new Label("Service");
		deuxiemeForm = new VerticalPanel();
		deuxiemeForm.setStyleName("deuxiemeForm");

		table = new FlexTable();
		table2 = new FlexTable();
		table3 = new FlexTable();
		date = new Label("Date");
		nbrH = new Label("Nombre d'heures");
		nbrH.setStyleName("nbrH");
		lundi = new Label("Lundi");
		mardi = new Label("Mardi");
		mercredi = new Label("Mercredi");
		jeudi = new Label("Jeudi");
		vendredi = new Label("Vendredi");
		samedi = new Label("Samedi");
		dimanche = new Label("Dimanche");
		lConges= new Label("Congés");

		totLundi = new TextBox();
		totMardi = new TextBox();
		totMercredi = new TextBox();
		totJeudi = new TextBox();
		totVendredi = new TextBox();
		totSamedi = new TextBox();
		totDimanche = new TextBox();
		conges= new TextBox();
		tDirection = new SimpleComboBox<String>(
				new StringLabelProvider<String>());
		tDirection.add("UCDD");
		tDirection.add("BM");
//		tDirection.add("CC");
		tDirection.add("CM");
		tDirection.add("DSI");
		tDirection.add("UEP");
		tDirection.add("UCSA");
		tDirection.add("DRH");
		tDirection.add("DAA");
		tDirection.add("DEE");
		tDirection.add("DAJ");
		tDirection.add("DPC");
		tDirection.add("DIF");
//		tDirection.add("DDNO");
//		tDirection.add("DDN");
//		tDirection.add("DDNI");
//		tDirection.add("DDS");
//		tDirection.add("DDGA");
//		tDirection.add("DDA");
//		tDirection.add("DDC");
//		tDirection.add("DDNE");
//		tDirection.add("BDPG");
//		tDirection.add("DDSE");
		tDirection.add("DGTCP");
		tDirection.add("DG");
		tDirection.add("CRFPGE");
		tDirection.add("UCGPPP");
		tDirection.setStyleName("combo1");
		tDirection.setEmptyText("Direction");
		tService = new SimpleComboBox<String>(new StringLabelProvider<String>());
		tService.setEmptyText("Service");
		tService.add("SAT");
		tService.add("SCB");
		tService.add("SIFE");
		tService.add("BSGB");
		tService.add("CAPF");
		tService.add("SCP");
		tService.add("SCA");
		// tService.add("DPC/SAC");
		tService.add("SL");
		tService.add("SF");
		tService.add("SC");
		tService.add("SA");
		tService.add("Analyse et Recherche Fiscale");
		tService.add("Verification");
		tService.add("Franchises");
		tService.add("Recettes Douani�res");
		tService.add("Recettes Internes");
		tService.add("SG");
		tService.add("CC");
		tService.add("Service de la Planification des RH, de l'Organisation du travail, de Dotation des RH et Mouvements du Personnel");
		tService.add("Service Gestion de la Rémunération, des Avantages sociaux, des Relations de travail, des Compétences, Carrière et Retraite");
		tService.add("Sécurité");
		recherche = new TextBox();
		recherche.setStyleName("recherche");
//		recherche.setSearchQuery(true);
//		recherche.setPlaceholder("Recherche");
		bExport = new Button("Export");
		bExport.setStyleName("bExport");
		enregistrer = new Button("Enregistrer");
		enregistrer.setStyleName("bEnregistrer");
		bRecherche = new Button("Rechercher");
		bRecherche.setStyleName("bRecherche");
		modifier = new Button("Modifier");
		modifier.setStyleName("bModifier");
		lister = new Button("Lister");

		lMois = new Label("Mois & année");
		mois = new SimpleComboBox<String>(new StringLabelProvider<String>());
		mois.setStyleName("mois");
		mois.setEmptyText("Janvier");
		mois.add("Janvier");
		mois.add("Fevrier");
		mois.add("Mars");
		mois.add("Avril");
		mois.add("Mai");
		mois.add("Juin");
		mois.add("Juillet");
		mois.add("Aout");
		mois.add("Septembre");
		mois.add("Octobre");
		mois.add("Novembre");
		mois.add("Decembre");
		
		annee = new SimpleComboBox<String>(new StringLabelProvider<String>());
		annee.setEmptyText("annee");
		annee.add("2015");
		annee.add("2016");
		annee.add("2017");
		annee.add("2018");
		annee.add("2019");
		annee.add("2020");
		annee.add("2021");
		annee.add("2022");
		annee.add("2023");
		annee.add("2024");
		annee.add("2025");		
		annee.add("2026");
		annee.add("2027");
		annee.add("2028");
		annee.add("2029");
		annee.add("2030");
		annee.add("2031");
		annee.add("2032");
		annee.add("2033");
		annee.add("2034");
		annee.add("2035");
		annee.add("2036");		
		annee.add("2037");
		annee.add("2038");
		annee.add("2039");
		annee.add("2040");
		annee.add("2041");
		annee.add("2042");
		annee.add("2043");
		annee.add("2044");
		annee.add("2045");
		annee.add("2046");
		annee.add("2047");
		annee.add("2048");
		annee.add("2049");
		annee.add("2050");
		
		
//
//		// mois.addKeyPressHandler(new KeyPressHandler(){
//		//
//		// @Override
//		// public void onKeyPress(KeyPressEvent event) {
//		// // TODO Auto-generated method stub
//		// mois.clear();
//		// mois.add("Janvier");
//		// mois.add("Fevrier");
//		// }});
//		// Ajout d'ecouteur
//		salaire.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					salaire.setText("");
//				}
//			}
//		});
//
//		totLundi.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					totLundi.setText("");
//				}
//			}
//		});
//
//		totMardi.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					totMardi.setText("");
//				}
//			}
//		});
//
//		totMercredi.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					totMercredi.setText("");
//				}
//			}
//		});
//
//		totJeudi.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					totJeudi.setText("");
//				}
//			}
//		});
//
//		totVendredi.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					totVendredi.setText("");
//				}
//			}
//		});
//
//		totSamedi.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					totSamedi.setText("");
//				}
//			}
//		});
//
//		totDimanche.addKeyboardListener(new KeyboardListener() {
//
//			@Override
//			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
//				// TODO Auto-generated method stub
//				if (FieldVerifier.isNumberCar(salaire.getText())) {
//					salaire.setText("");
//				}
//			}
//		});
//
//		salaire.addKeyUpHandler(new KeyUpHandler() {
//
//			@Override
//			public void onKeyUp(KeyUpEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//

		bExport.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				float salaireDefinitif = 0;
				float ae = Float.valueOf(salaire.getText()) / 3;
				float tier = Float.valueOf(salaire.getText()) / 3;

				// System.out.println("tier================================"+tier);
				float taux = tauxHoraire(salaire.getText());
				int totalHSemaine = FieldVerifier.isVide(totLundi.getText())
						+ FieldVerifier.isVide(totMardi.getText())
						+ FieldVerifier.isVide(totMercredi.getText())
						+ FieldVerifier.isVide(totJeudi.getText())
						+ FieldVerifier.isVide(totVendredi.getText());

				int totalHWeekend = FieldVerifier.isVide(totDimanche.getText())
						+ FieldVerifier.isVide(totSamedi.getText());

				float salaireSemaine = (float) (1.5 * taux * totalHSemaine);
				float salaireWeekend = (float) (2 * taux * totalHWeekend);
				float salaireConges = (float) (2 * taux * FieldVerifier.isVide(conges.getText()));
				float salaireToPay = salaireSemaine + salaireWeekend+salaireConges;

				if (tier < salaireToPay) {
					salaireDefinitif = tier;
				} else {
					salaireDefinitif = salaireToPay;
				}

				Employes employe = new Employes();
				employe.setNom(nom.getText());
				employe.setPrenom(prenom.getText());
				employe.setSalaire(salaire.getText());
				employe.setFonction(tFonction.getText());
				employe.setHoraireRegulier(tHoraireRegulier.getText());
				employe.setDirection(tDirection.getText());
				employe.setService(tService.getText());
				employe.setLundi(totLundi.getText());
				employe.setMardi(totMardi.getText());
				employe.setMercredi(totMercredi.getText());
				employe.setJeudi(totJeudi.getText());
				employe.setVendredi(totVendredi.getText());
				employe.setSamedi(totSamedi.getText());
				employe.setDimanche(totDimanche.getText());
				String salaire = nombreChiffreApresVirgule(String
						.valueOf(salaireDefinitif));
				employe.setValeurAPayer(salaire);
				employe.setTotalHeuresS(String.valueOf(totalHSemaine));
				employe.setTotalHeureW(String.valueOf(totalHWeekend));
				employe.setTotalHeures(String
						.valueOf((totalHSemaine + totalHWeekend+FieldVerifier.isVide(conges.getText()))));
				employe.setRaison(tRaison.getText());
				employe.setMois(mois.getText());
				employe.setConge(conges.getText());
				employe.setAnnee(annee.getText());
				String url = "images/background.png";
				System.out
						.println("======================================         Login.typeUser");
				
				
				pdfService.generatePdf(employe, new AsyncCallback<String>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						
						Frame frame = new Frame();
						
						if (Login.typeUser.equals("Super Utilisateur")) {
							frame.setUrl(GWT.getModuleBaseURL()
									+ "report?reportName=SupplementaireRaport");
							frame.setHeight("620px");
							frame.setWidth("700px");
							FenetreAdmin.conteneurPDFAdmin.clear();
							FenetreAdmin.conteneurPDFAdmin.add(frame);
						} else {
//							FenetrePrincipale.conteneurPDF.clear();
							frame.setUrl(GWT.getModuleBaseURL()
									+ "report?reportName=SupplementaireRaport");
							frame.setHeight("490px");
							frame.setWidth("700px");
							FenetreAdmin.conteneurPDFAdmin.clear();
							FenetreAdmin.conteneurPDFAdmin.add(frame);
						}
					}});
			}});
		
		
		
		
		
		
//				
////				pdfService.imageToByte(new AsyncCallback<Void>(){
////
////					@Override
////					public void onFailure(Throwable caught) {
////						// TODO Auto-generated method stub
////						Window.alert(caught.getMessage());
////					}
////
////					@Override
////					public void onSuccess(Void result) {
////						// TODO Auto-generated method stub
////						Window.alert("Ou lala");
////					}});
//
//			}
//		});
//
		enregistrer.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				// FenetrePrincipale.conteneurPDF.clear();

				compteurService.numberSave(new AsyncCallback<List<Employes>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(List<Employes> result) {
						// TODO Auto-generated method stub

						ArrayList list = new ArrayList();
						int code = 0;

						for (Employes employe : result) {
							list.add(employe.getCode());
						}

						if (list.size() != 0) {
							code = list.size() + 1;
						} else {
							code = 1;
						}

						float salaireDefinitif = 0;
						float tier = FieldVerifier.isVide(salaire.getText()) / 3;
						float taux = tauxHoraire(salaire.getText());
						int totalHSemaine = FieldVerifier.isVide(totLundi
								.getText())
								+ FieldVerifier.isVide(totMardi.getText())
								+ FieldVerifier.isVide(totMercredi.getText())
								+ FieldVerifier.isVide(totJeudi.getText())
								+ FieldVerifier.isVide(totVendredi.getText());

						int totalHWeekend = FieldVerifier.isVide(totDimanche
								.getText())
								+ FieldVerifier.isVide(totSamedi.getText());

						float salaireSemaine = (float) (1.5 * taux * totalHSemaine);
						float salaireWeekend = (float) (2 * taux * totalHWeekend);
						float salaireConges = (float) (2 * taux * FieldVerifier.isVide(conges.getText()));
						float salaireToPay = salaireSemaine + salaireWeekend+salaireConges;

						if (tier < salaireToPay) {
							salaireDefinitif = tier;
						} else {
							salaireDefinitif = salaireToPay;
						}

						Employes employe = new Employes();
						employe.setCode(String.valueOf(code));
						employe.setNom(nom.getText());
						employe.setPrenom(prenom.getText());
						employe.setSalaire(salaire.getText());
						employe.setFonction(tFonction.getText());
						employe.setHoraireRegulier(tHoraireRegulier.getText());
						employe.setDirection(tDirection.getText());
						employe.setService(tService.getText());
						employe.setLundi(totLundi.getText());
						employe.setMardi(totMardi.getText());
						employe.setMercredi(totMercredi.getText());
						employe.setJeudi(totJeudi.getText());
						employe.setVendredi(totVendredi.getText());
						employe.setSamedi(totSamedi.getText());
						employe.setDimanche(totDimanche.getText());
						employe.setConge(conges.getText());
						employe.setValeurAPayer(String
								.valueOf(salaireDefinitif));
						employe.setTotalHeures(String.valueOf(totalHSemaine));
						employe.setTotalHeureW(String.valueOf(totalHWeekend));
						employe.setTotalHeures(String
								.valueOf((totalHSemaine + totalHWeekend+FieldVerifier.isVide(conges.getText()))));
						employe.setRaison(tRaison.getText());
						employe.setMois(mois.getText());
						employe.setCreerPar(Login.log);
						employe.setCreerLe(FieldVerifier
								.formateDate(new Date()));
						employe.setModifierPar("");
						employe.setModifierLe("");
						employe.setAnnee(annee.getText());
						
						enregistrerService.enregistrer(employe,
								new AsyncCallback<String>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onSuccess(String result) {
										// TODO Auto-generated method stub

										if (result != null) {
											if (Login.typeUser
													.equals("Super Utilisateur")) {
												// Label message2=new Label();
												// message2.setText("");
												message.setText(result);
												// message2.setText("Enregistrement reussi");
												// FenetreAdmin.conteneurPDFAdmin.clear();
												// FenetreAdmin.conteneurPDFAdmin.add(message);
											} else {
												// FenetrePrincipale.conteneurPDF.clear();
												// panelMessage.clear();
												// Label message2=new Label();
												// message2.setText("");
												message.setText(result);
												// message2.setText("Enregistrement reussi");
												// panelMessage.add(message2);
												// panelMessage.add(message);
												// FenetrePrincipale.conteneurPDF
												// .add(panelMessage);
											}
										} else {
											panelMessage.add(new Label(
													"Echec d'enregistrement"));
											FenetrePrincipale.conteneurPDF
													.add(panelMessage);
										}

									}
								});

					}
				});

			}
		});
//
		bRecherche.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out
						.println("=======================================================");
				message.setText("");
				list.clear();
				rechercheService.rechercher(recherche.getValue(),
						new AsyncCallback<Employes>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onSuccess(Employes result) {
								// TODO Auto-generated method stub
								if (result != null) {
									// System.out.println("5444444444444444444444444444444444444444444444444446 ");
									list.add(result.getCode());
									list.add(result.getNom());
									list.add(result.getPrenom());
									list.add(result.getSalaire());
									list.add(result.getFonction());
									list.add(result.getHoraireRegulier());
									list.add(result.getLundi());
									list.add(result.getMardi());
									list.add(result.getMercredi());
									list.add(result.getJeudi());
									list.add(result.getVendredi());
									list.add(result.getSamedi());
									list.add(result.getDimanche());
									list.add(result.getValeurAPayer());
									list.add("0");
									list.add(result.getTotalHeureW());
									list.add(result.getTotalHeures());
									list.add(result.getRaison());
									list.add(result.getMois());
									list.add(result.getDirection());
									list.add(result.getService());
									list.add(result.getCreerPar());
									list.add(result.getCreerLe());
									list.add(null);
									list.add(null);
									list.add(result.getConge());
									list.add(result.getAnnee());
									nom.setText(result.getNom());
									prenom.setText(result.getPrenom());
									salaire.setText(result.getSalaire());
									tFonction.setText(result.getFonction());
									tHoraireRegulier.setText(result
											.getHoraireRegulier());
									tDirection.setText(result.getDirection());
									tService.setText(result.getService());
									tRaison.setText(result.getRaison());
									mois.setText(result.getMois());
									totLundi.setText(result.getLundi());
									totMardi.setText(result.getMardi());
									totMercredi.setText(result.getMercredi());
									totJeudi.setText(result.getJeudi());
									totVendredi.setText(result.getVendredi());
									totSamedi.setText(result.getSamedi());
									totDimanche.setText(result.getDimanche());
									tEnregistrerPar.setText(result
											.getCreerPar());
									tEnregitrerLe.setText(result.getCreerLe());
									tModifierPar.setText(result
											.getModifierPar());
									tModifierLe.setText(result.getModifierLe());
									conges.setText(result.getConge());
									annee.setText(result.getAnnee());
									if (Login.typeUser
											.equals("Super Utilisateur")) {
										audit.setVisible(true);
									}else{
										audit.setVisible(false);
									}

									// Recherche au niveau de la table Employe
									// Archive

									rechercheServiceArchive.rechercherArchive(
											recherche.getText(),
											mois.getText(),annee.getText(),
											new AsyncCallback<Archiveemployes>() {

												@Override
												public void onFailure(
														Throwable caught) {
													// TODO Auto-generated
													// method stub

												}

												@Override
												public void onSuccess(
														Archiveemployes result) {
													// TODO Auto-generated
													// method stub
													if (result != null) {
														System.out
																.println("Il est deja la");
														Archiveemployes archive = new Archiveemployes();
														archive.setArchiveemployesPK(new ArchiveemployesPK(
																recherche
																		.getText(),
																mois.getText(),annee.getText()));
														System.out.println("Le nom est: "+list
																.get(1)
																.toString());
														archive.setNom(list
																.get(1)
																.toString());

														archive.setPrenom(list
																.get(2)
																.toString());
														Date date = new Date();

														archive.setSalaire(list
																.get(3)
																.toString());
														archive.setFonction(list
																.get(4)
																.toString());
														archive.setHoraireRegulier(list
																.get(5)
																.toString());
														archive.setLundi(list
																.get(6)
																.toString());
														archive.setMardi(list
																.get(7)
																.toString());
														archive.setMercredi(list
																.get(8)
																.toString());
														archive.setJeudi(list
																.get(9)
																.toString());
														archive.setVendredi(list
																.get(10)
																.toString());
														archive.setSamedi(list
																.get(11)
																.toString());
														archive.setDimanche(list
																.get(12)
																.toString());
														archive.setValeurAPayer(list
																.get(13)
																.toString());

														archive.setTotalHeuresS(list
																.get(14)
																.toString());

//														System.out
//																.println("Ce code n'est pas dans la table archive   :"
//																		+ list.get(
//																				0)
//																				.toString()
//																		+ "          :"
//																		+ list.size());
														archive.setTotalHeureW(list
																.get(15)
																.toString());
														archive.setTotalHeures(list
																.get(16)
																.toString());
														archive.setRaison(list
																.get(17)
																.toString());

														archive.setDirection(list
																.get(19)
																.toString());
														archive.setService(list
																.get(20)
																.toString());
														archive.setCreerPar(list
																.get(21)
																.toString());
														archive.setCreerLe(list
																.get(22)
																.toString());
														archive.setModifierPar(Login.log);
														archive.setModifierLe(FieldVerifier
																.formateDate(new Date()));
														archive.setConge(list.get(25).toString());
														//archive.setAnnee(list.get(26).toString());
														//System.out.println("lalalalalalalqaa========");
														modifierServiceA.modifier(archive, new AsyncCallback<String>(){

															@Override
															public void onFailure(
																	Throwable caught) {
																// TODO Auto-generated method stub
																
															}

															@Override
															public void onSuccess(
																	String result) {
																// TODO Auto-generated method stub
																System.out.println("lalalalalalalqaa========"+result);
															}});
													} else {

														Archiveemployes archive = new Archiveemployes();

														archive.setArchiveemployesPK(new ArchiveemployesPK(
																recherche
																		.getText(),
																mois.getText(),annee.getText()));
														
														archive.setNom(list
																.get(1)
																.toString());
														System.out.println("Le nom2 est : "+list
																.get(1)
																.toString());
														archive.setPrenom(list
																.get(2)
																.toString());
														Date date = new Date();

														archive.setSalaire(list
																.get(3)
																.toString());
														archive.setFonction(list
																.get(4)
																.toString());
														archive.setHoraireRegulier(list
																.get(5)
																.toString());
														archive.setLundi(list
																.get(6)
																.toString());
														archive.setMardi(list
																.get(7)
																.toString());
														archive.setMercredi(list
																.get(8)
																.toString());
														archive.setJeudi(list
																.get(9)
																.toString());
														archive.setVendredi(list
																.get(10)
																.toString());
														archive.setSamedi(list
																.get(11)
																.toString());
														archive.setDimanche(list
																.get(12)
																.toString());
														archive.setValeurAPayer(list
																.get(13)
																.toString());

														archive.setTotalHeuresS(list
																.get(14)
																.toString());

														System.out
																.println("Ce code n'est pas dans la table archive   :"
																		+ list.get(
																				0)
																				.toString()
																		+ "          :"
																		+ list.size());
														archive.setTotalHeureW(list
																.get(15)
																.toString());
														archive.setTotalHeures(list
																.get(16)
																.toString());
														archive.setRaison(list
																.get(17)
																.toString());

														archive.setDirection(list
																.get(19)
																.toString());
														archive.setService(list
																.get(20)
																.toString());
														archive.setCreerPar(Login.log);
														archive.setCreerLe(FieldVerifier
																.formateDate(new Date()));
														archive.setModifierPar("");
														archive.setModifierLe("");
														archive.setConge(list.get(25).toString());
														//archive.setAnnee(list.get(26).toString());
														System.out.println("valeur========="+list.get(26).toString());
														enregistrerServiceArchive
																.enregistrerArchive(
																		archive,
																		new AsyncCallback<String>() {

																			@Override
																			public void onFailure(
																					Throwable caught) {
																				// TODO
																				// Auto-generated
																				// method
																				// stub

																			}

																			@Override
																			public void onSuccess(
																					String result) {
																				// TODO
																				// Auto-generated
																				// method
																				// stub
																				System.out
																						.println(result);
																			}
																		});
														// System.out.println("Ce code n'est pas dans la table archive");
													}
												}
											});

								} else {
									Window.alert("Ce code n'existe pas");
								}
							}
						});
			}
		});

		modifier.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Employes employe = new Employes();
				employe.setCode(recherche.getText());
				employe.setNom(nom.getText());
				employe.setPrenom(prenom.getText());
				employe.setSalaire(salaire.getText());
				employe.setFonction(tFonction.getText());
				employe.setHoraireRegulier(tHoraireRegulier.getText());
				employe.setDirection(tDirection.getText());
				employe.setService(tService.getText());
				employe.setLundi(totLundi.getText());
				employe.setMardi(totMardi.getText());
				employe.setMercredi(totMercredi.getText());
				employe.setJeudi(totJeudi.getText());
				employe.setVendredi(totVendredi.getText());
				employe.setSamedi(totSamedi.getText());
				employe.setDimanche(totDimanche.getText());
				employe.setRaison(tRaison.getText());
				employe.setMois(mois.getText());
				employe.setModifierPar(Login.log);
				employe.setModifierLe(FieldVerifier.formateDate(new Date()));
				employe.setConge(conges.getText());
				employe.setAnnee(annee.getText());
				modifierService.modifier(employe, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (Login.typeUser.equals("Super Utilisateur")) {
							// panelMessage.clear();
							// panelMessage.add(new Label(result));
							// FenetreAdmin.conteneurPDFAdmin.clear();
							// FenetreAdmin.conteneurPDFAdmin.add(panelMessage);

							Archiveemployes archive = new Archiveemployes();
							archive.setArchiveemployesPK(new ArchiveemployesPK(
									recherche.getText(), mois.getText(),annee.getText()));
							archive.setNom(nom.getText());
							archive.setPrenom(prenom.getText());
							archive.setSalaire(salaire.getText());
							archive.setFonction(tFonction.getText());
							archive.setHoraireRegulier(tHoraireRegulier
									.getText());
							archive.setDirection(tDirection.getText());
							archive.setService(tService.getText());
							archive.setLundi(totLundi.getText());
							archive.setMardi(totMardi.getText());
							archive.setMercredi(totMercredi.getText());
							archive.setJeudi(totJeudi.getText());
							archive.setVendredi(totVendredi.getText());
							archive.setSamedi(totSamedi.getText());
							archive.setDimanche(totDimanche.getText());
							archive.setRaison(tRaison.getText());
							archive.setModifierPar(Login.log);
							archive.setModifierLe(FieldVerifier
									.formateDate(new Date()));
							archive.setConge(conges.getText());
							//archive.setAnnee(annee.getText());
//							modifierServiceA.modifier(archive,
//									new AsyncCallback<String>() {
//
//										@Override
//										public void onFailure(Throwable caught) {
//											// TODO Auto-generated method stub
//
//										}
//
//										@Override
//										public void onSuccess(String result) {
//											// TODO Auto-generated method stub
//
//											message.setText(result);
//
//										}
//									});

							message.setText(result);
						} else {
							// FenetrePrincipale.conteneurPDF.clear();
							// panelMessage.clear();
							// panelMessage.add(new Label(result));
							// FenetrePrincipale.conteneurPDF.add(panelMessage);

							Archiveemployes archive = new Archiveemployes();
							archive.setArchiveemployesPK(new ArchiveemployesPK(
									recherche.getText(), mois.getText(),annee.getText()));
							archive.setNom(nom.getText());
							archive.setPrenom(prenom.getText());
							archive.setSalaire(salaire.getText());
							archive.setFonction(tFonction.getText());
							archive.setHoraireRegulier(tHoraireRegulier
									.getText());
							archive.setDirection(tDirection.getText());
							archive.setService(tService.getText());
							archive.setLundi(totLundi.getText());
							archive.setMardi(totMardi.getText());
							archive.setMercredi(totMercredi.getText());
							archive.setJeudi(totJeudi.getText());
							archive.setVendredi(totVendredi.getText());
							archive.setSamedi(totSamedi.getText());
							archive.setDimanche(totDimanche.getText());
							archive.setRaison(tRaison.getText());
							archive.setModifierPar(Login.log);
							archive.setModifierLe(FieldVerifier
									.formateDate(new Date()));
							archive.setConge(conges.getText());
							//archive.setAnnee(annee.getText());
//							modifierServiceA.modifier(archive,
//									new AsyncCallback<String>() {
//
//										@Override
//										public void onFailure(Throwable caught) {
//											// TODO Auto-generated method stub
//
//										}
//
//										@Override
//										public void onSuccess(String result) {
//											// TODO Auto-generated method stub
//
//											message.setText(result);
//
//										}
//									});
							message.setText(result);
						}
					}
				});
			}
		});
//
//		lister.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
////				listerService.lister(new AsyncCallback<List<Employes>>() {
////
////					@Override
////					public void onFailure(Throwable caught) {
////						// TODO Auto-generated method stub
////
////					}
////
////					@Override
////					public void onSuccess(List<Employes> result) {
////						// TODO Auto-generated method stub
////						if (result != null) {
////							List liste = new ArrayList();
////							String[] entete = { "Nom", "Prenom" };
////							// liste.add("Eugene");
////							// liste.add("Pierre");
////							Grid grid = new Grid(result.size(), 2);
////							grid.setBorderWidth(3);
////							grid.setCellPadding(3);
////							grid.setText(0, 0, entete[0]);
////							grid.setText(0, 1, entete[1]);
////							// for(int i=0; i<liste.size(); i++){
////							// for(int column=0; column<2; column++){
////							// grid.setText(i, column, (String) liste.get(i));
////							// }
////							// }
////							for (Employes employe : result) {
////								for (int row = 1; row < result.size(); row++) {
////
////									grid.setText(row, 0, result.get(row)
////											.getCode());
////									grid.setText(row, 1, result.get(row)
////											.getNom());
////
////									// grid.setText(row, 1, employe.getNom());
////
////								}
////								System.out.println("Code===============:"
////										+ employe.getCode());
////								System.out.println("Nom============:"
////										+ employe.getNom());
////							}
////							FenetreAdmin.conteneurPDFAdmin.clear();
////							FenetreAdmin.conteneurPDFAdmin.add(grid);
////						} else {
////							Window.alert("Null");
////						}
////					}
////				});
//				
//			}
//		});
//
//		box.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				if (box.isChecked()) {
//					audit.setVisible(false);
//				}
//			}
//		});
//
		recherche.addKeyDownHandler(new KeyDownHandler(){

			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					System.out
					.println("=======================================================");
			message.setText("");
			list.clear();
			rechercheService.rechercher(recherche.getValue(),
					new AsyncCallback<Employes>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onSuccess(Employes result) {
							// TODO Auto-generated method stub
							if (result != null) {
								// System.out.println("5444444444444444444444444444444444444444444444444446 ");
								list.add(result.getCode());
								list.add(result.getNom());
								list.add(result.getPrenom());
								list.add(result.getSalaire());
								list.add(result.getFonction());
								list.add(result.getHoraireRegulier());
								list.add(result.getLundi());
								list.add(result.getMardi());
								list.add(result.getMercredi());
								list.add(result.getJeudi());
								list.add(result.getVendredi());
								list.add(result.getSamedi());
								list.add(result.getDimanche());
								list.add(result.getValeurAPayer());
								list.add("0");
								list.add(result.getTotalHeureW());
								list.add(result.getTotalHeures());
								list.add(result.getRaison());
								list.add(result.getMois());
								list.add(result.getDirection());
								list.add(result.getService());
								list.add(result.getCreerPar());
								list.add(result.getCreerLe());
								list.add(null);
								list.add(null);
								list.add(result.getConge());
								list.add(result.getAnnee());
								nom.setText(result.getNom());
								prenom.setText(result.getPrenom());
								salaire.setText(result.getSalaire());
								tFonction.setText(result.getFonction());
								tHoraireRegulier.setText(result
										.getHoraireRegulier());
								tDirection.setText(result.getDirection());
								tService.setText(result.getService());
								tRaison.setText(result.getRaison());
								mois.setText(result.getMois());
								totLundi.setText(result.getLundi());
								totMardi.setText(result.getMardi());
								totMercredi.setText(result.getMercredi());
								totJeudi.setText(result.getJeudi());
								totVendredi.setText(result.getVendredi());
								totSamedi.setText(result.getSamedi());
								totDimanche.setText(result.getDimanche());
								tEnregistrerPar.setText(result
										.getCreerPar());
								tEnregitrerLe.setText(result.getCreerLe());
								tModifierPar.setText(result
										.getModifierPar());
								tModifierLe.setText(result.getModifierLe());
								conges.setText(result.getConge());
								annee.setText(result.getAnnee());
								if (Login.typeUser
										.equals("Super Utilisateur")) {
									audit.setVisible(true);
								}else{
									audit.setVisible(false);
								}

								// Recherche au niveau de la table Employe
								// Archive

								rechercheServiceArchive.rechercherArchive(
										recherche.getText(),
										mois.getText(),annee.getText(),
										new AsyncCallback<Archiveemployes>() {

											@Override
											public void onFailure(
													Throwable caught) {
												// TODO Auto-generated
												// method stub

											}

											@Override
											public void onSuccess(
													Archiveemployes result) {
												// TODO Auto-generated
												// method stub
												if (result != null) {
													System.out
															.println("Il est deja la");
													Archiveemployes archive = new Archiveemployes();
													archive.setArchiveemployesPK(new ArchiveemployesPK(
															recherche
																	.getText(),
															mois.getText(),annee.getText()));
													System.out.println("Le nom est: "+list
															.get(1)
															.toString());
													archive.setNom(list
															.get(1)
															.toString());

													archive.setPrenom(list
															.get(2)
															.toString());
													Date date = new Date();

													archive.setSalaire(list
															.get(3)
															.toString());
													archive.setFonction(list
															.get(4)
															.toString());
													archive.setHoraireRegulier(list
															.get(5)
															.toString());
													archive.setLundi(list
															.get(6)
															.toString());
													archive.setMardi(list
															.get(7)
															.toString());
													archive.setMercredi(list
															.get(8)
															.toString());
													archive.setJeudi(list
															.get(9)
															.toString());
													archive.setVendredi(list
															.get(10)
															.toString());
													archive.setSamedi(list
															.get(11)
															.toString());
													archive.setDimanche(list
															.get(12)
															.toString());
													archive.setValeurAPayer(list
															.get(13)
															.toString());

													archive.setTotalHeuresS(list
															.get(14)
															.toString());

//													System.out
//															.println("Ce code n'est pas dans la table archive   :"
//																	+ list.get(
//																			0)
//																			.toString()
//																	+ "          :"
//																	+ list.size());
													archive.setTotalHeureW(list
															.get(15)
															.toString());
													archive.setTotalHeures(list
															.get(16)
															.toString());
													archive.setRaison(list
															.get(17)
															.toString());

													archive.setDirection(list
															.get(19)
															.toString());
													archive.setService(list
															.get(20)
															.toString());
													archive.setCreerPar(list
															.get(21)
															.toString());
													archive.setCreerLe(list
															.get(22)
															.toString());
													archive.setModifierPar(Login.log);
													archive.setModifierLe(FieldVerifier
															.formateDate(new Date()));
													archive.setConge(list.get(25).toString());
													//archive.setAnnee(list.get(26).toString());
													//System.out.println("lalalalalalalqaa========");
													modifierServiceA.modifier(archive, new AsyncCallback<String>(){

														@Override
														public void onFailure(
																Throwable caught) {
															// TODO Auto-generated method stub
															
														}

														@Override
														public void onSuccess(
																String result) {
															// TODO Auto-generated method stub
															System.out.println("lalalalalalalqaa========"+result);
														}});
												} else {

													Archiveemployes archive = new Archiveemployes();

													archive.setArchiveemployesPK(new ArchiveemployesPK(
															recherche
																	.getText(),
															mois.getText(),annee.getText()));
													
													archive.setNom(list
															.get(1)
															.toString());
													System.out.println("Le nom2 est : "+list
															.get(1)
															.toString());
													archive.setPrenom(list
															.get(2)
															.toString());
													Date date = new Date();

													archive.setSalaire(list
															.get(3)
															.toString());
													archive.setFonction(list
															.get(4)
															.toString());
													archive.setHoraireRegulier(list
															.get(5)
															.toString());
													archive.setLundi(list
															.get(6)
															.toString());
													archive.setMardi(list
															.get(7)
															.toString());
													archive.setMercredi(list
															.get(8)
															.toString());
													archive.setJeudi(list
															.get(9)
															.toString());
													archive.setVendredi(list
															.get(10)
															.toString());
													archive.setSamedi(list
															.get(11)
															.toString());
													archive.setDimanche(list
															.get(12)
															.toString());
													archive.setValeurAPayer(list
															.get(13)
															.toString());

													archive.setTotalHeuresS(list
															.get(14)
															.toString());

													System.out
															.println("Ce code n'est pas dans la table archive   :"
																	+ list.get(
																			0)
																			.toString()
																	+ "          :"
																	+ list.size());
													archive.setTotalHeureW(list
															.get(15)
															.toString());
													archive.setTotalHeures(list
															.get(16)
															.toString());
													archive.setRaison(list
															.get(17)
															.toString());

													archive.setDirection(list
															.get(19)
															.toString());
													archive.setService(list
															.get(20)
															.toString());
													archive.setCreerPar(Login.log);
													archive.setCreerLe(FieldVerifier
															.formateDate(new Date()));
													archive.setModifierPar("");
													archive.setModifierLe("");
													archive.setConge(list.get(25).toString());
													//archive.setAnnee(list.get(26).toString());
													System.out.println("valeur========="+list.get(26).toString());
													enregistrerServiceArchive
															.enregistrerArchive(
																	archive,
																	new AsyncCallback<String>() {

																		@Override
																		public void onFailure(
																				Throwable caught) {
																			// TODO
																			// Auto-generated
																			// method
																			// stub

																		}

																		@Override
																		public void onSuccess(
																				String result) {
																			// TODO
																			// Auto-generated
																			// method
																			// stub
																			System.out
																					.println(result);
																		}
																	});
													// System.out.println("Ce code n'est pas dans la table archive");
												}
											}
										});

							} else {
								Window.alert("Ce code n'existe pas");
							}
						}
					});
				}
			}});
//		cLister.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
////				if (cLister.isChecked()) {
////					listerService.lister(new AsyncCallback<List<Employes>>() {
////
////						@Override
////						public void onFailure(Throwable caught) {
////							// TODO Auto-generated method stub
////
////						}
////
////						@Override
////						public void onSuccess(List<Employes> result) {
////							// TODO Auto-generated method stub
////							if (result != null) {
////								List liste = new ArrayList();
////								String[] entete = { "CODE", "NOM", "PRENOM",
////										"SALAIRE", "FONCTION",
////										"HORAIRE REGULIER", "CREER PAR",
////										"DATE CREATION", "MODIFIER PAR",
////										"DATE MODIFICATION" };
////								// liste.add("Eugene");
////								// liste.add("Pierre");
////								Grid grid = new Grid(result.size() + 1,
////										entete.length);
////								grid.setBorderWidth(2);
////								grid.setCellPadding(5);
////								grid.setStyleName("grilleForm");
////
////								// grid.setText(0, 0, entete[0]);
////								// grid.setText(0, 1, entete[1]);
////								// for(int i=0; i<liste.size(); i++){
////								// for(int column=0; column<2; column++){
////								// grid.setText(i, column, (String)
////								// liste.get(i));
////								// }
////								// }
////								for (Employes employe : result) {
////									for (int row = 1; row <= result.size(); row++) {
////
////										grid.setText(0, 0, entete[0]);
////										grid.setText(0, 1, entete[1]);
////										grid.setText(0, 2, entete[2]);
////										grid.setText(0, 3, entete[3]);
////										grid.setText(0, 4, entete[4]);
////										grid.setText(0, 5, entete[5]);
////										grid.setText(0, 6, entete[6]);
////										grid.setText(0, 7, entete[7]);
////										grid.setText(0, 8, entete[8]);
////										grid.setText(0, 9, entete[9]);
////
////										grid.setText(row, 0, result
////												.get(row - 1).getCode());
////										grid.setText(row, 1, result
////												.get(row - 1).getNom());
////										grid.setText(row, 2, result
////												.get(row - 1).getPrenom());
////
////										grid.setText(row, 3, result
////												.get(row - 1).getSalaire());
////										grid.setText(row, 4, result
////												.get(row - 1).getFonction());
////										grid.setText(row, 5, result
////												.get(row - 1)
////												.getHoraireRegulier());
////
////										grid.setText(row, 6, result
////												.get(row - 1).getCreerPar());
////										grid.setText(row, 7, result
////												.get(row - 1).getCreerLe());
////										grid.setText(row, 8, result
////												.get(row - 1).getModifierPar());
////										grid.setText(row, 9, result
////												.get(row - 1).getModifierLe());
////									}
////
////									// grid.setText(row, 1,
////									// employe.getNom());
////
////									System.out.println("Code===============:"
////											+ employe.getCode());
////									System.out.println("Nom============:"
////											+ employe.getNom());
////								}
////								FenetreAdmin.conteneurPDFAdmin.clear();
////								FenetreAdmin.conteneurPDFAdmin.add(grid);
////							} else {
////								Window.alert("Null");
////							}
////						}
////					});
////				} else {
////					FenetreAdmin.conteneurPDFAdmin.clear();
////				}
//				
////				try{
////					imageToByte();
////					}
////					catch(Exception ex){}
//			}
//		});
//
//		// Ajout du style
////		teteForm.setStyleName("teteForm");
////		deuxiemeForm.setStyleName("deuxiemeForm");
////		audit.setStyleName("teteForm");
////		lNom.setStyleName("labelForm");
////		lPrenom.setStyleName("labelForm");
////		lSalaire.setStyleName("labelForm");
////		lFonction.setStyleName("labelForm");
////		lHoraireRegulier.setStyleName("labelForm");
////		lRaison.setStyleName("labelForm");
////		direction.setStyleName("labelForm");
////		service.setStyleName("labelForm");
////		nbrH.setStyleName("labelForm2");
////		date.setStyleName("labelForm2");
////
////		panelMessage.setStyleName("panelMessage");
////		panelRecherche.setStyleName("panelRecherche");
////
////		table.setStyleName("tableForm");
////		table2.setStyleName("table2Form");
////		table3.setStyleName("table3Form");
////		nom.setStyleName("textForm");
////		prenom.setStyleName("textForm");
////		salaire.setStyleName("textForm");
////		tFonction.setStyleName("textForm");
////		tHoraireRegulier.setStyleName("textForm");
////		tDirection.setStyleName("textForm");
////		tService.setStyleName("textForm");
////		totLundi.setStyleName("textForm2");
////		totMardi.setStyleName("textForm2");
////		totMercredi.setStyleName("textForm2");
////		totJeudi.setStyleName("textForm2");
////		totVendredi.setStyleName("textForm2");
////		totSamedi.setStyleName("textForm2");
////		totDimanche.setStyleName("textForm2");
////		conges.setStyleName("textForm2");
////		bExport.setStyleName("bExport");
////		enregistrer.setStyleName("bExport");
////		modifier.setStyleName("bExport");
////		lister.setStyleName("bExport");
////		bRecherche.setStyleName("bRecherche");
////		lundi.setStyleName("jour");
////		mardi.setStyleName("jour");
////		mercredi.setStyleName("jour");
////		jeudi.setStyleName("jour");
////		vendredi.setStyleName("jour");
////		samedi.setStyleName("jour");
////		dimanche.setStyleName("jour");
//		
//
		// Ajout des elements

		hPanelBouton.add(bExport);
		hPanelBouton.add(enregistrer);
		hPanelBouton.add(modifier);
//		hPanelBouton.add(cLister);
//		hPanelBouton.add(liste);
		// hPanelBouton.add(lister);
		
		

		table.setWidget(0, 0, lNom);
		table.setWidget(0, 1, nom);
		table.setWidget(1, 0, lPrenom);
		table.setWidget(1, 1, prenom);
		table.setWidget(2, 0, lSalaire);
		table.setWidget(2, 1, salaire);
		table.setWidget(3, 0, lFonction);
		table.setWidget(3, 1, tFonction);
		table.setWidget(4, 0, lHoraireRegulier);
		table.setWidget(4, 1, tHoraireRegulier);
		table.setWidget(5, 0, direction);
		table.setWidget(5, 1, tDirection);
		table.setWidget(6, 0, service);
		table.setWidget(6, 1, tService);
		table.setWidget(7, 0, lRaison);
		table.setWidget(7, 1, tRaison);
		
		FlexTable tableDate=new FlexTable();
		tableDate.setWidget(0, 0, lMois);
		tableDate.setWidget(0, 1, mois);
		tableDate.setWidget(0, 2, annee);
		lMois.setStyleName("dateComplete");
		annee.setStyleName("dateComplete1");
		mois.setWidth("100px");
		annee.setWidth("80px");
		

//		table2.setWidget(0, 0, date);
		table2.setWidget(0, 1, nbrH);
		sPTable2.add(table2);

		table3.setWidget(0, 0, lundi);
		table3.setWidget(0, 1, totLundi);
		table3.setWidget(1, 0, mardi);
		table3.setWidget(1, 1, totMardi);
		table3.setWidget(2, 0, mercredi);
		table3.setWidget(2, 1, totMercredi);
		table3.setWidget(3, 0, jeudi);
		table3.setWidget(3, 1, totJeudi);
		table3.setWidget(4, 0, vendredi);
		table3.setWidget(4, 1, totVendredi);
		table3.setWidget(5, 0, samedi);
		table3.setWidget(5, 1, totSamedi);
		table3.setWidget(6, 0, dimanche);
		table3.setWidget(6, 1, totDimanche);
		table3.setWidget(7, 0, lConges);
		table3.setWidget(7, 1, conges);
		// table3.setWidget(7, 0, hPanelBouton);
		// table3.setWidget(7, 1, enregistrer);
		// table3.setWidget(8, 1, modifier);

		table4.setWidget(0, 0, lEnregistrerPar);
		table4.setWidget(0, 1, tEnregistrerPar);
		table4.setWidget(1, 0, lEnregitrerLe);
		table4.setWidget(1, 1, tEnregitrerLe);

		table4.setWidget(2, 0, lModifierPar);
		table4.setWidget(2, 1, tModifierPar);
		table4.setWidget(3, 0, lModifierLe);
		table4.setWidget(3, 1, tModifierLe);
		table4.setWidget(3, 3, masquer);
		table4.setWidget(3, 2, box);
		audit.add(table4);

		// panelMessage.add(message);
		panelRecherche.add(recherche);
		panelRecherche.add(bRecherche);
		panelRecherche.add(hPanelBouton);
		
		dateEtJour.add(sPTable2);
//		dateEtJour.add(tableDate);
		dateEtJour.add(table3);

		deuxiemeForm.add(message);
		panelDeuxTables.add(table);
		panelDeuxTables.add(dateEtJour);
		deuxiemeForm.add(panelDeuxTables);
		deuxiemeForm.add(tableDate);
		deuxiemeForm.add(audit);
//		deuxiemeForm.add(hPanelBouton);
		teteForm.add(panelRecherche);
//		teteForm.add(table);
//		teteForm.add(tableDate);
		gVPanel.add(teteForm);
		gVPanel.add(deuxiemeForm);

	}

	public static float tauxHoraire(String salaire) {
		float resultat = 0;
		try {
			resultat = Float.valueOf(salaire) / 160;
		} catch (Exception ex) {
		}
		return resultat;
	}

	// ---------------------- Observers -------------------------------
	private List<PdfObserver> pdfObservers = new ArrayList<PdfObserver>();

	// --------------- Registration/DeRegitration methods --------------
	public void addPdfObserver(PdfObserver observer) {
		pdfObservers.add(observer);
	}

	public void removePdfObserver(PdfObserver observer) {
		pdfObservers.remove(observer);
	}

	// ---------------------- Controller's Methods ---------------------

	private String nombreChiffreApresVirgule(String nombre) {
		String nombreFinal = null;
		String buf = "";
		char caractere;
		for (int i = 0; i < nombre.length(); i++) {
			caractere = nombre.charAt(i);
			if (caractere == '.') {
				if (nombre.length() >= i + 3) {
					nombreFinal = nombre.substring(0, i + 3);
				} else {
					nombreFinal = nombre.substring(0, i + 2);
				}
				buf = nombre.substring(i, i + 1);
			}
			if (buf.equals("")) {
				nombreFinal = nombre;
			}
		}
		return nombreFinal;
	}

//	public byte[] imageToByte(){
//		
//		try {
//			FileInputStream stream = new FileInputStream("images/background.png");
//			
//				Window.alert("Ce fichier existe");
//				//
//		
//		} catch (Exception ex) {
//
//		}
//
//		return null;
//	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return gVPanel;
	}

}
