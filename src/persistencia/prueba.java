package persistencia;

import java.util.Iterator;
import java.util.List;

import model.Fichero;
import model.Usuario;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorBD d= new GestorBD();
		
		try {
			Usuario u=d.buscarUsuario("1a");
			Usuario u2=d.buscarUsuario("2a");
			
//			System.out.println(u.getId());
//			System.out.println(u.getNombre());
//			System.out.println(u.getApellidos());
//			System.out.println(u.getContraseña());
//			System.out.println(u.getIP());
			
			Fichero F = new Fichero("1","Tremendo.txt",u,u2,"c/home/Tremendo.txt","UTF-8");
			Fichero F1 = new Fichero("2","Tremendo2.txt",u,u2,"c/home/Tremendo2.txt","UTF-8");
			Fichero F2 = new Fichero("3","Tremendo3.txt",u,u2,"c/home/Tremendo3.txt","UTF-8");
			
			d.agnadirFichero(F);
			d.agnadirFichero(F1);
			d.agnadirFichero(F2);
			
			System.out.println(d.agnadirPersona(u2));
			
			List<Fichero> lf=d.todosFicheros();
			
			Iterator<Fichero> it=lf.iterator();
			
			while(it.hasNext()) {
				Fichero fAux=it.next();
				System.out.println(fAux.getId());
				System.out.println(fAux.getNombre());
				System.out.println(fAux.getEmisor().getId());
				System.out.println(fAux.getReceptor().getId());
				System.out.println(fAux.getRuta());
				System.out.println(fAux.getCodificacion());
				System.out.println("-------------------------------------");
			}
//			System.out.println(d.eliminarFichero("1"));
//			System.out.println(d.eliminarPersona("1a"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
