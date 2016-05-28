#include <string.h>
#include "cadena.h"

void quitaSaltoDeLinea(Cadena c){
	int len = strlen(c);
	if(c[len-1] == '\n'){
		c[len-1] = '\0';
	}
}
