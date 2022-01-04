package interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import model.Usuario;



public class VentanaPrincipal {
	
	private Usuario u;
	
	public VentanaPrincipal() {
		
	}
	
	public VentanaPrincipal(Usuario u) {
		this.u=u;
	}
	
	public void inicio() {
		Display d= new Display();
		
		Shell s = new Shell(d);
		
		s.setBounds(100, 100, 700, 500);
		s.setLayout(new FillLayout());
		TabFolder t = new TabFolder(s,SWT.TOP);
		t.setLayout(new FillLayout());
		
		TabItem t1=new TabItem(t,SWT.FILL);
		t1.setText("Subir archivo");
		t1.setControl(new GrupoSubir(t,SWT.NONE));
		
		TabItem t2=new TabItem(t,SWT.FILL);
		t2.setText("Mis archivos");
		t2.setControl(new GrupoArchivos(t,SWT.NONE));
		t.setLayout(new FillLayout());
		VentanaPrincipal pri= this;
		t.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent event) {
		        if(t.getSelection()[0].getText().equals("Mis archivos")) {
		        	GrupoArchivos.eyey(pri);
		        }
		      }
		    });
		
		TabItem t3=new TabItem(t,SWT.FILL);
		t3.setText("Archivos publicos");
		//t3.setControl(new GrupoConEventos(t,SWT.NONE));
		
		TabItem t4=new TabItem(t,SWT.FILL);
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
	
	public Usuario getUsuario() {
		return this.u;
	}
}
