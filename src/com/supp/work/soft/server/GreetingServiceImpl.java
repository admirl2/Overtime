package com.supp.work.soft.server;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.supp.work.soft.client.GreetingService;
import com.supp.work.soft.server.pdfCreator.PDFCreator;
import com.supp.work.soft.shared.model.Archiveemployes;
import com.supp.work.soft.shared.model.Employes;


/**
 * The server-side implementation of the RPC service.
 */
//@SuppressWarnings("serial")

public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url;
//
//	public String greetServer(String input) throws IllegalArgumentException {
//		// Verify that the input is valid. 
//		if (!FieldVerifier.isValidName(input)) {
//			// If the input is not valid, throw an IllegalArgumentException back to
//			// the client.
//			throw new IllegalArgumentException(
//					"Name must be at least 4 characters long");
//		}
//
//		String serverInfo = getServletContext().getServerInfo();
//		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
//
//		// Escape data from the client to avoid cross-site script vulnerabilities.
//		input = escapeHtml(input);
//		userAgent = escapeHtml(userAgent);
//
//		return "Hello, " + input + "!<br><br>I am running " + serverInfo
//				+ ".<br><br>It looks like you are using:<br>" + userAgent;
//	}
//
//	/**
//	 * Escape an html string. Escaping data received from the client helps to
//	 * prevent cross-site script vulnerabilities.
//	 * 
//	 * @param html the html string to escape
//	 * @return the escaped string
//	 */
//	private String escapeHtml(String html) {
//		if (html == null) {
//			return null;
//		}
//		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
//				.replaceAll(">", "&gt;");
//	}
//
//	
	@Override
	public String generatePdf(Employes supplementaire) {
		List<Employes> emp=new ArrayList<Employes>();
		emp.add(supplementaire);
		this.getThreadLocalRequest().getSession().setAttribute("employeList", emp);
		return "";
	}

	@Override
	public String transfert(Employes supplementaire) {
		// TODO Auto-generated method stub
		PDFCreator creer=new PDFCreator();
		creer.transfertData(supplementaire);
		return url;
	}

	@Override
	public String enregistrer(Employes employe) {
		// TODO Auto-generated method stub\
		
		return new PDFCreator().enregistrer(employe);
	}

	@Override
	public List<Employes> numberSave() {
		// TODO Auto-generated method stub
		PDFCreator pdf=new PDFCreator();
		
		return pdf.numberSave();
	}

	@Override
	public Employes rechercher(String code) {
		// TODO Auto-generated method stub
		return (Employes) new PDFCreator().rechercher(code);
	}

	@Override
	public String modifier(Employes employe) {
		// TODO Auto-generated method stub
		return new PDFCreator().modifier(employe);
	}

	@Override
	public List<Employes> lister() {
		// TODO Auto-generated method stub
		return new PDFCreator().lister();
	}

	@Override
	public Archiveemployes rechercherArchive(String code, String mois,String annee) {
		// TODO Auto-generated method stub
		return new PDFCreator().rechercherArchive(code, mois,annee);
	}

	@Override
	public String enregistrerArchive(Archiveemployes archive) {
		// TODO Auto-generated method stub
		return new PDFCreator().enregistrerArchive(archive);
	}
//
//	@Override
//	public String bonjour() {
//		// TODO Auto-generated method stub
//		return "Bonjour";
//	}
//
////	@Override
////	public void imageToByte() {
////		// TODO Auto-generated method stub
////		SupplementaireRaport rap=new SupplementaireRaport();
////		rap.imageToByte();
////	}
//
//	
//
//	
//	

	@Override
	public String graphe(String mois,String annee) {
		// TODO Auto-generated method stub
		this.getThreadLocalRequest().getSession().setAttribute("employeList", new PDFCreator().lister(mois,annee));
		return "";
	}
}
