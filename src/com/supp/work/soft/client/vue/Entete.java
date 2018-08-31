package com.supp.work.soft.client.vue;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.supp.work.soft.client.DRH_SUPPWORK_SOFT;

public class Entete implements IsWidget {
	VerticalPanel gVPanelEntete;
	HorizontalPanel gHPanelEntete;
	SimplePanel sLogo;
	SimplePanel textMEF;
	VerticalPanel systeme;
	Image logo;
	Label info;
	Label lSysteme;
	HorizontalPanel login;
	Button log;
	SimplePanel sPanelInfo2;
	SimplePanel mef;
	Label lMef;
	VerticalPanel infoAndlMef;
	Label defSYSCHS;

	public Entete() {

		// Instanciation des objets
		gVPanelEntete = new VerticalPanel();
		infoAndlMef = new VerticalPanel();
		gHPanelEntete = new HorizontalPanel();
		sLogo = new SimplePanel();
		textMEF = new SimplePanel();
		systeme = new VerticalPanel();
		info = new Label("Ministere de l'Economie et des Finances");
		logo = new Image("images/logo.png");
		login = new HorizontalPanel();
		log = new Button("Deconnexion");
		sPanelInfo2 = new SimplePanel();
		mef = new SimplePanel();
		lMef = new Label("MEF");
		lSysteme = new Label("SysCHS");
		defSYSCHS = new Label("Système de Controle des Heures Supplémentaires");

		// mettre du style
		logo.setStyleName("logo");
		info.setStyleName("info");
		login.setStyleName("login");
		log.setStyleName("log");
		sPanelInfo2.setStyleName("sPanelInfo2");
		lMef.setStyleName("lMef");
		gHPanelEntete.setStyleName("gHPanelEntete");
		lSysteme.setStyleName("lSysteme");
		textMEF.setStyleName("textMEF");
		infoAndlMef.setStyleName("infoAndlMef");
		systeme.setStyleName("systeme");
		defSYSCHS.setStyleName("defSYSCHS");

		// Ajout des ecouteurs
		log.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				DRH_SUPPWORK_SOFT.hPanel.clear();
				DRH_SUPPWORK_SOFT.hPanel.add(new Login().asWidget());
			}
		});

		// Ajout des elements dans les conteneurs
		sLogo.add(logo);
		textMEF.add(info);
		gHPanelEntete.add(sLogo);
		mef.add(lMef);
		infoAndlMef.add(textMEF);
		infoAndlMef.add(mef);
		systeme.add(lSysteme);
		systeme.add(defSYSCHS);
		gHPanelEntete.add(infoAndlMef);
		// gHPanelEntete.add(mef);
		gHPanelEntete.add(systeme);
		login.add(sPanelInfo2);
		login.add(log);
		gVPanelEntete.add(login);
		gVPanelEntete.add(gHPanelEntete);

	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return gVPanelEntete;
	}

}
