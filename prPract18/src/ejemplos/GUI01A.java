package ejemplos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI01A extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -376043348785583325L;
	// Variable de instancia
	private JLabel etiqueta;
	private JButton bSi, bNo;

	// Constructor
	public GUI01A() {
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
		// Añadir control a los botones (enlazar el componente event con
		// la interfaz que lo que programa)
		bSi.addActionListener(this);
		bNo.addActionListener(this);
	}

	// Programa principal
	public static void main(String[] args) {
		new GUI01A();
	}

	// Método de la interfaz ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bSi)
			etiqueta.setText("Si pulsado");
		else
			etiqueta.setText("No pulsado");
	}
}