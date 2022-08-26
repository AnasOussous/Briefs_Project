package com.rest.brief.project.stc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.brief.project.stc.exeption.Exeption;
import com.rest.brief.project.stc.model.Administrateur;
import com.rest.brief.project.stc.repository.AdministrateurRepositiry;



@Service 
public class AdministateurService {
	 @Autowired
	    private AdministrateurRepositiry AdministateurRepository;

	    public Optional<Administrateur> getResponsable(final Long id) {
	        return AdministateurRepository.findById(id);
	    }

	    public Iterable<Administrateur> getResponsable() {
	        return AdministateurRepository.findAll();
	    }

	    public void deleteResponsable(final Long id) {
	    	AdministateurRepository.deleteById(id);
	    }

	    public Administrateur saveAdministrateur(Administrateur Administrateur) {
	    	Administrateur savedAdministrateur;
			
				savedAdministrateur = AdministateurRepository.save(Administrateur);
			
	        return savedAdministrateur;
	    }
	    public List<Administrateur> getAllResponsable(){
	        return getAllResponsable();
	      }

	    public Administrateur updateAdministrateur(Administrateur administrateur, long id) {
			Administrateur existingAdministrateur = AdministateurRepository.findById(id)
					.orElseThrow(() -> new Exeption("administrateurRepository", "Id", id));

			
			existingAdministrateur.setNom(administrateur.getNom());
			existingAdministrateur.setPrenom(administrateur.getPrenom());
			existingAdministrateur.setLogin(administrateur.getLogin());
			existingAdministrateur.setPasword(administrateur.getPasword());
			existingAdministrateur.setEmail(administrateur.getEmail());
			existingAdministrateur.setTelephone(administrateur.getTelephone());
			existingAdministrateur.setEtat(administrateur.getEtat());

			AdministateurRepository.save(existingAdministrateur);

			return existingAdministrateur;
		}

		

}
