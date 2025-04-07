package Calculadora;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.UIManager;

public class Controlador implements KeyListener, ActionListener, FocusListener {
	
	private Vista miVista;
	private ProcesaDatos pd;
	
	public Controlador(Vista v) {
		miVista = v;
		pd = new ProcesaDatos(miVista.getTfRdo());
	}

	@Override
	public void focusGained(FocusEvent e) {
		e.getComponent().setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		/* ------------------------------------------------------------
		 * Primera forma: Preguntando por el texto del botón.
		 * ------------------------------------------------------------ */
		/*JButton botonPulsado = (JButton)e.getSource();
		
		switch (botonPulsado.getText()) {
		case " +", " *", " /", " -", " .", " =" -> botonPulsado.setBackground(UIManager.getColor( "Button.setbackground"));
		default -> botonPulsado.setBackground(Color.cyan);
		}
		*/
		
		/* ------------------------------------------------------------
		 * Segunda forma: Parseando y con un try catch
		 * ------------------------------------------------------------ */
		/*JButton botonPulsado = (JButton)e.getSource();
		try {
			Integer.parseInt(botonPulsado.getText());
			botonPulsado.setBackground(Color.cyan);
		} catch (Exception ex) {
			botonPulsado.setBackground(UIManager.getColor("Button.setbackground"));
		}
		*/
		
		/* ------------------------------------------------------------
		 * Tercera forma: Con expresiones regulares
		 * ------------------------------------------------------------ */
		JButton botonPulsado = (JButton)e.getSource();
		botonPulsado.setBackground(botonPulsado.getText().matches("[0-9]") ? Color.cyan : null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Obtener una referencia al botón pulsado
		JButton botonPulsado = (JButton)e.getSource();
		
		// Guardar el carácter del botón pulsado
		char valorBoton = botonPulsado.getActionCommand().charAt(0);
		try {
			pd.procesa(valorBoton);
		} catch (MiExcepcion e1) {
			//e1.printStackTrace();
			botonPulsado.setBackground(Color.red);
			miVista.getTfRdo().setText(e1.getMessage());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char valorTecla = e.getKeyChar();
		if (valorTecla == '\n') valorTecla = '=';
		JButton botonPulsado = null;
		
		try {
			botonPulsado = asignaFoco(valorTecla);
			if (botonPulsado != null)
				pd.procesa(valorTecla);
		} catch (MiExcepcion e1) {
			//e1.printStackTrace();
			botonPulsado.setBackground(Color.red);
			miVista.getTfRdo().setText(e1.getMessage());
		}
	}
	
	private JButton asignaFoco(char valorTecla) {
		
		JButton botonPulsado = switch (valorTecla) {
		case '+' -> miVista.getbOperaciones()[0];
		case '-' -> miVista.getbOperaciones()[1];
		case '*' -> miVista.getbOperaciones()[2];
		case '/' -> miVista.getbOperaciones()[3];
		case '.' -> miVista.getbPunto();
		case '=' -> miVista.getbIgual();
		case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> miVista.getbDigitos()[valorTecla-48];
		default -> null;
		};
		
		return botonPulsado;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
