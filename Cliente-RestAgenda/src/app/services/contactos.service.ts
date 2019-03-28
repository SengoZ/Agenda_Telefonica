import { Injectable } from '@angular/core';

// Nuevo
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Contactos } from '../models/contactos';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ContactosService {

  constructor(private http: HttpClient) {}

  private contactosUrl = 'http://localhost:8080/person';


  public getContactos(): Observable<Contactos[]> {
    return this.http.get<Contactos[]>(this.contactosUrl);
  }

  // Con Observable, tipamos el tipo de objeto que va a devolver, diciendo que es un Contacto
  public addContacto(contacto: Contactos): Observable<Contactos> {
    console.log('holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
    console.log(contacto);
    return this.http.post<Contactos>(`${this.contactosUrl}`, contacto);
  }
  public fichacontacto(contactos) {
    return this.http.get<Contactos>(`${this.contactosUrl}/${contactos.idpersona}`);
  }
  // http://localhost:8080/person/id
  public deletecontacto(contactos) {
    console.log(contactos.idpersona);
    console.log((this.contactosUrl + '/' + contactos.idpersona));
    return this.http.delete(this.contactosUrl + '/' + contactos.idpersona);
  }
}
