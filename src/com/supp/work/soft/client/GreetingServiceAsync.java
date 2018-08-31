package com.supp.work.soft.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.supp.work.soft.shared.model.Archiveemployes;
import com.supp.work.soft.shared.model.Employes;



/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
//	void greetServer(String input, AsyncCallback<String> callback)
//			throws IllegalArgumentException;
//
//
	void generatePdf(Employes supplementaire,
			AsyncCallback<String> callback);


	void transfert(Employes supplementaire, AsyncCallback<String> callback);


	void enregistrer(Employes employe, AsyncCallback<String> callback);


	void numberSave(AsyncCallback<List<Employes>> callback);


	void rechercher(String code, AsyncCallback<Employes> callback);


	void modifier(Employes employe, AsyncCallback<String> callback);


	void lister(AsyncCallback<List<Employes>> callback);


	void rechercherArchive(String text, String text2, String annee,
			AsyncCallback<Archiveemployes> asyncCallback);


	void enregistrerArchive(Archiveemployes archive,
			AsyncCallback<String> asyncCallback);


	void graphe(String mois, String annee, AsyncCallback<String> callback);


//	void bonjour(AsyncCallback<String> callback);


//	void imageToByte(AsyncCallback<Void> callback);
}
