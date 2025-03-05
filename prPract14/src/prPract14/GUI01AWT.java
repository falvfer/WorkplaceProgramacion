package prPract14;

import java.awt.*;

public class GUI01AWT {

	public static void main(String[] args) {

	// Crear un contenedor
		Frame f = new Frame("Mi primer GUI");
		
	// Seleccionar un gestor de esquemas para la inserción de los componentes
		f.setLayout(new FlowLayout());
		
	// Crear los componentes adecuados
		Button bSi = new Button("Si");
		Button bNo = new Button("No");
		Label lNombre = new Label("Nombre");
		
	// Agregarlos al contenedor
		f.add(lNombre);
		f.add(bSi);
		f.add(bNo);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(300,150);
		
	// Mostrar el contenedor
		f.setVisible(true);
		
	// Programar el evento de cierre de ventana
		f.addWindowListener(new ControlVentana());

	}

}
