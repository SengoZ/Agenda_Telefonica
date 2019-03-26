/**
 * 
 */
package com.spring.agenda.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.agenda.model.Persona;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Interfaz de datos de la aplicación de Agenda telefónica
 *
 */

@Repository
public interface AgendaDao extends JpaRepository<Persona, Integer> {}
