/**
 * 
 */
package com.spring.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.agenda.model.Provincia;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Interfaz de datos de las provincias disponibles en la BBDD de la aplicación de Agenda telefónica
 *
 */
public interface AgendaProvincias extends JpaRepository<Provincia, Integer>{}
