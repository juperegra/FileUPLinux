package interfazGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import model.Usuario;

public class VentanaInicioSesion {
	
	private Usuario ussr;
	
	public Usuario start() {
		Display d= new Display();
		
		Shell s = new Shell(d);
		GridLayout gl= new GridLayout();
		
		s.setBounds(750, 400, 500, 250);
		
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
		
		GridData gdB= new GridData();
		gdB.horizontalSpan=3;
		gdB.horizontalAlignment = GridData.FILL;
		
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
		bis.setLayoutData(gdB);
		
		Label lre= new Label(s,SWT.CENTER);
		lre.setText("¿No tienes cuenta?");
		lre.setLayoutData(gd);
		
		
		
		Button b = new Button(s, SWT.CENTER);
		b.setText("Registrate");
		b.setLayoutData(gdB);
		
		Label lerro= new Label(s,SWT.CENTER);
		lerro.setText("");
		lerro.setLayoutData(gd);
		
		
		
		bis.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
					inicioSesion(text.getText(), text1.getText(), s, d, lerro);
				}
			});
		
		b.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
					registrarse(d);
				}
			});
		
		s.setDefaultButton(bis);
		
		s.open();
		
		while(!s.isDisposed()) {
			if(d.readAndDispatch()) {
				d.sleep();
			}
		}
		//d.dispose();
		return this.ussr;
	}
	public void inicioSesion(String usuario, String contraseña, Shell sh, Display de, Label lerr) {
		String respuesta="";
		try{
			Socket s = new Socket("Localhost", 40400);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in= new DataInputStream(s.getInputStream());
			
			String ins="POST ";
			ins+=usuario+" "+contraseña+"\n";
			System.out.println(ins);
			out.write(ins.getBytes());// enviar el usuario y la contraseña al servidor para validar los datos
			System.out.println("ej1");
			respuesta=in.readLine();
			System.out.println(respuesta);
			if(respuesta.startsWith("OK ")) {
				this.ussr=getUsuario(usuario,s,in,out);
				de.dispose();
				System.out.println("esto");
			}else if(respuesta.startsWith("ERROR: ")){
				String[] trozos=respuesta.split(":");
				
				lerr.setText(trozos[1]);
				final Color color = new Color(de, 255, 0, 0);
				lerr.setForeground(color);
				
				while(!sh.isDisposed()) {
					if(de.readAndDispatch()) {
						de.sleep();
					}
				}
			}
			
			
			s.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void registrarse(Display d){
		d.dispose();
		VentanaRegistrar vr= new VentanaRegistrar();
		vr.startReg();
		this.start();
	}
	
	private Usuario getUsuario(String id, Socket s, DataInputStream in, DataOutputStream out) throws IOException {
		String peti="GET: ";
		peti+="Usuario "+ id+"\n";
		out.write(peti.getBytes());
		
		String respuesta=in.readLine();
		
		String [] trozos= respuesta.split(" ");
		
		String apellidos=null;
		if(trozos.length==4) {
			apellidos=trozos[3];
		}
		return new Usuario(trozos[0],trozos[2],apellidos,trozos[1]);
	}
	
}
