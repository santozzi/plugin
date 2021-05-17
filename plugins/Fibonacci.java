import Logica.PluginFunction;

/**
 * This plugin calculates the n-th Fibonacci number.
 */

public class Fibonacci implements PluginFunction {
    protected final int CANTIDAD_DE_PARAMETROS=1;
    protected int parametro = 0;
	boolean hasError = false;


	// you can define additional functions as necessary
	protected int fib (int n) {
		if (n < 0) {
			hasError = true;
			return 0;
		}

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2); 
	}

	public String getPluginName() {
		return "Fibonacci";
	}
	public String toString() {
		return "Fibonacci";
	}


	@Override
	public void setParametro(int numeroDeParametro, String param) throws OutOfRangeException  {
		int parametro = StringToX.stringToInt(param);
		if(numeroDeParametro!=1) {
			  throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");
		}
		if(parametro<0)
			  throw new OutOfRangeException("El parámetro debe ser positivo");
		
		this.parametro = (int)parametro;
		
	}

	@Override
	public String getResultado() {
		hasError = false;
		return fib(parametro)+"";
	}

	@Override
	public String getNombreDeParametro(int numeroDeParametro) throws OutOfRangeException {
		if(numeroDeParametro!=1)
			  throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");
		
			
		return "Pos Fibonacci";
	}

	@Override
	public String getDescripcion() {
		return "Debe ingresar la posición del número Fibonacci si ingresa un numero con '.' se tomará la parte entera, y el resultado obtenido sera el número en esa posicion";
	}

	@Override
	public int getCantDeParametros() {
		return CANTIDAD_DE_PARAMETROS;
	}
}

