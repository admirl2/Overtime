package com.supp.work.soft.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.supp.work.soft.shared.model.Utilisateur;
@RemoteServiceRelativePath("user")
public interface UserService extends RemoteService {

	String enregistrer(Utilisateur utilisateur);
	Utilisateur rechercher(String login,String password);
	String modifier(Utilisateur utilisateur);
	Utilisateur rechercher(String login);
}
