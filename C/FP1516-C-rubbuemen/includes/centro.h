#ifndef CENTRO_H_
#define CENTRO_H_

#include "cadena.h"
#include "espacio.h"
#include "logico.h"

typedef struct{
	Cadena nombre;
	Cadena direccion;
	int numeroPlantas;
	int numeroSotanos;
	ArrayEspacios espacios;
	int numEspacios;
} Centro;

typedef Centro *PCentro;

int inicializaCentro(PCentro res, const Cadena nombre, const Cadena direccion, int numeroPlantas, int numeroSotanos, const ArrayEspacios espacios, int numEspacios);
void muestraCentro (Centro c);

Logico checkNumPlantas(int numPlantas);
Logico checkNumSotanos(int numSotanos);
void copiaArray(ArrayEspacios destino, const ArrayEspacios origen, int numElem);

#endif
