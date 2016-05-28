#include "enteros.h"

Logico estaEn(int a, int b, double v){
	// v está en el intervalo [a,b]
	if(a>b){
		printf("El intervalo no está bien definido\n");
	}
	return a <= v && v <= b;
}

int mcd(int m, int n){
	int r, aux;
	if(m<n){
		aux=m;
		m=n;
		n=aux;
	}
	r=m%n;
	while(r > 0){
		if(m>n){
			m=n;
			n=r;
			r=m%n;
		}
	}
	return n;
}

int mcm(int m, int n){
	return (m*n)/mcd(m,n);
}

Logico esPrimo(int n){
	int i;
	if(n<=1){
		return FALSO;
	}
	for(i=2;i<=sqrt(n);i++){
		if(n%i == 0){
			return FALSO;
		}
	}
	return CIERTO;
}

int sumaPrimosMenores(int n){
	int i;
	int sum = 0;
	if (n<0){
		printf("El número introducido debe ser mayor a 0\n");
		return -1;
	}
	for(i=0;i<=n;i++){
		if(esPrimo(i) == CIERTO){
			sum = sum + i;
		}
	}
	return sum;
}

int sumaNoPrimosEntre(int a, int b){
	int i;
	int sum = 0;
	if (a<=0 || b<=0){
		printf("Los números introducidos deben ser mayor a 0\n");
		return -1;
	}
	if(a>b){
		printf("El intervalo no está bien definido\n");
	}
	for(i=a;i<=b;i++){
		if(esPrimo(i) == FALSO){
			sum = sum + i;
		}
	}
	return sum;
}

Logico formanTrianguloRectangulo(int a, int b, int c){
	double pit;
	if (a<=0 || b<=0 || c<=0){
		printf("Los números introducidos deben ser mayor a 0\n");
	}
	pit = sqrt(pow(b,2) + pow(c,2));
	if(a == pit){
		return CIERTO;
	}
	else{
		return FALSO;
	}
}
