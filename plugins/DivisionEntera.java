import Logica.PluginFunction;

public class DivisionEntera implements PluginFunction {
	protected final int  CANTIDAD_DE_PARAMETROS= 2;
	protected int dividendo;
	protected int divisor;

	@Override
	public void setParametro(int numeroDeParametro, String param)throws Exception {
	    int parametro = StringToX.stringToInt(param);
		if(numeroDeParametro==1) {
			dividendo= parametro;
		}else if(numeroDeParametro==2) {
			divisor= parametro;
		}else
			throw new OutOfRangeException("El número de parametro no existe");
		if(divisor==0)
			throw new DivXCeroException("No se puede dividir por 0");
	
	}


	@Override
	public String getResultado(){
        String resultado="";
        resultado +=dividendo/divisor+"\n";
        resultado +="resto: "+dividendo % divisor;

		return resultado;
	}

	@Override
	public String getPluginName() {
		return "DivisionEntera";
	}



	@Override
	public int getCantDeParametros() {

		return CANTIDAD_DE_PARAMETROS;
	}

	@Override
	public String getNombreDeParametro(int numeroDeParametro)throws Exception {
		String resultado = ""; 
		if(numeroDeParametro==1) {
			resultado = "Dividendo";
		}else if(numeroDeParametro==2) {
			resultado = "Divisor";
		}else
			throw new OutOfRangeException("El número de parámetro no existe");

		return resultado;
	}
	@Override
	public String getDescripcion() {
		return "División: Se divide el dividendo con el divisor, el divisor no debe ser 0";
	}

	public String toString() {
		return "División entera";
	}

}
