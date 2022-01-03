package interfazGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class GrupoArchivos extends Composite{
	
	public GrupoArchivos(Composite c, int style) {
		super(c,style);
		try {	
			Group g= new Group(this, SWT.FILL);
			//g.setText("Grupo de cosas");
			g.setLayout(new FillLayout());
			g.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			Socket s= new Socket("localhost",40400);
			DataInputStream in= new DataInputStream(s.getInputStream());
			DataOutputStream out= new DataOutputStream(s.getOutputStream());
			
			
			
			in.close();
			out.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
