package prPract16;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GUI03Swing {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Calculadora");
		Container cp = f.getContentPane();
		cp.setLayout(new BorderLayout(15,15));
		
	// Crear los componentes adecuados
		JPanel pNorte = new JPanel(new FlowLayout());
		JLabel lResultado = new JLabel("Resultado");
		JTextField taResultado = new JTextField(15);

		JPanel pCentro = new JPanel(new GridLayout(4,4));
		JButton[] bCalculadora = {
				new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
				new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
				new JButton("7"), new JButton("8"), new JButton("9"), new JButton("*"),
				new JButton("0"), new JButton("."), new JButton("="), new JButton("/")};
		
		JPanel pSur = new JPanel(new FlowLayout());
		JRadioButton[] rbOpcionesBases = {
			new JRadioButton("Dec"),
			new JRadioButton("Bin"),
			new JRadioButton("Hex"),
			new JRadioButton("Oct"),
		};
		ButtonGroup bgBase = new ButtonGroup();
		
	// Agregarlos a sus contenedores correspondientes
		pNorte.add(lResultado);
		pNorte.add(taResultado);
		
		for (JButton b: bCalculadora)
			pCentro.add(b);
		
		// Añadir los radios al mismo grupo y aprovechar el mismo bucle para añadirlos al pSur
		for (JRadioButton rb: rbOpcionesBases) {
			bgBase.add(rb);
			pSur.add(rb);
		}
		bgBase.setSelected(rbOpcionesBases[0].getModel(), true);
		
		cp.add(pNorte, BorderLayout.NORTH);
		cp.add(pCentro, BorderLayout.CENTER);
		cp.add(new JLabel("         "), BorderLayout.EAST);
		cp.add(new JLabel("         "), BorderLayout.WEST);
		cp.add(pSur, BorderLayout.SOUTH);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(280,250);
		
	// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
