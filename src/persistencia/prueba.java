package persistencia;

import model.Usuario;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorBD d= new GestorBD();
		
		try {
			Usuario u=d.buscarUsuario("1a");
			
			System.out.println(u.getId());
			System.out.println(u.getNombre());
			System.out.println(u.getApellidos());
			System.out.println(u.getContraseña());
			System.out.println(u.getIP());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
