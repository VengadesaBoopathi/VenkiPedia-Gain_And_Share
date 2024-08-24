package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Load;
import com.springrest.springrest.server.LoadServer;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class controllerAPI {
	
	@Autowired 
	LoadServer loadserver;
	
	@PostMapping("/load")
	String post(@RequestBody  Load load) {
		return loadserver.addLoad(load);
	}
	
	@GetMapping("/load")
	List<Load> get(){
		return loadserver.getLoad();
	} 
	 
	@GetMapping("/load/{loadId}")
	Load getSpecific(@PathVariable String loadId) {
		return loadserver.getspecificLoad(loadId);
	}
	
	@PutMapping("/load/{loadId}")
	String update(@RequestBody Load load,@PathVariable String loadId) {
		return loadserver.update(load,loadId);
	}
	
	@DeleteMapping("/load/{loadId}")
	String delete(@PathVariable String loadId) {
		return loadserver.delete(loadId);
	}
	
}
