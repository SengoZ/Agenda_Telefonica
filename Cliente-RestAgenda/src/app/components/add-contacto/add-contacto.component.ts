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

  
}
