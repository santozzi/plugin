package Observer;

import Logica.PluginFunction;

public interface Observador {
/**
 * updateListaAdd
 * Agrega el item a una lista o coleccón	
 * @param item
 */
public void updateListaAdd(PluginFunction item);
/**
 * updateListaRem
 * Elimina el item de una lista o colección
 * @param item
 */
public void updateListaRem(PluginFunction item);

}
