package com.simplilearn.Brief5;

import java.util.List;



public class main {

	public static void main(String[] args) {
		CandidatDAO candidatDAO = new CandidatDAOImp();
		Candidat candidat = getCandidat();
		//candidatDAO.createCandidat(candidat);
		//getCandidatById(candidatDAO, 1);
		//candidatDAO.updateCandidatEmailById("anas@gmail.com", 1);
		//candidatDAO.deleteCandidatById(3);
		//getAllCandidatInfo(candidatDAO);
	}
	
 
	private static void getAllCandidatInfo (CandidatDAO candidatDAO) {
		List<Candidat> CanList = candidatDAO.getAllCandidatInfo();
		for (Candidat candidat : CanList) {
			System.out.println(candidat);
		}
	}
 
	private static void getCandidatById(CandidatDAO candidatDAO, Integer CandidatId) {
		Candidat candidat2 = candidatDAO.getCandidatById(CandidatId);
		if(candidat2 != null){
			System.out.println(candidat2);
		}else{
			System.out.println("Candidat does not exist..");
		}
	}
 
	private static Candidat getCandidat() {
		Candidat candidat = new Candidat();
		candidat.setNom("Maryam");
		candidat.setPrénom("Maryam");
		candidat.setMail("Maryam@gmail.com");
		candidat.setVille("marrakesh");
		candidat.setAdresse("Tilila");
		candidat.setId_candidat(3);
		candidat.setPays("Maroc");
		return candidat;
	}

	
	
	
}
