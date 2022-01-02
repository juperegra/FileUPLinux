package principal;

import org.eclipse.swt.SWTException;

import interfazGrafica.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		try {
			VentanaPrincipal.iniciarCliente();
		}catch(SWTException e) {
			
		}
		
	}

}
