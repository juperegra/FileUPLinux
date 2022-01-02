package interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import model.Usuario;

;

public class VentanaPrincipal {
	
	
	public static void iniciarCliente() {
		VentanaInicioSesion.start();
		inicio();
	}
	public static void inicio() {
		Display d= new Display();
		
		Shell s = new Shell(d);
		s.setBounds(100, 100, 700, 500);
		s.setLayout(new FillLayout());
		TabFolder t = new TabFolder(s,SWT.TOP);
		t.setLayout(new FillLayout());
		
		TabItem t1=new TabItem(t,SWT.FILL);
		t1.setText("Subir archivo");
		t1.setControl(new GrupoA(t,SWT.NONE));
		
		TabItem t2=new TabItem(t,SWT.NONE);
		t2.setText("Mis archivos");
		//t2.setControl(new GrupoDeGrupos(t,SWT.NONE));
		t.setLayout(new FillLayout());
		TabItem t3=new TabItem(t,SWT.NONE);
		t3.setText("Archivos publicos");
		//t3.setControl(new GrupoConEventos(t,SWT.NONE));
		
		TabItem t4=new TabItem(t,SWT.NONE);
		Device de = Display.getCurrent ();
		Image ima= new Image(de,"Images/campana.jpg");
		t4.setImage(ima);
		//t4.setText("2"); segun el numero de notificaciones, se puede modificar este numero
		
		//t3.setControl(new GrupoConEventos(t,SWT.NONE));
		//t.setSelection(t3);
		t4.setToolTipText("Notificaciones");
		
		t.pack();
		
		t.pack();
		s.setText("SubeArchivos");
		s.open();
		
		while(!s.isDisposed()) {
			if(d.readAndDispatch()) {
				d.sleep();
			}
		}
		d.dispose();
	}
}
