import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactos } from '../../models/contactos';
import { ContactosService } from '../../services/contactos.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-contactos',
  templateUrl: './contactos.component.html',
  styleUrls: ['./contactos.component.css']
})
export class ContactosComponent implements OnInit {

  public contactos: Observable<Contactos[]>;
  constructor(private router: Router, private contactosService: ContactosService) {

  }
  ngOnInit() {
    this.contactos = this.contactosService.getContactos();
  }
}
