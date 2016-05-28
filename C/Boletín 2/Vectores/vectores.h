#ifndef VECTORES_H_
#define VECTORES_H_

#include <stdio.h>

#define TAM_VECTOR 20

typedef double Vector[TAM_VECTOR];

void leeVector(Vector, int);
void escribeVector(const Vector, int);
void mediaAritmetica(const Vector, int);
void productoEscalar(const Vector, const Vector, int);
void mayoresVector(const Vector, int*, double, Vector);

#endif
