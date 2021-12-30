package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import model.Usuario;
import persistencia.GestorBD;

public class AtenderPeticion extends Thread{

	private Socket s;
	private static GestorBD gb= new GestorBD();
	
	public AtenderPeticion(Socket s){
		this.s=s;
	}
	
	public void run() {
		try {
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out= new DataOutputStream(s.getOutputStream());
			
			String pet= in.readLine();
			System.out.println(pet);
			out.write(pet.getBytes());
			System.out.println("1");
			//leerPeticion(pet, out);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerPeticion(String pet, DataOutputStream out) {
		if(pet.startsWith("INSE ")) {
			String resp="OK";
			try {
	 			String[] trozos=pet.split(" ");
				System.out.println(trozos[1]);
				Usuario u=gb.buscarUsuario(trozos[1]);
				if(u!=null) {
					if(u.getContraseña().equals(trozos[2])) {
						 resp="OK";
					}else{
						 resp="ERROR:Usuario y/o contraseña no validos";
					}
				}else {
					resp="ERROR:Usuario y/o contraseña no validos";
				}
				System.out.println("justo antes de enviar");
				out.write(resp.getBytes());
				System.out.println("justo despues deenviar");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
