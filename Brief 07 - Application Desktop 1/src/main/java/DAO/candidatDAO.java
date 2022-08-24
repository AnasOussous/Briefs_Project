package DAO;

import com.example.brief7.Candidat;

import java.util.List;

public interface candidatDAO {
    public abstract void createCandidat(Candidat candidat);

    public abstract void updateCandidatEmailById(String newEmail, Integer CandidatId);

    public abstract void deleteCandidat(Integer CandidatId);


    //public abstract List<Candidat> getAllCandidatInfo();
}
