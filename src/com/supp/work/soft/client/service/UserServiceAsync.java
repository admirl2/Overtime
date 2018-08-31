package com.supp.work.soft.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.supp.work.soft.shared.model.Utilisateur;

public interface UserServiceAsync {

	void enregistrer(Utilisateur utilisateur, AsyncCallback<String> callback);

	void modifier(Utilisateur utilisateur, AsyncCallback<String> callback);

	void rechercher( String login,String password,
			AsyncCallback<Utilisateur> callback);

	void rechercher(String login, AsyncCallback<Utilisateur> callback);

}
