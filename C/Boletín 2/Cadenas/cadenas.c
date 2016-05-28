#include "cadenas.h"

int buscaCaracter(const Cadena cad, char c){
	int i;
	int pos = -1;
	for(i=0;i<strlen(cad);i++){
		if(cad[i] == c){
			pos = i;
			break;
		}
	}
	return pos;
}

Logico esPalindromo(const Cadena cad){
	int i;
	for(i=0;i<strlen(cad)/2;i++){
		if(cad[i] != cad[strlen(cad)-i-1]){
			return FALSO;
		}
	}
	return CIERTO;
}

char digitoControlISBN(const Cadena cad){
	int i, num;
	int valor = 0;
	char c;
	if(strlen(cad) !=9 ){
		c = '\0';
	}
	else{
		for(i=0;i<strlen(cad);i++){
			num = (int)(cad[i]-'0');
			valor = valor + (num * (i+1));
		}
		valor = valor%11;
		if(valor == 10){
			c = 'X';
		}
		else{
			c = (char)(valor+'0');
		}
	}
	return c;
}

void posicionesDeCaracter(const Cadena cad, char c, Vector v, Pint p){
	int i;
	int i2 = 0;
	for(i=0;i<strlen(cad);i++){
		if(cad[i] == c){
			v[i2] = i;
			i2++;
		}
	}
	*p=i2;
}

void escribeVector(const Vector v, int n){
	int i;
	printf("[");
	for(i=0;i<n;i++){
		printf("%d", v[i]);
		if(i < n-1){
			printf(", ");
		}
	}
	printf("]\n");
}
