package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.Controlador;
import modelo.SeccionExpediente;
import modelo.SubseccionExpediente;

public class Vista extends JFrame {
	private static final long serialVersionUID = -2294662424161337165L;
	
	// Paneles principales, para poder esconderlos y mostrarlos
	private PanelCrear pCrear;
	private JPanel pBusqueda;
	private JPanel pBordeExpedientes, pExpedientes;
	private PanelInformacion pInformacion;
	// Datos de busqueda
	private JTextField busExpediente, busAnno, busCaja;
	// Botones de busqueda
	private JButton buscarExpAnno, buscarCaja;
	// Menues
	private JMenu menuAdd, menuBuscar;
	
// Getters y Setter
	public JPanel getpCrear() {return pCrear;}
	public JPanel getpBusqueda() {return pBusqueda;}
	public JPanel getpBordeExpedientes() {return pBordeExpedientes;}
	public JPanel getpExpedientes() {return pExpedientes;}
	public JPanel getpInformacion() {return pInformacion;}
	public JTextField getBusExpediente() {return busExpediente;}
	public JTextField getBusAnno() {return busAnno;}
	public JTextField getBusCaja() {return busCaja;}
	public JButton getBuscarExpAnno() {return buscarExpAnno;}
	public JButton getBuscarCaja() {return buscarCaja;}
	public JMenuItem getMenuAdd() {return menuAdd;}
	public JMenuItem getMenuBuscar() {return menuBuscar;}
	public void setpExpedientes(JPanel pExpedientes) {this.pExpedientes = pExpedientes;}
	
	// Panel de información
	public JTextField getInfCaja() {return pInformacion.getInfCaja();}
	public JTextField getInfExpediente() {return pInformacion.getInfExpediente();}
	public JTextField getInfFecha() {return pInformacion.getInfFecha();}
	public JComboBox<SeccionExpediente> getInfSeccion() {return pInformacion.getInfSeccion();}
	public JComboBox<SubseccionExpediente> getInfSubseccion() {return pInformacion.getInfSubseccion();}
	public DefaultComboBoxModel<SubseccionExpediente> getInfSubseccionModel() {return pInformacion.getInfSubseccionModel();}
	public JTextField getInfNombres() {return pInformacion.getInfNombres();}
	public JTextArea getInfDescripcion() {return pInformacion.getInfDescripcion();}
	public JButton getbInfBorrar() {return pInformacion.getbBorrar();}
	public JButton getbInfEditar() {return pInformacion.getbEditar();}
	public JButton getbInfGuardar() {return pInformacion.getbGuardar();}
	public JButton getbInfCancelar() {return pInformacion.getbCancelar();}
	
	// Panel de creación
	public JTextField getAddCaja() {return pCrear.getInfCaja();}
	public JTextField getAddExpediente() {return pCrear.getInfExpediente();}
	public JTextField getAddFecha() {return pCrear.getInfFecha();}
	public JComboBox<SeccionExpediente> getAddSeccion() {return pCrear.getInfSeccion();}
	public JComboBox<SubseccionExpediente> getAddSubseccion() {return pCrear.getInfSubseccion();}
	public DefaultComboBoxModel<SubseccionExpediente> getAddSubseccionModel() {return pCrear.getInfSubseccionModel();}
	public JTextField getAddNombres() {return pCrear.getInfNombres();}
	public JTextArea getAddDescripcion() {return pCrear.getInfDescripcion();}
	public JButton getbAddGuardar() {return pCrear.getbGuardar();}
	public JButton getbAddCancelar() {return pCrear.getbCancelar();}
	
	public Vista() {
		
		CompoundBorder mainBorder = new CompoundBorder(
				new LineBorder(Color.DARK_GRAY),
				new EmptyBorder(10,10,10,10));
		
		this.setTitle("Buscador de Expedientes");
		Container cp = this.getContentPane();
		
		JPanel principal = new JPanel(new FlowLayout());
			cp.add(principal);
			
		this.setJMenuBar(crearMenu());
			
		// Opcion añadir
		pCrear = new PanelCrear(mainBorder);
		
		// Opcion busqueda
		crearSuperior(mainBorder);
		crearMedio(mainBorder);
		pInformacion = new PanelInformacion(mainBorder);
		principal.add(pCrear);
		principal.add(pBusqueda);
		principal.add(pBordeExpedientes);
		principal.add(pInformacion);

		pCrear.setVisible(false);
		pBordeExpedientes.setVisible(false);
		pInformacion.setVisible(false);
		
		this.pack();
		this.setSize(400, 205);
		setEditableBuscar(false);
	}
	public JMenuBar crearMenu() {
		// Crear la barra y los menus
		JMenuBar barraMenu = new JMenuBar();
		menuAdd = new JMenu("Añadir");
			menuAdd.setOpaque(true);
		menuBuscar = new JMenu("Buscar");
			menuBuscar.setOpaque(true);
			menuBuscar.setBackground(Color.decode("#d4d4d4"));
		
		barraMenu.add(menuAdd);
		barraMenu.add(menuBuscar);
		
		return barraMenu;
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
	
	public void setEditableBuscar(boolean b) {
		getInfCaja().setEditable(b);
		getInfExpediente().setEditable(b);
		getInfFecha().setEditable(b);
		getInfSeccion().setEnabled(b);
		getInfSubseccion().setEnabled(b);
		getInfDescripcion().setEditable(b);
		getInfNombres().setEditable(b);
	}
	
	public void control(Controlador ctr) {
		buscarExpAnno.addActionListener(ctr);
		buscarCaja.addActionListener(ctr);
		
		getbInfBorrar().addActionListener(ctr);
		getbInfEditar().addActionListener(ctr);
		getbInfGuardar().addActionListener(ctr);
		getbInfCancelar().addActionListener(ctr);
		
		getbAddGuardar().addActionListener(ctr);
		getbAddCancelar().addActionListener(ctr);
		
		menuAdd.addMouseListener(ctr);
		menuBuscar.addMouseListener(ctr);
		
		getInfSeccion().addItemListener(ctr);
			ctr.actualizarSubseccionInf();
		getAddSeccion().addItemListener(ctr);
			ctr.actualizarSubseccionAdd();
	}

}
