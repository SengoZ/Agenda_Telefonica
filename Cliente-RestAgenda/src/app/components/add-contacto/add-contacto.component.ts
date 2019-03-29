import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactos } from '../../models/contactos';
import { Persona } from '../../models/personas';
import { ContactosService } from '../../services/contactos.service';
import { tap } from 'rxjs/operators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {
  persona: Persona = new Persona();
  constructor(private router: Router,
              private contactosService: ContactosService,
              private formBuilder: FormBuilder) {
    }
  addContactos(): void {
    this.contactosService.addContacto(this.persona)
    // tslint:disable-next-line:variable-name
    .subscribe( _data => {
      alert(`Usuario ${this.persona.nombre} generado de forma correcta.`);
      this.router.navigate(['contactos']);
    });
  }
  ngOnInit() {
  }
}