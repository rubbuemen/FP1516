#ifndef ASIGNATURA_H_
#define ASIGNATURA_H_

#include "cadena.h"
#include "logico.h"
#include <stdio.h>

#define CODIGOLEN 8
#define MAXASIG 100

typedef char Codigo[CODIGOLEN];

typedef struct{
	Cadena nombre;
	Codigo codigo;
	double creditos;
	int curso;
	Cadena departamento;

} Asignatura;

typedef Asignatura *PAsignatura;
typedef Asignatura ArrayAsignaturas[MAXASIG];

int inicializaAsignatura(PAsignatura res, const Cadena nombre, const Codigo codigo, double creditos, int curso, const Cadena departamento);
void muestraAsignatura(Asignatura a);
void muestraAsignaturas(const ArrayAsignaturas res, int nAsig);

Logico checkCodigo(const Codigo codigo);
Logico checkCreditos(double creditos);
Logico checkCurso(int curso);

int leeAsignaturasFichero(const Cadena nombreFichero, ArrayAsignaturas res);
void leeAsignaturaFichero(FILE *f, PAsignatura a);

#endif
