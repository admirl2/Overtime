package com.supp.work.soft.server.iDao;

import java.util.List;

import com.supp.work.soft.shared.model.Utilisateur;


public interface IUtilisateur <T> {
	public T enregistrer(Utilisateur utilisateur);
	public T rechercher(String login);
	public T rechercher(String login,String password);
	public T modifier(Utilisateur utilisateur);
	public List<T> lister();

}
