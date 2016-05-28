#ifndef CADENAS_H_
#define CADENAS_H_

#include "stdio.h"
#include "string.h"

#define N 129

typedef enum{
	FALSO, CIERTO
} Logico;

typedef char Cadena[N];
typedef int* Pint;
typedef int Vector[N];

int buscaCaracter(const Cadena, char);
Logico esPalindromo (const Cadena);
char digitoControlISBN(const Cadena);
void posicionesDeCaracter(const Cadena, char, Vector, Pint);
void escribeVector(const Vector, int);

#endif
