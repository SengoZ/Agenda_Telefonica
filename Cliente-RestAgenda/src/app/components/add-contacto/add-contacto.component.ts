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
    this.addContactos();
    this.formGroup = this.formBuilder.group({

      nomb: ['', Validators.required],
      // ape1: ['', Validators.required],
      // ape2: ['', Validators.required],
    //  dni: ['', Validators.required],
     // fecha ['', Validators.required];
      tel: ['', Validators.required],
    });


  }

  public createContact() {
    const contact: Contactos = {
      nombre: this.formGroup.get('nomb').value,
      apellido1: this.formGroup.get('ape1').value,
      apellido2: this.formGroup.get('ape2').value,
      idpersona: 0,
      dni: this.formGroup.get('dni').value,
      fechaNacimiento: this.formGroup.get('fecha').value,
      telefonos: [this.formGroup.get('tel').value]
    };

    // tslint:disable-next-line:no-string-literal
    // this.formGroup['telefono'] = [this.formGroup.get('telefono').value, '651'] as string[];
    console.log(this.formGroup.value);


  }

}
