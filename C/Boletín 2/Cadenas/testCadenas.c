#include "cadenas.h"

void testBuscaCaracter();
void testEsPalindromo();
void testDigitoControlISBN();
void testPosicionesDeCaracter();

int main(void){
	testBuscaCaracter();
	testEsPalindromo();
	testDigitoControlISBN();
	testPosicionesDeCaracter();
	return 0;
}

void testBuscaCaracter(){
	Cadena cad;
	char c;
	int pos;
	printf("Teclea una cadena:\n");
	fflush(stdout);
	gets(cad);
	printf("Teclea un carácter:\n");
	fflush(stdout);
	c = getchar();
	pos = buscaCaracter(cad, c);
	if(pos >= 0){
		printf("El carácter %c está en la posición %d de la cadena %s\n", c, pos, cad);
	}
	else{
		printf("El carácter %c no está en la cadena %s\n", c, cad);
	}
}

void testEsPalindromo(){
	Cadena cad;
	printf("Teclee una palabra:\n");
	fflush(stdout);
	gets(cad);
	if(esPalindromo(cad) == CIERTO){
		printf("La palabra %s es palíndromo\n", cad);
	}
	else{
		printf("La palabra %s NO es palíndromo\n", cad);
	}
}

void testDigitoControlISBN(){
	Cadena cad;
	printf("Teclee una cadena de 9 caracteres:\n");
	fflush(stdout);
	gets(cad);
	printf("El carácter correspondiente al dígito de control es %c", digitoControlISBN(cad));
}

void testPosicionesDeCaracter(){
	Cadena cad;
	char c;
	Vector v;
	int n;
	printf("Teclea una cadena:\n");
	fflush(stdout);
	gets(cad);
	printf("Teclea un carácter:\n");
	fflush(stdout);
	c = getchar();
	posicionesDeCaracter(cad,c,v,&n);
	printf("El tamaño real del vector es %d\n", n);
	printf("Las posiciones donde se encuentran el carácter son:\n");
	escribeVector(v, n);
}

