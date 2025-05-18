package test;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import controlador.Controlador;
import vista.Vista;
import vista.VistaDialog;

public class Test {
	
	public static void main(String[] args) {
		
		// Crear un objeto de la clase Vista
		// Vista miVista = new Vista();
		VistaDialog vistaDialog = new VistaDialog();

		// Crear un objeto de la Clase Controlador
		// Controlador ctr = new Controlador(miVista);

		// Llamar al método que da control a los componentes
		// miVista.control(ctr);

		// Crearemos un JFrame
		/*
		JFrame ventana = new JFrame("Venta de billetes de tren");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
		*/
		
		// miVista.getCbTipoDescuento().setSelectedItem(EnumDescuentos.SIN_DESCUENTO);
		
		// Crear un objeto
		JDialog ventanaDialog = new JDialog();
		ventanaDialog.setContentPane(vistaDialog);
		ventanaDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventanaDialog.setPreferredSize(new Dimension(400,350));
		ventanaDialog.pack();
		ventanaDialog.setVisible(true);
		
	}
	
}
