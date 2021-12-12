package InterfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class GrupoA extends Composite{

	public GrupoA(Composite c, int style) {
		super(c,style);
		Group g= new Group(this, SWT.FILL);
		
		//g.setText("Grupo de cosas");
		g.setLayout(new FillLayout());
		g.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}
