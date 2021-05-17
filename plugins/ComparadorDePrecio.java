import Logica.PluginFunction;

public class ComparadorDePrecio implements PluginFunction {
    protected final int CANTIDAD_DE_PARAMETROS=4;
	protected float valorA;
	protected float valorB;
	protected float unidadA;
	protected float unidadB;
	
	
	@Override
	public void setParametro(int numeroDeParametro, String parametro) throws Exception {
		if(numeroDeParametro<=0||numeroDeParametro>4)
			throw new OutOfRangeException("Fuera de rango");
		
		if(numeroDeParametro==1) {
			unidadA = StringToX.stringTofloat(parametro);
		}else if(numeroDeParametro==2) {
			valorA =StringToX.stringTofloat(parametro);
		}else if(numeroDeParametro==3) {
			unidadB = StringToX.stringTofloat(parametro);
		}else if(numeroDeParametro==4) {
			valorB =StringToX.stringTofloat(parametro);
		}
	}

	@Override
	public String getResultado() {
		float unidadAEn1 =valorA/unidadA ;
		float unidadBEn1= valorB/unidadB;
		String resultado = "";
		  resultado +="UnidadA en 1 = "+unidadAEn1+"\n";
		  resultado +="UnidadB en 1 = "+unidadBEn1+"\n";
		  if(unidadAEn1<unidadBEn1) {
			  resultado += "El producto con UnidadA es más conveniente \n";
		  }else if(unidadAEn1>unidadBEn1) {
			  resultado += "El producto con UnidadB es más conveniente \n";
		  }else
			  resultado += "El que mas te guste, es lo mismo \n";
		return resultado;
	}

	@Override
	public String getPluginName() {
	
		return "ComparadorDePrecio";
	}

	@Override
	public int getCantDeParametros() {
		return CANTIDAD_DE_PARAMETROS;
	}

	@Override
	public String getNombreDeParametro(int numeroDeParametro) throws Exception {
		String nombre="";
		if(numeroDeParametro<=0||numeroDeParametro>4)
			throw new OutOfRangeException("Fuera de rango");
		if(numeroDeParametro==1) {
			nombre = "Unidad A";
		}else if(numeroDeParametro==2) {
			nombre = "Valor A";
		}else if(numeroDeParametro==3) {
			nombre = "Unidad B";
		}else if(numeroDeParametro==4) {
			nombre = "Valor B";
		}
		return nombre;
	}

	@Override
	public String getDescripcion() {
		String descripcion = "";
		descripcion += "Si usted esta canzado de ir al mayorista y pensar qué producto \n"+
		               "le conviene comprar, este es un complemento infaltable para usted, \n"+
				       "¿cuál me conviene más el cacao en polvo de oferta de 100 g o \n"+
		               "el de 2 Kg? A tener en cuenta: En la unidad B debe ir un equivalente de \n"+
				       "la unidad A, en el ejemplo del cacao: unidad A= 100 y unidad B = 2000";
		return descripcion;
	}
   
	public String toString() {
	   return "Comparador de precios";   
    }
}
