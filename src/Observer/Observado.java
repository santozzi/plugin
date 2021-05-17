package Observer;

import Logica.PluginFunction;

public interface Observado {
	/**
	 * agregarObservador
	 * -----------------
	 * Agrega un observador en una coleccion de observadores
	 * @param obs
	 */
	public void agregarObservador(Observador obs);
	/**
	 * eliminarObservador
	 * -------------------
	 * Elimina un observador de la coleccion de observadores
	 * @param obs
	 */
	public void eliminarObservador(Observador obs);
	/**
	 * notificarAddItem
	 * Notifica a los observadores que se agrego un nuevo plugin en el directorio
	 * @param item plugin
	 */
	public void notificarAddItem(String item);
	/**
	 * notificarRemItem
	 * Notifica a los observadores que se elimino un plugin del directorio
	 * @param item
	 */
	public void notificarRemItem(String item);
	
}
