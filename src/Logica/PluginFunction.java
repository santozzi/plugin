package Logica;
/**
 * PluginFuncion
 * Este código esta basado en el articulo "Adding Plugins to a Java Application" by Ulf Dittmer
 * https://javaranch.com/journal/200607/Plugins.html 
 *
 */
public interface PluginFunction {
	/**
	 * setParametro
	 * Configura los parametros de tipo String, indicando que número de parametro es. 
	 * @param numeroDeParametro, es la posición que va a ocupar en la estructura
	 * @param parametro, es un valor de tipo String con el que se va a operar
	 * @throws Exception, se lanza cuando el numeroDeParametro excede o es <=0 a la cantidad
	 * de parámetros
	 */
	public void setParametro (int numeroDeParametro ,String parametro)throws Exception;
	/**
	 * getResultado
	 * Devuelve el resultado de la operación
	 * @return resultado de la operación de tipo String
	 */
	public String getResultado();
	/**
	 * getPluginName
	 * Devuelve el nombre del plugin,este debe ser el nombre del archivo sin la extensión
	 * @return nombre del archivo sin la extensión
	 */
	public String getPluginName();
	/**
	 * getCantDeParametros
	 * Devuelve la cantidad de parámetros máxima que va a utilizar el plugin
	 * @return cantidad máxima de parámetros del plugin
	 */
	public int getCantDeParametros();
	/**
	 * nombreDeParametro
	 * Ingredando la posicion en la estructura devuelve el nombre del parámetro al que 
	 * se refiere
	 * @param numeroDeParametro, este valor de pende de la cantidad de parametros
	 * @return devuelve un nombre de tipo String
	 * @throws Exception , se lanza cuando el numeroDeParametro excede o es <=0 a la cantidad
	 * de parámetros
	 */
	public String getNombreDeParametro(int numeroDeParametro)throws Exception;
	/**
	 * getDescripcion
	 * Es la descripción del comportamiento del plugin
	 * @return detalle de tipo String
	 */
	public String getDescripcion();
	public String toString();
}
