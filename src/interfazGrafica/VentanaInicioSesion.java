package interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class VentanaInicioSesion {
	public static void main(String[] args) {
		Display d= new Display();
		
		Shell s = new Shell(d);
		GridLayout gl= new GridLayout();
		
		s.setBounds(100, 100, 200, 100);
		
		s.setFullScreen(false);
		
		gl.numColumns=3;
		
		s.setLayout(gl);
		
		Label l= new Label(s, SWT.CENTER);
		
		l.setText("Inicio de sesión");
		
		GridData gd= new GridData();
		
		gd.horizontalSpan=3;
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		l.setLayoutData(gd);
		
		Label l1 = new Label(s, SWT.LEFT);
		l1.setText("Usuario:");
		Text text = new Text(s,SWT.SINGLE |SWT.BORDER);
		
		
		
		
		GridData gd1= new GridData();
		
		gd1.horizontalSpan=2;
		gd1.horizontalAlignment = GridData.FILL;
		gd1.grabExcessHorizontalSpace = true;
		text.setLayoutData(gd1);
		
		Label l2 = new Label(s, SWT.LEFT);
		l2.setText("Contraseña:");
		Text text1 = new Text(s,SWT.SINGLE |SWT.BORDER);
		text1.setLayoutData(gd1);
		
		s.open();
		
		while(!s.isDisposed()) {
			if(d.readAndDispatch()) {
				d.sleep();
			}
		}
		d.dispose();
	}
}
