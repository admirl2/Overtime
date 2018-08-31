package com.supp.work.soft.server.dao;

import java.security.Key;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Query;

import com.supp.work.soft.server.connexion.Connexion;
import com.supp.work.soft.server.iDao.IUtilisateur;
import com.supp.work.soft.shared.Base64;
import com.supp.work.soft.shared.model.Utilisateur;


public class UtilisateurDAO implements IUtilisateur {
	
	String message;
	
	public UtilisateurDAO(){
		new Connexion();
	}

	@Override
	public String enregistrer(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		try{
			utilisateur.setPassword(encrypt(utilisateur.getPassword(),""));
			Connexion.em.getTransaction().begin();
			Connexion.em.persist(utilisateur);
			Connexion.em.getTransaction().commit();
			message="Enregistrement reussi";
		}catch(Exception ex){
			System.out.println(ex);
			message=ex.getMessage();
		}finally{
			try{
				Connexion.closeEm();
				Connexion.closeEmf();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public Object rechercher(String login) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=null;
		try{
			utilisateur=Connexion.em.find(Utilisateur.class, login);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public String modifier(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String message = null;
		try {
			Connexion.em.getTransaction().begin();
			Utilisateur utilisateur1=Connexion.em.find(Utilisateur.class, utilisateur.getLogin());
			utilisateur1.setPassword(encrypt(utilisateur.getPassword(),""));
			utilisateur1.setModifierPar(utilisateur.getModifierPar());
			utilisateur1.setModifierLe(utilisateur.getModifierLe());
			utilisateur1.setNbrFoisLog(utilisateur.getNbrFoisLog());
			utilisateur1.setTypeUser(utilisateur.getTypeUser());
			Connexion.em.flush();
			Connexion.em.getTransaction().commit();
			System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa====");
			message = "Modification reussie";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}

	@Override
	public List lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur rechercher(String login, String password) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=null;
		try{
			String requete="SELECT u FROM Utilisateur u WHERE u.login='"+login+"' AND u.password='"+encrypt(password,"")+"'";
			Query query=Connexion.em.createQuery(requete);
			utilisateur=(Utilisateur) query.getSingleResult();
			System.out.println(encrypt(password, ""));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return utilisateur;
	}
	
	 private static final String ALGORITHM = "AES";
		 private static final int ITERATIONS = 1;
		 private static final byte[] keyValue =
		 new byte[]
		 {'f','A','|','C','o','N','=','6','-','a','(','e','@','*','A','"'};
		
		 public static String encrypt(String value, String salt) throws Exception
		 {
		 Key key = generateKey();
		 Cipher c = Cipher.getInstance(ALGORITHM);
		 c.init(Cipher.ENCRYPT_MODE, key);
		
		 String valueToEnc = null;
		 String eValue = value;
		 for (int i = 0; i < ITERATIONS; i++) {
		 valueToEnc = salt + eValue;
		 byte[] encValue = c.doFinal(valueToEnc.getBytes());
		 eValue = Base64.encodeToString(encValue, true);
		 }
		 return eValue;
		 }
		
		 public static String decrypt(String value, String salt) throws Exception
		 {
		 Key key = generateKey();
		 Cipher c = Cipher.getInstance(ALGORITHM);
		 c.init(Cipher.DECRYPT_MODE, (Key) key);
		
		 String dValue = null;
		 String valueToDecrypt = value;
		 for (int i = 0; i < ITERATIONS; i++) {
		 byte[] decordedValue = Base64.decodeFast(valueToDecrypt);
		 byte[] decValue = c.doFinal(decordedValue);
		 dValue = new String(decValue).substring(salt.length());
		 valueToDecrypt = dValue;
		 }
		 return dValue;
		 }
		 
		 private static Key generateKey() throws Exception {
			 Key key = (Key) new SecretKeySpec(keyValue, ALGORITHM);
			 return key;
			 }

	
}
