package com.supp.work.soft.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.supp.work.soft.shared.model.Archiveemployes;
@RemoteServiceRelativePath("archive")
public interface ArchiveService extends RemoteService{

	public String enregistrer (Archiveemployes archive);
	public Archiveemployes rechercher (String code,String mois,String annee);
	public String modifier (Archiveemployes archive);
}
