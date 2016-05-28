#include <stdio.h>
#include "grado.h"

void testInicializaGrado1();
void testInicializaGrado2();
void testInicializaGrado3();
void testInicializaGrado(const Cadena, const Cadena, const ArrayAsignaturas, int, const ArrayAsignaturas, int,	double);

int main(void){
	testInicializaGrado1();
	testInicializaGrado2();
	testInicializaGrado3();
	return 0;
}

void testInicializaGrado1(){
	printf("\n========Probando grado con un n�mero m�nimo de cr�ditos de asignaturas optativas no comprendido entre cero y el n�mero total de cr�ditos de asignaturas optativas======================================================================================");
	ArrayAsignaturas obligatorias;
	int numObligatorias;
	ArrayAsignaturas optativas;
	int numOptativas;
	numObligatorias=leeAsignaturasFichero("./res/asignaturas.txt",obligatorias);
	numOptativas=leeAsignaturasFichero("./res/asignaturasOptativas.txt",optativas);
	testInicializaGrado("Test","Test",obligatorias,numObligatorias,optativas,numOptativas,120.0);
}

void testInicializaGrado2(){
	printf("\n========Probando grado con un n�mero de cr�ditos diferentes para todas asignaturas optativas======================================================================================");
	ArrayAsignaturas obligatorias;
	int numObligatorias;
	ArrayAsignaturas optativas;
	int numOptativas;
	numObligatorias=leeAsignaturasFichero("./res/asignaturas.txt",obligatorias);
	numOptativas=leeAsignaturasFichero("./res/asignaturasOptativas.txt",optativas);
	optativas[0].creditos=15.0; /* Para violar la restricci�n */
	testInicializaGrado("Test","Test",obligatorias,numObligatorias,optativas,numOptativas,12.0);
}

void testInicializaGrado3(){
	printf("\n========Probando grado======================================================================================");
	ArrayAsignaturas obligatorias;
	int numObligatorias;
	ArrayAsignaturas optativas;
	int numOptativas;
	numObligatorias=leeAsignaturasFichero("./res/asignaturas.txt",obligatorias);
	numOptativas=leeAsignaturasFichero("./res/asignaturasOptativas.txt",optativas);
	testInicializaGrado("Test","Test",obligatorias,numObligatorias,optativas,numOptativas,12.0);
}

void testInicializaGrado(const Cadena nombre, const Cadena centro, const ArrayAsignaturas obligatorias, int numObligatorias, const ArrayAsignaturas optativas, int numOptativas, double minimoCreditosOptativas){
	Grado g;
	int status;
	status = inicializaGrado(&g, nombre, centro, obligatorias, numObligatorias, optativas, numOptativas, minimoCreditosOptativas);
	if(status == -1){
		printf("\nHubo alg�n problema con la inicializaci�n.\n");
	}
	else{
		printf("\n==Se inicializ� el grado correctamente:\n");
		muestraGrado(g);
	}
}
