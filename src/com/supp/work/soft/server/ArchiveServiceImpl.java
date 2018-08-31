package com.supp.work.soft.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.supp.work.soft.client.service.ArchiveService;
import com.supp.work.soft.server.dao.ArchiveDAO;
import com.supp.work.soft.server.iDao.IArchive;
import com.supp.work.soft.shared.FieldVerifier;
import com.supp.work.soft.shared.model.Archiveemployes;


/**
 * The server-side implementation of the RPC service.
 */
//@SuppressWarnings("serial")

public class ArchiveServiceImpl extends RemoteServiceServlet implements
		ArchiveService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url;

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public String enregistrer(Archiveemployes archive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Archiveemployes rechercher(String code, String mois,String annee) {
		// TODO Auto-generated method stub
		IArchive iArchive=new ArchiveDAO();
		return (Archiveemployes) iArchive.rechercher(code, mois, annee);
	}

	@Override
	public String modifier(Archiveemployes archive) {
		// TODO Auto-generated method stub
		IArchive iArchive=new ArchiveDAO();
		return (String) iArchive.modifier(archive);
	}

	
	
}
