package com.rest.brief.project.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.rest.brief.project.stc.model.Responsable;
import com.rest.brief.project.stc.service.ResponsableService;

@RestController
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/responsables")
    public Iterable<Responsable> getResponsables() {
        return responsableService.getResponsable();
    }

}