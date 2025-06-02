package vista;

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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.ControladorBusqueda;
import modelo.Caja;
import modelo.Expediente;
import modelo.Gestor;

public class VentanaBusqueda extends JFrame {
	private static final long serialVersionUID = -2294662424161337165L;
	
	
	// Paneles principales, para poder esconderlos y mostrarlos
	private JPanel pBusqueda;
	private JPanel pInformacion;
	private JPanel pBordeExpedientes, pExpedientes;
	// Datos de busqueda
	private JTextField busExpediente, busAnno, busCaja;
	// Campos de información
	private JTextField infCaja, infExpediente, infFecha, infSeccion, infSubseccion, infNombres;
	private JTextArea infDescripcion;
	JButton buscarExpAnno, buscarCaja;
	
// Getters y Setter
	public JPanel getpBusqueda() {return pBusqueda;}
	public JPanel getpInformacion() {return pInformacion;}
	public JPanel getpBordeExpedientes() {return pBordeExpedientes;}
	public JPanel getpExpedientes() {return pExpedientes;}
	public JTextField getBusExpediente() {return busExpediente;}
	public JTextField getBusAnno() {return busAnno;}
	public JTextField getBusCaja() {return busCaja;}
	public JTextField getInfCaja() {return infCaja;}
	public JTextField getInfExpediente() {return infExpediente;}
	public JTextField getInfFecha() {return infFecha;}
	public JTextField getInfSeccion() {return infSeccion;}
	public JTextField getInfSubseccion() {return infSubseccion;}
	public JTextField getInfNombres() {return infNombres;}
	public JTextArea getInfDescripcion() {return infDescripcion;}
	public JButton getBuscarExpAnno() {return buscarExpAnno;}
	public JButton getBuscarCaja() {return buscarCaja;}
	public void setpExpedientes(JPanel pExpedientes) {this.pExpedientes = pExpedientes;}
	
	
	public VentanaBusqueda() {
		
		CompoundBorder mainBorder = new CompoundBorder(
				new LineBorder(Color.DARK_GRAY),
				new EmptyBorder(10,10,10,10));
		
		this.setTitle("Buscador de Expedientes");
		Container cp = this.getContentPane();
		
		JPanel principal = new JPanel(new FlowLayout());
			cp.add(principal);
			
		crearSuperior(mainBorder);
		crearMedio(mainBorder);
		crearInferior(mainBorder);
		principal.add(pBusqueda);
		principal.add(pBordeExpedientes);
		principal.add(pInformacion);
			
		pBordeExpedientes.setVisible(false);
		pInformacion.setVisible(false);
		
		this.pack();
		this.setSize(400, 180);
					
	}

	public void crearSuperior(Border mainBorder) {
		pBusqueda = new JPanel(new BorderLayout());
		pBusqueda.setPreferredSize(new Dimension(370, 130));
		pBusqueda.setBorder(mainBorder);
		
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
				buscarExpAnno = new JButton("Buscar");
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
					buscarCaja = new JButton("Buscar");
						pSup2_2.add(buscarCaja);
	}
	
	public void crearMedio(Border mainBorder) {
		pBordeExpedientes = new JPanel(new BorderLayout());
		pBordeExpedientes.setBorder(mainBorder);
		pExpedientes = new JPanel(new FlowLayout());
			pBordeExpedientes.add(pExpedientes, BorderLayout.CENTER);
	}
	
	public void crearInferior(Border mainBorder) {
		pInformacion = new JPanel(new BorderLayout());
		pInformacion.setPreferredSize(new Dimension(370, 240));
		pInformacion.setBorder(mainBorder);
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
	}
	
	public void control(ControladorBusqueda ctr) {
		buscarExpAnno.addActionListener(ctr);
		buscarCaja.addActionListener(ctr);
		
	}

}
