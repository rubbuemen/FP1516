#include "vectores.h"

void leeVector(Vector v, int n){
	int i;
	printf("Va a introducir %d elementos\n", n);
	for(i=0;i<n;i++){
		printf("Elemento[%d]: ", i);
		fflush(stdout);
		scanf("%lf", &v[i]);
	}
}

void escribeVector(const Vector v, int n){
	int i;
	printf("[");
	for(i=0;i<n;i++){
		printf("%lf", v[i]);
		if(i < n-1){
			printf(", ");
		}
	}
	printf("]\n");
}

void mediaAritmetica(const Vector v, int n){
	int i;
	double media;
	double sum = 0.0;
	for(i=0;i<n;i++){
		sum = sum + v[i];
	}
	if(i == 0){
		media = 0.0;
	}
	else{
		media = sum/i;
	}
	printf("Su media aritmética es %lf:\n", media);
}

void productoEscalar(const Vector v1, const Vector v2, int n){
	int i;
	int producto = 0;
	for(i=0;i<=n;i++){
		for(i=0;i<=n;i++){
			producto = producto + (v1[i]*v2[i]);
		}
	}
	printf("El producto escalar de los vectores es %d\n", producto);
}

void mayoresVector(const Vector v, int* n, double x, Vector w){
	int i;
	int i2 = 0;
	for(i=0;i<*n;i++){
		if(v[i] >= x){
			w[i2]=v[i];
			i2++;
		}
	}
	*n=i2;
}
