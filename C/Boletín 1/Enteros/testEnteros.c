#include "enteros.h"

void testEstaEn();
void testMCD();
void testMCM();
void testEsPrimo();
void testSumaPrimosMenores();
void testSumaNoPrimosEntre();
void testFormanTrianguloRectangulo();

int main(void){
	testEstaEn();
	testMCD();
	testMCM();
	testEsPrimo();
	testSumaPrimosMenores();
	testSumaNoPrimosEntre();
	testFormanTrianguloRectangulo();
	return 0;
}

void testEstaEn(){
	int a, b;
	double v;
	printf("Teecle el intervalo [a,b]:\n");
	fflush(stdout);
	scanf("%d%d", &a, &b);
	printf("Teclee un valor:\n");
	fflush(stdout);
	scanf("%lf", &v);
	if(estaEn(a,b,v) == CIERTO){
		printf("%lf está en el intervalo [%d, %d]\n", v, a, b);
	}
	else{
		printf("%lf NO está en el intervalo [%d, %d]\n", v, a, b);
	}
}

void testMCD(){
	int m, n;
	printf("Teecle dos números:\n");
	fflush(stdout);
	scanf("%d%d", &m, &n);
	printf("El mcd de %d y %d es ", m, n);
	printf("%d\n",mcd(m,n));
}

void testMCM(){
	int m, n;
	printf("Teecle dos números:\n");
	fflush(stdout);
	scanf("%d%d", &m, &n);
	printf("El mcm de %d y %d es ", m, n);
	printf("%d\n",mcm(m,n));
}

void testEsPrimo(){
	int n;
	printf("Teecle un número:\n");
	fflush(stdout);
	scanf("%d", &n);
	if(esPrimo(n) == CIERTO){
		printf("%d es primo\n", n);
	}
	else{
		printf("%d NO es primo\n", n);
	}
}

void testSumaPrimosMenores(){
	int n;
	printf("Teecle un número:\n");
	fflush(stdout);
	scanf("%d", &n);
	printf("La suma de los primos menores o igual a %d es:\n", n);
	printf("%d\n", sumaPrimosMenores(n));
}

void testSumaNoPrimosEntre(){
	int a, b;
	printf("Teecle el intervalo [a,b]:\n");
	fflush(stdout);
	scanf("%d%d", &a, &b);
	printf("La suma de los no primos comprendidos en el intervalo [%d, %d] es\n", a, b);
	printf("%d\n", sumaNoPrimosEntre(a,b));
}

void testFormanTrianguloRectangulo(){
	int a, b, c;
	printf("Teecle los lados del triángulo:\n");
	fflush(stdout);
	scanf("%d%d%d", &a, &b, &c);
	if(formanTrianguloRectangulo(a,b,c) == CIERTO){
		printf("Los lados forman un triángulo rectángulo");
	}
	else{
		printf("Los lados NO forman un triángulo rectángulo");
	}
}
