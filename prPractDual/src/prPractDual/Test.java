package prPractDual;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Test {
	
	
	
	public static void main(String[] args) {
		// Crear las cajas y los expedientes para probar
		Gestor g = new Gestor();
		GeneradorExpediente expGen = new GeneradorExpediente();
		for (int i = 1; i<=5; i++) {
			g.crearCaja(i);
		}
		for (int i = 0; i<50; i++) {
			g.addExpediente(expGen.next((short)(i%10+1),(short)(2020+(i+10)/10)), (i+10)/10);
		}
		
		// Crear la Ventana
		Ventana v = new Ventana(g);
		v.pack();
		v.setSize(400, 500);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
	}
}
