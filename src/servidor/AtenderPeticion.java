package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtenderPeticion extends Thread{

	private Socket s;
	
	public AtenderPeticion(Socket s){
		this.s=s;
	}
	
	public void run() {
		try {
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out= new DataOutputStream(s.getOutputStream());
			
			String pet= in.readLine();
			System.out.println(pet);
			//invocacion al metodo de iniciar sesion
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
