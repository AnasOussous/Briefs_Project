package com.rest.brief.project.stc.repsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.brief.project.stc.model.Responsable;

@Repository
public interface ResponsableRespository extends CrudRepository<Responsable, Long> {
	

	
	

}
