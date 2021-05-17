package Logica;
/**
 * PluginFuncion
 * Este c�digo esta basado en el articulo "Adding Plugins to a Java Application" by Ulf Dittmer
 * https://javaranch.com/journal/200607/Plugins.html 
 *
 */
public interface PluginFunction {
	/**
	 * setParametro
	 * Configura los parametros de tipo String, indicando que n�mero de parametro es. 
	 * @param numeroDeParametro, es la posici�n que va a ocupar en la estructura
	 * @param parametro, es un valor de tipo String con el que se va a operar
	 * @throws Exception, se lanza cuando el numeroDeParametro excede o es <=0 a la cantidad
	 * de par�metros
	 */
	public void setParametro (int numeroDeParametro ,String parametro)throws Exception;
	/**
	 * getResultado
	 * Devuelve el resultado de la operaci�n
	 * @return resultado de la operaci�n de tipo String
	 */
	public String getResultado();
	/**
	 * getPluginName
	 * Devuelve el nombre del plugin,este debe ser el nombre del archivo sin la extensi�n
	 * @return nombre del archivo sin la extensi�n
	 */
	public String getPluginName();
	/**
	 * getCantDeParametros
	 * Devuelve la cantidad de par�metros m�xima que va a utilizar el plugin
	 * @return cantidad m�xima de par�metros del plugin
	 */
	public int getCantDeParametros();
	/**
	 * nombreDeParametro
	 * Ingredando la posicion en la estructura devuelve el nombre del par�metro al que 
	 * se refiere
	 * @param numeroDeParametro, este valor de pende de la cantidad de parametros
	 * @return devuelve un nombre de tipo String
	 * @throws Exception , se lanza cuando el numeroDeParametro excede o es <=0 a la cantidad
	 * de par�metros
	 */
	public String getNombreDeParametro(int numeroDeParametro)throws Exception;
	/**
	 * getDescripcion
	 * Es la descripci�n del comportamiento del plugin
	 * @return detalle de tipo String
	 */
	public String getDescripcion();
	public String toString();
}
