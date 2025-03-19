package prPract17;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI01Swing_BORDES {

	public static void main(String[] args) {
		
	// Crear un contenedor
		JFrame f = new JFrame("Examen de Java");
		Container cp = f.getContentPane();
		JPanel principal = new JPanel(new BorderLayout());
			principal.setBorder(new EmptyBorder(10,30,10,30));
		
		cp.add(principal);

	// ----------------------------------------------------------
	// PARTE DEL CONTENIDO
	// ----------------------------------------------------------
		// Parte norte
			JLabel titulo = new JLabel("Esto es un ejercicio JAVA");
				titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Parte centro
			JPanel pCentro = new JPanel(new GridLayout(1,2));
				
			// C Oeste
				// C O Oeste
					JButton[] botones = {
						new JButton("Botón 1"),
						new JButton("Botón 2"),
						new JButton("Botón 3")	
					};
					JPanel pCentroOesteOeste = new JPanel(new GridLayout(3,1));
						for (JButton b: botones)
							pCentroOesteOeste.add(b);

				// C O Este
						String[] items = new String[15];
							for (int i = 0; i<items.length; i++)
								items[i] = "Item número " + (i+1);
					JList<String> listaItems = new JList<>(items);
					JScrollPane spLista = new JScrollPane(listaItems);

				JPanel pCentroOeste = new JPanel(new GridLayout(1,2));
					
			
			// C Este
				JPanel pCentroEste = new JPanel();
				JPanel pEdad = new JPanel(new GridLayout(4,1));
				JLabel tituloEdad = new JLabel("Marca tu edad:");
				JRadioButton[] edades = {
						new JRadioButton("Menor de 20"),
						new JRadioButton("Mayor de 20 y menor de 35"),
						new JRadioButton("Mayor de 35 años")
				};
				ButtonGroup grupoEdades = new ButtonGroup();
					pEdad.add(tituloEdad);
					for (JRadioButton rb: edades) {
						pEdad.add(rb);
						grupoEdades.add(rb);
					}
			
		// Parte sur
			JPanel pSur = new JPanel(new FlowLayout());
			
				String[] strElecciones = new String[5];
					for (int i = 0; i<strElecciones.length; i++)
						strElecciones[i] = "Eleccion " + (i+1);
			JComboBox<String> cbElecciones = new JComboBox<>(strElecciones);
			
			JLabel lObs = new JLabel("Observación: ");
			
			JTextField tfObs = new JTextField(15);
			
	// ----------------------------------------------------------
		// Añadir todos los elementos a sus sitios respectivos
			// Parte Norte
			principal.add(titulo, BorderLayout.NORTH);
				titulo.setBorder(new EmptyBorder(0,0,20,0));
			
			// Parte Centro
			pCentroOeste.add(pCentroOesteOeste);
				pCentroOesteOeste.setBorder(new EmptyBorder(0,0,0,20));
			pCentroOeste.add(spLista);
			
			pCentro.add(pCentroOeste);
			pCentro.add(pCentroEste);
			
			pCentroEste.add(pEdad);
				pCentroEste.setBorder(new EmptyBorder(0,20,0,0));
			
			principal.add(pCentro, BorderLayout.CENTER);
			
			// Parte Sur
			pSur.add(cbElecciones);
			cbElecciones.setBorder(new EmptyBorder(0,0,0,15));
			pSur.add(lObs);
			pSur.add(tfObs);
			
			principal.add(pSur, BorderLayout.SOUTH);
				pSur.setBorder(new EmptyBorder(20,0,0,0));
		
		// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
		// Dimensionar el contenedor(opcional)
		f.setSize(520,300);
		
		// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Programar el evento de cierre de ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// PRUEBA DE BORDES SOBRE EL pEdad
			// EtcherBorder --> Crea una linea resaltada o hundida.
				// pEdad.setBorder(new EtchedBorder(EtchedBorder.RAISED));
			// TitledBorder --> Crea un borde añadiendo un tilulo a otro borde.
				// pEdad.setBorder(new TitledBorder("Marca tu edad"));
				// pEdad.setBorder(new TitledBorder(new LineBorder(Color.blue,3,true),"Titulo"));
			// LineBorder --> Dibuja una linea de diferentes grosores..
				// pEdad.setBorder(new LineBorder(Color.red,5));
			// MatteBorder --> Crea un borde usando un color o una imagen.
				// pEdad.setBorder(new MatteBorder(5,15,30,30,Color.LIGHT_GRAY));
			// BevelBorder --> Presenta al componente alzado o hundido.
				// pEdad.setBorder(new BevelBorder(BevelBorder.RAISED));
			// SoftBevelBorder --> Mas suave que BevelBorder.
				// pEdad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			// EmptyBorder --> Borde para añadir espacio vacio.
				// pEdad.setBorder(new EmptyBorder(5,15,30,30));
			// CompoundBorder --> Compone dos bordes en uno solo
				//pEdad.setBorder(new CompoundBorder(
				//		new EtchedBorder(),
				//		new LineBorder(Color.red,3)));
		pEdad.setBorder(
				new CompoundBorder(
						new TitledBorder("Borde compuesto"),
						new BevelBorder(BevelBorder.RAISED)));
	}

}
