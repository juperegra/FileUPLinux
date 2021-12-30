package interfazGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class VentanaInicioSesion {
	
	public static void main(String[] args) {
		Display d= new Display();
		
		Shell s = new Shell(d);
		GridLayout gl= new GridLayout();
		
		s.setBounds(750, 400, 400, 200);
		
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
		
		Button bis = new Button(s, SWT.CENTER);
		bis.setText("Iniciar Sesion");
		bis.setLayoutData(gd);
		
		Label lre= new Label(s,SWT.CENTER);
		lre.setText("¿No tienes cuenta?");
		//lre.setLayoutData(gd);
		
		Button b = new Button(s, SWT.CENTER);
		b.setText("Registrate");
		b.setLayoutData(gd1);
		
		bis.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
					inicioSesion(text.getText(), text1.getText(), d);
				}
			});
		
		b.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
					registrarse();
				}
			});
		
		s.setDefaultButton(bis);
		
		s.open();
		
		while(!s.isDisposed()) {
			if(d.readAndDispatch()) {
				d.sleep();
			}
		}
		d.dispose();
	}
	public static void inicioSesion(String usuario, String contraseña, Display di) {
		String respuesta="";
		try{
			Socket s = new Socket("Localhost", 40400);
			DataOutputStream d = new DataOutputStream(s.getOutputStream());
			DataInputStream in= new DataInputStream(s.getInputStream());
			
			String ins="INSE ";
			ins+=usuario+" "+contraseña;
			System.out.println(ins);
			d.write(ins.getBytes());// enviar el usuario y la contraseña al servidor para validar los datos
			System.out.println("ej1");
			while(in.readLine()!=null) {
				respuesta+=in.readLine();
			}
			
			//String respuesta ="OK";
			System.out.println("ej2");
			if(respuesta.equals(" OK")) {
				di.sleep();
				di.dispose();
				VentanaPrincipal.start();
			}else if(respuesta.startsWith(" ERROR: ")){
				String[] trozos=respuesta.split(":");
				System.out.println(trozos[1]);
			}
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void registrarse(){
		// llamada al formulario de registro
	}
	
}
