package com.rest.brief.project.stc.service;



	

	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.brief.project.stc.model.Responsable;
import com.rest.brief.project.stc.repsitory.ResponsableRespository;

import lombok.Data;

	@Data
	@Service
	public class ResponsableService {

	    @Autowired
	    private ResponsableRespository ResponsableRepository;

	    public Optional<Responsable> getResponsable(final Long id) {
	        return ResponsableRepository.findById(id);
	    }

	    public Iterable<Responsable> getResponsable() {
	        return ResponsableRepository.findAll();
	    }

	    public void deleteResponsable(final Long id) {
	    	ResponsableRepository.deleteById(id);
	    }

	    public Responsable saveResponsable(Responsable responsable) {
	    	Responsable savedResponsable = ResponsableRepository.save(responsable);
	        return savedResponsable;
	    }

	}

