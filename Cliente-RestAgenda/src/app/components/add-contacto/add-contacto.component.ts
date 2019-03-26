import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactos } from '../../models/contactos';
import { ContactosService } from '../../services/contactos.service';

@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {
  
  contactos: Contactos = new Contactos();

  constructor(private router: Router, private contactosService: ContactosService) {

  }

  createContactos(): void {
    this.contactosService.createContactos(this.contactos)
        .subscribe( data => {
          alert("Contacto generado de forma correcta.");
        });

  };

  ngOnInit() {
  };

}
