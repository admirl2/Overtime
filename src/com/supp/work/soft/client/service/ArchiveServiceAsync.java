package com.supp.work.soft.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.supp.work.soft.shared.model.Archiveemployes;

public interface ArchiveServiceAsync {

	void enregistrer(Archiveemployes archive, AsyncCallback<String> callback);

	void modifier(Archiveemployes archive, AsyncCallback<String> callback);

	void rechercher(String code, String mois, String annee,
			AsyncCallback<Archiveemployes> callback);

}
