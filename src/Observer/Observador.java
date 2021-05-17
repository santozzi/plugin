package Observer;

import Logica.PluginFunction;

public interface Observador {
/**
 * updateListaAdd
 * Agrega el item a una lista o colecc�n	
 * @param item
 */
public void updateListaAdd(PluginFunction item);
/**
 * updateListaRem
 * Elimina el item de una lista o colecci�n
 * @param item
 */
public void updateListaRem(PluginFunction item);

}
