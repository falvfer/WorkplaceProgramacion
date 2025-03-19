package prPract17;

import javax.swing.*;

public class GUI04Swing_Mensajes_Alerta {

	public static void main(String[] args) {
		
		// ------------------------------------------------------------
		// Pruebas del método showMessageDialog (muestra un mensaje al usuario)
		// ------------------------------------------------------------
		/*
		JOptionPane.showMessageDialog(null, "Hola que tal");
		JOptionPane.showMessageDialog(null, "Hola",
				"Título mensaje", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null,
				"Hola, que tal estáis",
				"Título mensaje",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon("Duke.png"));
		*/
		// ------------------------------------------------------------
		// Pruebas del método showConfirmDialog
		// ------------------------------------------------------------
		/*
		JOptionPane.showConfirmDialog(null, "¿Estamos en primavera?");
		int resp = JOptionPane.showConfirmDialog(null,
		"¿Estamos en primavera?",
		"Titulo de la ventana",
		JOptionPane.YES_NO_OPTION);
		System.out.println(resp);
		if (resp == JOptionPane.YES_OPTION)
		JOptionPane.showMessageDialog(null,"Que bien, ya llegó la alergia");
		else
		JOptionPane.showMessageDialog(null,"Ohhhhhhhh");
		*/
		// ------------------------------------------------------------
		// Pruebas del método showOptionDialog
		// ------------------------------------------------------------
		/*
		Object [] opciones = {"OK", "Bien", "HOLA"};
		int num = JOptionPane.showOptionDialog(null,
				"Selecciona una respuesta",
				"Titulo de la ventana",
				JOptionPane.OK_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				opciones,
				opciones[2]);
		System.out.println(opciones[num]);
		*/
		// ------------------------------------------------------------
		// Pruebas del método showInputDialog
		// ------------------------------------------------------------
		
		String nombre = JOptionPane.showInputDialog("¿Cómo te llamas?");
		JOptionPane.showMessageDialog(null,
		"Hola, " + nombre.toUpperCase(),
		"Bienvenido",
		JOptionPane.PLAIN_MESSAGE,
		new ImageIcon("Duke.png"));
		Object [] diasSemana = {"Lunes","Martes","Miércoles","Jueves","Viernes"};
		Object respDia = JOptionPane.showInputDialog(null,
		"Elije tu día favorito: ",
		"Titulo de la ventana",
		JOptionPane.QUESTION_MESSAGE,
		null,
		diasSemana,
		diasSemana[3]);
		System.out.println(respDia);
		
	}
}
