#include <stdio.h>
#include <string.h>
#include "cadena.h"
#include "asignatura.h"

void testLeeAsignaturasFichero(const Cadena nombreFichero);
void testInicializaAsignatura1();
void testInicializaAsignatura2();
void testInicializaAsignatura3();
void testInicializaAsignatura4();
void testInicializaAsignatura(const Cadena, const Codigo, double, int, const Cadena);

int main(void){
	testLeeAsignaturasFichero("./res/asignaturas.txt");
	testInicializaAsignatura1();
	testInicializaAsignatura2();
	testInicializaAsignatura3();
	testInicializaAsignatura4();
	return 0;
}

void testLeeAsignaturasFichero(const Cadena nombreFichero) {
	printf("\n========Probando asignatura con lectura de fichero======================================================================================\n");
	ArrayAsignaturas asignaturas;
	int nAsig;
	nAsig=leeAsignaturasFichero(nombreFichero, asignaturas);
	muestraAsignaturas(asignaturas,nAsig);
}

void testInicializaAsignatura1(){
	printf("\n========Probando asignatura con un n�mero de m�s en el c�digo======================================================================================");
	testInicializaAsignatura("Fundamentos de Programaci�n","12345767", 12.0, 1, "LSI");
}

void testInicializaAsignatura2(){
	printf("\n========Probando asignatura con un n�mero de cr�ditos menor a 0======================================================================================");
	testInicializaAsignatura("Fundamentos de Programaci�n","1234567", -1.0, 1, "LSI");
}

void testInicializaAsignatura3(){
	printf("\n========Probando asignatura con un curso inexistente======================================================================================");
	testInicializaAsignatura("Fundamentos de Programaci�n","1234567", 12.0, 6, "LSI");
}

void testInicializaAsignatura4(){
	printf("\n========Probando asignatura======================================================================================");
	testInicializaAsignatura("Fundamentos de Programaci�n","1234567", 12.0, 1, "LSI");
}

void testInicializaAsignatura(const Cadena nombre, const Codigo codigo, double creditos, int curso, const Cadena departamento){
	Asignatura asig;
	int status = inicializaAsignatura(&asig, nombre, codigo, creditos, curso, departamento);
	if (status == -1) {
		printf("\nHubo alg�n problema con la inicializaci�n.\n");
	} else {
		printf("\n==Se inicializ� la asignatura correctamente:\n");
		muestraAsignatura(asig);
	}
}
