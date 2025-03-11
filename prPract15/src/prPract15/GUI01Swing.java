package prPract15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GUI01Swing {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Componentes varios");
		Container cp = f.getContentPane();
		
	// Seleccionar un gestor de esquemas para la inserción de los componentes
		cp.setLayout(new BorderLayout());
		
	// Crear los componentes adecuados
		JButton bBoton1 = new JButton("Botón 1");
		JButton bBoton2 = new JButton("Botón 2");
		JLabel lCentro = new JLabel("Etiqueta");
			lCentro.setHorizontalAlignment(SwingConstants.CENTER);
		JTextArea areaTexto = new JTextArea("Area de texto");
		JScrollPane spCentro = new JScrollPane(areaTexto);

		// Crear los elementos de la lista
		String[] strLista = new String[15];
		for (int i = 1; i<=15; i++)
			strLista[i-1] = "Item número: " + i;
		
		JList<String> list = new JList<>(strLista);
		JScrollPane spEste = new JScrollPane(list);

		// Crear los elementos del checkbox
		strLista = new String[5];
		for (int i = 1; i<=5; i++)
			strLista[i-1] = "Opción: " + i;
		
		JTextField tfSur = new JTextField("Campo de texto");
			tfSur.setEditable(false);
		JCheckBox chSur = new JCheckBox("CheckBox");
		JComboBox<String> cbSur = new JComboBox<>(strLista);
		
		// Crear el panel oeste con los botones
		JPanel pOeste = new JPanel(new GridLayout(2,1));
		pOeste.add(bBoton1);
		pOeste.add(bBoton2);
		
		// Crear el panel centro con el textArea
		JPanel pCentro = new JPanel(new BorderLayout());
		pCentro.add(lCentro, BorderLayout.NORTH);
		pCentro.add(spCentro, BorderLayout.CENTER);
		
		// Crear el panel sur con sus elementos
		JPanel pSur = new JPanel(new FlowLayout());
		pSur.add(tfSur);
		pSur.add(chSur);
		pSur.add(cbSur);
		
		// Crear el panel del centro para añadirle los demas componentes y
		// que aparezcan con el mismo ancho
		JPanel pFinalCentro = new JPanel(new GridLayout(1,3));
		pFinalCentro.add(pOeste);
		pFinalCentro.add(pCentro);
		pFinalCentro.add(spEste);
		
	// Agregarlos al contenedor
		cp.add(pFinalCentro, BorderLayout.CENTER);
		cp.add(pSur, BorderLayout.SOUTH);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(450,225);
		
	// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Bloquear cambios tamaño ventana
		f.setResizable(false);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
