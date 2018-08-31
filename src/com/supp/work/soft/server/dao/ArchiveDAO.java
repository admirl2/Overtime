package com.supp.work.soft.server.dao;

import javax.persistence.Query;

import com.supp.work.soft.server.connexion.Connexion;
import com.supp.work.soft.server.iDao.IArchive;
import com.supp.work.soft.shared.model.Archiveemployes;
import com.supp.work.soft.shared.model.ArchiveemployesPK;


public class ArchiveDAO implements IArchive{
	
	public ArchiveDAO(){
		new Connexion();
	}

	@Override
	public Object enregistrer(Archiveemployes archive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Archiveemployes rechercher(String code,String mois,String annee) {
		Archiveemployes archive = null;
		try{
			ArchiveemployesPK eployes=new ArchiveemployesPK(code,mois,annee);
			archive=Connexion.em.find(Archiveemployes.class, eployes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return archive;
	}

	@Override
	public String modifier(Archiveemployes employe) {
		String message = null;
		try {
			Connexion.em.getTransaction().begin();
			Archiveemployes employe1=Connexion.em.find(Archiveemployes.class, employe.getArchiveemployesPK());
			employe1.setNom(employe.getNom());
			employe1.setPrenom(employe.getPrenom());
			employe1.setSalaire(employe.getSalaire());
			employe1.setFonction(employe.getFonction());
			employe1.setHoraireRegulier(employe.getHoraireRegulier());
			employe1.setDirection(employe.getDirection());
			employe1.setService(employe.getService());
			employe1.setRaison(employe.getRaison());
			employe1.setLundi(employe.getLundi());
			employe1.setMardi(employe.getMardi());
			employe1.setMercredi(employe.getMercredi());
			employe1.setJeudi(employe.getJeudi());
			employe1.setVendredi(employe.getVendredi());
			employe1.setSamedi(employe.getSamedi());
			employe1.setDimanche(employe.getDimanche());
			employe1.setModifierPar(employe.getModifierPar());
			employe1.setModifierLe(employe.getModifierLe());
			employe1.setConge(employe.getConge());
			//employe1.setAnnee(employe.getAnnee());
			Connexion.em.flush();
			Connexion.em.getTransaction().commit();
			message = "Modification reussie";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}



}
