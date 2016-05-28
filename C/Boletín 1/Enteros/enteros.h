
#ifndef ENTEROS_H_
#define ENTEROS_H_

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

typedef enum{
	FALSO, CIERTO
} Logico;

Logico estaEn(int a, int b, double v);
int mcd(int m, int n);
int mcm(int m , int n);
Logico esPrimo(int n);
int sumaPrimosMenores(int n);
int sumaNoPrimosEntre(int a, int b);
Logico formanTrianguloRectangulo(int a, int b, int c);

#endif
