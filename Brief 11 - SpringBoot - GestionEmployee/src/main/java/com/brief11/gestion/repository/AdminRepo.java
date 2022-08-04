package com.brief11.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brief11.gestion.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
