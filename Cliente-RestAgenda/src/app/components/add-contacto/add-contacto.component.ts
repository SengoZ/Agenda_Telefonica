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

  contactos: Contactos = new Contactos();

  private contact: Contact;
  public formGroup: FormGroup;

  constructor(private router: Router,
              private contactosService: ContactosService,
              private formBuilder: FormBuilder) {

  }

  createContactos(): void {
    this.contactosService.createContactos(this.contactos)
      .pipe(
        tap((data) => alert(`Contacto ${data.nombre} generado de forma correcta`))
      )
      .subscribe();

  }

  ngOnInit() {
    this.createContactos();
    this.formGroup = this.formBuilder.group({

      name: ['', Validators.required],
      telefono: ['', Validators.required]
    });


  }

  public createContact() {
    // const contact: Contact = {
    //   nombre: this.formGroup.get('name').value,
    //   apellido1: '',
    //   apellido2: '',
    //   idpersona: 0,
    //   telefonos: []
    // };
    // tslint:disable-next-line:no-string-literal
    this.formGroup['telefono'] = [this.formGroup.get('telefono').value, '651'] as string[];
    console.log(this.formGroup.value);


  }

}
