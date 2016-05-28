#include "numeroCombinatorio.h"

long factorial(int n){
	long res = 1;
	int i;
	for (i=2; i<=n; i++){
		res = res * i;
	}
	return res;
}

long numeroCombinatorio(int m, int n){
	long res = factorial(m) / (factorial(n) * factorial(m-n));
	return res;
}
