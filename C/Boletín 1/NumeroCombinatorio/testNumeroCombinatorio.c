#include <stdio.h>
#include "numeroCombinatorio.h"

int main(void){
	int m, n;
	long res;
	printf("Teclee el numerador y el denominador de un número combinatorio:\n");
	fflush(stdout);
	scanf("%d%d", &m, &n);
	res = numeroCombinatorio(m, n);
	printf("%d sobre %d es %ld", m, n, res);
	return 0;
}
