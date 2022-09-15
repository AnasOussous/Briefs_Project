package com.Souss_Health_Brief16.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.Souss_Health_Brief16.model.Command;
import com.Souss_Health_Brief16.repository.CommandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommandController {
	
	 @Autowired
	  private CommandRepository commandRepository;
	 
	  @PreAuthorize("hasRole('CLIENT')")
	  @GetMapping("/commands")     
	  public List<Command> getAllCommand() {
	    return commandRepository.findAll();
	  }
	  
	  @PreAuthorize("hasRole('CLIENT')")
	  @GetMapping("/commands/{id}")
	  public ResponseEntity<Command> getCommandById(@PathVariable(value = "id") Long id)
	      throws ResourceNotFoundException {
		  Command command =
				  commandRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Command not found on :: " + id));
	    return ResponseEntity.ok().body(command);
	  }
	  
	  @PreAuthorize("hasRole('CLIENT')")
	  @PostMapping("/commands")
	  public Command createCommand(@Valid @RequestBody Command command) {
	    return commandRepository.save(command);
	  }
	  
	  @PreAuthorize("hasRole('CLIENT')")
	  @PutMapping("/commands/{id}")
	  public ResponseEntity<Command> updateCommand(
	      @PathVariable(value = "id") Long id, @Valid @RequestBody Command CommandDetails)
	      throws ResourceNotFoundException {

		  Command command =
				  commandRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Command not found on :: " + id));
		  
		  command.setDateCommand(CommandDetails.getDateCommand());
		  command.setProduitsId(CommandDetails.getProduitsId());
		  command.setTotal(CommandDetails.getTotal());
		  
	    final Command updatedCommand = commandRepository.save(command);
	    return ResponseEntity.ok(updatedCommand);
	  }
	  
	  @PreAuthorize("hasRole('CLIENT')")
	  @DeleteMapping("/commands/{id}")
	  public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long id) throws Exception {
		  Command command =
				  commandRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Command not found on :: " + id));

		  commandRepository.delete(command);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }

}
