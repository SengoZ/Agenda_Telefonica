package com.spring.agenda.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.agenda.model.Direccion;
import com.spring.agenda.model.Persona;
import com.spring.agenda.model.Telefono;
import com.spring.agenda.services.AgendaService;

@RestController
@RequestMapping({"/person"})
public class AgendaController {

	@Autowired
	private AgendaService servicios;
	
	@GetMapping
    public List<Persona> list(){
        System.out.println("-----------------------------------------------------------------listaaa");
        return servicios.list();
    }
	@PostMapping
	public void add(@ModelAttribute Persona pers, @ModelAttribute Telefono tel, @ModelAttribute Direccion dir) {
		System.out.println("------------------------------------- he entrado al metodo pero no he guardado");
		System.out.println(tel.toString());
		System.out.println(pers.toString());
		
		//INYECTAMOS DENTRO DEL TELEFONO AÑADIDO LA PERSONA A LA QUE VA A SER AÑADIDA
		//CREAMOS UNA LISTA, A LA CUAL AÑADIMOS EL TELEFONO Y ESA LISTA LA INYECTAMOS EN PERSONA
		tel.setPersona(pers);
		List<Telefono> listaTelefonica = new ArrayList<>();
		listaTelefonica.add(tel);
		pers.setTelefonos(listaTelefonica);
		
		dir.setPersona(pers);
		List<Direccion> listaDirecciones = new ArrayList<>();
		listaDirecciones.add(dir);
		pers.setDireccions(listaDirecciones);
		
		servicios.add(pers);
		System.out.println("------------------------------------- he guardado, soy dios");
	}
}
