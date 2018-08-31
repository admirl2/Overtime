package com.supp.work.soft.client.vue;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class FenetrePrincipale implements IsWidget {

	VerticalPanel gHPanel;
	HorizontalPanel panelCorps;
	public static SimplePanel conteneurPDF;

	public FenetrePrincipale() {
		gHPanel = new VerticalPanel();
		panelCorps = new HorizontalPanel();
		conteneurPDF = new SimplePanel();
		conteneurPDF.setStyleName("conteneurPDF");

		
		panelCorps.add(new Formulaire().asWidget());
		//panelCorps.add(new VueFonctionnaire().asWidget());
		panelCorps.add(conteneurPDF);
		gHPanel.add(new Entete().asWidget());
		gHPanel.add(panelCorps);
		panelCorps.setStyleName("panelCorpsFenetrePrincipale");
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return gHPanel;
	}

}
