/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.utilidades;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricardo
 */
public class Updater {
	
	
	
	private static UpdateThread task;
	public static void start( boolean mysql){
		
		if (task == null || !task.isRunning()){
		
		task = new UpdateThread(mysql);
		task.setRunning(true);
		Thread thread = new Thread(task);
		thread.start();
		}
		
	}
	public static void stop(){
		if (task != null){
		task.setRunning(false);
		}
	}

	
	public static boolean getStatus(){
		if (task == null || !task.isRunning()){
			return false;
		}else{
			return true;
		}
	}
	
	
	
}

class UpdateThread implements Runnable{
	Biblioteca biblioteca;
	private static final long UPDATE_TIME_MIN = 1; //tiempo en minutos
	private boolean running = false;
	
	public UpdateThread(boolean mysql) {
		biblioteca = new Biblioteca(mysql);
	}
	
	

	@Override
	public void run() {
		
		System.out.println("Iniciando ejecucion de Hilo");
		while (running) {
			System.out.println("Actualizando...");
			biblioteca.actualizarPenalizaciones();
			//TODO: enviar eMails necesarios
			System.out.println("Enviando EMails...");
		
			
			
			try {
				System.out.println("Esperando...");
				Thread.sleep(UPDATE_TIME_MIN * 60 * 1000); //pasarlo a milis
				
			} catch (InterruptedException ex) {
				Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
		System.out.println("Terminando ejecucion de Hilo");
	}

	protected boolean isRunning() {
		return running;
	}

	protected void setRunning(boolean running) {
		this.running = running;
	}
	
	
}