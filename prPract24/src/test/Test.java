package test;

import java.awt.Dimension;

import javax.swing.JFrame;
import vista.Vista;
import vista.VistaDialog;

public class Test {
	
	public static void main(String[] args) {
		
		// Dialogo inicial
		VistaDialog miDialogo = new VistaDialog();
		//Controlador ctr = new Controlador(miVista);
		//miVista.control(ctr);
		JFrame ventanaDialog = new JFrame("Dimensión del cuadrado");
		ventanaDialog.setContentPane(miDialogo);
		ventanaDialog.setDefaultCloseOperation(JFrame./*TODO DO_NOTHING_ON_CLOSE*/EXIT_ON_CLOSE);
		ventanaDialog.pack();
		ventanaDialog.setVisible(true);
		
		// Cuadrado mágico
		Vista miVista = new Vista();
		//Controlador ctr = new Controlador(miVista);
		//miVista.control(ctr);
		JFrame ventana = new JFrame("Cuadrado mágico");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();

		// Crearemos un JFrame

		
		
		
		
	}
}
