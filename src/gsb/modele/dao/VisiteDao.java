package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;


public class VisiteDao {
	
	public static Visite rechercher(String reference){
		Visite uneVisite = null;
		ResultSet reqSeleq = ConnexionMySql.execReqSelection("select * from VISITE where REFERENCE = '"+reference+"'");
		
		try {
			if(reqSeleq.next())
			{
				Medecin unMedecin = MedecinDao.rechercher(reqSeleq.getString(5));
				Visiteur unVisiteur = VisiteurDao.rechercher(reqSeleq.getString(4));
				uneVisite = new Visite(reqSeleq.getString(1), reqSeleq.getString(2), reqSeleq.getString(3), unMedecin, unVisiteur);
						
			}
		}
		catch(Exception e) {
			System.out.println("erreur reqSeleq.next() pour la requ�te - select * from VISITE where REFERENCE ='"+reference+"'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	public static int ajouter(Visite uneVisite){
		int verificationAjout = 0;
		
		try {
		String reqInsertion = "insert into VISITE values ('"+uneVisite.getReference()+"','"+uneVisite.getDate()+"','"+uneVisite.getCommentaire()+"','"+uneVisite.getUnMedecin()+"','"+uneVisite.getUnVisiteur()+"')";
		verificationAjout = ConnexionMySql.execReqMaj(reqInsertion);
	
			
		}
		catch(Exception e) {
			System.out.println("erreur reqInsertion");
			e.printStackTrace();
		}
		return verificationAjout;
	}
	
	public static int modifier(Visite uneVisite)
	{
		int verifModif = 0;
		try 
		{
			String reqModif = "update VISITE set DATEVISITE='"+uneVisite.getDate()+"',COMMENTAIRE='"+
		uneVisite.getCommentaire()+"',MATRICULE='"+uneVisite.getUnVisiteur().getMatricule()+"',CODEMED='"+uneVisite.getUnMedecin().getCodeMed()+
		"' where REFERENCE ='"+uneVisite.getReference()+"'";
			verifModif = ConnexionMySql.execReqMaj(reqModif);
		}
		catch(Exception e)
		{
			System.out.println("erreur sur la requete update");
			e.printStackTrace();
		}
		return verifModif;
	}
}

