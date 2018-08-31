package com.supp.work.soft.client;


import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.supp.work.soft.shared.model.Archiveemployes;
import com.supp.work.soft.shared.model.Employes;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
//	String greetServer(String name) throws IllegalArgumentException;
	
	String generatePdf(Employes supplementaire);
	String transfert(Employes employe);
	String enregistrer(Employes employe);
	List<Employes> numberSave();
	Employes rechercher(String code);
	String modifier(Employes employe);
	List<Employes> lister();
	String graphe(String mois,String annee);
	Archiveemployes rechercherArchive(String text, String text2,String annee);
	String enregistrerArchive(Archiveemployes archive);
//	public String bonjour();
//	void imageToByte();
	
}
