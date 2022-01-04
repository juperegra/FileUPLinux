package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import model.Fichero;
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
			
			System.out.println("mas ejecuciones");
			
			String pet= in.readLine();
			System.out.println(pet);
			if(pet!=null) {
				leerPeticion(pet, out);
			}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerPeticion(String pet, DataOutputStream out) {
		if(pet.startsWith("POST ")) {
			String resp=""+"\n";
			try {
	 			String[] trozos=pet.split(" ");
				System.out.println(trozos[1]);
				Usuario u=gb.buscarUsuario(trozos[1]);
				if(u!=null) {
					if(u.getContraseña().equals(trozos[2])) {
						 resp="OK "+"\n";
						 System.out.println("correcto");
					}else{
						System.out.println("this");
						 resp="ERROR: Usuario y/o contraseña no validos"+"\n";
					}
				}else {
					System.out.println("or maybe this");
					resp="ERROR: Usuario y/o contraseña no validos"+"\n";
				}
				System.out.println(resp);
				out.write(resp.getBytes());
				System.out.println("justo despues deenviar");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(pet.startsWith("INSERT: ")) {
			String resp=""+"\n";
			try {
	 			String[] trozos=pet.split(" ");
				System.out.println(trozos[1]);
				Usuario u=gb.buscarUsuario(trozos[1]);
				if(u==null) {
					System.out.println("por aqui se inserta un usuario");
					String apellidos=null;
					System.out.println(trozos.length);
					if(trozos.length==5) {
						apellidos=trozos[4];
					}
					Usuario us= new Usuario(trozos[1],trozos[3],apellidos,trozos[2]);
					
					boolean agnadido=gb.agnadirPersona(us);
					if(agnadido) {
						resp="OK "+"\n";
					}else {
						resp="ERROR: no se ha podido añadir el usuario"+"\n";
					}
				}else {
					resp="ERROR: Este usuario ya existe"+"\n";
					System.out.println("error por aqui");
				}
				System.out.println(resp);
				out.write(resp.getBytes());
				System.out.println("justo despues deenviar");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(pet.startsWith("GET: ")) {
			String resp=""+"\n";
			try {
	 			String[] trozos=pet.split(" ");
				System.out.println(trozos[1]);
				System.out.println("ey");
				if(trozos[1].equals("Usuario")) {
					System.out.println(trozos[2]);
					Usuario us= gb.buscarUsuario(trozos[2]);
					resp=us.getId()+" "+us.getContraseña()+" "+us.getNombre()+" "+us.getApellidos()+"\n";
				}
				/*if(trozos[1].equals("Fichero")) {
					
				}*/
	 			
				out.write(resp.getBytes());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(pet.startsWith("GET ALL: Ficheros ")) {
			String resp=""+"\n";
			try {
	 			String[] trozos=pet.split(" ");
	 			System.out.println(trozos[3]);
	 			List<Fichero> lis = gb.todosFicherosUsuario(trozos[3]);
	 			
	 			for(Fichero f: lis) {
	 				System.out.println(f.toString());
	 				resp=f.toString()+"\n";
	 				out.write(resp.getBytes());
	 			}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
