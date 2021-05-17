import Logica.PluginFunction;

public class Division implements PluginFunction {
	protected final int  CANTIDAD_DE_PARAMETROS= 2;
	protected float dividendo;
	protected float divisor;

	@Override
	public void setParametro(int numeroDeParametro, String param)throws Exception {
		float parametro = StringToX.stringTofloat(param);
		if(numeroDeParametro==1) {
			dividendo= parametro;
		}else if(numeroDeParametro==2) {
			divisor= parametro;
		}else
			throw new OutOfRangeException("El número de parametro no existe");
		if(divisor==0.0)
			throw new DivXCeroException("No se puede dividir por 0");
	
	}
   
    
	@Override
	public String getResultado(){


		return (dividendo/divisor)+"";
	}

	@Override
	public String getPluginName() {
		return "Division";
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
		return "División";
	}

}
