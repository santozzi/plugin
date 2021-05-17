import Logica.PluginFunction;

public class Potencia implements PluginFunction {
	protected final int  CANTIDAD_DE_PARAMETROS= 2;
	protected float base;
    protected float potencia;

    

	@Override
	public void setParametro(int numeroDeParametro, String param) throws OutOfRangeException {
	  float parametro = StringToX.stringTofloat(param);
	  if(numeroDeParametro==1) {
		  base= parametro;
	  }else if(numeroDeParametro==2) {
		  potencia= parametro;
	  }else
		  throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");
    
	}


	@Override
	public String getResultado() {
	  String resultado="";
	  if(base==0 && potencia==0) {
		  resultado = "1 pero si hablamos de limite, el resultado es indeterminado";
	  }else
		  resultado =Math.pow(base, potencia)+"";
		return resultado;
	}

	@Override
	public String getPluginName() {
		return "Potencia";
	}


	@Override
	public int getCantDeParametros() {
		
		return CANTIDAD_DE_PARAMETROS;
	}

	@Override
	public String getNombreDeParametro(int numeroDeParametro) throws OutOfRangeException {
		String resultado = ""; 
		if(numeroDeParametro==1) {
            resultado = "Base";
		}else if(numeroDeParametro==2) {
			resultado = "Potencia";
		  }else
			  throw new OutOfRangeException("El numero de parámetro no esta en el rango permitido");

		
		return resultado;
	}
	@Override
	public String getDescripcion() {
		return "Potencia: Eleva la base a la pontencia indicada";
	}

	public String toString() {
		return "Potencia";
	}

}
