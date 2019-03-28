package com.spring.agenda.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.agenda.model.Direccion;
import com.spring.agenda.model.Persona;
import com.spring.agenda.model.Provincia;
import com.spring.agenda.model.Telefono;
import com.spring.agenda.services.AgendaService;
/**
 * Clase AgendaController. Realiza y gestiona las peticiones REST que lleguen para listar, añadir, borrar y editar un contacto
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/person"})
public class AgendaController {

	/**
	 * Inyección en la interface AgendaService de su implementacion
	 */
	@Autowired
	private AgendaService servicios;
	 /**
	  * Método para listar los contactos existentes en la BBDD
	  * @return List<Personas>: devuelve una lista de tipo Personas
	  */
	@GetMapping
    public List<Persona> list(){
        return servicios.list();
    }
	
	/**
	 * Método para añadir un contacto a la base de datos
	 * @param pers: Recoge el objeto tipo Json y introduce los atributos correspondientes de persona
	 * @param tel: Recoge el objeto tipo Json y introduce los atributos correspondientes de Telefono
	 * @param dir: Recoge el objeto tipo Json y introduce los atributos correspondientes de direccion
	 * @param prov: Recoge el objeto tipo Json y introduce los atributos correspondientes de Provincia
	 */
	@PostMapping
	public void add(@ModelAttribute Persona pers, @ModelAttribute Telefono tel, @ModelAttribute Direccion dir, @ModelAttribute Provincia prov) {
		
		//INYECTAMOS DENTRO DEL TELEFONO AÑADIDO LA PERSONA A LA QUE VA A SER AÑADIDA
		//CREAMOS UNA LISTA, A LA CUAL AÑADIMOS EL TELEFONO Y ESA LISTA LA INYECTAMOS EN PERSONA
		tel.setPersona(pers);
		List<Telefono> listaTelefonica = new ArrayList<>();
		listaTelefonica.add(tel);
		pers.setTelefonos(listaTelefonica);
		
		//INYECTAMOS DENTRO DE LA DIRECCION AÑADIDA LA PERSONA A LA QUE VA A SER AÑADIDA
		//CREAMOS UNA LISTA, A LA CUAL AÑADIMOS LA DIRECCION Y ESA LISTA LA INYECTAMOS EN PERSONA
		dir.setPersona(pers);
		List<Direccion> listaDirecciones = new ArrayList<>();
		listaDirecciones.add(dir);	
		
		//A LA PROVINCIA CORRESPONDIENTE, DEL CUAL COGEMOS EL ID PROVINCIA, LE ASIGNAMOS UNA DIRECCION
		//Y ESA PROVINCIA A SU VEZ, LA RELACIONAMOS CON UNA DIRECCION
		prov.setDireccions(listaDirecciones);
		dir.setProvincia(prov);
		
		//FINALEMENTE INYECTAMOS LA LISTA DE DIRECCIONES A PERSONAS
		pers.setDireccions(listaDirecciones);
		
		//AÑADIMOS DENTRO DE LA BASE DE DATOS LA PERSONA JUNTO CON LA DIRECCION Y SU PROVINCIA ASOCIADA Y EL TELEFONO
		servicios.add(pers);
	}
	/**
	 * Método para modificar una persona, la cual la recibimos como un atributo de tipo Persona, junto con su Id y la sobreescribimos.
	 * @param idpers: id de la persona que estamos modificando.
	 * @param pers: Atributo tipo Persona con sus atributos modificados.
	 */
	@PutMapping(path = {"/{idpersona}"})
	public void edit(@PathVariable("idpersona") int idpers, @ModelAttribute Persona pers) {
		/*//Estas dos sentencias son para probar como no machacamos los valores de la persona que recogemos como parámetro, y ver que efectivamente no cambian
		Persona nueva = servicios.buscarId(idpers);
		nueva.setNombre(pers.getNombre());
		*/
		pers.setIdpersona(idpers);
		servicios.edit(pers);
	}
	
	/**
	 * Método para borrar un contactor dado un identificador
	 * @param idpersona Recibe el parámetro de entrada id de la persona que se eliminará
	 */
	@DeleteMapping(path = { "/{idpersona}" })
	public void deletecontacto(@PathVariable("idpersona") int idpersona) {
		System.out.println("********************************************************************************"+idpersona);
		servicios.delete(idpersona);
	}
}
