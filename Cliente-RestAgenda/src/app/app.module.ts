import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactosComponent } from './components/contactos/contactos.component';
import { AddContactoComponent } from './components/add-contacto/add-contacto.component';
import { FichaContactoComponent } from './components/ficha-contacto/ficha-contacto.component';


import { ContactosService } from './services/contactos.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@NgModule({
  declarations: [
    AppComponent,
    ContactosComponent,
    AddContactoComponent,
    FichaContactoComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    ReactiveFormsModule
  ],
  providers: [ContactosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
