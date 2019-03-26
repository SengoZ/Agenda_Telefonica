package com.spring.agenda.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.agenda.model.Persona;

@RestController
@RequestMapping({"/"})
public class AgendaController {

	@PostMapping
	public Persona add(@RequestBody Persona pers) {
		return null;
	}
}
