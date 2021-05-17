import java.util.HashMap;
import java.util.Map;

import Logica.PluginFunction;

/**
 * This plugin calculates the n-th Fibonacci number.
 */

public class NumeroFeliz implements PluginFunction {
	protected final int CANTIDAD_DE_PARAMETROS=1;
	protected int parametro = 0;
	protected Map<Integer,Integer> mapaDeNumeros;
	public NumeroFeliz() {
		
	}

	public String getPluginName() {
		return "NumeroFeliz";
	}
	public String toString() {
		return "Número feliz";
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
		Map<Integer,Integer> mapaDeNumeros = new HashMap<Integer, Integer>();
		String resultado="";
		int parametro = this.parametro;
		mapaDeNumeros.put(parametro,parametro);
		int valorConDigitosSumados=0;
		boolean corte = false;

		while(!corte) {
			while(parametro !=0) {
				valorConDigitosSumados += Math.pow(parametro % 10,2);
				parametro /= 10;
			}
			if( valorConDigitosSumados ==1) {
				resultado += "1 por lo tanto es feliz :)";
				corte = true;
			}  else {

				if(mapaDeNumeros.get(valorConDigitosSumados)==null) {
					mapaDeNumeros.put(valorConDigitosSumados,valorConDigitosSumados);
					parametro = valorConDigitosSumados;
					
					resultado += valorConDigitosSumados +"\n"; 
					valorConDigitosSumados = 0;
				}else {
					resultado += valorConDigitosSumados +" por lo tanto no es feliz :(";
					corte= true;
				}
			}
		}



		return resultado;
	}

	@Override
	public String getNombreDeParametro(int numeroDeParametro) throws OutOfRangeException {
		if(numeroDeParametro!=1)
			throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");

		return "Número";
	}

	@Override
	public String getDescripcion() {
		String descripcion = "";
		descripcion += "\n" + 
				"Los números felices se definen por el siguiente procedimiento: empezando con cualquier número entero positivo, \n"
				+ " se reemplaza el número por la suma de los cuadrados de sus dígitos, y se repite el proceso hasta que el número \n "
				+ " es igual a 1 o hasta que se entra en un bucle que no incluye el 1.1​ Los números que al finalizar el proceso \n "
				+ " terminan con 1 son conocidos como números felices. Aquellos que no, son conocidos como números infelices.";
		return descripcion;
	}

	@Override
	public int getCantDeParametros() {
		return CANTIDAD_DE_PARAMETROS;
	}
}

