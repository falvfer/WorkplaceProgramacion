package vista;

import javax.swing.border.Border;

public class PanelCrear extends PanelInformacion {
	private static final long serialVersionUID = -291548456224244242L;
	
	public PanelCrear(Border mainBorder) {
		super(mainBorder);
		super.getbBorrar().setVisible(false);
		super.getbEditar().setVisible(false);
		super.getbGuardar().setEnabled(true);
		super.getbCancelar().setEnabled(true);
	}
}
