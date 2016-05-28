#include "centro.h"
#include <stdio.h>
#include <string.h>

int inicializaCentro(PCentro res, const Cadena nombre, const Cadena direccion, int numeroPlantas, int numeroSotanos, const ArrayEspacios espacios, int numEspacios){
	int status = 0;
	if(!checkNumPlantas(numeroPlantas)){
		fprintf(stderr, "Error en el número de plantas del espacio: %d\n", numeroPlantas);
		status = -1;
	}
	else if(!checkNumSotanos(numeroSotanos)){
		fprintf(stderr, "Error en el número de sotanos del espacio: %d\n", numeroSotanos);
		status = -1;
	}
	else{
		strcpy(res->nombre, nombre);
		strcpy(res->direccion, direccion);
		res->numeroPlantas = numeroPlantas;
		res->numeroSotanos = numeroSotanos;
		copiaArray(res->espacios, espacios, numEspacios);
		res->numEspacios = numEspacios;
	}
	return status;
}

void muestraCentro(Centro c) {
	printf("Nombre: %s\n", c.nombre);
	printf("Dirección: %s\n", c.direccion);
	printf("Número de plantas: %d\n", c.numeroPlantas);
	printf("Número de plantas: %d\n", c.numeroSotanos);
	printf("-----Espacios:\n");
	muestraEspacios(c.espacios, c.numEspacios);
	printf("Número de espacios: %d\n", c.numEspacios);
}

Logico checkNumPlantas(int numPlantas){
	Logico res = FALSO;
	if(numPlantas > 0){
		res = CIERTO;
	}
	return res;
}

Logico checkNumSotanos(int numSotanos){
	Logico res = FALSO;
	if(numSotanos >= 0){
		res = CIERTO;
	}
	return res;
}

void copiaArray(ArrayEspacios destino, const ArrayEspacios origen, int numElem){
	int i;
	for(i=0;i<numElem;i++){
		destino[i] = origen[i];
	}
}
