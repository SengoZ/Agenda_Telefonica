import { Injectable } from '@angular/core';

//Nuevo
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Contactos } from '../models/contactos';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ContactosService {

  constructor(private http:HttpClient) {}

  private contactosUrl = 'http://localhost:8080/user-portal/contactos';


  public getContactos() {
    return this.http.get<Contactos[]>(this.contactosUrl);
  }
  public createContactos(contactos) {
    return this.http.post<Contactos>(this.contactosUrl, contactos);
  }
  public fichacontacto(contactos) {
    return this.http.post<Contactos>(this.contactosUrl, contactos);
  }
}