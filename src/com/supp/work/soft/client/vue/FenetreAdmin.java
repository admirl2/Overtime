package com.supp.work.soft.client.vue;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class FenetreAdmin implements IsWidget {

	VerticalPanel gHPanel;
	VerticalPanel vPDisclosure;
	HorizontalPanel gHPanel2;
	SimplePanel separator;
	public static HorizontalPanel panelCorps;
	public static SimplePanel conteneurPDFAdmin;
	DisclosurePanel dHS;
	public static DisclosurePanel dArchive;
	public static DisclosurePanel dAdmin;
	Button bHS;
	Button bArchive;
	Button bFormulaire;
	Button bFormulaireA;
	Button user;
	Button bAdmin;
	VerticalPanel vPanel;
	VerticalPanel vPanelA;
	VerticalPanel vPanelAdmin;
	FlexTable table;
	FlexTable tableA;
	FlexTable tableAdmin;
	Button rapport;
	
	
	//Cote droit au lancement
	VerticalPanel vPImageForm;
	Image iForm;
	Label lForm;	
	VerticalPanel vPImageArchive;
	public static Image iArchive;
	public static Label lArchive;
	VerticalPanel vPImageReport;
	Image iReport;
	Label lReport;
	VerticalPanel vPImageUser;
	public static Image iUser;
	public static Label lUser;
	
	

	
	public FenetreAdmin() {
		//Creation des objets
		gHPanel = new VerticalPanel();
		vPDisclosure= new VerticalPanel();
		panelCorps = new HorizontalPanel();
		gHPanel2=new HorizontalPanel();
		separator=new SimplePanel();
		separator.setStyleName("separator");
//		panelCorps.setStyleName("panelCorps");
		conteneurPDFAdmin = new SimplePanel();
		bHS=new Button("Gestion HS");
		bHS.setStyleName("fenetreAdmin");
//		bHS.setIcon(IconType.USER);
		bFormulaire=new Button("Formulaire");
		user=new Button("Utilisateur");
		
		rapport=new Button("Rapport mensuel");
		
		dHS=new DisclosurePanel(bHS);
		dHS.setStyleName("dHS");
		dHS.setAnimationEnabled(true);
		
		bAdmin=new Button("Administrateur");
		bAdmin.setStyleName("fenetreAdmin");
		dAdmin=new DisclosurePanel(bAdmin);
		dAdmin.setAnimationEnabled(true);
		dAdmin.setStyleName("dHS");
		dAdmin.setAnimationEnabled(true);
		
		bArchive=new Button("Archive");
		bArchive.setStyleName("fenetreAdmin");
		bFormulaireA=new Button("Formulaire");
		dArchive=new DisclosurePanel(bArchive);
		dArchive.setStyleName("dHS");
		dArchive.setAnimationEnabled(true);
		
		table=new FlexTable();
		tableA=new FlexTable();
		tableAdmin=new FlexTable();;
		
		vPanel= new VerticalPanel();
		vPanelA= new VerticalPanel();
		vPanelAdmin=new VerticalPanel();
		conteneurPDFAdmin.setStyleName("conteneurPDF");
		
		//Cote droit au lancement
		vPImageForm=new VerticalPanel();
		vPImageForm.setStyleName("vPImageForm");
		Image iForm=new Image("images/form.png");
		iForm.setStyleName("imageCoteDroit");
		iForm.setSize("100px", "100px");
		lForm=new Label("Formulaire");
		lForm.setStyleName("lCoteDroit");
		vPImageForm.add(iForm);
		vPImageForm.add(lForm);
		iForm.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				conteneurPDFAdmin.clear();
				panelCorps.add(new Formulaire().asWidget());
				panelCorps.add(conteneurPDFAdmin);
//				Window.alert("");
			}});
		
		vPImageArchive=new VerticalPanel();
		vPImageArchive.setStyleName("vPImageForm");
		iArchive=new Image("images/archive.png");
		iArchive.setStyleName("imageCoteDroit");
		iArchive.setSize("120px", "100px");
		lArchive=new Label("Archive");
		lArchive.setStyleName("lCoteDroit");
		vPImageArchive.add(iArchive);
		vPImageArchive.add(lArchive);
		iArchive.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				conteneurPDFAdmin.clear();
				panelCorps.add(new FormulaireArchive().asWidget());
				panelCorps.add(conteneurPDFAdmin);
			}});
		
		vPImageReport=new VerticalPanel();
		vPImageReport.setStyleName("vPImageForm");
		iReport=new Image("images/report.jpg");
		iReport.setStyleName("imageCoteDroit");
		iReport.setSize("100px", "100px");
		lReport=new Label("Rapport");
		lReport.setStyleName("lCoteDroit");
		vPImageReport.add(iReport);
		vPImageReport.add(lReport);
		
		iReport.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				conteneurPDFAdmin.clear();
				VerticalPanel verticalPanel=new VerticalPanel();
				verticalPanel.add(new VueRapportMensuel().asWidget());
				verticalPanel.add(conteneurPDFAdmin);
//				panelCorps.add(new FormulaireArchive().asWidget());
				panelCorps.add(verticalPanel);
			}});
		
		
		vPImageUser=new VerticalPanel();
		vPImageUser.setStyleName("vPImageForm");
		iUser=new Image("images/user.png");
		iUser.setStyleName("imageCoteDroit");
		iUser.setSize("100px", "100px");
		lUser=new Label("Nouveau Utilisateur");
		lUser.setStyleName("lCoteDroit");
		vPImageUser.add(iUser);
		vPImageUser.add(lUser);
		iUser.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				panelCorps.add(new VueUser().asWidget());
			}});
		
		//Ajout des ecouteurs sur les boutons
		bFormulaire.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				conteneurPDFAdmin.clear();
				panelCorps.add(new Formulaire().asWidget());
				panelCorps.add(conteneurPDFAdmin);
//				Window.alert("");
			}});
		
		
		user.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				panelCorps.add(new VueUser().asWidget());
			}});
		
		bFormulaireA.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				conteneurPDFAdmin.clear();
				panelCorps.add(new FormulaireArchive().asWidget());
				panelCorps.add(conteneurPDFAdmin);
			}});
		
		rapport.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				panelCorps.clear();
				conteneurPDFAdmin.clear();
				VerticalPanel verticalPanel=new VerticalPanel();
				verticalPanel.add(new VueRapportMensuel().asWidget());
				verticalPanel.add(conteneurPDFAdmin);
//				panelCorps.add(new FormulaireArchive().asWidget());
				panelCorps.add(verticalPanel);
			}});
		
		
		//panelCorps.add(new Formulaire().asWidget());
		//panelCorps.add(new VueFonctionnaire().asWidget());
		//panelCorps.add(dAdmin);
		//panelCorps.add(conteneurPDFAdmin);

		//Ajout des elements dans les conteneurs
		table.setWidget(0, 0, bFormulaire);
		table.setWidget(1, 0, rapport);
		tableAdmin.setWidget(0, 0, user);
		vPanelAdmin.add(tableAdmin);
		vPanel.add(table);	
		dHS.setContent(vPanel);
		tableA.setWidget(0, 0, bFormulaireA);
		vPanelA.add(tableA);
		dArchive.setContent(vPanelA);
		dAdmin.setContent(vPanelAdmin);
		vPDisclosure.add(dHS);
		vPDisclosure.add(dArchive);
		vPDisclosure.add(dAdmin);
		gHPanel.add(new Entete().asWidget());
//		gHPanel.add(vPDisclosure);
//		gHPanel.add(dArchive);
		
		panelCorps.add(vPImageForm);
		panelCorps.add(vPImageArchive);
		panelCorps.add(vPImageReport);
		panelCorps.add(vPImageUser);
		
		
		panelCorps.setStyleName("panelCorpsFenetreAdmin");
		gHPanel2.setStyleName("gHPanel2");
		gHPanel2.add(vPDisclosure);
		gHPanel2.add(separator);
		gHPanel2.add(panelCorps);
		gHPanel.add(gHPanel2);
		
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return gHPanel;
	}

}
