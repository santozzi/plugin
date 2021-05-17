
public class StringToX {
	static public int stringToInt(String cadena) {
		int resultado=0;
	    try {
		 resultado = Integer.parseInt(cadena);
		} catch (NumberFormatException nfe){
		     throw new NumberFormatException(nfe.getMessage());
		}
		return resultado;
	
	}

	static public boolean esDigito(char caracter) {

		return (int)caracter>=48&&(int)caracter<=57;
	}
	
static public float stringTofloat(String cadena) {
	float resultado=0;
	    try {
		 resultado = Float.parseFloat(cadena);
		} catch (NumberFormatException nfe){
		     throw new NumberFormatException(nfe.getMessage());
		}
		return resultado;
	}



}
