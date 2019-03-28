interface Telefono {
     idtelefono: number;
     telefono: string;
     idpersona: number;
}

interface Provincia{
     idprovincia: number;
     provincia: string;
}

interface Direccion {
     iddireccion: number;
     direccion: string;
     codpostal: string;
     localidad: string;
     idpersona: number;
     provincia: Provincia;
  }
  

export class Contactos {
     idpersona: number;
     nombre: string;
     apellido1: string;
     apellido2: string;
     dni: string;
     fechaNacimiento: Date;
     telefonos: Telefono[];
     direccions: Direccion;
}

export interface Contact {
     idpersona: number;
     nombre: string;
     apellido1: string;
     apellido2: string;
     dni: string;
     fechaNacimiento: Date;
     telefonos: Telefono[];
     direccions: Direccion;
}


