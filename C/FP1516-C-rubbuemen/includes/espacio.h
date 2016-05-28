#ifndef ESPACIO_H_
#define ESPACIO_H_

#include "cadena.h"
#include "logico.h"
#include <stdio.h>

#define MAXESPACIOS 200

typedef struct{
	Cadena nombre;
	int planta;
	int capacidad;
} Espacio;

typedef Espacio *PEspacio;
typedef Espacio ArrayEspacios[MAXESPACIOS];

int inicializaEspacio(PEspacio res, const Cadena nombre, int planta, int capacidad);
void muestraEspacio (Espacio e);
void muestraEspacios(const ArrayEspacios res, int nEspacios);
int leeEspaciosFichero(const Cadena nombreFichero, ArrayEspacios res);

Logico checkCapacidad(int capacidad);
void leeEspacioFichero(FILE *f, PEspacio es);

#endif
