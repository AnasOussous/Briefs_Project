package com.rest.brief.project.stc.service;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.rest.brief.project.stc.exeption.Exeption;
import com.rest.brief.project.stc.model.Responsable;
import com.rest.brief.project.stc.repository.ResponsableRespository;

import lombok.Data;

	@Data
	@Service
	public class ResponsableService {

	    @Autowired
	    private ResponsableRespository responsableRepository;

	    public Optional<Responsable> getResponsable(final Long id) {
	        return responsableRepository.findById(id);
	    }

	    public Iterable<Responsable> getResponsable() {
	        return responsableRepository.findAll();
	    }

	    public void deleteResponsable(final Long id) {
	    	responsableRepository.deleteById(id);
	    }

	    public Responsable saveResponsable(Responsable responsable) {
	    	Responsable savedResponsable = responsableRepository.save(responsable);
	        return savedResponsable;
	    }
	    public List<Responsable> getAllResponsable(){
	        return responsableRepository.findAll();
	      }

	    public Responsable updateResponsable(Responsable responsable, long id) {
			
			Responsable existingResponsable = responsableRepository.findById(id)
					.orElseThrow(() -> new Exeption("Responsable", "Id", id));

			existingResponsable.setNom(responsable.getNom());
			existingResponsable.setPrenom(responsable.getPrenom());
			existingResponsable.setLogin(responsable.getLogin());
			existingResponsable.setPasword(responsable.getPasword());
			existingResponsable.setEmail(responsable.getEmail());
			existingResponsable.setTelephone(responsable.getTelephone());
			existingResponsable.setDomaine(responsable.getDomaine());
			existingResponsable.setType(responsable.getType());
			existingResponsable.setEtat(responsable.getEtat());

			responsableRepository.save(existingResponsable);

			return existingResponsable;
		}

		public static List<Responsable> getAllExercice() {
			// TODO Auto-generated method stub
			return null;
		}
	   

	}

