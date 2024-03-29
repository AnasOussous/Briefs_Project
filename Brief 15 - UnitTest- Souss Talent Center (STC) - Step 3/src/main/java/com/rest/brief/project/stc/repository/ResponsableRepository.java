package com.rest.brief.project.stc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rest.brief.project.stc.model.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
	

}
