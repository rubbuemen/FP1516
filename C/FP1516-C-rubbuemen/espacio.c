#include "espacio.h"
#include <stdio.h>
#include <string.h>

int inicializaEspacio(PEspacio res, const Cadena nombre, int planta, int capacidad){
	int status = 0;
	if(!checkCapacidad(capacidad)){
		fprintf(stderr, "Error en la capacidad de espacio: %d\n", capacidad);
		status = -1;
	}
	else{
		strcpy(res->nombre, nombre);
		res->planta = planta;
		res->capacidad = capacidad;
	}
	return status;
}

void muestraEspacio(Espacio es) {
	printf("Nombre: %s\n", es.nombre);
	printf("Planta: %d\n", es.planta);
	printf("Capacidad: %d\n", es.capacidad);
}

void muestraEspacios(const ArrayEspacios res, int nEspacios) {
	int i;
	for (i = 0; i < nEspacios; i++) {
		printf("Espacio número %d.\n", i + 1);
		muestraEspacio(res[i]);
		printf("------------------------\n");
	}
}

int leeEspaciosFichero(const Cadena nombreFichero, ArrayEspacios res){
	FILE *f;
	int n;
	int i = 0;
	f=fopen(nombreFichero,"r");
	if(f == NULL){
		printf("Fichero %s no encontrado", nombreFichero);
		n=0;
	}
	else{
		leeEspacioFichero(f,&res[i]);
		while(!feof(f) && i < MAXESPACIOS - 1){
			i++;
			leeEspacioFichero(f,&res[i]);
		}
		n=i;
		fclose(f);
	}
	return n;
}

void leeEspacioFichero(FILE *f, PEspacio es){
	char c;
	fgets(es->nombre,MAXCAR,f);
	quitaSaltoDeLinea(es->nombre);
	fscanf(f,"%d%c",&es->planta,&c);
	fscanf(f,"%d%c",&es->capacidad,&c);
}

Logico checkCapacidad(int capacidad){
	Logico res = FALSO;
	if(capacidad > 0){
		res = CIERTO;
	}
	return res;
}
