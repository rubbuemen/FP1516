#include <stdio.h>
#include "centro.h"

void testInicializaCentro1();
void testInicializaCentro2();
void testInicializaCentro3();
void testInicializaCentro(const Cadena, const Cadena, int, int, const ArrayEspacios, int);

int main(void){
	testInicializaCentro1();
	testInicializaCentro2();
	testInicializaCentro3();
	return 0;
}

void testInicializaCentro1(){
	printf("\n========Probando centro con un n�mero de plantas inferior a 1======================================================================================");
	ArrayEspacios espacios;
	int numEspacios;
	numEspacios=leeEspaciosFichero("./res/espacios.txt",espacios);
	testInicializaCentro("Test","Test",0,0,espacios,numEspacios);
}

void testInicializaCentro2(){
	printf("\n========Probando centro con un n�mero de sotanos inferior a 0=====================================================================================");
	ArrayEspacios espacios;
	int numEspacios;
	numEspacios=leeEspaciosFichero("./res/espacios.txt",espacios);
	testInicializaCentro("Test","Test",2,-1,espacios,numEspacios);
}

void testInicializaCentro3(){
	printf("\n========Probando centro======================================================================================");
	ArrayEspacios espacios;
	int numEspacios;
	numEspacios=leeEspaciosFichero("./res/espacios.txt",espacios);
	testInicializaCentro("Test","Test",5,2,espacios,numEspacios);
}

void testInicializaCentro(const Cadena nombre, const Cadena direccion, int numeroPlantas, int numeroSotanos, const ArrayEspacios espacios, int numEspacios){
	Centro c;
	int status;
	status = inicializaCentro(&c, nombre, direccion, numeroPlantas, numeroSotanos, espacios, numEspacios);
	if(status == -1){
		printf("\nHubo alg�n problema con la inicializaci�n.\n");
	}
	else{
		printf("\n==Se inicializ� el grado correctamente:\n");
		muestraCentro(c);
	}
}
