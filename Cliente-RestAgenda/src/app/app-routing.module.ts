import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactosComponent }   from './components/contactos/contactos.component';
import {AddContactoComponent} from './components/add-contacto/add-contacto.component';
import {FichaContactoComponent} from './components/ficha-contacto/ficha-contacto.component';

const routes: Routes = [
  {  path: 'contactos', component: ContactosComponent },
  { path: 'addcontacto', component: AddContactoComponent },
  { path: 'fichacontacto', component: FichaContactoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
