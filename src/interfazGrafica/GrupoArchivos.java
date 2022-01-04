package interfazGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import model.Fichero;
import model.Usuario;

public class GrupoArchivos extends Composite{
	
	public GrupoArchivos(Composite c, int style) {
		super(c,style);
			
			VentanaPrincipal vp= new VentanaPrincipal();
			Group g= new Group(this, SWT.FILL);
			//g.setText("Grupo de cosas");
			g.setLayout(new FillLayout());
			g.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			g.pack();		

	}
	public static void eyey(VentanaPrincipal vp ) {
		
		try (Socket s = new Socket("localhost",40400);
			DataInputStream in= new DataInputStream(s.getInputStream());
			DataOutputStream out= new DataOutputStream(s.getOutputStream());){
			
			String pet="GET ALL: ";
			System.out.println("se esta enviando esto");
			
			Usuario u=vp.getUsuario();
			System.out.println("se esta enviando esto2");
			
			pet +="Ficheros "+u.getId()+"\n";
			System.out.println("se esta enviando esto3");
			
			out.write(pet.getBytes());
			System.out.println("se esta enviando esto4");
			
			String resp=in.readLine();
			List<Fichero> fichs=new ArrayList<>();
			while(resp!=null) {
				String [] trozos=resp.split(" ");
				fichs.add(new Fichero(trozos[0],trozos[1],new Usuario(trozos[2],"","",""),new Usuario(trozos[3],"","",""),trozos[4],trozos[5]));
				resp=in.readLine();
			}
			
			for(Fichero f: fichs) {
				System.out.println(f.toString());
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
