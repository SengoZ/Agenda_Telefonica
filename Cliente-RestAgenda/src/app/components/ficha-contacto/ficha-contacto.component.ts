import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactos } from '../../models/contactos';
import { ContactosService } from '../../services/contactos.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-ficha-contacto',
  templateUrl: './ficha-contacto.component.html',
  styleUrls: ['./ficha-contacto.component.css']
})
export class FichaContactoComponent implements OnInit {
  // serias dudas de que esto esté bien, porque es enseñar los datos de un contacno y no hacer uno nuevo maji
  public contacto: Observable<Contactos[]>;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private contactosService: ContactosService) {

  }

  showContactos(): void {
    this.contactosService.fichacontacto(this.contacto)
        .subscribe( _ => {
          alert('Contacto generado de forma correcta.');
        });

  }

  ngOnInit() {
    this.contacto = JSON.parse(localStorage.getItem('ficha'));
    if(!this.contacto) {
      alert("Invalid action.")
      this.router.navigate(['contactos']);
      return;
    }
    console.log('userId: ', this.contacto);
    
  }

}



