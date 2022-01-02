package principal;

import org.eclipse.swt.SWTError;

import interfazGrafica.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
			try {
				VentanaPrincipal vp= new VentanaPrincipal();
				vp.inicio();
			}catch(SWTError e) {
				
			}
			
		
	}

}
