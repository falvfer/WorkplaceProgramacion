package prPract18_1_Tarea2;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.pack();
		v.setSize(350,150);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Añadir el ActionListener al botón de Aceptar
		v.bAceptar.addActionListener((e) -> {
			if (v.tfUsuario.getText().equals("Francisco") &&
					Arrays.equals(v.tfPassword.getPassword(), "12345".toCharArray())) {
				v.lMensaje.setText("Datos correctos");
				v.lMensaje.setForeground(Color.BLACK);
			}
			else {
				v.lMensaje.setText("Datos incorrectos");
				v.lMensaje.setForeground(Color.RED);
			}
		});

		// Añadir el ActionListener al botón de Cancelar
		v.bCancelar.addActionListener((e) -> {
			v.tfUsuario.setText("");
			v.tfPassword.setText("");
			v.lMensaje.setText("Introduzca usuario y clave");
			v.lMensaje.setForeground(Color.BLACK);
		});
	}
}
