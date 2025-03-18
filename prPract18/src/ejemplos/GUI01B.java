package ejemplos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class GUI01B extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3448863442811211295L;
	// Variable de instancia
	private JLabel etiqueta;
	private JButton bSi, bNo;

	// Constructor
	public GUI01B() {
		// Poner título a la ventana
		super("Con actionListener");
		// Creo un objeto de tipo container con el método getContentPane()
		Container contentPane = this.getContentPane();
		// Establecer el gestor de esquemas
		contentPane.setLayout(new FlowLayout());
		// Crear los componentes
		bSi = new JButton("Si");
		bNo = new JButton("No");
		etiqueta = new JLabel("Pulsaciones");
		// Añadir los componentes al JFrame
		contentPane.add(etiqueta);
		contentPane.add(bSi);
		contentPane.add(bNo);
		// Pack, setVisible, control de cierre, etc
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Añadir control a los botones
		ControlBoton cb = new ControlBoton();
		ControlFoco cf = new ControlFoco();
		bSi.addActionListener(cb);
		bSi.addFocusListener(cf);
		bNo.addActionListener(cb);
		bNo.addFocusListener(cf);
	}

	// Programa principal
	public static void main(String[] args) {
		new GUI01B();
	}

	class ControlBoton implements ActionListener {
		// Método de la interfaz ActionListener
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bSi)
				etiqueta.setText("Si pulsado");
			else
				etiqueta.setText("No pulsado");
		}
	}
	
	class ControlFoco implements FocusListener {
		
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(Color.RED);
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(UIManager.getColor("Button.background"));
		}
	}
}