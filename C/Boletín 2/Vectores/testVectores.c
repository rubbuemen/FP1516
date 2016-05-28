#include "vectores.h"

void testLeeEscribeMediaVector();
void testProductoEscalar();
void testMayoresVector();

int main(void){
	testLeeEscribeMediaVector();
	testProductoEscalar();
	testMayoresVector();
	return 0;
}

void testLeeEscribeMediaVector(){
	int n;
	Vector v;
	printf("Teclea el número de elementos a introducir: ");
	fflush(stdout);
	scanf("%d", &n);
	if(n > TAM_VECTOR){
		printf("El número máximo de elementos es %d\n", TAM_VECTOR);
	}
	else{
		leeVector(v, n);
		escribeVector(v, n);
		mediaAritmetica(v, n);
	}
}

void testProductoEscalar(){
	int n;
	Vector v1, v2;
	printf("Teclea el número de elementos a introducir: ");
	fflush(stdout);
	scanf("%d", &n);
	if(n > TAM_VECTOR){
		printf("El número máximo de elementos es %d\n", TAM_VECTOR);
	}
	else{
		leeVector(v1, n);
		leeVector(v2, n);
		productoEscalar(v1, v2, n);
	}
}

void testMayoresVector(){
	int n;
	double x;
	Vector v, w;
	printf("Teclea el número de elementos a introducir: ");
	fflush(stdout);
	scanf("%d", &n);
	if(n > TAM_VECTOR){
		printf("El número máximo de elementos es %d\n", TAM_VECTOR);
	}
	else{
		leeVector(v, n);
		printf("Teclea un valor double:\n");
		fflush(stdout);
		scanf("%lf", &x);
		mayoresVector(v, &n, x, w);
		printf("El tamaño real del vector es %d\n", n);
		printf("Los elementos del vector son:\n");
		escribeVector(w, n);
	}
}
