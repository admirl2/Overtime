package com.supp.work.soft.server.iDao;

import com.supp.work.soft.shared.model.Archiveemployes;

public interface IArchive <T>{

	public T enregistrer (Archiveemployes archive);
	public T modifier (Archiveemployes archive);
	public T rechercher (String code,String mois,String annee);
}
