package com.spring.agenda.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.agenda.model.Provincia;

/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 * @version 1.0
 * 
 *Clase para verificar que están todas las provincias registradas en la BBDD
 *
 */

public class AgendaDatos{
	
	private String[] listaProv = {"Álava", "Albacete", "Alicante", "Almería", "Ávila", "Badajoz",
			"Baleares (Islas)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón", "Ciudad Real",
			"Córdoba", "A Coruña", "Cuenca", "Girona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva",
			"Huesca", "Jaén", "León", "Lleida", "La Rioja", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra",
			"Ourense", "Asturias", "Palencia", "Las Palmas", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife",
			"Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia",
			"Valladolid", "Vizcaya", "Zamora", "Zaragoza", "Ceuta", "Melilla"};
	
	/*
	 * @Autowired
	 * private AgendaDao repository;
	 */
	
	@Autowired
	private AgendaProvincias provincias;

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public void comprobarProvincias() {
		int cont=0;
		for(Provincia p:provincias.findAll()) {
			for(int i=0; i< listaProv.length; i++) {
				if(p.getProvincia().equalsIgnoreCase(listaProv[i])) {
					cont ++;
				}
			}
		}
		if(cont!=provincias.findAll().size()) {
			provincias.deleteAll();
			entityManager.createNativeQuery("ALTER TABLE provincia AUTO_INCREMENT = 1").executeUpdate(); 
			cargarProvinciasBBDD(listaProv);
		}
	}

	public void cargarProvinciasBBDD(String[] listaProv2) {
		for(String p: listaProv) {
			provincias.save(new Provincia(p));
		}
	}
	
	
}
