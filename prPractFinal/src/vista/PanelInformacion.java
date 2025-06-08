package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import modelo.SeccionExpediente;
import modelo.SubseccionExpediente;

public class PanelInformacion extends JPanel {
	private static final long serialVersionUID = -7939598519154569545L;
	
	// Campos de información
	private JTextField infCaja, infExpediente, infFecha, infNombres;
	private JComboBox<SeccionExpediente> infSeccion;
	private JComboBox<SubseccionExpediente> infSubseccion;
	private DefaultComboBoxModel<SubseccionExpediente> infSubseccionModel;
	private JTextArea infDescripcion;
	// Botones de información
	private JButton bBorrar, bEditar, bGuardar, bCancelar;
	
	// Getters
	public JTextField getInfCaja() {return infCaja;}
	public JTextField getInfExpediente() {return infExpediente;}
	public JTextField getInfFecha() {return infFecha;}
	public JTextField getInfNombres() {return infNombres;}
	public JComboBox<SeccionExpediente> getInfSeccion() {return infSeccion;}
	public JComboBox<SubseccionExpediente> getInfSubseccion() {return infSubseccion;}
	public DefaultComboBoxModel<SubseccionExpediente> getInfSubseccionModel() {return infSubseccionModel;}
	public JTextArea getInfDescripcion() {return infDescripcion;}
	public JButton getbBorrar() {return bBorrar;}
	public JButton getbEditar() {return bEditar;}
	public JButton getbGuardar() {return bGuardar;}
	public JButton getbCancelar() {return bCancelar;}
	
	// Constructor
	public PanelInformacion(Border mainBorder) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(370, 290));
		this.setBorder(mainBorder);
		JPanel pInf1 = new JPanel(new BorderLayout());
			this.add(pInf1);
			JPanel pInf1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				pInf1.add(pInf1_1, BorderLayout.NORTH);
				JPanel pInf_Caja = new JPanel(new GridLayout(2,1));
					pInf1_1.add(pInf_Caja);
					pInf_Caja.add(new JLabel("Caja"));
					infCaja = new JTextField(6);
						pInf_Caja.add(infCaja);
				JPanel pInf_Expediente = new JPanel(new GridLayout(2,1));
					pInf1_1.add(pInf_Expediente);
					pInf_Expediente.add(new JLabel("Expediente"));
					infExpediente = new JTextField(6);
						pInf_Expediente.add(infExpediente);
				JPanel pInf_Fecha = new JPanel(new GridLayout(2,1));
					pInf1_1.add(pInf_Fecha);
					pInf_Fecha.add(new JLabel("Fecha"));
					infFecha = new JTextField(6);
						pInf_Fecha.add(infFecha);
						
			JPanel pInf1_2 = new JPanel(new BorderLayout());
				pInf1.add(pInf1_2, BorderLayout.SOUTH);
				JPanel pInf_Seccion = new JPanel(new GridLayout(2,1));
					pInf1_2.add(pInf_Seccion, BorderLayout.WEST);
					pInf_Seccion.add(new JLabel("Seccion"));
					infSeccion = new JComboBox<SeccionExpediente>(SeccionExpediente.values());
						pInf_Seccion.add(infSeccion);
				JPanel pInf_Subseccion = new JPanel(new GridLayout(2,1));
					pInf1_2.add(pInf_Subseccion, BorderLayout.EAST);
					pInf_Subseccion.add(new JLabel("Subsección"));
					infSubseccionModel = new DefaultComboBoxModel<SubseccionExpediente>(SubseccionExpediente.values());
					infSubseccion = new JComboBox<SubseccionExpediente>(infSubseccionModel);
						pInf_Subseccion.add(infSubseccion);

		JPanel pInf2 = new JPanel(new BorderLayout());
			this.add(pInf2);
			JPanel pInf2_1 = new JPanel(new BorderLayout());
				pInf2.add(pInf2_1, BorderLayout.NORTH);
				pInf2_1.add(new JLabel("Descripción"), BorderLayout.NORTH);
				infDescripcion = new JTextArea();
					JScrollPane spDescripcion = new JScrollPane(infDescripcion);
						spDescripcion.setPreferredSize(new Dimension(300, 60));
						pInf2_1.add(spDescripcion, BorderLayout.SOUTH);
				
			JPanel pInf2_2 = new JPanel(new BorderLayout());
				pInf2_2.setBorder(new EmptyBorder(8,0,0,0));
				pInf2.add(pInf2_2, BorderLayout.SOUTH);
				pInf2_2.add(new JLabel("Nombres"), BorderLayout.NORTH);
				infNombres = new JTextField();
					pInf2_2.add(infNombres, BorderLayout.SOUTH);
					
		JPanel pInf3 = new JPanel(new FlowLayout());
			pInf3.setBorder(new EmptyBorder(10,0,0,0));
			this.add(pInf3);
			bBorrar = new JButton("Borrar");
			bEditar = new JButton("Editar");
			bGuardar = new JButton("Guardar");
				bGuardar.setEnabled(false);
			bCancelar = new JButton("Cancelar");
				bCancelar.setEnabled(false);
				
			pInf3.add(bBorrar);
			pInf3.add(bEditar);
			pInf3.add(bGuardar);
			pInf3.add(bCancelar);
	}
}
