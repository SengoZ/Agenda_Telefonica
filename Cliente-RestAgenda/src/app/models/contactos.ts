interface Telefono {
     idtelefono: number;
     telefono: string;
     idpersona: number;
}

export class Contactos {
     idpersona: number;
     nombre: string;
     apellido1: string;
     apellido2: string;
     telefonos: Telefono[];

}

export interface Contact {
     idpersona: number;
     nombre: string;
     apellido1: string;
     apellido2: string;
     telefonos: Telefono[];

}
