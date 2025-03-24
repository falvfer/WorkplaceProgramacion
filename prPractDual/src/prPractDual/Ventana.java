package prPractDual;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -2294662424161337165L;
	private Gestor gestor;
	
	public Ventana(Gestor gestor) {
		this.gestor = gestor;
		this.setTitle("Buscador de Expedientes");
		Container cp = this.getContentPane();
		
		JPanel principal = new JPanel(new FlowLayout());
			cp.add(principal);
			
		// Parte superior de busqueda
		JPanel pBusqueda = new JPanel(new GridLayout(1,2));
			principal.add(pBusqueda);
			
			JPanel pSup1 = new JPanel(new GridLayout(2,1));
				pBusqueda.add(pSup1);
				JPanel pSup1_1 = new JPanel(new GridLayout(1,2,10,10));
					pSup1.add(pSup1_1);
					JPanel pSup1_1_1 = new JPanel(new GridLayout(2,1));
						pSup1_1.add(pSup1_1_1);
						pSup1_1_1.add(new JLabel("Expediente"));
						JTextField busExpediente = new JTextField(7);
							pSup1_1_1.add(busExpediente);
					JPanel pSup1_1_2 = new JPanel(new GridLayout(2,1));
						pSup1_1.add(pSup1_1_2);
						pSup1_1_2.add(new JLabel("Año"));
						JTextField busAnno = new JTextField(7);
							pSup1_1_2.add(busAnno);
				JPanel pSup1_2 = new JPanel(new FlowLayout());
					pSup1.add(pSup1_2);
					JButton buscarExpAnno = new JButton("Buscar");
						pSup1_2.add(buscarExpAnno);
						
			JPanel pSup2 = new JPanel(new GridLayout(2,1));
				pBusqueda.add(pSup2);
					JPanel pSup2_1 = new JPanel(new FlowLayout());
					pSup2.add(pSup2_1);
						JPanel pSup2_1_Grid = new JPanel(new GridLayout(2,1));
							pSup2_1.add(pSup2_1_Grid);
							pSup2_1_Grid.add(new JLabel("Caja"));
							JTextField busCaja = new JTextField(7);
								pSup2_1_Grid.add(busCaja);
					JPanel pSup2_2 = new JPanel(new FlowLayout());
						pSup2.add(pSup2_2);
						JButton buscarCaja = new JButton("Buscar");
							pSup2_2.add(buscarCaja);
		
		// Parte media de botones de expedientes encontrados
		JPanel pExpedientes = new JPanel(new FlowLayout(FlowLayout.LEFT));
			principal.add(pExpedientes);
		
		// Parte inferior de información del expediente
		JPanel pInformacion = new JPanel(new BorderLayout());
			principal.add(pInformacion);
			JPanel pInf1 = new JPanel(new BorderLayout());
				pInformacion.add(pInf1, BorderLayout.NORTH);
				JPanel pInf1_1_Flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
					pInf1.add(pInf1_1_Flow);
					JPanel pInf_Caja = new JPanel(new GridLayout(2,1));
						pInf1_1_Flow.add(pInf_Caja);
						pInf_Caja.add(new JLabel("Caja"));
						JTextField infCaja = new JTextField(6);
							pInf_Caja.add(infCaja);
					JPanel pInf_Expediente = new JPanel(new GridLayout(2,1));
						pInf1_1_Flow.add(pInf_Expediente);
						pInf_Expediente.add(new JLabel("Expediente"));
						JTextField infExpediente = new JTextField(6);
							pInf_Expediente.add(infExpediente);
					JPanel pInf_Fecha = new JPanel(new GridLayout(2,1));
						pInf1_1_Flow.add(pInf_Fecha);
						pInf_Fecha.add(new JLabel("Fecha"));
						JTextField infFecha = new JTextField(6);
							pInf_Fecha.add(infFecha);

			JPanel pInf2 = new JPanel(new BorderLayout());
				pInformacion.add(pInf2, BorderLayout.SOUTH);
		
	}

}
