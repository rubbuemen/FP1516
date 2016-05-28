#include <stdio.h>
#include <string.h>
#include "cadena.h"
#include "espacio.h"

void testLeeEspaciosFichero(const Cadena nombreFichero);
void testInicializaEspacio1();
void testInicializaEspacio2();
void testInicializaEspacio(const Cadena, int, int);

int main(void){
	testLeeEspaciosFichero("./res/espacios.txt");
	testInicializaEspacio1();
	testInicializaEspacio2();
	return 0;
}

void testLeeEspaciosFichero(const Cadena nombreFichero) {
	printf("\n========Probando espacio con lectura de fichero======================================================================================\n");
	ArrayEspacios espacios;
	int nEspacio;
	nEspacio=leeEspaciosFichero(nombreFichero, espacios);
	muestraEspacios(espacios,nEspacio);
}

void testInicializaEspacio1(){
	printf("\n========Probando espacio con una capacidad menor a 0======================================================================================");
	testInicializaEspacio("A3.10", 3, 0);
}

void testInicializaEspacio2(){
	printf("\n========Probando espacio======================================================================================");
	testInicializaEspacio("A3.10", 3, 210);
}

void testInicializaEspacio(const Cadena nombre, int planta, int capacidad){
	Espacio res;
	int status = inicializaEspacio(&res, nombre, planta, capacidad);
	if (status == -1) {
		printf("\nHubo algún problema con la inicialización.\n");
	} else {
		printf("\n==Se inicializó el espacio correctamente:\n");
		muestraEspacio(res);
	}
}
