package Logica;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import Observer.Observado;
/**
 * FileChangeWathcher
 * Observa en un hilo secundario si hay modificaciones en el directorio, si se crea
 * un nuevo archivo es notificado a obs.notificarAddItem(file) y si es eliminado se 
 * notifica a  obs.notificarRemItem(file);
 * Este código esta basado en el articulo "¿Cómo observar cambios en un directorio?"
 * de https://experto.dev/observar-cambios-en-directorios-con-java/
 */
public class FileChangeWatcher extends Thread{

	protected Observado obs;
	protected WatchService watchService;
	protected String directory;
	protected Path directoryToWatch;
	/**
	 * FileChageWatcher
	 * Recibe un observado, al que se le notifica que hubo cambios en el directorio
	 * @param obs de tipo Observado
	 */
	public FileChangeWatcher(Observado obs) {
		this.obs= obs;
	}

	public Path  doWath(String directory)  {
		this.directory= directory;
		directoryToWatch = Paths.get(directory);
		
		return directoryToWatch;

	}

	@Override
	public void run() {

		Path directoryToWatch = Paths.get(directory);
	       if (directoryToWatch == null) {
	           throw new UnsupportedOperationException("Directory not found");
	       }

		// Solicitamos el servicio WatchService
		try {
			watchService = directoryToWatch.getFileSystem().newWatchService();
		} catch (IOException e1) {
 			e1.printStackTrace();
		}
		try {
			directoryToWatch.register(watchService, new WatchEvent.Kind[] {ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY});
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			
			// Esperamos que algo suceda con el directorio
			WatchKey key = watchService.take();

			// Algo ocurrio en el directorio para los eventos registrados
			while (key != null) {
				// Thread.sleep(150);
				for (WatchEvent event : key.pollEvents()) {
					String eventKind = event.kind().toString();
					String file = event.context().toString();
					//    System.out.println("Event : " + eventKind + " in File " +  file);
					if(eventKind.equals(ENTRY_CREATE.name())) {
						obs.notificarAddItem(file);
					}else if(eventKind.equals(ENTRY_DELETE.name())) {
						obs.notificarRemItem(file);
					}
				}

				// Volvemos a escuchar. Lo mantenemos en un loop para escuchar indefinidamente.
				key.reset();
				key = watchService.take();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
