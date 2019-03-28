import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactos } from '../../models/contactos';
import { Contact } from '../../models/contactos';
import { ContactosService } from '../../services/contactos.service';

import { tap } from 'rxjs/operators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {

  contacto: Contactos;

  private contact: Contact;
  public formGroup: FormGroup;

  constructor(private router: Router,
              private contactosService: ContactosService,
              private formBuilder: FormBuilder) {
  }

  addContactos(): void {
    this.contactosService.addContacto(this.contact)
      .pipe(
        tap((data) => alert(`Contacto ${data.nombre} generado de forma correcta`))
      )
      .subscribe();
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({

      nomb: ['amador', Validators.required],
      ape1: ['caceres', Validators.required],
      ape2: ['rubio', Validators.required],
      dni: [111, Validators.required],
      fecha: ['', Validators.required],
      tel: ['651547466', Validators.required],
    });
  }

  public createContact() {
    const contact: Contactos = {
      idpersona: 0,
      nombre: this.formGroup.get('nomb').value,
      apellido1: this.formGroup.get('ape1').value,
      apellido2: this.formGroup.get('ape2').value,
      dni: this.formGroup.get('dni').value,
      fechaNacimiento: this.formGroup.get('fecha').value,
      telefonos: [this.formGroup.get('tel').value]
    };
    // tslint:disable-next-line:no-unused-expression
    console.log('heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee');
    console.log(this.formGroup);

    this.contactosService.addContacto(this.formGroup.value);
    console.log('ya he salido de servicios colega, ¿ha salido bien?? animo tronco');
  }
}
