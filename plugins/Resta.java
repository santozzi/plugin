import Logica.PluginFunction;

public class Resta implements PluginFunction {
    protected final int  CANTIDAD_DE_PARAMETROS= 2;
    protected float operador1;
    protected float operador2;
    
    
    
	@Override
	public void setParametro(int numeroDeParametro, String param) throws OutOfRangeException {
	  float parametro = StringToX.stringTofloat(param);
	  if(numeroDeParametro==1) {
		  operador1= parametro;
	  }else if(numeroDeParametro==2) {
		  operador2= parametro;
	  }else
		  throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");
	    
	}

	@Override
	public String getResultado() {
		
		return (operador1-operador2)+"";
	}

	@Override
	public String getPluginName() {
	return "Resta";
	}



	@Override
	public int getCantDeParametros() {
		
		return CANTIDAD_DE_PARAMETROS;
	}

	@Override
	public String getNombreDeParametro(int numeroDeParametro) throws OutOfRangeException {
		String resultado = ""; 
		if(numeroDeParametro==1) {
            resultado = "NumA";
		}else if(numeroDeParametro==2) {
			resultado = "NumB";
		  }else
			  throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");
		    
		return resultado;
	}

	@Override
	public String getDescripcion() {
		
		return "La resta de dos números, que da como resultado NumA - NumB";
	}
	public String toString() {
		return "Resta";
	}
	

}
