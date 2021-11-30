package com.dscode.aplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${some.value}")
	private String myValue;
	
	@GetMapping(path="/myValue")
	public String myValue() {
		return this.myValue;
	}
	

	private final static Logger logger= LoggerFactory.getLogger(TestController.class);
	
	
	@GetMapping("/")
	public ResponseEntity<String> index() {
		logger.info("Llamada al endpoint inicial." + this.myValue);
		return new ResponseEntity<String>(HttpStatus.OK).ok("Hola Reto" + this.myValue);
	}
	
}
