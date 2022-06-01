package com.simplilearn.Brief5;
import java.util.List;


public interface CandidatDAO {
	public abstract void createCandidat(Candidat candidat);
	public abstract Candidat getCandidatById(Integer CandidatId);
	public abstract void updateCandidatEmailById(String newEmail,Integer CandidatId);
	public abstract void deleteCandidatById(Integer CandidatId);
	public abstract List<Candidat> getAllCandidatInfo();
}
