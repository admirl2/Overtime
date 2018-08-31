package com.supp.work.soft.client.vue;

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
import com.supp.work.soft.shared.model.Employes;

public class FormulaireArchive implements IsWidget {

	private final GreetingServiceAsync pdfService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync rechercheService = GWT
			.create(GreetingService.class);
	private final ArchiveServiceAsync modifierService = GWT
			.create(ArchiveService.class);
	private final GreetingServiceAsync enregistrerService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync compteurService = GWT
			.create(GreetingService.class);
	private final GreetingServiceAsync listerService = GWT
			.create(GreetingService.class);
	private final ArchiveServiceAsync rechercheServiceArchive = GWT
			.create(ArchiveService.class);

	private final GreetingServiceAsync enregistrerServiceArchive = GWT
			.create(GreetingService.class);

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
	SimpleComboBox<String> annee;
	Label lRaison;
	TextArea tRaison;
	SimpleComboBox<String> mois;
	Label code;
	Label direction;
	Label service;
	TextBox tDirection;
	TextBox tService;
	VerticalPanel deuxiemeForm;
	VerticalPanel teteForm;

	FlexTable table;
	Label date;
	Label nbrH;
	Label lundi;
	Label mardi;
	Label mercredi;
	Label jeudi;
	Label vendredi;
	Label samedi;
	Label dimanche;
	Label massage;
	TextBox totLundi;
	TextBox totMardi;
	TextBox totMercredi;
	TextBox totJeudi;
	TextBox totVendredi;
	TextBox totSamedi;
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
	private TextBox conge;
	private Label lConge;
	public FormulaireArchive() {
		// Creation de l'objet
		table4=new FlexTable();
		audit=new HorizontalPanel();
		audit.setVisible(false);
		box=new CheckBox();
		cLister=new CheckBox();
		tEnregistrerPar=new TextBox();
		tEnregitrerLe=new TextBox();
		tModifierPar=new TextBox();
		tModifierLe=new TextBox();
		lEnregistrerPar=new Label("Creer par");
		lEnregitrerLe=new Label("Creer le");
		lModifierPar=new Label("Modifier par");
		lModifierLe=new Label("Modifier le");
		masquer=new Label("Hide");
		liste=new Label("Liste");
		
		final ArrayList list = new ArrayList();
		hPanelBouton = new HorizontalPanel();
		panelRecherche = new HorizontalPanel();
		panelMessage = new VerticalPanel();
		message = new Label();
		message.setStyleName("messageFormulaire");
		teteForm = new VerticalPanel();
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

		table = new FlexTable();
		table2 = new FlexTable();
		table3 = new FlexTable();
		date = new Label("Date");
		nbrH = new Label("Nombre d'heures");
		lundi = new Label("Lundi");
		mardi = new Label("Mardi");
		mercredi = new Label("Mercredi");
		jeudi = new Label("Jeudi");
		vendredi = new Label("Vendredi");
		samedi = new Label("Samedi");
		dimanche = new Label("Dimanche");
		lConge= new Label("Jours fériés");

		totLundi = new TextBox();
		totMardi = new TextBox();
		totMercredi = new TextBox();
		totJeudi = new TextBox();
		totVendredi = new TextBox();
		totSamedi = new TextBox();
		totDimanche = new TextBox();
		conge = new TextBox();
		tDirection = new TextBox();
		tService = new TextBox();
		recherche = new TextBox();
//		recherche.setSearchQuery(true);
//		recherche.setPlaceholder("Recherche");
		bExport = new Button("Export");
		enregistrer = new Button("Enregistrer");
		bRecherche = new Button("Rechercher");
		modifier = new Button("Modifier");
		lister = new Button("Lister");

		code = new Label("Code");
		mois = new SimpleComboBox<String>(new StringLabelProvider<String>());
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
		annee.setEmptyText("Annee");
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

		// mois.addKeyPressHandler(new KeyPressHandler(){
		//
		// @Override
		// public void onKeyPress(KeyPressEvent event) {
		// // TODO Auto-generated method stub
		// mois.clear();
		// mois.add("Janvier");
		// mois.add("Fevrier");
		// }});
		// Ajout d'ecouteur
		salaire.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					salaire.setText("");
				}
			}
		});

		totLundi.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					totLundi.setText("");
				}
			}
		});

		totMardi.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					totMardi.setText("");
				}
			}
		});

		totMercredi.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					totMercredi.setText("");
				}
			}
		});

		totJeudi.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					totJeudi.setText("");
				}
			}
		});

		totVendredi.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					totVendredi.setText("");
				}
			}
		});

		totSamedi.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					totSamedi.setText("");
				}
			}
		});

		totDimanche.addKeyboardListener(new KeyboardListener() {

			@Override
			public void onKeyDown(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onKeyPress(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onKeyUp(Widget sender, char keyCode, int modifiers) {
				// TODO Auto-generated method stub
				if (FieldVerifier.isNumberCar(salaire.getText())) {
					salaire.setText("");
				}
			}
		});

		salaire.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub

			}
		});

		bExport.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				// String a="2345.9778";
				// nombreChiffreApresVirgule(a);
				// System.out.println("Le nom est  :"+nombreChiffreApresVirgule(a));
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
				float salaireConges = (float) (2 * taux * FieldVerifier.isVide(conge.getText()));
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
						.valueOf((totalHSemaine + totalHWeekend)));
				employe.setRaison(tRaison.getText());
				employe.setMois(mois.getText());
				employe.setAnnee(annee.getText());
				employe.setConge(conge.getText());
				System.out
						.println("======================================         Login.typeUser");

				pdfService.generatePdf(employe, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {

						Frame frame = new Frame();

						// frame.setUrl("Invoice.pdf");
						// frame.setUrl("pdf/Invoice.pdf");

						if (Login.typeUser.equals("Super Utilisateur")) {
							frame.setUrl(GWT.getModuleBaseURL()
									+ "report?reportName=SupplementaireRaport");
							frame.setHeight("920px");
							frame.setWidth("800px");
							FenetreAdmin.conteneurPDFAdmin.clear();
							FenetreAdmin.conteneurPDFAdmin.add(frame);
						} else {
							FenetrePrincipale.conteneurPDF.clear();
							frame.setUrl(GWT.getModuleBaseURL()
									+ "report?reportName=SupplementaireRaport");
							frame.setHeight("920px");
							frame.setWidth("800px");
							FenetrePrincipale.conteneurPDF.add(frame);
						}

						/*
						 * // TODO Auto-generated method stub for (PdfObserver
						 * observer : pdfObservers) {
						 * observer.notifyPdfGenratedSuccessfully(result);
						 * 
						 * }
						 * 
						 * // System.out.println("Path==============="+result);
						 * //Window.alert("Path===============" +
						 * GWT.getModuleBaseURL());
						 * //Window.alert("Path===============" + result); Frame
						 * frame = new Frame(); // frame.setUrl("Invoice.pdf");
						 * // frame.setUrl("pdf/Invoice.pdf");
						 * frame.setUrl(result); frame.setHeight("920px");
						 * frame.setWidth("800px");
						 * FenetrePrincipale.conteneurPDF.add(frame);
						 */
						// System.out.println(result);
					}
				});

			}
		});
		
		
		
		
		bExport.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				// String a="2345.9778";
				// nombreChiffreApresVirgule(a);
				// System.out.println("Le nom est  :"+nombreChiffreApresVirgule(a));
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
				float salaireConges = (float) (2 * taux * FieldVerifier.isVide(conge.getText()));
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
						.valueOf((totalHSemaine + totalHWeekend)));
				employe.setRaison(tRaison.getText());
				employe.setMois(mois.getText());
				employe.setAnnee(annee.getText());
				employe.setConge(conge.getText());
				System.out
						.println("======================================         Login.typeUser");

//				pdfService.graphe(new AsyncCallback<String>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onSuccess(String result) {
//
//						Frame frame = new Frame();
//
//						// frame.setUrl("Invoice.pdf");
//						// frame.setUrl("pdf/Invoice.pdf");
//
//						if (Login.typeUser.equals("Super Utilisateur")) {
//							frame.setUrl(GWT.getModuleBaseURL()
//									+ "report?reportName=ReportWithChart");
//							frame.setHeight("920px");
//							frame.setWidth("800px");
//							FenetreAdmin.conteneurPDFAdmin.clear();
//							FenetreAdmin.conteneurPDFAdmin.add(frame);
//						} else {
//							FenetrePrincipale.conteneurPDF.clear();
//							frame.setUrl(GWT.getModuleBaseURL()
//									+ "report?reportName=SupplementaireRaport");
//							frame.setHeight("920px");
//							frame.setWidth("800px");
//							FenetrePrincipale.conteneurPDF.add(frame);
//						}
//
//						/*
//						 * // TODO Auto-generated method stub for (PdfObserver
//						 * observer : pdfObservers) {
//						 * observer.notifyPdfGenratedSuccessfully(result);
//						 * 
//						 * }
//						 * 
//						 * // System.out.println("Path==============="+result);
//						 * //Window.alert("Path===============" +
//						 * GWT.getModuleBaseURL());
//						 * //Window.alert("Path===============" + result); Frame
//						 * frame = new Frame(); // frame.setUrl("Invoice.pdf");
//						 * // frame.setUrl("pdf/Invoice.pdf");
//						 * frame.setUrl(result); frame.setHeight("920px");
//						 * frame.setWidth("800px");
//						 * FenetrePrincipale.conteneurPDF.add(frame);
//						 */
//						// System.out.println(result);
//					}
//				});

			}
		});
		
		
		
		
		
		

//		enregistrer.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//
//				// FenetrePrincipale.conteneurPDF.clear();
//
//				compteurService.numberSave(new AsyncCallback<List<Employes>>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onSuccess(List<Employes> result) {
//						// TODO Auto-generated method stub
//
//						ArrayList list = new ArrayList();
//						int code = 0;
//
//						for (Employes employe : result) {
//							list.add(employe.getCode());
//						}
//
//						if (list.size() != 0) {
//							code = list.size() + 1;
//						} else {
//							code = 1;
//						}
//
//						float salaireDefinitif = 0;
//						float tier = FieldVerifier.isVide(salaire.getText()) / 3;
//						float taux = tauxHoraire(salaire.getText());
//						int totalHSemaine = FieldVerifier.isVide(totLundi
//								.getText())
//								+ FieldVerifier.isVide(totMardi.getText())
//								+ FieldVerifier.isVide(totMercredi.getText())
//								+ FieldVerifier.isVide(totJeudi.getText())
//								+ FieldVerifier.isVide(totVendredi.getText());
//
//						int totalHWeekend = FieldVerifier.isVide(totDimanche
//								.getText())
//								+ FieldVerifier.isVide(totSamedi.getText());
//
//						float salaireSemaine = (float) (1.5 * taux * totalHSemaine);
//						float salaireWeekend = (float) (2 * taux * totalHWeekend);
//						float salaireToPay = salaireSemaine + salaireWeekend;
//
//						if (tier < salaireToPay) {
//							salaireDefinitif = tier;
//						} else {
//							salaireDefinitif = salaireToPay;
//						}
//
//						Employes employe = new Employes();
//						employe.setCode(String.valueOf(code));
//						employe.setNom(nom.getText());
//						employe.setPrenom(prenom.getText());
//						employe.setSalaire(salaire.getText());
//						employe.setFonction(tFonction.getText());
//						employe.setHoraireRegulier(tHoraireRegulier.getText());
//						employe.setDirection(tDirection.getText());
//						employe.setService(tService.getText());
//						employe.setLundi(totLundi.getText());
//						employe.setMardi(totMardi.getText());
//						employe.setMercredi(totMercredi.getText());
//						employe.setJeudi(totJeudi.getText());
//						employe.setVendredi(totVendredi.getText());
//						employe.setSamedi(totSamedi.getText());
//						employe.setDimanche(totDimanche.getText());
//						employe.setValeurAPayer(String
//								.valueOf(salaireDefinitif));
//						employe.setTotalHeures(String.valueOf(totalHSemaine));
//						employe.setTotalHeureW(String.valueOf(totalHWeekend));
//						employe.setTotalHeures(String
//								.valueOf((totalHSemaine + totalHWeekend)));
//						employe.setRaison(tRaison.getText());
//						employe.setMois(mois.getText());
//						employe.setCreerPar(Login.log);
//						employe.setCreerLe(FieldVerifier
//								.formateDate(new Date()));
//						employe.setModifierPar("");
//						employe.setModifierLe("");
//
//						enregistrerService.enregistrer(employe,
//								new AsyncCallback<String>() {
//
//									@Override
//									public void onFailure(Throwable caught) {
//										// TODO Auto-generated method stub
//
//									}
//
//									@Override
//									public void onSuccess(String result) {
//										// TODO Auto-generated method stub
//
//										if (result != null) {
//											if (Login.typeUser
//													.equals("Super Utilisateur")) {
//												// Label message2=new Label();
//												// message2.setText("");
//												message.setText(result);
//												// message2.setText("Enregistrement reussi");
//												// FenetreAdmin.conteneurPDFAdmin.clear();
//												// FenetreAdmin.conteneurPDFAdmin.add(message);
//											} else {
//												// FenetrePrincipale.conteneurPDF.clear();
//												// panelMessage.clear();
//												// Label message2=new Label();
//												// message2.setText("");
//												message.setText(result);
//												// message2.setText("Enregistrement reussi");
//												// panelMessage.add(message2);
//												// panelMessage.add(message);
//												// FenetrePrincipale.conteneurPDF
//												// .add(panelMessage);
//											}
//										} else {
//											panelMessage.add(new Label(
//													"Echec d'enregistrement"));
//											FenetrePrincipale.conteneurPDF
//													.add(panelMessage);
//										}
//
//									}
//								});
//
//					}
//				});
//
//			}
//		});

		bRecherche.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				rechercheServiceArchive.rechercher(recherche.getText(), mois.getText(),annee.getText(), new AsyncCallback<Archiveemployes>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Archiveemployes result) {
						// TODO Auto-generated method stub
						if(result!=null){
							recherche.setText(result.getArchiveemployesPK().getCode());
							nom.setText(result.getNom());
							prenom.setText(result.getPrenom());
							salaire.setText(result.getSalaire());
							tFonction.setText(result.getFonction());
							tHoraireRegulier.setText(result.getHoraireRegulier());
							tDirection.setText(result.getDirection());
							tService.setText(result.getService());
							tRaison.setText(result.getRaison());
							mois.setText(result.getArchiveemployesPK().getMois());
							annee.setText(result.getArchiveemployesPK().getAnnee());
							totLundi.setText(result.getLundi());
							totMardi.setText(result.getMardi());
							totMercredi.setText(result.getMercredi());
							totJeudi.setText(result.getJeudi());
							totVendredi.setText(result.getVendredi());
							totSamedi.setText(result.getSamedi());
							totDimanche.setText(result.getDimanche());
							conge.setText(result.getConge());
						}
					}});
			}
		});

//		modifier.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				Archiveemployes archive = new Archiveemployes();
//				archive.setArchiveemployesPK(new ArchiveemployesPK(recherche.getText(),mois.getText()));
//				archive.setNom(nom.getText());
//				archive.setPrenom(prenom.getText());
//				archive.setSalaire(salaire.getText());
//				archive.setFonction(tFonction.getText());
//				archive.setHoraireRegulier(tHoraireRegulier.getText());
//				archive.setDirection(tDirection.getText());
//				archive.setService(tService.getText());
//				archive.setLundi(totLundi.getText());
//				archive.setMardi(totMardi.getText());
//				archive.setMercredi(totMercredi.getText());
//				archive.setJeudi(totJeudi.getText());
//				archive.setVendredi(totVendredi.getText());
//				archive.setSamedi(totSamedi.getText());
//				archive.setDimanche(totDimanche.getText());
//				archive.setRaison(tRaison.getText());
//				archive.setModifierPar(Login.log);
//				archive.setModifierLe(FieldVerifier.formateDate(new Date()));
//				modifierService.modifier(archive, new AsyncCallback<String>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onSuccess(String result) {
//						// TODO Auto-generated method stub
//						
//							message.setText(result);
//					
//					}
//				});
//			}
//		});

		lister.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				listerService.lister(new AsyncCallback<List<Employes>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(List<Employes> result) {
						// TODO Auto-generated method stub
						if (result != null) {
							List liste = new ArrayList();
							String[] entete = { "Nom", "Prenom" };
							// liste.add("Eugene");
							// liste.add("Pierre");
							Grid grid = new Grid(result.size(), 2);
							grid.setText(0, 0, entete[0]);
							grid.setText(0, 1, entete[1]);
							// for(int i=0; i<liste.size(); i++){
							// for(int column=0; column<2; column++){
							// grid.setText(i, column, (String) liste.get(i));
							// }
							// }
							for (Employes employe : result) {
								for (int row = 1; row < result.size(); row++) {

									grid.setText(row, 0, result.get(row)
											.getCode());
									grid.setText(row, 1, result.get(row)
											.getNom());

									// grid.setText(row, 1, employe.getNom());

								}
								System.out.println("Code===============:"
										+ employe.getCode());
								System.out.println("Nom============:"
										+ employe.getNom());
							}
							FenetreAdmin.conteneurPDFAdmin.clear();
							FenetreAdmin.conteneurPDFAdmin.add(grid);
						} else {
							Window.alert("Null");
						}
					}
				});
			}
		});
		
		box.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(box.isChecked()){
					audit.setVisible(false);
				}
			}});
		
		cLister.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(cLister.isChecked()){
					listerService.lister(new AsyncCallback<List<Employes>>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onSuccess(List<Employes> result) {
							// TODO Auto-generated method stub
							if (result != null) {
								List liste = new ArrayList();
								String[] entete = {"Code", "Nom", "Prenom" };
								// liste.add("Eugene");
								// liste.add("Pierre");
								Grid grid = new Grid(result.size()+1, 4);
//								grid.setText(0, 0, entete[0]);
//								grid.setText(0, 1, entete[1]);
								// for(int i=0; i<liste.size(); i++){
								// for(int column=0; column<2; column++){
								// grid.setText(i, column, (String) liste.get(i));
								// }
								// }
								for (Employes employe : result) {
									for (int row = 1; row <= result.size(); row++) {
										grid.setText(0, 0, entete[0]);
										grid.setText(0, 1, entete[1]);
										grid.setText(0, 2, entete[2]);
										grid.setText(row, 0, result.get(row-1)
												.getCode());
										grid.setText(row, 1, result.get(row-1)
												.getNom());
										grid.setText(row, 2, result.get(row-1)
												.getPrenom());

									// grid.setText(row, 1, employe.getNom());

									}
									System.out.println("Code===============:"
											+ employe.getCode());
									System.out.println("Nom============:"
											+ employe.getNom());
								}
								FenetreAdmin.conteneurPDFAdmin.clear();
								FenetreAdmin.conteneurPDFAdmin.add(grid);
							} else {
								Window.alert("Null");
							}
						}
					});
				}
			}});
		
		
		annee.addKeyDownHandler(new KeyDownHandler(){

			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					rechercheServiceArchive.rechercher(recherche.getText(), mois.getText(),annee.getText(), new AsyncCallback<Archiveemployes>(){

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Archiveemployes result) {
							// TODO Auto-generated method stub
							if(result!=null){
								recherche.setText(result.getArchiveemployesPK().getCode());
								nom.setText(result.getNom());
								prenom.setText(result.getPrenom());
								salaire.setText(result.getSalaire());
								tFonction.setText(result.getFonction());
								tHoraireRegulier.setText(result.getHoraireRegulier());
								tDirection.setText(result.getDirection());
								tService.setText(result.getService());
								tRaison.setText(result.getRaison());
								mois.setText(result.getArchiveemployesPK().getMois());
								annee.setText(result.getArchiveemployesPK().getAnnee());
								totLundi.setText(result.getLundi());
								totMardi.setText(result.getMardi());
								totMercredi.setText(result.getMercredi());
								totJeudi.setText(result.getJeudi());
								totVendredi.setText(result.getVendredi());
								totSamedi.setText(result.getSamedi());
								totDimanche.setText(result.getDimanche());
								conge.setText(result.getConge());
							}
						}});
				}
			}});

		// Ajout du style
		teteForm.setStyleName("teteForm");
		deuxiemeForm.setStyleName("deuxiemeForm");
		audit.setStyleName("teteForm");
		lNom.setStyleName("labelForm");
		lPrenom.setStyleName("labelForm");
		lSalaire.setStyleName("labelForm");
		lFonction.setStyleName("labelForm");
		lHoraireRegulier.setStyleName("labelForm");
		lRaison.setStyleName("labelForm");
		direction.setStyleName("labelForm");
		service.setStyleName("labelForm");
		nbrH.setStyleName("labelForm2");
		date.setStyleName("labelForm2");
		lConge.setStyleName("labelForm");

		panelMessage.setStyleName("panelMessage");
		panelRecherche.setStyleName("panelRecherche");

		table.setStyleName("tableForm");
		table2.setStyleName("table2Form");
		table3.setStyleName("table3Form");
		nom.setStyleName("textForm");
		prenom.setStyleName("textForm");
		salaire.setStyleName("textForm");
		tFonction.setStyleName("textForm");
		tHoraireRegulier.setStyleName("textForm");
		tDirection.setStyleName("textForm");
		tService.setStyleName("textForm");
		totLundi.setStyleName("textForm2");
		totMardi.setStyleName("textForm2");
		totMercredi.setStyleName("textForm2");
		totJeudi.setStyleName("textForm2");
		totVendredi.setStyleName("textForm2");
		totSamedi.setStyleName("textForm2");
		totDimanche.setStyleName("textForm2");
		bExport.setStyleName("bExport");
		enregistrer.setStyleName("bExport");
		modifier.setStyleName("bExport");
		lister.setStyleName("bExport");
		bRecherche.setStyleName("bRecherche");
		lundi.setStyleName("jour");
		mardi.setStyleName("jour");
		mercredi.setStyleName("jour");
		jeudi.setStyleName("jour");
		vendredi.setStyleName("jour");
		samedi.setStyleName("jour");
		dimanche.setStyleName("jour");

		// Ajout des elements

		hPanelBouton.add(bExport);
		hPanelBouton.add(enregistrer);
		hPanelBouton.add(modifier);
		hPanelBouton.add(cLister);
		hPanelBouton.add(liste);
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
//		table.setWidget(8, 0, lMois);
//		table.setWidget(8, 1, mois);
//		table.setWidget(8, 2, annee);

		table2.setWidget(0, 0, date);
		table2.setWidget(0, 1, nbrH);

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
		table3.setWidget(7, 0, lConge);
		table3.setWidget(7, 1, conge);
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
		table4.setWidget(3, 2, masquer);
		table4.setWidget(3, 2, box);
		audit.add(table4);
		
		
		// panelMessage.add(message);
		panelRecherche.add(code);
		panelRecherche.add(recherche);
		panelRecherche.add(mois);
		panelRecherche.add(annee);
		panelRecherche.add(bRecherche);

		deuxiemeForm.add(table2);
		deuxiemeForm.add(table3);
		deuxiemeForm.add(message);
		deuxiemeForm.add(audit);
		deuxiemeForm.add(hPanelBouton);
		teteForm.add(panelRecherche);
		teteForm.add(table);
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

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return gVPanel;
	}

}
