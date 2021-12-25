package servidor;

import java.net.Socket;

public class AtenderPeticion extends Thread{

	private Socket s;
	
	public AtenderPeticion(Socket s){
		this.s=s;
	}
	
	public void run() {
		
	}
}
