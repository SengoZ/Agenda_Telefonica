import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactos } from '../../models/contactos';
import { ContactosService } from '../../services/contactos.service';

@Component({
  selector: 'app-ficha-contacto',
  templateUrl: './ficha-contacto.component.html',
  styleUrls: ['./ficha-contacto.component.css']
})
export class FichaContactoComponent implements OnInit {
  // serias dudas de que esto esté bien, porque es enseñar los datos de un contacno y no hacer uno nuevo maji
  contactos: Contactos = new Contactos();

  constructor(private router: Router, private contactosService: ContactosService) {

  }

  showContactos(): void {
    this.contactosService.fichacontacto(this.contactos)
        .subscribe( _ => {
          alert('Contacto generado de forma correcta.');
        });

  }

  ngOnInit() {
  }

}



