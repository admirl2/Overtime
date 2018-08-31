package com.supp.work.soft.client.vue;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.supp.work.soft.client.GreetingService;
import com.supp.work.soft.client.GreetingServiceAsync;

public class VueRapportMensuel implements IsWidget {
	
	private final GreetingServiceAsync pdfService = GWT
			.create(GreetingService.class);
	FlexTable table;
	SimpleComboBox<String> mois;
	SimpleComboBox<String> annee;
	SimpleComboBox<String> modeleGraphe;
	Button export;
	HorizontalPanel hPVueRapportMensuel;
	VerticalPanel vPVueRapportMensuel;
	Label libele;
	
	public VueRapportMensuel(){
		
		hPVueRapportMensuel=new HorizontalPanel();
		vPVueRapportMensuel=new VerticalPanel();
		export=new Button("Export");
		export.setStyleName("bExportvueRapportMensuel");
		table=new FlexTable();
		libele=new Label("Rapport mensuel des heures supplémentaires");
		libele.setStyleName("libelevueRapportMensuel");
		
		mois = new SimpleComboBox<String>(new StringLabelProvider<String>());
		mois.setStyleName("vueRapportMensuel");
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
		annee.setStyleName("vueRapportMensuel");
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
		
		modeleGraphe = new SimpleComboBox<String>(new StringLabelProvider<String>());
		modeleGraphe.setEmptyText("Modeles graphiques");
		modeleGraphe.add("Barres");
		modeleGraphe.add("Secteurs");
		
		export.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				pdfService.graphe(mois.getText(),annee.getText(),new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {

						Frame frame = new Frame();

						// frame.setUrl("Invoice.pdf");
						// frame.setUrl("pdf/Invoice.pdf");
								if (modeleGraphe.getText().equals("Barres")) {

									if (Login.typeUser
											.equals("Super Utilisateur")) {
										frame.setUrl(GWT.getModuleBaseURL()
												+ "report?reportName=ReportWithChart");
										frame.setHeight("920px");
										frame.setWidth("800px");
										FenetreAdmin.conteneurPDFAdmin.clear();
										FenetreAdmin.conteneurPDFAdmin
												.add(frame);
									} else {
										// FenetrePrincipale.conteneurPDF.clear();
										// frame.setUrl(GWT.getModuleBaseURL()
										// +
										// "report?reportName=SupplementaireRaport");
										// frame.setHeight("920px");
										// frame.setWidth("800px");
										// FenetrePrincipale.conteneurPDF.add(frame);

										frame.setUrl(GWT.getModuleBaseURL()
												+ "report?reportName=ReportWithChart");
										frame.setHeight("920px");
										frame.setWidth("800px");
										FenetreAdmin.conteneurPDFAdmin.clear();
										FenetreAdmin.conteneurPDFAdmin
												.add(frame);
									}

									/*
									 * // TODO Auto-generated method stub for
									 * (PdfObserver observer : pdfObservers) {
									 * observer
									 * .notifyPdfGenratedSuccessfully(result);
									 * 
									 * }
									 * 
									 * //
									 * System.out.println("Path==============="
									 * +result);
									 * //Window.alert("Path===============" +
									 * GWT.getModuleBaseURL());
									 * //Window.alert("Path===============" +
									 * result); Frame frame = new Frame(); //
									 * frame.setUrl("Invoice.pdf"); //
									 * frame.setUrl("pdf/Invoice.pdf");
									 * frame.setUrl(result);
									 * frame.setHeight("920px");
									 * frame.setWidth("800px");
									 * FenetrePrincipale
									 * .conteneurPDF.add(frame);
									 */
									// System.out.println(result);
								}else{
									if (Login.typeUser
											.equals("Super Utilisateur")) {
										frame.setUrl(GWT.getModuleBaseURL()
												+ "report?reportName=ReportWithSector");
										frame.setHeight("920px");
										frame.setWidth("800px");
										FenetreAdmin.conteneurPDFAdmin.clear();
										FenetreAdmin.conteneurPDFAdmin
												.add(frame);
									} else {
										// FenetrePrincipale.conteneurPDF.clear();
										// frame.setUrl(GWT.getModuleBaseURL()
										// +
										// "report?reportName=SupplementaireRaport");
										// frame.setHeight("920px");
										// frame.setWidth("800px");
										// FenetrePrincipale.conteneurPDF.add(frame);

										frame.setUrl(GWT.getModuleBaseURL()
												+ "report?reportName=ReportWithSector");
										frame.setHeight("920px");
										frame.setWidth("800px");
										FenetreAdmin.conteneurPDFAdmin.clear();
										FenetreAdmin.conteneurPDFAdmin
												.add(frame);
									}
								}
							}
				});
			}});
		
		
		table.setWidget(0, 0, mois);
		table.setWidget(0, 1, annee);
		table.setWidget(0, 2, modeleGraphe);
		table.setWidget(0, 3, export);
		
		hPVueRapportMensuel.add(table);
		vPVueRapportMensuel.add(libele);
		vPVueRapportMensuel.add(hPVueRapportMensuel);
		
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return vPVueRapportMensuel;
	}

}
