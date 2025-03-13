package prPract17;

import javax.swing.*;

public class GUI05Swing {

	public static void main(String[] args) {
		float numero = 0;
		boolean continuar = true;
		
		try {
			numero = Float.parseFloat(JOptionPane.showInputDialog("Escriba un número"));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Entrada cancelada",
					"Error", JOptionPane.ERROR_MESSAGE);
			continuar = false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tienes que indicar un número",
					"Error", JOptionPane.ERROR_MESSAGE);
			continuar = false;
		}
		
		if (continuar) {
			JOptionPane.showMessageDialog(null, "El número indicado es " + numero);
			if (numero == 100)
				JOptionPane.showMessageDialog(null, "Enhorabuena, has obtenido un premio");
		}
		
	}
}
