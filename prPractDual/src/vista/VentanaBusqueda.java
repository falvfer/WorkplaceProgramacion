package prPractDual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -2294662424161337165L;
	private Gestor gestor;
	// Paneles principales, para poder esconderlos y mostrarlos
	JPanel pBusqueda;
	JPanel pInformacion;
	JPanel pBordeExpedientes, pExpedientes;
	// Datos de busqueda
	JTextField busExpediente, busAnno, busCaja;
	// Campos de información
	JTextField infCaja, infExpediente, infFecha, infSeccion, infSubseccion, infNombres;
	JTextArea infDescripcion;
	int ultContExp;
	
	
	public Ventana(Gestor gestor) {
		
		CompoundBorder mainBorder = new CompoundBorder(
				new LineBorder(Color.DARK_GRAY),
				new EmptyBorder(10,10,10,10));
		
		this.gestor = gestor;
		this.setTitle("Buscador de Expedientes");
		Container cp = this.getContentPane();
		
		JPanel principal = new JPanel(new FlowLayout());
			cp.add(principal);
			
		// Parte superior de busqueda
		pBusqueda = new JPanel(new BorderLayout());
			pBusqueda.setPreferredSize(new Dimension(370, 130));
			pBusqueda.setBorder(mainBorder);
			principal.add(pBusqueda);
			
			JPanel pSup1 = new JPanel(new GridLayout(2,1));
				pBusqueda.add(pSup1, BorderLayout.WEST);
				JPanel pSup1_1 = new JPanel(new GridLayout(1,2,6,6));
					pSup1.add(pSup1_1);
					JPanel pSup1_1_1 = new JPanel(new GridLayout(2,1));
						pSup1_1.add(pSup1_1_1);
						pSup1_1_1.add(new JLabel("Expediente", SwingConstants.CENTER));
						busExpediente = new JTextField(7);
							pSup1_1_1.add(busExpediente);
					JPanel pSup1_1_2 = new JPanel(new GridLayout(2,1));
						pSup1_1.add(pSup1_1_2);
						pSup1_1_2.add(new JLabel("Año", SwingConstants.CENTER));
						busAnno = new JTextField(7);
							pSup1_1_2.add(busAnno);
				JPanel pSup1_2 = new JPanel(new FlowLayout());
					pSup1.add(pSup1_2);
					JButton buscarExpAnno = new JButton("Buscar");
						buscarExpAnno.addActionListener(new CBusquedaExpAnno());
						pSup1_2.add(buscarExpAnno);
						
			JPanel pSup2 = new JPanel(new GridLayout(2,1));
				pBusqueda.add(pSup2, BorderLayout.EAST);
					JPanel pSup2_1 = new JPanel(new FlowLayout());
						pSup2.add(pSup2_1);
						JPanel pSup2_1_Grid = new JPanel(new GridLayout(2,1));
							pSup2_1.add(pSup2_1_Grid);
							pSup2_1_Grid.add(new JLabel("Caja", SwingConstants.CENTER));
							busCaja = new JTextField(7);
								pSup2_1_Grid.add(busCaja);
					JPanel pSup2_2 = new JPanel(new FlowLayout());
						pSup2.add(pSup2_2);
						JButton buscarCaja = new JButton("Buscar");
							buscarCaja.addActionListener(new CBusquedaCaja());
							pSup2_2.add(buscarCaja);
		
		// Parte media de botones de expedientes encontrados
		pBordeExpedientes = new JPanel(new BorderLayout());
			pBordeExpedientes.setBorder(mainBorder);
			principal.add(pBordeExpedientes);
			pExpedientes = new JPanel(new FlowLayout());
				pBordeExpedientes.add(pExpedientes, BorderLayout.CENTER);
		
		// Parte inferior de información del expediente
		pInformacion = new JPanel(new BorderLayout());
			pInformacion.setPreferredSize(new Dimension(370, 240));
			pInformacion.setBorder(mainBorder);
			principal.add(pInformacion);
			JPanel pInf1 = new JPanel(new BorderLayout());
				pInformacion.add(pInf1, BorderLayout.NORTH);
				JPanel pInf1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
					pInf1.add(pInf1_1, BorderLayout.NORTH);
					JPanel pInf_Caja = new JPanel(new GridLayout(2,1));
						pInf1_1.add(pInf_Caja);
						pInf_Caja.add(new JLabel("Caja"));
						infCaja = new JTextField(6);
							infCaja.setEditable(false);
							pInf_Caja.add(infCaja);
					JPanel pInf_Expediente = new JPanel(new GridLayout(2,1));
						pInf1_1.add(pInf_Expediente);
						pInf_Expediente.add(new JLabel("Expediente"));
						infExpediente = new JTextField(6);
							infExpediente.setEditable(false);
							pInf_Expediente.add(infExpediente);
					JPanel pInf_Fecha = new JPanel(new GridLayout(2,1));
						pInf1_1.add(pInf_Fecha);
						pInf_Fecha.add(new JLabel("Fecha"));
						infFecha = new JTextField(6);
							infFecha.setEditable(false);
							pInf_Fecha.add(infFecha);
							
				JPanel pInf1_2 = new JPanel(new BorderLayout());
					pInf1.add(pInf1_2, BorderLayout.SOUTH);
					JPanel pInf_Seccion = new JPanel(new GridLayout(2,1));
						pInf1_2.add(pInf_Seccion, BorderLayout.WEST);
						pInf_Seccion.add(new JLabel("Seccion"));
						infSeccion = new JTextField(14);
							infSeccion.setEditable(false);
							pInf_Seccion.add(infSeccion);
					JPanel pInf_Subseccion = new JPanel(new GridLayout(2,1));
						pInf1_2.add(pInf_Subseccion, BorderLayout.EAST);
						pInf_Subseccion.add(new JLabel("Subsección"));
						infSubseccion = new JTextField(14);
							infSubseccion.setEditable(false);
							pInf_Subseccion.add(infSubseccion);

			JPanel pInf2 = new JPanel(new BorderLayout());
				pInformacion.add(pInf2, BorderLayout.SOUTH);
				JPanel pInf2_1 = new JPanel(new BorderLayout());
					pInf2.add(pInf2_1, BorderLayout.NORTH);
					pInf2_1.add(new JLabel("Descripción"), BorderLayout.NORTH);
					infDescripcion = new JTextArea();
						infDescripcion.setEditable(false);
						JScrollPane spDescripcion = new JScrollPane(infDescripcion);
							spDescripcion.setPreferredSize(new Dimension(300, 60));
							pInf2_1.add(spDescripcion, BorderLayout.SOUTH);
					
				JPanel pInf2_2 = new JPanel(new BorderLayout());
					pInf2_2.setBorder(new EmptyBorder(8,0,0,0));
					pInf2.add(pInf2_2, BorderLayout.SOUTH);
					pInf2_2.add(new JLabel("Nombres"), BorderLayout.NORTH);
					infNombres = new JTextField();
						infNombres.setEditable(false);
						pInf2_2.add(infNombres, BorderLayout.SOUTH);
			
		pBordeExpedientes.setVisible(false);
		pInformacion.setVisible(false);
		
		this.pack();
		this.setSize(400, 180);
					
	}
	
	class CBusquedaExpAnno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			Expediente exp = null;
			boolean error = false;
			try {
				exp = gestor.findExpediente(Short.parseShort(busExpediente.getText()),
											Short.parseShort(busAnno.getText()));
			} catch (Exception e) {error = true;}
			
			if (exp instanceof Expediente) {
				infCaja.setText(exp.getNumCaja()+"");
				infExpediente.setText(exp.getNumExpediente()+"");
				infFecha.setText(exp.getAnno()+"");
				infSeccion.setText(exp.getSeccion().toString()+"");
				infSubseccion.setText(exp.getSubseccion().toString()+"");
				infDescripcion.setText(exp.getDescripcion()+"");
				infNombres.setText(exp.getNombres()+"");
				
				if (pBordeExpedientes.isVisible())
					pBordeExpedientes.setVisible(false);
				if (!pInformacion.isVisible())
					pInformacion.setVisible(true);
				
				pack();
				setSize(400, 425);
				
			} else {
				if (error)
					JOptionPane.showMessageDialog(null, "Solamente se admiten datos numéricos",
							"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "No se ha encontrado ningún expediente",
							"Error en la búsqueda", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	class CBusquedaCaja implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			Caja caj = null;
			boolean error = false;
			try {
				caj = gestor.findCaja(Integer.parseInt(busCaja.getText()));
			} catch (Exception e) {error = true;}
			
			if (caj instanceof Caja) {
				pBordeExpedientes.remove(pExpedientes);
				pExpedientes = new JPanel(new FlowLayout(FlowLayout.LEFT));
				pBordeExpedientes.add(pExpedientes);
				
				ultContExp = 0;
				for (Expediente exp: caj.getExpedientes()) {
					JButton bExp = new JButton(exp.getNumExpediente()+"/"+exp.getAnno());
					bExp.addActionListener(new CBotonesExpediente());
					pExpedientes.add(bExp);
					ultContExp++;
				}
				
				if (pInformacion.isVisible())
					pInformacion.setVisible(false);
				
				pBordeExpedientes.setPreferredSize(new Dimension(370, 25+35*((ultContExp+3)/4)));
				if (!pBordeExpedientes.isVisible())
					pBordeExpedientes.setVisible(true);
				
				pack();
				setSize(400, 210+35*((ultContExp+3)/4));
				
			} else {
				if (error)
					JOptionPane.showMessageDialog(null, "Solamente se admiten datos numéricos",
							"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna caja",
							"Error en la búsqueda", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	class CBotonesExpediente implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			String[] datosExp = ((JButton)e1.getSource()).getText().split("/");
			Expediente exp = gestor.findExpediente(Short.parseShort(datosExp[0]),
													Short.parseShort(datosExp[1]));
			
			infCaja.setText(exp.getNumCaja()+"");
			infExpediente.setText(exp.getNumExpediente()+"");
			infFecha.setText(exp.getAnno()+"");
			infSeccion.setText(exp.getSeccion().toString()+"");
			infSubseccion.setText(exp.getSubseccion().toString()+"");
			infDescripcion.setText(exp.getDescripcion()+"");
			infNombres.setText(exp.getNombres()+"");
			
			if (!pInformacion.isVisible())
				pInformacion.setVisible(true);
			
			pack();
			setSize(400, 455+35*((ultContExp+3)/4));
		}
		
	}

}
