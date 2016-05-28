#include <stdio.h>

int main(void){
	char nombre[30];
	int edad;
	printf("Introduce tu nombre y tu edad:\n");
	fflush(stdout);
	scanf("%s", nombre);
	scanf("%d", &edad);
	printf("Hola %s; tienes %d años\n", nombre, edad);
	return 0;
}
