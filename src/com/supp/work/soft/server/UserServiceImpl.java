package com.supp.work.soft.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.supp.work.soft.client.service.UserService;
import com.supp.work.soft.server.dao.UtilisateurDAO;
import com.supp.work.soft.shared.model.Utilisateur;

public class UserServiceImpl extends RemoteServiceServlet implements UserService{
/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String enregistrer(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return new UtilisateurDAO().enregistrer(utilisateur);
	}

	@Override
	public Utilisateur rechercher(String login,String password) {
		// TODO Auto-generated method stub
		return new UtilisateurDAO().rechercher(login, password);
	}

	@Override
	public String modifier(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return new UtilisateurDAO().modifier(utilisateur);
	}

	@Override
	public Utilisateur rechercher(String login) {
		// TODO Auto-generated method stub
		return (Utilisateur) new UtilisateurDAO().rechercher(login);
	}

}
